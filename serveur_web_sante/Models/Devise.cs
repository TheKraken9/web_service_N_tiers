using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;
using MongoDB.Driver;

namespace serveur_web_sante.Models
{
    public class Devise
    {
        private readonly IMongoCollection<Devise> _deviseCollection;

        [BsonId]
        [BsonRepresentation(BsonType.ObjectId)]
        public string Id { get; set; }
        public string Idt { get; set; }
        public string Nom { get; set; }
        public double Valeur { get; set; }
        public double Vente { get; set; }
        public DateTime Date { get; set; }

        public Devise(string connectionString, string databaseName)
        {
            var client = new MongoClient(connectionString);
            var database = client.GetDatabase(databaseName);
            _deviseCollection = database.GetCollection<Devise>("devise");
        }

        public List<Devise> GetAllDevise()
        {
            try
            {
                Console.WriteLine(_deviseCollection.Find(devise => true).ToList());
                return _deviseCollection.Find(devise => true).ToList();
            }
            catch (Exception ex)
            {
                // Gérez l'exception (imprimez-la, enregistrez-la, etc.)
                Console.WriteLine(ex.Message);
                throw;
            }
        }

        public List<Devise> GetDeviseById(string idt)
        {
            try
            {
                var filter = Builders<Devise>.Filter.Eq(s => s.Idt, idt);
                return _deviseCollection.Find(filter).ToList();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                throw;
            }
        }


    }
}
