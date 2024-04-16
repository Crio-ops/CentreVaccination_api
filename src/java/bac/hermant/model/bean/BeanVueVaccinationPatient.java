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
public class BeanVueVaccinationPatient {
    private String nom, prenom, niss, nomVaccin, etatDeVaccination, dateRdv_d1, dateRdv_d2 ;

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

    public String getNiss() {
        return niss;
    }

    public void setNiss(String niss) {
        this.niss = niss;
    }

    public String getNomVaccin() {
        return nomVaccin;
    }

    public void setNomVaccin(String nomVaccin) {
        this.nomVaccin = nomVaccin;
    }

    public String getEtatDeVaccination() {
        return etatDeVaccination;
    }

    public void setEtatDeVaccination(String etatDeVaccination) {
        this.etatDeVaccination = etatDeVaccination;
    }

    public String getDateRdv_d1() {
        return dateRdv_d1;
    }

    public void setDateRdv_d1(String dateRdv_d1) {
        this.dateRdv_d1 = dateRdv_d1;
    }

    public String getDateRdv_d2() {
        return dateRdv_d2;
    }

    public void setDateRdv_d2(String dateRdv_d2) {
        this.dateRdv_d2 = dateRdv_d2;
    }

  @Override
    public String toString() {
        return "BeanVueVaccinationPatient{" + "nom=" + nom + ", prenom=" + prenom + ", niss=" + niss + ", nomVaccin=" + nomVaccin + ", etatDeVaccination=" + etatDeVaccination + ", dateRdv_d1=" + dateRdv_d1 + ", dateRdv_d2=" + dateRdv_d2 + '}';
    }
    
    
}
