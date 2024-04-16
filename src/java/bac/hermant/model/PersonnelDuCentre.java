/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model;

import bac.hermant.model.dao.AbstractDAOFactory;
import bac.hermant.model.dao.PersonnelDuCentreDAO;
import bac.hermant.model.dao.mysql.MySqlDAOFactory;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class PersonnelDuCentre extends TicketPointage{

    private String niss, nom, prenom, role, motDePasse;
    private int id_Role, centre_attribue;

    public String getNiss() {
        return niss;
    }

    public void setNiss(String enss) {
        this.niss = enss;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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



    public int getCentre_attribue() {
        return centre_attribue;
    }

    public void setCentre_attribue(int centre_attribue) {
        this.centre_attribue = centre_attribue;
    }

    @Override
    public String toString() {
        return "PersonnelDuCentre{" + "niss=" + niss + ", nom=" + nom + ", prenom=" + prenom + ", role=" + role + ", motDePasse=" + motDePasse + ", id_Role=" + id_Role + ", centre_attribue=" + centre_attribue + '}';
    }

    public static boolean checkPersonnelEnroll(ArrayList<PersonnelDuCentre> lpdc) {

        int nombre_med = 0;
        int nombre_inf = 0;

        for (PersonnelDuCentre pc : lpdc) {

            if (pc.getId_Role() == 3) {
                nombre_inf = nombre_inf + 1;
            }else if(pc.getId_Role() == 2){
                nombre_med = nombre_med + 1;
            }
            
        }
        
        if( nombre_med*10 <= nombre_inf){
            System.out.println("False, on peut engager ! Med : " + nombre_med + " inf : " + nombre_inf);
            return false;
        }else{
            System.out.println("True, on ne peux pas engager ! Med : " + nombre_med + " inf : " + nombre_inf);
            return true;
        }
    }

    public PersonnelDuCentre setPersonnelInVacCentre(PersonnelDuCentre pdc) {
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        PersonnelDuCentreDAO PdcDAO = AbstractDAOFactory.getFactory().createPersonnelDuCentreDAO();

        return PdcDAO.setPersonnelInVacCentre(pdc);

    }

    public ArrayList<PersonnelDuCentre> getListeDuPersonnel() {
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        PersonnelDuCentreDAO PdcDAO = AbstractDAOFactory.getFactory().createPersonnelDuCentreDAO();

        return PdcDAO.getListeDuPersonnel();
    }

    public PersonnelDuCentre deletePersonnel(PersonnelDuCentre pdc) {
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        PersonnelDuCentreDAO PdcDAO = AbstractDAOFactory.getFactory().createPersonnelDuCentreDAO();

        return PdcDAO.deletePersonnel(pdc);
    }

    public PersonnelDuCentre selectPersonnel(PersonnelDuCentre pc) {
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        PersonnelDuCentreDAO PdcDAO = AbstractDAOFactory.getFactory().createPersonnelDuCentreDAO();

        return PdcDAO.selectPersonnel(pc);
    }
    
    public ArrayList<PersonnelDuCentre> getListeDesMedecinsParCentre(PersonnelDuCentre pc){
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        PersonnelDuCentreDAO PdcDAO = AbstractDAOFactory.getFactory().createPersonnelDuCentreDAO();

        return PdcDAO.getListeDesMedecinsParCentre(pc);
    }

    public ArrayList<PersonnelDuCentre> getListeDuPersonnelDuCentre(PersonnelDuCentre pdcvac){
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        PersonnelDuCentreDAO PdcDAO = AbstractDAOFactory.getFactory().createPersonnelDuCentreDAO();

        return PdcDAO.getListeDuPersonnelDuCentre(pdcvac);
    }
    
    public PersonnelDuCentre insertTicketPointageEntre(PersonnelDuCentre pc){
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        PersonnelDuCentreDAO PdcDAO = AbstractDAOFactory.getFactory().createPersonnelDuCentreDAO();

        return PdcDAO.insertTicketPointageEntre(pc);
    }
    
    public PersonnelDuCentre insertTicketPointageSortie(PersonnelDuCentre pc){
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        PersonnelDuCentreDAO PdcDAO = AbstractDAOFactory.getFactory().createPersonnelDuCentreDAO();

        return PdcDAO.insertTicketPointageSortie(pc);
    }
    
    public ArrayList<PersonnelDuCentre> getListePointageSortiePersonnelParCentre(PersonnelDuCentre pc){
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        PersonnelDuCentreDAO PdcDAO = AbstractDAOFactory.getFactory().createPersonnelDuCentreDAO();

        return PdcDAO.getListePointageSortiePersonnelParCentre(pc);
    }
    
        public ArrayList<PersonnelDuCentre> getListePointageEntreePersonnelParCentre(PersonnelDuCentre pc){
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        PersonnelDuCentreDAO PdcDAO = AbstractDAOFactory.getFactory().createPersonnelDuCentreDAO();

        return PdcDAO.getListePointageEntreePersonnelParCentre(pc);
    }

}
