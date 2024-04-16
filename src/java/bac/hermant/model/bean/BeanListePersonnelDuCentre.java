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
public class BeanListePersonnelDuCentre {
    private String niss, nom, prenom, role,centre_attribue;
    private int id_Role;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId_Role() {
        return id_Role;
    }

    public void setId_Role(int id_Role) {
        this.id_Role = id_Role;
    }

   

    public String getCentre_attribue() {
        return centre_attribue;
    }

    public void setCentre_attribue(String centre_attribue) {
        this.centre_attribue = centre_attribue;
    }

    @Override
    public String toString() {
        return "BeanListePersonnelDuCentre{" + "niss=" + niss + ", nom=" + nom + ", prenom=" + prenom + ", role=" + role + ", centre_attribue=" + centre_attribue + ", id_Role=" + id_Role + '}';
    }
 
    
    }
