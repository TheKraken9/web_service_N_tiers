using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace serveur_web_sante.Connecting
{
    public class Connect
    {
        string string_connection;

        public Connect()
        {

        }

        public static SqlConnection GetCon()
        {
            SqlConnection con = new SqlConnection("Data Source=DESKTOP-U4RVM70;Initial Catalog=banque;Integrated Security=True");
            return con;
        }
    }
}
