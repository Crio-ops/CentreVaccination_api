/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao;

import bac.hermant.model.PersonnelDuCentre;
import bac.hermant.model.TicketPointage;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public interface PersonnelDuCentreDAO {

    public PersonnelDuCentre setPersonnelInVacCentre(PersonnelDuCentre pdc);

    public ArrayList<PersonnelDuCentre> getListeDuPersonnel();

    public PersonnelDuCentre deletePersonnel(PersonnelDuCentre pdc);

    public PersonnelDuCentre selectPersonnel(PersonnelDuCentre pc);

    public ArrayList<PersonnelDuCentre> getListeDesMedecinsParCentre(PersonnelDuCentre pc);

    public ArrayList<PersonnelDuCentre> getListeDuPersonnelDuCentre(PersonnelDuCentre pdcvac);

    public PersonnelDuCentre insertTicketPointageEntre(PersonnelDuCentre pc);

    public PersonnelDuCentre insertTicketPointageSortie(PersonnelDuCentre pc);

    public ArrayList<PersonnelDuCentre> getListePointageEntreePersonnelParCentre(PersonnelDuCentre pc);

    public ArrayList<PersonnelDuCentre> getListePointageSortiePersonnelParCentre(PersonnelDuCentre pc);
}
