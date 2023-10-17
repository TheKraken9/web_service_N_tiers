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
    public class DeviseController : ControllerBase
    {
        // GET: api/<DeviseController>
        [HttpGet]
        public List<Devise> Get()
        {
            Devise devise = new Devise("mongodb://localhost:27017", "devise");
            Console.WriteLine(devise);
            List<Devise> devises = devise.GetAllDevise();
            return devises;
        }

        // GET api/<DeviseController>/5
        [HttpGet("{id}")]
        public List<Devise> Get(string id)
        {
            Devise devise = new Devise("mongodb://localhost:27017", "devise");
            List<Devise> devises = devise.GetDeviseById(id);
            return devises;
        }

        // POST api/<DeviseController>
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/<DeviseController>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/<DeviseController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
