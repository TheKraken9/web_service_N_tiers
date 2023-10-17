/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package session_bean;

import javax.ejb.Stateless;

/**
 *
 * @author 26134
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    @Override
    public String hello_world(String message) {
        return message;
    }
}
