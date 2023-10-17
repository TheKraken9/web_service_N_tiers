/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import DTO_Devise.Devise;
import DTO_Foncier.Foncier;
import java.util.ArrayList;
import java.util.Properties;
import javax.naming.InitialContext;
import session_bean_remote.NewSessionBeanRemoteRemote;

/**
 *
 * @author 26134
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        try{
                Properties props = new Properties();
                props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
                InitialContext ctx = new InitialContext(props);
                NewSessionBeanRemoteRemote new_session_bean_remote = (NewSessionBeanRemoteRemote) ctx.lookup("java:global/EJBModule1/NewSessionBeanRemote!session_bean_remote.NewSessionBeanRemoteRemote");
                
                ArrayList<Foncier> listes = (ArrayList<Foncier>)new_session_bean_remote.foncier(1);
                System.out.println("ito");
                for(int i=0;i<listes.size();i++){
                    System.out.println("ao tsara");
                    System.out.println(listes.get(i).getCin());
                }
                System.out.println("eto");
                Devise devise = new_session_bean_remote.get_devise(1);
                System.out.println(devise.getNom());
                
                ArrayList<Devise> dev = new_session_bean_remote.devises();
                for(int i=0;i<dev.size();i++){
                    System.out.println("ao tsara");
                    System.out.println(dev.get(i).getNom());
                }
            }catch(Exception e){
                System.out.println("erreur");
                System.out.println(e.getMessage());
            }

    }
    
}
