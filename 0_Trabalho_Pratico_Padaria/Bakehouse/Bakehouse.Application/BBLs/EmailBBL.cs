using Bakehouse.App.ViewObjects.Email;
using Bakehouse.Helpers;
using Bakehouse.Infra.Data.Repositories;
using FluentResults;
using System;
using System.IO;
using System.Net;
using System.Net.Mail;
using System.Threading.Tasks;

namespace Bakehouse.App.BBLs
{
    class EmailBBL
    {
        private async Task<string> LoadTemplateEmail(string urlEmailTemplate)
        {
            try
            {
                return Templates.TemplateEmailResetPassword;
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesEmail.ErrorBBLLoadTemplate,
                                          ex.Message,
                                          this.GetType().ToString());

                return null;
            }
        }

        private async Task<Result> SendMail(SendMailVO mailVO)
        {
            MailMessage mail = new MailMessage();
            SmtpClient smtp = new SmtpClient();
            try
            {
                mail.From = new MailAddress(ConstantsSettings.EmailLogin, "Suporte Bakehouse");
                mail.To.Add(mailVO.Destination);
                mail.Subject = mailVO.Subject;
                mail.Body = mailVO.Body;
                mail.IsBodyHtml = true;
                mail.Priority = MailPriority.Normal;

                smtp.Credentials = new NetworkCredential(ConstantsSettings.EmailLogin, ConstantsSettings.EmailPassword);
                smtp.Host = ConstantsSettings.EmailSmtp;
                smtp.Port = int.Parse(ConstantsSettings.EmailPort);
                smtp.UseDefaultCredentials = false;
                smtp.EnableSsl = true;
                smtp.Send(mail);

                return Result.Ok();
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesEmail.ErrorBBLSendMail,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesEmail.ErrorBBLSendMail);
            }
            finally
            {
                if (mail != null)
                    mail.Dispose();
                if (smtp != null)
                    smtp.Dispose();
            }
        }

        public async Task<Result> SendMailResetPassword(EmailDataVO dataVO)
        {
            try
            {
                SendMailVO mailVO = new SendMailVO();

                mailVO.Body = await LoadTemplateEmail("EmailResetPassword.html");
                mailVO.Destination = dataVO.Email;

                if (string.IsNullOrEmpty(dataVO.NameUser) ||
                    string.IsNullOrEmpty(dataVO.Token) ||
                    string.IsNullOrEmpty(mailVO.Body) ||
                    string.IsNullOrEmpty(mailVO.Destination))
                {
                    return Result.Fail(ConstantsMessagesEmail.ErrorBBLInformationsNotFound);
                }

                mailVO.Subject = ConstantsMessagesEmail.SubjectResetPassword;

                mailVO.Body = mailVO.Body.Replace("[[NAME]]", dataVO.NameUser);
                mailVO.Body = mailVO.Body.Replace("[[TOKEN]]", dataVO.Token);

                return await SendMail(mailVO);
            }
            catch (Exception ex)
            {
                await LogRepository.RegisterLog(ConstantsMessagesEmail.ErrorBBLSendMail,
                                          ex.Message,
                                          this.GetType().ToString());

                return Result.Fail(ConstantsMessagesEmail.ErrorBBLSendMail);
            }
        }
    }
}