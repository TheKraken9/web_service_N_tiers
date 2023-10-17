package project_banque;

import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.Remote;

import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.Remote;

import DTO_Banque.Banque;

import java.io.Serializable;
import javax.ws.rs.core.Response;

/**
 *
 * @author 26134
 */
@Remote
public interface session_bean_banque_remoteRemote extends Serializable{

    public String hello_banque(String hafatra);
     
    public ArrayList<Banque> all_banque() throws Exception;
    
    public ArrayList<Banque> banque(int id) throws Exception;
    
    public void new_banque(Banque b) throws Exception;
    
    public void make_transaction(int id1, int id2, double somme, double vente) throws Exception;
    
    public double check_sold(int id) throws Exception;
    
    public void update_somme(double somme,int id1) throws Exception;
}