/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package session_bean;

import javax.ejb.Local;

/**
 *
 * @author 26134
 */
@Local
public interface NewSessionBeanLocal {

    public String hello_world(String message);
    
}
