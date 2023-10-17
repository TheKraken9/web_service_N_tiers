/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO_Banque;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 26134
 */
@XmlRootElement
public class Banque implements Serializable{
    private int id;
    private int no_compte;
    private Double solde;

    public Banque() {
    }

    public Banque(int id,int no_compte, Double solde) {
        this.id = id;
        this.no_compte = no_compte;
        this.solde = solde;
    }

    public Banque(int id) {
        this.id = id;
    }

    public Banque(Double solde) {
        this.solde = solde;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public int getNo_compte() {
        return no_compte;
    }

    public void setNo_compte(int no_compte) {
        this.no_compte = no_compte;
    }
    
    
}
