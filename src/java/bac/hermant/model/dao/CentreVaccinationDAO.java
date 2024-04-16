/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao;

import bac.hermant.model.CentreVaccination;
import bac.hermant.model.Citoyens;
import bac.hermant.model.Vaccins;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public interface CentreVaccinationDAO {

    public String weekMaxiBtw2Doses(Citoyens p, Vaccins v);

    public String weekMiniBtw2Doses(Citoyens p, Vaccins v);

    public CentreVaccination createCentre(CentreVaccination cv) throws SQLException;

    public ArrayList<CentreVaccination> getListeDesCentres();

    public CentreVaccination getInfoDuCentre(CentreVaccination cv);

    public ArrayList<Citoyens> getStatistiqueEtatVaccinalPatient();
}
