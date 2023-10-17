/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import DTO_Banque.Banque;
import DTO_Foncier.Foncier;
import java.util.ArrayList;
import java.util.Properties;
import javax.naming.InitialContext;
import project_banque.session_bean_banque_remoteRemote;
import session_bean_remote.NewSessionBeanRemoteRemote;

/**
 *
 * @author 26134
 */
public class Test2 {
     public static void main(String[] args) throws Exception{
         try{
             Banque data = new Banque(15,123456789,45121.2);
            Properties props2 = new Properties();
            props2.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props2.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
            InitialContext ctx2 = new InitialContext(props2);
            session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx2.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
            
            //session_bean_banque.new_banque(data);
            session_bean_banque.make_transaction(1, 2, 111,111);
        
        }catch(Exception e){
            e.getMessage();
        }
        /*try{
                Properties props = new Properties();
                props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                props.setProperty("org.omg.CORBA.ORBInitialPort", "1234");
                InitialContext ctx = new InitialContext(props);
                session_bean_banque_remoteRemote session_bean_banque = (session_bean_banque_remoteRemote) ctx.lookup("java:global/EJBModuleBanque/session_bean_banque_remote!project_banque.session_bean_banque_remoteRemote");
                
                ArrayList<Banque> listes = (ArrayList<Banque>)session_bean_banque.banque(3);
                System.out.println("ito");
                for(int i=0;i<listes.size();i++){
                    System.out.println("ao tsara");
                    System.out.println(listes.get(i).getSolde());
                }
            }catch(Exception e){
                System.out.println("erreur test2");
                System.out.println(e.getMessage());
            }*/
       

    }
}
