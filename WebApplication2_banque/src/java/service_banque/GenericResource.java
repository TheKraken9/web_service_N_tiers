/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package service_banque;

import DTO_Banque.Banque;
import DTO_Foncier.Foncier;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Properties;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import project_banque.session_bean_banque_remoteRemote;
import session_bean_remote.NewSessionBeanRemoteRemote;

/**
 * REST Web Service
 *
 * @author 26134
 */
@Path("generic")
@RequestScoped
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of service_banque.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/banque/{id}")
    public String getJson(@PathParam("id") int id) {
        Gson gson = new Gson();
        ArrayList<Banque> listes_banques = null;
         try{
                /*Properties props1 = new Properties();
                props1.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props1.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
                InitialContext ctx1 = new InitialContext(props1);
                NewSessionBeanRemoteRemote new_session_bean_remote = (NewSessionBeanRemoteRemote) ctx1.lookup("java:global/EJBModule1/NewSessionBeanRemote!session_bean_remote.NewSessionBeanRemoteRemote");
                
                listes_foncier = (ArrayList<Foncier>)new_session_bean_remote.foncier(id);*/
             
                
                Properties props2 = new Properties();
                props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
                InitialContext ctx2 = new InitialContext(props2);
                session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
                
                listes_banques = (ArrayList<Banque>)session_bean_banque.banque(id);
            }catch(Exception e){
                System.out.println("erreur");
                System.out.println(e.getMessage());
            }
        return gson.toJson(listes_banques);
    }
    

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/banque")
    public Response postData(Banque data) {
        try{
            Properties props2 = new Properties();
            props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
            InitialContext ctx2 = new InitialContext(props2);
            session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
            
            session_bean_banque.new_banque(data);
            return Response.status(Response.Status.CREATED).build();
        }catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error: " + e.getMessage()).build();
        }
    }
}
