using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace serveur_web_sante.Models
{
    public class JavaData
    {
        public List<FoncierData> FoncierData { get; set; }
        public List<BanqueData> BanqueData { get; set; }
        public List<DeviseData> DeviseData { get; set; }
    }

    
}
