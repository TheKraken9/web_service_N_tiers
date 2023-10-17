using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using MongoDB.Driver;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace serveur_web_sante.Models
{
    public class Sante
    {

        private readonly IMongoCollection<Sante> _santeCollection;

        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string Id { get; set; }
        public string CIN { get; set; }
        public string GroupeSanguin { get; set; }
        public List<string> AntecedentsMedicaux { get; set; }
        public List<string> MedicamentsActuels { get; set; }
        public List<string> Allergies { get; set; }
        public DateTime DerniereConsultation { get; set; }
        public List<Vaccination> Vaccinations { get; set; }
        public MesuresAnthropometriques MesuresAnthropometriques { get; set; }
        public List<ResultatExamen> ResultatsExamens { get; set; }
        public CoordonneesMedecinTraitant CoordonneesMedecinTraitant { get; set; }
        public List<ChronologieMaladieChronique> ChronologieMaladiesChroniques { get; set; }
        public List<HistoireChirurgie> HistoireChirurgies { get; set; }
        public ModeDeVie ModeDeVie { get; set; }

        public Sante(string connectionString, string databaseName)
        {
            var client = new MongoClient(connectionString);
            var database = client.GetDatabase(databaseName);
            _santeCollection = database.GetCollection<Sante>("infosante");
        }

        public List<Sante> GetAllSante()
        {
            try
            {
                return _santeCollection.Find(sante => true).ToList();
            }
            catch (Exception ex)
            {
                // Gérez l'exception (imprimez-la, enregistrez-la, etc.)
                Console.WriteLine(ex.Message);
                throw;
            }
        }

        public List<Sante> GetSanteById(string cin)
        {
            try
            {
                var filter = Builders<Sante>.Filter.Eq(s => s.CIN, cin);
                return _santeCollection.Find(filter).ToList();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                throw;
            }
        }

        public void AjouterNouvelleInformation(string id, string nomTableau, string nouvelleInformation)
        {
            try
            {
                var filter = Builders<Sante>.Filter.Eq(s => s.CIN, id);

                var update = Builders<Sante>.Update.Push(nomTableau, nouvelleInformation);

                _santeCollection.UpdateOne(filter, update);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                throw;
            }
        }

    }

    public class Vaccination
    {
        public string Nom { get; set; }
        public DateTime Date { get; set; }
    }

    public class MesuresAnthropometriques
    {
        public int Taille { get; set; }
        public int Poids { get; set; }
        public string PressionArterielle { get; set; }
    }

    public class ResultatExamen
    {
        public string Nom { get; set; }
        public string Resultat { get; set; }
    }

    public class CoordonneesMedecinTraitant
    {
        public string Nom { get; set; }
        public string Specialite { get; set; }
        public string Telephone { get; set; }
    }

    public class ChronologieMaladieChronique
    {
        public string Nom { get; set; }
        public DateTime DateDiagnostic { get; set; }
    }

    public class HistoireChirurgie
    {
        public string Nom { get; set; }
        public DateTime Date { get; set; }
    }

    public class ModeDeVie
    {
        public string Alimentation { get; set; }
        public string ActivitePhysique { get; set; }
    }

}
