/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.bean;

/**
 *
 * @author kevin
 */
public class BeanTicket {

    private int id, centre_attribue;
    private String niss, nom, prenom, vaccin_attribue, numLot, num_dose, gestionnaire, etatDeVaccination, heure_de_depart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNiss() {
        return niss;
    }

    public void setNiss(String niss) {
        this.niss = niss;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getVaccin_attribue() {
        return vaccin_attribue;
    }

    public void setVaccin_attribue(String vaccin_attribue) {
        this.vaccin_attribue = vaccin_attribue;
    }

    public String getNumLot() {
        return numLot;
    }

    public void setNumLot(String numLot) {
        this.numLot = numLot;
    }

    public String getNum_dose() {
        return num_dose;
    }

    public void setNum_dose(String num_dose) {
        this.num_dose = num_dose;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(String gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    public int getCentre_attribue() {
        return centre_attribue;
    }

    public void setCentre_attribue(int centre_attribue) {
        this.centre_attribue = centre_attribue;
    }

    public String getEtatDeVaccination() {
        return etatDeVaccination;
    }

    public void setEtatDeVaccination(String etatDeVaccination) {
        this.etatDeVaccination = etatDeVaccination;
    }

    public String getHeure_de_depart() {
        return heure_de_depart;
    }

    public void setHeure_de_depart(String heure_de_depart) {
        this.heure_de_depart = heure_de_depart;
    }

    @Override
    public String toString() {
        return "BeanTicket{" + "id=" + id + ", centre_attribue=" + centre_attribue + ", niss=" + niss + ", nom=" + nom + ", prenom=" + prenom + ", vaccin_attribue=" + vaccin_attribue + ", numLot=" + numLot + ", num_dose=" + num_dose + ", gestionnaire=" + gestionnaire + ", etatDeVaccination=" + etatDeVaccination + ", heure_de_depart=" + heure_de_depart + '}';
    }

    

}
