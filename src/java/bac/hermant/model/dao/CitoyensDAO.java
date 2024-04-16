/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao;

import bac.hermant.model.Calendrier;
import bac.hermant.model.Citoyens;
import bac.hermant.model.PersonnelDuCentre;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author kevin
 */
public interface CitoyensDAO {

    public Citoyens getCitoyensInVacCentre(Citoyens p);

    public Citoyens getLoginPatient(Citoyens p);

    public Citoyens CitoyensEnPersonnelVac(Citoyens p);

    public Citoyens getInfoPatient(Citoyens p);

    public Citoyens changePassword(Citoyens p);

    public Citoyens vuePatient(Citoyens p);

    public Citoyens vaccination_D1(Citoyens p);

    public Citoyens vaccination_D2(Citoyens p);

    public ArrayList<Citoyens> getListeDesCitoyens();

    public Citoyens callProcedurePatient_dose1(Citoyens p);

    public Citoyens getRdvPatient(Citoyens p);

    public Citoyens getRdvPatient_Dose2(Citoyens p);

    public Citoyens getInfoPatientForD2(Citoyens p);

    public Citoyens getInfoCitoyen(Citoyens citoyen);

    public Citoyens updateRolePersonnelInCitoyens(Citoyens p);

    public Citoyens updateCentreAttribueAuPatient(Citoyens p);

    public ArrayList<Citoyens> getListeRdvDuJour(Calendrier cal);

    public Citoyens validerPresencePatientRdv1(Citoyens cit);

    public Citoyens validerPresencePatientRdv2(Citoyens cit);

    public Citoyens getRdvPatientViaEnss(Citoyens cit);

    public Citoyens getInfoForTicket(Citoyens cit);

    public Citoyens getInfoVaccinationPatient(Citoyens cit);

    public Citoyens getVaccinationPourVuePatient(Citoyens cit);
    
    public ArrayList<Citoyens> getListeDesCitoyensDuCentre(PersonnelDuCentre pdc);

}
