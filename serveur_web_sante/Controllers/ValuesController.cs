using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using serveur_web_sante.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace serveur_web_sante.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValuesController : ControllerBase
    {
        // GET: api/<ValuesController>
        [HttpGet]
        public Personne Get()
        {
            Personne pers = new Personne();
            //return new string[] { "value1", "value2" };
            return pers.GetPersonne(123);
        }

        // GET api/<ValuesController>/5
        [HttpGet("{id}")]
        public async Task<IActionResult> Get(int id)
        {
            try
            {
                string javaServiceUrl = "http://localhost:8080/WebApplication1/webresources/generic/invokeall/"+id;
                string javaJson = await CallWebService(javaServiceUrl);
                Personne pers = new Personne();
                Personne dotNetData = pers.GetPersonne(id);
                JavaData javaData = JsonConvert.DeserializeObject<JavaData>(javaJson);

                Sante sante1 = new Sante("mongodb://localhost:27017", "sante");
                List<Sante> santes1 = sante1.GetSanteById(id.ToString());

                return Ok(new { Sante = santes1, Dotnet = dotNetData, Java = javaData });
            }
            catch (Exception e)
            {
                return StatusCode(500, "Erreur interne du serveur");
            }
           
        }

        private async Task<string> CallWebService(string url)
        {
            using (HttpClient client = new HttpClient())
            {
                HttpResponseMessage response = await client.GetAsync(url);

                if (response.IsSuccessStatusCode)
                {
                    return await response.Content.ReadAsStringAsync();
                }
                else
                {
                    // Gérer les erreurs ici
                    return string.Empty;
                }
            }
        }

    

        // POST api/<ValuesController>
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/<ValuesController>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/<ValuesController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
