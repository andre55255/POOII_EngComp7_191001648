using System.Collections.Generic;

namespace Bakehouse.App.ViewObjects.Email
{
    class SendMailVO
    {
        public string Destination { get; set; }
        public List<string> Destinations { get; set; }
        public string Subject { get; set; }
        public string Body { get; set; }

        public SendMailVO()
        {
            Destinations = new List<string>();
        }
    }
}