/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO_Bien;

import java.io.Serializable;

/**
 *
 * @author 26134
 */
public class Bien implements Serializable{
    private int vendeur;
    private int acheteur;
    private String partielle;

    public Bien() {
    }

    public Bien(int vendeur) {
        this.vendeur = vendeur;
    }

    public Bien(String partielle) {
        this.partielle = partielle;
    }

    public Bien(int vendeur, int acheteur, String partielle) {
        this.vendeur = vendeur;
        this.acheteur = acheteur;
        this.partielle = partielle;
    }

    public int getVendeur() {
        return vendeur;
    }

    public void setVendeur(int vendeur) {
        this.vendeur = vendeur;
    }

    public int getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(int acheteur) {
        this.acheteur = acheteur;
    }

    public String getPartielle() {
        return partielle;
    }

    public void setPartielle(String partielle) {
        this.partielle = partielle;
    }
    
    
    
}
