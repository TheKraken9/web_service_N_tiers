using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace serveur_web_sante.Models
{
    public class DeviseData
    {
        public int Id { get; set; }
        public string Nom { get; set; }
        public double Valeur { get; set; }
        public double Vente { get; set; }
        public DateTime Date { get; set; }
    }
}
