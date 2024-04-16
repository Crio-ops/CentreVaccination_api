/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao;

import bac.hermant.model.Calendrier;
import bac.hermant.model.Citoyens;
import bac.hermant.model.Vaccins;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public interface CalendrierDAO {

    public ArrayList<Calendrier> getRDVDisponible(Calendrier dateHeure);

    public ArrayList<Calendrier> verifRdvEstDisponible(Calendrier dateHeure);

    public Calendrier insertRdvIndisponible(Calendrier cal);

}
