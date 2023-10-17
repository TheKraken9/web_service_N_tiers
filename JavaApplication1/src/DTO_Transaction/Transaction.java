/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO_Transaction;

/**
 *
 * @author 26134
 */
public class Transaction {
    private int depositaire;
    private int destinataire;
    private double somme;
    private double vente;

    public Transaction() {
    }

    public Transaction(int depositaire) {
        this.depositaire = depositaire;
    }

    public Transaction(double somme) {
        this.somme = somme;
    }

    public Transaction(int depositaire, int destinataire, double somme, double vente) {
        this.depositaire = depositaire;
        this.destinataire = destinataire;
        this.somme = somme;
        this.vente = vente;
    }

    public int getDepositaire() {
        return depositaire;
    }

    public void setDepositaire(int depositaire) {
        this.depositaire = depositaire;
    }

    public int getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(int destinataire) {
        this.destinataire = destinataire;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public double getVente() {
        return vente;
    }

    public void setVente(double vente) {
        this.vente = vente;
    }
    
}
