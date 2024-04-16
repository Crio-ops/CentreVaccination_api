/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model;

import bac.hermant.model.dao.AbstractDAOFactory;
import bac.hermant.model.dao.VaccinDAO;
import bac.hermant.model.dao.mysql.MySqlDAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kevin
 */
public class Vaccins {
    private String nom, num_Lot;
    private int nbrDoses,joursMiniDose2,joursMaxiDose2 , idVaccin;
 
    public Vaccins(){
}
    
    public String getNom() {
        return nom; 
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNum_Lot() {
        return num_Lot;
    }

    public void setNum_Lot(String num_Lot) {
        this.num_Lot = num_Lot;
    }

    public int getNbrDoses() {
        return nbrDoses;
    }

    public void setNbrDoses(int nbrDoses) {
        this.nbrDoses = nbrDoses;
    }

    public int getJoursMiniDose2() {
        return joursMiniDose2;
    }

    public void setJoursMiniDose2(int joursMiniDose2) {
        this.joursMiniDose2 = joursMiniDose2;
    }

    public int getJoursMaxiDose2() {
        return joursMaxiDose2;
    }

    public void setJoursMaxiDose2(int joursMaxiDose2) {
        this.joursMaxiDose2 = joursMaxiDose2;
    }




    public int getIdVaccin() {
        return idVaccin;
    }

    public void setIdVaccin(int idVaccin) {
        this.idVaccin = idVaccin;
    }

    @Override
    public String toString() {
        return "Vaccins{" + "nom=" + nom + ", num_Lot=" + num_Lot + ", nbrDoses=" + nbrDoses + ", joursMiniDose2=" + joursMiniDose2 + ", joursMaxiDose2=" + joursMaxiDose2 + ", idVaccin=" + idVaccin + '}';
    }

   
    public Vaccins vaccinPourPatient(int age){
    
        Vaccins v = new Vaccins();
        Random rand = new Random();
       
        ArrayList<String> listVaccins= new ArrayList<String>();
        listVaccins.add("Astrazeneca");
        listVaccins.add("Pfizer");
        listVaccins.add("Moderna");
        listVaccins.add("Johnson_Johnson");		
        if(age <41) {
                listVaccins.remove("Astrazeneca");
                v.setNom(listVaccins.get(rand.nextInt(listVaccins.size())));
               
        }else {

    v.setNom(listVaccins.get(rand.nextInt(listVaccins.size())));

        }   
        

        return v;
    }

        public Vaccins getVaccinsInVacCentre(Vaccins v) {
         AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        VaccinDAO vacDAO = AbstractDAOFactory.getFactory().createVaccinDAO();
      
        return vacDAO.getVaccinsInVacCentre(v);
    }
  
    
    public Vaccins verifNumLot(Vaccins v) throws SQLException{
         AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        VaccinDAO vacDAO = AbstractDAOFactory.getFactory().createVaccinDAO();
      
        return vacDAO.verifNumLot(v);
    }
    
    public Vaccins getInfoVaccins(Vaccins v){
         AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        VaccinDAO vacDAO = AbstractDAOFactory.getFactory().createVaccinDAO();
      
        return vacDAO.getInfoVaccins(v);
    }
    
}
    
   

