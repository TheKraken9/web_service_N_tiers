using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;
using serveur_web_sante.Connecting;

namespace serveur_web_sante.Models
{
    public class Personne
    {
        public int Id { get; set; }
        public string Nom { get; set; }
        public string Prenoms { get; set; }
        public string Genre { get; set; }
        public string Telephone { get; set; }
        public string Adresse { get; set; }
        public string Email { get; set; }


        public Personne GetPersonne(int cin)
        {
            SqlConnection con = Connect.GetCon();
            con.Open();
            Personne personne = new Personne();
            string query = "select * from personne where id =" + cin;
            SqlCommand command = new SqlCommand(query, con);
            command.Parameters.AddWithValue("@cin", cin);
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                personne.Id = reader.GetInt32(0);
                personne.Nom = reader.GetString(1);
                personne.Prenoms = reader.GetString(2);
                personne.Genre = reader.GetString(3);
                personne.Telephone = reader.GetString(4);
                personne.Adresse = reader.GetString(5);
                personne.Email = reader.GetString(6);
            }
            con.Close();
            return personne;
        }
    }
}
