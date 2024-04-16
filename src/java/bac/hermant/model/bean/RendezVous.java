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
public class RendezVous implements Serializable{
    private String date, heure, niss, dateNaissance, presenceRdv1, presenceRdv2;
    private int  centre_attribue;
    public String getNiss() {
        return niss;
    }

    public void setNiss(String niss) {
        this.niss = niss;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

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

       public int getCentre_attribue() {
        return centre_attribue;
    }

    public void setCentre_attribue(int centre_attribue) {
        this.centre_attribue = centre_attribue;
    }

    @Override
    public String toString() {
        return "RendezVous{" + "date=" + date + ", heure=" + heure + ", niss=" + niss + ", dateNaissance=" + dateNaissance + ", presenceRdv1=" + presenceRdv1 + ", presenceRdv2=" + presenceRdv2 + ", centre_attribue=" + centre_attribue + '}';
    }
    
    

    
    
}
