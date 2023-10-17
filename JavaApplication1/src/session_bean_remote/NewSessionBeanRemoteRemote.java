/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package session_bean_remote;

import DTO_Devise.Devise;
import DTO_Foncier.Foncier;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author 26134
 */
@Remote
public interface NewSessionBeanRemoteRemote extends Serializable{

    public String akory(String hafatra);
     
     public String test_coonection();
     
     public ArrayList<Foncier> all_foncier() throws Exception;
     
     public ArrayList<Foncier> foncier(int id) throws Exception;
     
     public Devise get_devise(int id) throws Exception;
     
     public ArrayList<Devise> devises() throws Exception;
     
     public void sell(int id1, int id2, String partielle) throws Exception;
}
