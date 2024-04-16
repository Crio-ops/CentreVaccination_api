/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.bean;

import java.io.Serializable;

/**
 *
 * @author kevin
 */
public class Login implements Serializable{

private String niss, password, nom , prenom, dateNaissance, vaccin_attribue, etatDeVaccination, erreurLogin;
private int role, stateVaccinRdv,centre_attribue;

    public Login() {
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getErreurLogin() {
        return erreurLogin;
    }

    public void setErreurLogin(String erreurLogin) {
        this.erreurLogin = erreurLogin;
    }


    public String getNiss() {
        return niss;
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
   
    public void setNiss(String niss) {
        this.niss = niss;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public int getStateVaccinRdv() {
        return stateVaccinRdv;
    }

    public void setStateVaccinRdv(int stateVaccinRdv) {
        this.stateVaccinRdv = stateVaccinRdv;
    }
    
    public int getCentre_attribue() {
        return centre_attribue;
    }

    public void setCentre_attribue(int centre_attribue) {
        this.centre_attribue = centre_attribue;
    }

    public String getVaccin_attribue() {
        return vaccin_attribue;
    }

    public void setVaccin_attribue(String vaccin_attribue) {
        this.vaccin_attribue = vaccin_attribue;
    }

    public String getEtatDeVaccination() {
        return etatDeVaccination;
    }

    public void setEtatDeVaccination(String etatDeVaccination) {
        this.etatDeVaccination = etatDeVaccination;
    }

    @Override
    public String toString() {
        return "Login{" + "niss=" + niss + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", vaccin_attribue=" + vaccin_attribue + ", etatDeVaccination=" + etatDeVaccination + ", erreurLogin=" + erreurLogin + ", role=" + role + ", stateVaccinRdv=" + stateVaccinRdv + ", centre_attribue=" + centre_attribue + '}';
    }
    
}