/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connecting;

import DTO_Banque.Banque;
import DTO_Foncier.Foncier;
import DTO_Devise.Devise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.naming.InitialContext;
import project_banque.session_bean_banque_remoteRemote;

/**
 *
 * @author 26134
 */
public class FoncierEntity {
    public static ArrayList<Foncier> getAll(Connection con) throws Exception{
        ArrayList <Foncier> liste = new ArrayList<Foncier>();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from info_foncier";
            System.out.println("zatra tsika zany");
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getString("partielle"));
                System.out.println(res.getString("id"));
                Foncier ze = new Foncier(res.getInt("id"), res.getString("partielle"), res.getDouble("price"));
                liste.add(ze);
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return liste;
    }
    public static ArrayList<Foncier> getFoncier(Connection con, int id) throws Exception{
        ArrayList <Foncier> liste = new ArrayList<Foncier>();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from info_foncier where id ="+id;
            System.out.println("zatra tsika zany");
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getString("partielle"));
                System.out.println(res.getString("id"));
                Foncier ze = new Foncier(res.getInt("id"), res.getString("partielle"), res.getDouble("price"));
                liste.add(ze);
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return liste;
    }
    public static Devise getDevise(Connection con, int id)throws Exception{
        Devise devise = new Devise();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from devise where id ="+id;
            System.out.println("zatra tsika zany");
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getString("nom"));
                System.out.println(res.getDouble("valeur"));
                System.out.println(res.getDate("date"));
                devise = new Devise(res.getInt("id"), res.getString("nom"), res.getDouble("valeur"),res.getDouble("vente"),res.getDate("date"));
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        System.out.println(devise.getNom() + " eto");
        return devise;
    }
    
    
    public static ArrayList<Devise> getAllDevises(Connection con) throws Exception{
    ArrayList <Devise> listes = new ArrayList<Devise>();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "SELECT DISTINCT ON (nom) id, nom, valeur, vente, date FROM devise ORDER BY nom, date DESC";
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getString("id"));
                System.out.println(res.getString("nom"));
                Devise ze = new Devise(res.getInt("id"), res.getString("nom"), res.getDouble("valeur"),res.getDouble("vente"), res.getDate("date"));
                listes.add(ze);
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return listes;
    }
    
    
     public static double is_ok(Connection con, String parcelle,int id) throws Exception{
        double is_ok = 0;
        double som = 0;
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from info_foncier where partielle='" + parcelle + "' and id="+id;
            System.out.println(requete);
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                som = res.getDouble("price");
                System.out.println(res.getInt("id"));
                System.out.println(res.getDouble("price"));
                return som;
            }
        }catch(Exception e){
            throw new Exception("hehehe boy");
        }
        finally{
            if(res != null){
                res.close();
            }
            if(st != null){
                st.close();
            }
            if(co == 1){
                con.close();
            }
        }
        return is_ok;
    }
    
    public static void updateParcelle(Connection con, String parcelle,int id2) throws Exception {
        PreparedStatement pst = null;
    int co = 0;
    try {
        if (con == null) {
            con = Postgres.getConnect("postgres");
            co = 1;
        }

        String requete = "update info_foncier set id="+id2 + " where partielle='"+parcelle+"'";
        pst = con.prepareStatement(requete);
       
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected != 1) {
            throw new Exception("L'insertion a échoué. Aucune ligne n'a été affectée.");
        }
           System.out.println("modification effectue");
    } catch (Exception e) {
        throw new Exception("Erreur lors de l'insertion des données : " + e.getMessage());
    } finally {
        if (pst != null) {
            pst.close();
        }
        if (co == 1) {
            con.close();
        }
    }
    }
    
    public static void updateSomme(Connection con, double somme,int id1) throws Exception {
        try{
            Banque data = new Banque(15,123456789,45121.2);
            Properties props2 = new Properties();
            props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
            InitialContext ctx2 = new InitialContext(props2);
            session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
            
            session_bean_banque.update_somme(somme, id1);
        }catch(Exception e){
            System.out.println("erreur dans updateSomme : " + e.getMessage());
        }
        
    }
    
    public static double getPrice(Connection con, int id) throws Exception {
        double compte = 0.0;
        try{
            Banque data = new Banque(15,123456789,45121.2);
            Properties props2 = new Properties();
            props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
            InitialContext ctx2 = new InitialContext(props2);
            session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
            
            //session_bean_banque.new_banque(data);
            compte = session_bean_banque.check_sold(id);
        
        }catch(Exception e){
            e.getMessage();
        }
        return compte;
    }
    
}
