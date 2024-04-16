/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao.mysql;

import bac.hermant.model.CentreVaccination;
import bac.hermant.model.Citoyens;
import bac.hermant.model.Vaccins;
import bac.hermant.model.dao.CentreVaccinationDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;

/**
 *
 * @author kevin
 */
public class MySqlCentreVaccinationDAO implements CentreVaccinationDAO {

    private static MySqlCentreVaccinationDAO myInstance;

    static {
        myInstance = new MySqlCentreVaccinationDAO();
    }

    public static MySqlCentreVaccinationDAO getInstance() {
        return myInstance;
    }

    public String weekMiniBtw2Doses(Citoyens p, Vaccins v) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();
        String dateMini = "";

        String sql = "SELECT weekMiniBtw2Doses(?,?);";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getDateRdv_Dose1());
            ps.setInt(2, v.getJoursMiniDose2());

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                dateMini = result.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return dateMini;
    }

    public String weekMaxiBtw2Doses(Citoyens p, Vaccins v) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();
        String dateMaxi = "";

        String sql = "SELECT weekMaxiBtw2Doses(?,?);";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getDateRdv_Dose1());
            ps.setInt(2, v.getJoursMaxiDose2());

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                dateMaxi = result.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return dateMaxi;
    }

    public CentreVaccination createCentre(CentreVaccination cv) throws SQLException {

        CentreVaccination result;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "INSERT INTO centre_vac ( nomDuCentre, adresse, lat, lng) VALUES (?,?,?,?);";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, cv.getNomDuCentre());
            ps.setString(2, cv.getAdresse());
            ps.setString(3, cv.getLat());
            ps.setString(4, cv.getLng());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;

        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return cv;

    }

    public ArrayList<CentreVaccination> getListeDesCentres() {
        ArrayList<CentreVaccination> lcv = new ArrayList();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "SELECT nomDuCentre,adresse, lat, lng, num_centre FROM centre_vac ;";
        try {

            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                CentreVaccination cv = new CentreVaccination();

                cv.setNomDuCentre(rs.getString(1));
                cv.setAdresse(rs.getString(2));
                cv.setLat(rs.getString(3));
                cv.setLng(rs.getString(4));
                cv.setNum_centre(rs.getString(5));

                lcv.add(cv);

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }
        return lcv;
    }

    public CentreVaccination getInfoDuCentre(CentreVaccination cv) {
        ArrayList<CentreVaccination> lcv = new ArrayList();

        CentreVaccination cvac = new CentreVaccination();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "SELECT nomDuCentre,adresse, lat, lng, num_centre, nombre_ligne FROM centre_vac where num_centre = ? ;";
        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, cv.getNum_centre());

            rs = ps.executeQuery();

            while (rs.next()) {

                cvac.setNomDuCentre(rs.getString(1));
                cvac.setAdresse(rs.getString(2));
                cvac.setLat(rs.getString(3));
                cvac.setLng(rs.getString(4));
                cvac.setNum_centre(rs.getString(5));
                cvac.setNombre_ligne(rs.getInt(6));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }
        return cvac;
    }
    
       public ArrayList<Citoyens> getStatistiqueEtatVaccinalPatient() {
        ArrayList<Citoyens> lc = new ArrayList();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "select etatDeVaccination from patients;";
        try {

            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Citoyens cit = new Citoyens();

                cit.setEtatDeVaccination(rs.getString(1));
                
                lc.add(cit);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }
        return lc;
    }

}
