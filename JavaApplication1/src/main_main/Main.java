/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main_main;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session_bean_remote.NewSessionBeanRemoteRemote;

/**
 *
 * @author 26134
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        InitialContext ctx = new InitialContext(props);
        NewSessionBeanRemoteRemote new_session_bean_remote = (NewSessionBeanRemoteRemote) ctx.lookup("java:global/WebApplication1/NewSessionBeanRemote!session_bean_remote.NewSessionBeanRemoteRemote");
        //System.out.println(new_session_bean_remote.all_foncier());
    }
    
}
