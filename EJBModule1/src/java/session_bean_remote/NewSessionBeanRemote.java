/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package session_bean_remote;

import DTO_Devise.Devise;
import DTO_Foncier.Foncier;
import connecting.FoncierEntity;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author 26134
 */
@Stateless
public class NewSessionBeanRemote implements NewSessionBeanRemoteRemote {

    @Override
    public String akory(String hafatra) {
        return hafatra;
    }

    @Override
    public String test_coonection(){
        String rs = null;
        return rs;
    }
    
    @Override
    public ArrayList<Foncier> all_foncier() throws Exception{
        ArrayList<Foncier> listes = null;
        try{
            listes = FoncierEntity.getAll(null);
        }catch(Exception e){
            e.getMessage();
        }
        return listes;
    }
    
    @Override
    public ArrayList<Foncier> foncier(int id) throws Exception{
        ArrayList<Foncier> listes = null;
        try{
            listes = FoncierEntity.getFoncier(null,id);
        }catch(Exception e){
            e.getMessage();
        }
        return listes;
    }
    
    @Override
    public Devise get_devise(int id) throws Exception{
        Devise devises = null;
        try{
            devises = FoncierEntity.getDevise(null,id);
            System.out.println(devises.getValeur() + " valeur");
        }catch(Exception e){
            e.getMessage();
        }
        return devises;
    } 
    
    @Override
     public ArrayList<Devise> devises() throws Exception {
        ArrayList<Devise> listes = null;
        try{
            listes = FoncierEntity.getAllDevises(null);
        }catch(Exception e){
            e.getMessage();
        }
        return listes;
    }
     
     @Override
     public void sell(int id1, int id2, String partielle) throws Exception {
         double prix = 0.0;double sold1 = 0.0;double sold2 = 0.0;
         try{
            prix = FoncierEntity.is_ok(null, partielle, id1);
            if(prix == 0.0){
                throw new Exception("L acheteur ne possede pas ce bien");
            }
            sold1 = FoncierEntity.getPrice(null, id1);
            sold2 = FoncierEntity.getPrice(null, id2);
             System.out.println("sold1 ="+sold1 + " et sold2="+sold2);
             System.out.println("prix ="+prix);
            if(sold2 < prix){
                throw new Exception("solde insuffisant pour l acheteur");
            }else{
                double prix1 = (double)(sold1 + prix);
                double prix2 = (double)(sold2 - prix);
                System.out.println("prix1="+prix1 + " et prix2="+prix2);
                FoncierEntity.updateParcelle(null, partielle, id2);
                
                FoncierEntity.updateSomme(null, prix1, id1);
                FoncierEntity.updateSomme(null, prix2, id2);
            }
         }catch(Exception e){
             System.out.println("Erreur de vente de bien : " + e.getMessage());
         }
         
     }
}
