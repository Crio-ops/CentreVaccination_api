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
public class BeanInfoVaccinRdvPatient {
    private String niss, nom, prenom, dateRdv_Dose1, dateRdv_Dose2, heureRdv_Dose1, heureRdv_Dose2, etatDeVaccination, PresenceRdv1, PresenceRdv2, vaccin_attribue;

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


    public String getEtatDeVaccination() {
        return etatDeVaccination;
    }

    public void setEtatDeVaccination(String etatDeVaccination) {
        this.etatDeVaccination = etatDeVaccination;
    }

    public String getPresenceRdv1() {
        return PresenceRdv1;
    }

    public void setPresenceRdv1(String PresenceRdv1) {
        this.PresenceRdv1 = PresenceRdv1;
    }

    public String getPresenceRdv2() {
        return PresenceRdv2;
    }

    public void setPresenceRdv2(String PresenceRdv2) {
        this.PresenceRdv2 = PresenceRdv2;
    }

    public String getVaccinAttribue() {
        return vaccin_attribue;
    }

    public void setVaccinAttribue(String vaccin_attribue) {
        this.vaccin_attribue = vaccin_attribue;
    }

    @Override
    public String toString() {
        return "BeanInfoVaccinRdvPatient{" + "niss=" + niss + ", nom=" + nom + ", prenom=" + prenom + ", dateRdv_Dose1=" + dateRdv_Dose1 + ", dateRdv_Dose2=" + dateRdv_Dose2 + ", heureRdv_Dose1=" + heureRdv_Dose1 + 
                ", heureRdv_Dose2=" + heureRdv_Dose2 + ", etatDeVaccination=" + etatDeVaccination + ", PresenceRdv1=" + PresenceRdv1 + ", PresenceRdv2=" + PresenceRdv2 + ", vaccinAttribue=" + vaccin_attribue + '}';
    }
    
}
