/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO_Devise;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author 26134
 */
public class Devise implements Serializable{
    private int id;
    private String nom;
    private Double valeur;
    private Double vente;
    private Date date_devise;

    public Devise(int id, String nom, Double valeur,Double vente, Date date_devise) {
        this.id = id;
        this.nom = nom;
        this.valeur = valeur;
        this.vente = vente;
        this.date_devise = date_devise;
    }

    public Devise(int id) {
        this.id = id;
    }

    public Devise(String nom) {
        this.nom = nom;
    }

    public Devise(Double valeur) {
        this.valeur = valeur;
    }

    public Devise(Date date_devise) {
        this.date_devise = date_devise;
    }

    public Devise() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) throws Exception {
        if(this.valeur <= 0){
            throw new Exception("Valeur negative");
        }
        this.valeur = valeur;
    }

    public Date getDate_devise() {
        return date_devise;
    }

    public void setDate_devise(Date date_devise) {
        this.date_devise = date_devise;
    }

    public Double getVente() {
        return vente;
    }

    public void setVente(Double vente) {
        this.vente = vente;
    }
    
    
    
}
