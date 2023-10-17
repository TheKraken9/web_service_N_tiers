/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO_Foncier;

import java.io.Serializable;

/**
 *
 * @author 26134
 */
public class Foncier implements Serializable{
    private int cin;
    private String partielle;
    private double price;

    public Foncier(int cin, String partielle, double price) {
        this.cin = cin;
        this.partielle = partielle;
        this.price = price;
    }

    public Foncier() {
    }

    public Foncier(int cin) {
        this.cin = cin;
    }

    public Foncier(String partielle) {
        this.partielle = partielle;
    }

    public Foncier(double price) {
        this.price = price;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getPartielle() {
        return partielle;
    }

    public void setPartielle(String partielle) {
        this.partielle = partielle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
   
}
