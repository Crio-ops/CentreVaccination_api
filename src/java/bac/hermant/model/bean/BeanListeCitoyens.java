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
public class BeanListeCitoyens {
    private String niss, nom, prenom, adresse, centre_attribue, etatDeVaccination, vaccin_attribue, dateRdv_Dose1,dateRdv_Dose2, heureRdv_Dose1, heureRdv_Dose2, presenceRdv1, presenceRdv2;

    public String getPresenceRdv1() {
        return presenceRdv1;
    }

    public void setPresenceRdv1(String presenceRdv1) {
        this.presenceRdv1 = presenceRdv1;
    }

    public String getPresenceRdv2() {
        return presenceRdv2;
    }

    public void setPresenceRdv2(String presenceRdv2) {
        this.presenceRdv2 = presenceRdv2;
    }

    public String getDateRdv_Dose1() {
        return dateRdv_Dose1;
    }

    public void setDateRdv_Dose1(String dateRdv_Dose1) {
        this.dateRdv_Dose1 = dateRdv_Dose1;
    }

    public String getDateRdv_Dose2() {
        return dateRdv_Dose2;
    }

    public void setDateRdv_Dose2(String dateRdv_Dose2) {
        this.dateRdv_Dose2 = dateRdv_Dose2;
    }

    public String getHeureRdv_Dose1() {
        return heureRdv_Dose1;
    }

    public void setHeureRdv_Dose1(String heureRdv_Dose1) {
        this.heureRdv_Dose1 = heureRdv_Dose1;
    }

    public String getHeureRdv_Dose2() {
        return heureRdv_Dose2;
    }

    public void setHeureRdv_Dose2(String heureRdv_Dose2) {
        this.heureRdv_Dose2 = heureRdv_Dose2;
    }

   

    public String getVaccin_attribue() {
        return vaccin_attribue;
    }

    public void setVaccin_attribue(String vaccin_attribue) {
        this.vaccin_attribue = vaccin_attribue;
    }

    
    public String getCentre_attribue() {
        return centre_attribue;
    }

    public void setCentre_attribue(String centre_attribue) {
        this.centre_attribue = centre_attribue;
    }

    public String getEtatDeVaccination() {
        return etatDeVaccination;
    }

    public void setEtatDeVaccination(String etatDeVaccination) {
        this.etatDeVaccination = etatDeVaccination;
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

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
      @Override
    public String toString() {
        return "BeanListeCitoyens{" + "niss=" + niss + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", centre_attribue=" + centre_attribue + ", etatDeVaccination=" + etatDeVaccination + ", vaccin_attribue=" + vaccin_attribue + ", dateRdv_Dose1=" + dateRdv_Dose1 + ", dateRdv_Dose2=" + dateRdv_Dose2 + ", heureRdv_Dose1=" + heureRdv_Dose1 + ", heureRdv_Dose2=" + heureRdv_Dose2 + ", presenceRdv1=" + presenceRdv1 + ", presenceRdv2=" + presenceRdv2 + '}';
    }
    
    }
