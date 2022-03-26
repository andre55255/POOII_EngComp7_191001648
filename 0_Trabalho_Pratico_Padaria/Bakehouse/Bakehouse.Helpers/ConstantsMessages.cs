namespace Bakehouse.Helpers
{
    public static class ConstantsSettings
    {
        public static string ConnectionDB = "server=localhost;database=bakehouse_db;user=root;password=root";
        public static string EmailLogin = "lafabank135@gmail.com";
        public static string EmailPassword = "unipacbank@135";
        public static string EmailSmtp = "smtp.gmail.com";
        public static string EmailPort = "587";
    }

    public static class ConstantsMessagesCategory
    {
        // Infra Data
        public static string ErrorInfraDataDeleteCategory = "Ocorreu um erro ao deletar a categoria no InfraData";
        public static string ErrorInfraDataFindByIdCategory = "Ocorreu um erro ao buscar a categoria por id no InfraData";
        public static string ErrorInfraDataFindAllCategory = "Ocorreu um erro ao buscar a lista de categorias no InfraData";
        public static string ErrorInfraDataInsertCategory = "Ocorreu um erro ao inserir uma categoria no InfraData";
        public static string ErrorInfraDataUpdateCategory = "Ocorreu um erro ao atualizar uma categoria no InfraData";
    }

    public static class ConstantsMessagesMovement
    {
        // Infra Data
        public static string ErrorInfraDataDeleteMovement = "Ocorreu um erro ao deletar o movimento no InfraData";
        public static string ErrorInfraDataFindByIdMovement = "Ocorreu um erro ao buscar o movimento por id no InfraData";
        public static string ErrorInfraDataFindAllMovement = "Ocorreu um erro ao buscar a lista de movimentos no InfraData";
        public static string ErrorInfraDataInsertMovement = "Ocorreu um erro ao inserir um movimento no InfraData";
        public static string ErrorInfraDataUpdateMovement = "Ocorreu um erro ao atualizar um movimento no InfraData";
    }

    public static class ConstantsMessagesOrderPadItem
    {
        // Infra Data
        public static string ErrorInfraDataDelete = "Ocorreu um erro ao deletar o item de pedido no InfraData";
        public static string ErrorInfraDataFindById = "Ocorreu um erro ao buscar o item de pedido por id no InfraData";
        public static string ErrorInfraDataFindAll = "Ocorreu um erro ao buscar a lista de itens de pedidos no InfraData";
        public static string ErrorInfraDataInsert = "Ocorreu um erro ao inserir um item de pedidos no InfraData";
        public static string ErrorInfraDataUpdate = "Ocorreu um erro ao atualizar um item de pedido no InfraData";
    }

    public static class ConstantsMessagesOrderPad
    {
        // Infra Data
        public static string ErrorInfraDataDelete = "Ocorreu um erro ao deletar o pedido no InfraData";
        public static string ErrorInfraDataFindById = "Ocorreu um erro ao buscar o pedido por id no InfraData";
        public static string ErrorInfraDataFindAll = "Ocorreu um erro ao buscar a lista de pedidos no InfraData";
        public static string ErrorInfraDataInsert = "Ocorreu um erro ao inserir um pedidos no InfraData";
        public static string ErrorInfraDataUpdate = "Ocorreu um erro ao atualizar um pedido no InfraData";
    }

    public static class ConstantsMessagesProduct
    {
        // Infra Data
        public static string ErrorInfraDataDelete = "Ocorreu um erro ao deletar o produto no InfraData";
        public static string ErrorInfraDataFindById = "Ocorreu um erro ao buscar o produto por id no InfraData";
        public static string ErrorInfraDataFindAll = "Ocorreu um erro ao buscar a lista de produtos no InfraData";
        public static string ErrorInfraDataInsert = "Ocorreu um erro ao inserir um produto no InfraData";
        public static string ErrorInfraDataUpdate = "Ocorreu um erro ao atualizar um produto no InfraData";
    }

    public static class ConstantsMessagesRole
    {
        // Infra Data
        public static string ErrorInfraDataDelete = "Ocorreu um erro ao deletar a role no InfraData";
        public static string ErrorInfraDataFindById = "Ocorreu um erro ao buscar a role por id no InfraData";
        public static string ErrorInfraDataFindAll = "Ocorreu um erro ao buscar as listas de roles no InfraData";
        public static string ErrorInfraDataInsert = "Ocorreu um erro ao inserir uma role no InfraData";
        public static string ErrorInfraDataUpdate = "Ocorreu um erro ao atualizar uma role no InfraData";
    }

    public static class ConstantsMessagesUnitOfMeasurement
    {
        // Infra Data
        public static string ErrorInfraDataDelete = "Ocorreu um erro ao deletar a unidade de medida no InfraData";
        public static string ErrorInfraDataFindById = "Ocorreu um erro ao buscar a unidade de medida por id no InfraData";
        public static string ErrorInfraDataFindAll = "Ocorreu um erro ao buscar as listas de unidades de medidas no InfraData";
        public static string ErrorInfraDataInsert = "Ocorreu um erro ao inserir uma unidade de medida no InfraData";
        public static string ErrorInfraDataUpdate = "Ocorreu um erro ao atualizar uma unidade de medida no InfraData";
    }

    public static class ConstantsMessagesUser
    {
        // Infra Data
        public static string ErrorInfraDataInsert = "Ocorreu um erro ao inserir um novo usuário no Infra Data";
        public static string ErrorInfraDataUpdate = "Ocorreu um erro ao atualizar um usuário no Infra Data";
        public static string ErrorInfraDataDelete = "Ocorreu um erro ao deletar um usuário no Infra Data";
        public static string ErrorInfraDataFindById = "Ocorreu um erro ao buscar um novo usuário por id no Infra Data";
        public static string ErrorInfraDataFindAll = "Ocorreu um erro ao buscar a lista de todos os usuários no Infra Data";
        public static string ErrorInfraDataFindByEmail = "Ocorreu um erro ao buscar um novo usuário por email no Infra Data";
        public static string ErrorInfraDataFindByUsername = "Ocorreu um erro ao buscar um novo usuário por username no Infra Data";
        public static string ErrorInfraDataGenerateToken = "Ocorreu um erro ao gerar token para recuperação de senha no Infra Data";
        public static string ErrorInfraDataResetPassword = "Ocorreu um erro ao redefinir a senha no Infra Data";
        public static string ErrorInfraDataTokenResetPasswordIncorrect = "Token de redefinição de senha inválido ou incorreto";
        public static string ErrorInfraDataSignIn = "Ocorreu um erro ao realizar login de usuário";
        public static string ErrorInfraDataUserInvalid = "Ocorreu um erro ao validar dados de usuário";
        public static string ErrorInfraDataSignInPasswordIncorrect = "Senha incorreta, tentativas: ";
        public static string ErrorInfraDataLockoutEnded = "Você excedeu o número de tentativas para redefinir senha, redefina a senha para logar";
        public static string ErrorBBLSignIn = "Ocorreu um erro ao logar usuário: ";
        public static string ErrorBBLResetPasswordGenerateToken = "Ocorreu um erro ao gerar token de recuperação de senha, Username: ";
        public static string ErrorBBLResetPasswordTo = "Ocorreu um erro ao trocar a senha deste usuário, Username: ";
        public static string ErrorBBLResetPasswordTokenInvalid = "Token diferente do enviado para email: ";
        public static string ErrorBBLUserNotFound = "Usuário não encontrado no banco";
    }

    public static class ConstantsMessagesEmail
    {
        public static string SubjectResetPassword = "Solicitação para redefinição de senha";

        public static string ErrorBBLLoadTemplate = "Ocorreu um erro ao carregar o template de envio de email.";
        public static string ErrorBBLInformationsNotFound = "Ocorreu um erro ao obter dados para envio de email.";
        public static string ErrorBBLSendMail = "Ocorreu um erro no serviço de enviar o email.";
    }

    public static class Templates
    {
        public static string TemplateEmailResetPassword = "<!DOCTYPE html><html lang='pt-br'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Bakehouse</title></head><html><body><div style='font-family: sans-serif; font-family: 14px; line-height: 1.8; color: #0b4f6c; max-width: 700px; margin-right: auto; margin-left: auto; border-color: #4A1375; border-width: 1px; border-style: solid;'><div style='display: block;text-align: center;background-color: #0b4f6c; padding-top: 7px; padding-bottom: 3px;'><span style='color: #fff'>Bakehouse</span></div><div style='display: block;text-align: center;padding: 20px 70px;'><h1 style='font-weight: 800;font-size: 24px;line-height: 120%;text-align: center;color: #0b4f6c;'>Redefinição de senha</h1><p style='font-style: normal;font-weight: normal;font-size: 24px;line-height: 160%;text-align: center;color: #0b4f6c;'>Olá [[NAME]] :-)</p><p style='font-style: normal;font-weight: normal;font-size: 16px;line-height: 160%;text-align: center;color: #0b4f6c;'>Recebemos uma solicitação para que sua senha fosse redefinida, segue o token de redefinição de senha.</p></span><br /><span style='font-style: normal;font-weight: bold ;font-size: 16px;line-height: 160%;text-align: center;color: #0b4f6c;word-wrap: break-word;'>[[TOKEN]]</span></p><br /></div><div style='margin-top:20px;text-align: center;display: block;align-items: center;justify-content: center;background-color: #F1F2F2; padding: 20px 10px;'><p style='font-family: sans-serif; font-family: 14px;font-style: normal;font-weight: normal;font-size: 23px;line-height: 31px;text-align: center;letter-spacing: 0.01em;color: #0b4f6c;'>Ficou com alguma dúvida? <a style='text-decoration: underline;color: #0b4f6c' href='mailto:bakehouse55255@gmail.com'>Fale com agente.</a></p><span>Equipe de suporte Bakehouse<span></div></div></body></html>";
    }
}