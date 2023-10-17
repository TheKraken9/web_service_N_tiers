/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package project_banque;

import DTO_Banque.Banque;
import connecting.BanqueEntity;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

/**
 *
 * @author 26134
 */
@Stateless
public class session_bean_banque_remote implements session_bean_banque_remoteRemote {

    @Override
    public String hello_banque(String message) {
        return message;
    }

    @Override
    public ArrayList<Banque> all_banque() throws Exception{
        ArrayList<Banque> listes = BanqueEntity.getAll(null);
        return listes;
    }
    
    @Override
    public ArrayList<Banque> banque(int id) throws Exception{
        ArrayList<Banque> listes = BanqueEntity.getBanque(null, id);
        return listes;
    }
    
    @Override
    public void new_banque(Banque b) throws Exception{
        BanqueEntity.insertBanque(null, b);
    }
    
    @Override
    public void make_transaction(int id1, int id2, double somme, double vente) throws Exception{
        double somme1 = 0;
        double somme2 = 0;
        double ok1 = 0, ok2=0;
        try{
            ok1 = BanqueEntity.is_ok(null, somme, id1);
        ok2 = BanqueEntity.is_ok(null, somme, id2);
        System.out.println(ok1 + " sy " +ok2);
        if(ok1 != 0 && ok1 > somme){
            try{
             somme1 = ok1-somme;
             somme2 = ok2+vente;
            BanqueEntity.updateSomme(null, somme1, id1);
            BanqueEntity.updateSomme(null, somme2, id2);
            }catch(Exception e){
                e.getMessage();
            }
        }else{
            throw new Exception("votre solde est insufisant inferieur à "+ somme + " ariary");
        }
        }catch(Exception e) {
            System.out.println("Erreur de transaction : " + e.getMessage());
        }
    }
    
    @Override
    public double check_sold(int id) throws Exception{
        double sold = 0;
        sold = BanqueEntity.his_sold(null, sold, id);
        return sold;
    }
    
    @Override
    public void update_somme(double somme, int id) throws Exception{
        try{
            BanqueEntity.updateSomme(null, somme, id);
        }catch(Exception e){
            System.out.println("erreur dans la table banque " + e.getMessage());
        }
    }
}
