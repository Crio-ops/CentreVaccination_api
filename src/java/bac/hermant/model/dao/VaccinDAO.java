/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao;

import bac.hermant.model.Vaccins;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public interface VaccinDAO {
    
    public Vaccins getVaccinsInVacCentre (Vaccins v);
    public Vaccins verifNumLot(Vaccins v) throws SQLException;
    public Vaccins getInfoVaccins(Vaccins v);
}
