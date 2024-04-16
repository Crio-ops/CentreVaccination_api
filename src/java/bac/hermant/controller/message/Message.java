/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller.message;

import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class Message {
    
    private String patient, message, nomVaccin,rdvHeure, rdvDate, mess2Dose ;
    private ArrayList<String>date_de_Rdv = new ArrayList<String>();
    private ArrayList<String>heure_de_Rdv = new ArrayList<String>();
   
    
    public Message(){
        
    }

    public String getMess2Dose() {
        return mess2Dose;
    }

    public void setMess2Dose(String mess2Dose) {
        this.mess2Dose = mess2Dose;
    }

    public ArrayList<String> getDate_de_Rdv() {
        return date_de_Rdv;
    }

    public void setDate_de_Rdv(ArrayList<String> date_de_Rdv) {
        this.date_de_Rdv = date_de_Rdv;
    }

    public ArrayList<String> getHeure_de_Rdv() {
        return heure_de_Rdv;
    }

    public void setHeure_de_Rdv(ArrayList<String> heure_de_Rdv) {
        this.heure_de_Rdv = heure_de_Rdv;
    }
   

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

 

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNomVaccin() {
        return nomVaccin;
    }

    public void setNomVaccin(String nomVaccin) {
        this.nomVaccin = nomVaccin;
    }

    public String getRdvHeure() {
        return rdvHeure;
    }

    public void setRdvHeure(String rdvHeure) {
        this.rdvHeure = rdvHeure;
    }

    public String getRdvDate() {
        return rdvDate;
    }

    public void setRdvDate(String rdvDate) {
        this.rdvDate = rdvDate;
    }


}
