/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao.mysql;

import bac.hermant.model.Calendrier;
import bac.hermant.model.dao.CalendrierDAO;
import bac.hermant.model.dao.CitoyensDAO;
import bac.hermant.model.dao.VaccinDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class MySqlCalendrierDAO implements CalendrierDAO {

    private static MySqlCalendrierDAO myInstance;

    static {
        myInstance = new MySqlCalendrierDAO();
    }

    public static MySqlCalendrierDAO getInstance() {
        return myInstance;
    }

    public ArrayList<Calendrier> getRDVDisponible(Calendrier dateHeure) {
        ArrayList<Calendrier> arrayResult = new ArrayList<Calendrier>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "SELECT * from plage_horaire_indisponible where date= ? AND centre_attribue = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, dateHeure.getDate());
            ps.setInt(2, dateHeure.getCentre_attribue());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                Calendrier dhResult = new Calendrier();

                dhResult.setId(result.getInt(1));
                dhResult.setDate(result.getString(2));
                dhResult.setHeure(result.getString(3));
                dhResult.setNbrLigne(result.getInt(4));

                arrayResult.add(dhResult);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return arrayResult;
    }

    public ArrayList<Calendrier> verifRdvEstDisponible(Calendrier dateHeure) {
        ArrayList<Calendrier> arrayResult = new ArrayList<Calendrier>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "select * from rdv_patient where dateRdv_Dose1 = ? && heureRdv_Dose1 = ? && centre_attribue = ? || dateRdv_Dose2 = ? && heureRdv_Dose2 = ?  && centre_attribue = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, dateHeure.getDate());
            ps.setString(2, dateHeure.getHeure());
            ps.setInt(3, dateHeure.getCentre_attribue());
            ps.setString(4, dateHeure.getDate());
            ps.setString(5, dateHeure.getHeure());
            ps.setInt(6, dateHeure.getCentre_attribue());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                Calendrier dhResult = new Calendrier();

                dhResult.setId(result.getInt(1));
                dhResult.setDate(result.getString(2));
                dhResult.setHeure(result.getString(3));

                arrayResult.add(dhResult);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return arrayResult;
    }

    public Calendrier insertRdvIndisponible(Calendrier cal) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "INSERT INTO plage_horaire_indisponible (date, heure, nbr_ligne, centre_attribue) VALUES (?,?,?,?);";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, cal.getDate());
            ps.setString(2, cal.getHeure());
            ps.setInt(3, cal.getNbrLigne());
            ps.setInt(4, cal.getCentre_attribue());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return cal;
    }
}
