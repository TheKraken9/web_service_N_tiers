using Microsoft.AspNetCore.Mvc;
using serveur_web_sante.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace serveur_web_sante.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class SanteController : ControllerBase
    {
        // GET: api/<SanteController>
        [HttpGet]
        public List<Sante> Get()
        {
            Sante sante = new Sante("mongodb://localhost:27017", "sante");
            List<Sante> santes = sante.GetAllSante();
            return santes;
        }

        // GET api/<SanteController>/5
        [HttpGet("{id}")]
        public List<Sante> Get(string id)
        {
            Sante sante1 = new Sante("mongodb://localhost:27017", "sante");
            List<Sante> santes1 = sante1.GetSanteById(id);
            return santes1;
        }

        // POST api/<SanteController>
        [HttpPost]
        public void Post([FromBody] SanteRequest request)
        {
            Sante sante = new Sante("mongodb://localhost:27017", "sante");
            sante.AjouterNouvelleInformation(request.Id, request.NomTableau, request.NouvelleInformation);
        }

        public class SanteRequest
        {
            public string Id { get; set; }
            public string NomTableau { get; set; }
            public string NouvelleInformation { get; set; }
        }

        // PUT api/<SanteController>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/<SanteController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
