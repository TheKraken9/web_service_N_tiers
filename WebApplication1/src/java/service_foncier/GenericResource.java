/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package service_foncier;

import DTO_Banque.Banque;
import DTO_Bien.Bien;
import DTO_Devise.Devise;
import DTO_Foncier.Foncier;
import DTO_Transaction.Transaction;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
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
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import project_banque.session_bean_banque_remoteRemote;
import response.ResponseData;
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
     * Retrieves representation of an instance of service_foncier.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/invokeall/{id}")
    public String getJson(@PathParam("id") int id) {
        
        Gson gson = new Gson();
        ArrayList<Foncier> listes_foncier = null;
        ArrayList<Banque> listes_banques = null;
        CombinedData combinedData = null;
        try{
                Properties props1 = new Properties();
                props1.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props1.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
                InitialContext ctx1 = new InitialContext(props1);
                NewSessionBeanRemoteRemote new_session_bean_remote = (NewSessionBeanRemoteRemote) ctx1.lookup("java:global/EJBModule1/NewSessionBeanRemote!session_bean_remote.NewSessionBeanRemoteRemote");
                
                listes_foncier = (ArrayList<Foncier>)new_session_bean_remote.foncier(id);
                ArrayList<Devise> dev = new_session_bean_remote.devises();
                
                Properties props2 = new Properties();
                props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
                InitialContext ctx2 = new InitialContext(props2);
                session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
                
                listes_banques = (ArrayList<Banque>)session_bean_banque.banque(id);
                
                combinedData = new CombinedData(listes_foncier, listes_banques, dev);
                
            }catch(Exception e){
                System.out.println("erreur");
                System.out.println(e.getMessage());
            }
        return gson.toJson(combinedData);
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/transaction")
    public String postData(Transaction insertData) {
        Gson gson = new Gson();
        System.out.println(insertData.getSomme() + " et " + insertData.getVente());
        try {
            // Insérez ici la logique d'insertion des données en utilisant insertData

            // Exemple de connexion à une session distante
            Properties props2 = new Properties();
            props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
            InitialContext ctx2 = new InitialContext(props2);
            session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
            
            session_bean_banque.make_transaction(insertData.getDepositaire(), insertData.getDestinataire(), insertData.getSomme(), insertData.getVente());

            // Exemple de réponse JSON
            ResponseData responseData = new ResponseData("Insertion réussie");
            return gson.toJson(responseData);
        } catch (Exception e) {
            System.out.println("Erreur d'insertion");
            System.out.println(e.getMessage());
            ResponseData responseData = new ResponseData("Erreur d'insertion : " + e.getMessage());
            return gson.toJson(responseData);
        }
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sell")
    public String postData2(Bien insertData) {
        Gson gson = new Gson();
         try {
            // Exemple de connexion à une session distante
            Properties props = new Properties();
                props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
                InitialContext ctx = new InitialContext(props);
                NewSessionBeanRemoteRemote new_session_bean_remote = (NewSessionBeanRemoteRemote) ctx.lookup("java:global/EJBModule1/NewSessionBeanRemote!session_bean_remote.NewSessionBeanRemoteRemote");
                
            new_session_bean_remote.sell(insertData.getVendeur(), insertData.getAcheteur(), insertData.getPartielle());
            // Exemple de réponse JSON
            ResponseData responseData = new ResponseData("Insertion réussie");
            return gson.toJson(responseData);
        } catch (Exception e) {
            System.out.println("Erreur d'insertion");
            System.out.println(e.getMessage());
            ResponseData responseData = new ResponseData("Erreur d'insertion : " + e.getMessage());
            return gson.toJson(responseData);
        }
    }
    

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    private class CombinedData {
        private ArrayList<Foncier> foncierData;
        private ArrayList<Banque> banqueData;
        private ArrayList<Devise> deviseData;

        public CombinedData(ArrayList<Foncier> foncier, ArrayList<Banque> banque, ArrayList<Devise> devise) {
            this.foncierData = foncier;
            this.banqueData = banque;
            this.deviseData = devise;
        }
    }
}
