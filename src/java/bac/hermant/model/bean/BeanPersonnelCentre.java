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
public class BeanPersonnelCentre {
 
    private String niss, nom, prenom, password, role , errorMessage;
    private int id_Role, centre_attribue;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getId_Role() {
        return id_Role;
    }

    public void setId_Role(int id_Role) {
        this.id_Role = id_Role;
    }



    public int getCentre_attribue() {
        return centre_attribue;
    }

    public void setCentre_attribue(int centre_attribue) {
        this.centre_attribue = centre_attribue;
    }

    @Override
    public String toString() {
        return "BeanPersonnelCentre{" + "niss=" + niss + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", role=" + role + ", errorMessage=" + errorMessage + ", id_Role=" + id_Role + ", centre_attribue=" + centre_attribue + '}';
    }


    
    
}
