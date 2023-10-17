/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connecting;

import DTO_Banque.Banque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 26134
 */
public class BanqueEntity {
    public static ArrayList<Banque> getAll(Connection con) throws Exception{
        ArrayList <Banque> liste = new ArrayList<Banque>();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from solde";
            System.out.println("zatra tsika zany");
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getInt("solde"));
                System.out.println(res.getDouble("id"));
                Banque ze = new Banque(res.getInt("id"),res.getInt("no_compte"), res.getDouble("solde"));
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
    
     public static ArrayList<Banque> getBanque(Connection con, int id) throws Exception{
        ArrayList <Banque> liste = new ArrayList<Banque>();
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from solde where id ="+id;
            System.out.println("zatra tsika zany");
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                System.out.println(res.getInt("solde"));
                System.out.println(res.getDouble("id"));
                Banque ze = new Banque(res.getInt("id"),res.getInt("no_compte"), res.getDouble("solde"));
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
    
    public static void insertBanque(Connection con, Banque banque) throws Exception {
    PreparedStatement pst = null;
    int co = 0;
    try {
        if (con == null) {
            con = Postgres.getConnect("postgres");
            co = 1;
        }

        String requete = "INSERT INTO solde (id, solde) VALUES (?, ?)";
        pst = con.prepareStatement(requete);
        pst.setInt(1, banque.getId());
        pst.setInt(2, banque.getNo_compte());
        pst.setDouble(2, banque.getSolde());
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected != 1) {
            throw new Exception("L'insertion a échoué. Aucune ligne n'a été affectée.");
        }

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
    
    public static double is_ok(Connection con, Double solde,int id) throws Exception{
        double is_ok = 0;
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from solde where id ="+id;
           
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                double som = res.getDouble("solde");
                System.out.println(res.getInt("id"));
                System.out.println(res.getDouble("solde"));
                if(solde <= som){
                    return som;
                }else {
                    return 0;
                }
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
    
    
    public static double his_sold(Connection con, Double solde,int id) throws Exception{
        double is_ok = 0;
        Statement st = null;
        ResultSet res = null;
        int co = 0;
        try{
            if(con==null){
                con = Postgres.getConnect("postgres");
                co = 1;
            }
            String requete = "select * from solde where id ="+id;
           
            st = con.createStatement();
            res = st.executeQuery(requete);
            while(res.next()){
                is_ok = res.getDouble("solde");
                System.out.println(res.getInt("id"));
                System.out.println(res.getDouble("solde"));
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
    
    public static void updateSomme(Connection con,double somme,int id1) throws Exception {
        PreparedStatement pst = null;
    int co = 0;
    try {
        if (con == null) {
            con = Postgres.getConnect("postgres");
            co = 1;
        }

        String requete = "update solde set solde ="+somme + " where id="+id1;
        pst = con.prepareStatement(requete);
        /*pst.setInt(1, banque.getId());
        pst.setInt(2, banque.getNo_compte());
        pst.setDouble(2, banque.getSolde());*/
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
}
