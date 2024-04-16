/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao.mysql;

import bac.hermant.model.Citoyens;
import bac.hermant.model.PersonnelDuCentre;
import bac.hermant.model.TicketPointage;
import bac.hermant.model.dao.CitoyensDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bac.hermant.model.dao.PersonnelDuCentreDAO;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class MySqlPersonnelDAO implements PersonnelDuCentreDAO {

    private static MySqlPersonnelDAO myInstance;

    static {
        myInstance = new MySqlPersonnelDAO();
    }

    public static MySqlPersonnelDAO getInstance() {
        return myInstance;
    }

    // les méthodes crud pour Mysql seront placées ici 
    public PersonnelDuCentre setPersonnelInVacCentre(PersonnelDuCentre pdc) {

        PersonnelDuCentre result;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "INSERT INTO employe (niss ,nom, prenom, motDePasse, ID_Role, centre_attribue) VALUES (?,?,?,?,?,?);";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, pdc.getNiss());
            ps.setString(2, pdc.getNom());
            ps.setString(3, pdc.getPrenom());
            ps.setString(4, pdc.getMotDePasse());
            ps.setInt(5, pdc.getId_Role());
            ps.setInt(6, pdc.getCentre_attribue());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return pdc;

    }

    public PersonnelDuCentre deletePersonnel(PersonnelDuCentre pdc) {

        PersonnelDuCentre result;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "DELETE FROM employe WHERE niss = ? && nom = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, pdc.getNiss());
            ps.setString(2, pdc.getNom());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return null;

    }

    public ArrayList<PersonnelDuCentre> getListeDuPersonnel() {
        ArrayList<PersonnelDuCentre> lpdc = new ArrayList();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

//		
        String sql = "SELECT niss, prenom, nom, ID_Role, centre_attribue FROM employe;";
        try {

            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                PersonnelDuCentre pdc = new PersonnelDuCentre();

                pdc.setNiss(rs.getString(1));
                pdc.setNom(rs.getString(3));
                pdc.setPrenom(rs.getString(2));
                pdc.setId_Role(rs.getInt(4));
                pdc.setCentre_attribue(rs.getInt(5));

                lpdc.add(pdc);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }
        return lpdc;
    }

    public ArrayList<PersonnelDuCentre> getListeDuPersonnelDuCentre(PersonnelDuCentre pdcvac) {
        ArrayList<PersonnelDuCentre> lpdc = new ArrayList();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

//		
        String sql = "SELECT niss, prenom, nom, ID_Role, centre_attribue FROM employe where centre_attribue = ?;";
        System.out.println(sql);
        try {

            ps = c.prepareStatement(sql);
            ps.setInt(1, pdcvac.getCentre_attribue());
            System.out.println(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                PersonnelDuCentre pdc = new PersonnelDuCentre();

                pdc.setNiss(rs.getString(1));
                pdc.setNom(rs.getString(3));
                pdc.setPrenom(rs.getString(2));
                pdc.setId_Role(rs.getInt(4));
                pdc.setCentre_attribue(rs.getInt(5));

                lpdc.add(pdc);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }
        return lpdc;
    }

    public PersonnelDuCentre selectPersonnel(PersonnelDuCentre pc) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "SELECT nom, prenom, ID_Role, centre_attribue FROM employe WHERE niss = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, pc.getNiss());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                pc.setNom(result.getString(1));
                pc.setPrenom(result.getString(2));
                pc.setRole(result.getString(3));
                pc.setCentre_attribue(result.getInt(4));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }
        return pc;
    }

    public ArrayList<PersonnelDuCentre> getListeDesMedecinsParCentre(PersonnelDuCentre pc) {
        ArrayList<PersonnelDuCentre> lpdc = new ArrayList();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

//		
        String sql = "SELECT niss, prenom, nom, ID_Role, centre_attribue FROM employe WHERE centre_attribue = ?";

        try {

            ps = c.prepareStatement(sql);
            ps.setInt(1, pc.getCentre_attribue());
            rs = ps.executeQuery();

            while (rs.next()) {

                PersonnelDuCentre pdc = new PersonnelDuCentre();

                pdc.setNiss(rs.getString(1));
                pdc.setNom(rs.getString(3));
                pdc.setPrenom(rs.getString(2));
                pdc.setId_Role(rs.getInt(4));
                pdc.setCentre_attribue(rs.getInt(5));

                lpdc.add(pdc);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }
        return lpdc;
    }

    public PersonnelDuCentre insertTicketPointageEntre(PersonnelDuCentre pc) {

        PersonnelDuCentre result;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "INSERT INTO pointage_personnel_entre (niss ,nom, prenom, date, heure, centre_attribue) VALUES (?,?,?,?,?,?);";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, pc.getNiss());
            ps.setString(2, pc.getNom());
            ps.setString(3, pc.getPrenom());
            ps.setString(4, pc.getDate());
            ps.setString(5, pc.getHeure());
            ps.setInt(6, pc.getCentre_attribue());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return pc;

    }

    public PersonnelDuCentre insertTicketPointageSortie(PersonnelDuCentre pc) {

        PersonnelDuCentre result;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "INSERT INTO pointage_personnel_sortie (niss ,nom, prenom, date, heure, centre_attribue) VALUES (?,?,?,?,?,?);";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, pc.getNiss());
            ps.setString(2, pc.getNom());
            ps.setString(3, pc.getPrenom());
            ps.setString(4, pc.getDate());
            ps.setString(5, pc.getHeure());
            ps.setInt(6, pc.getCentre_attribue());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return pc;

    }

    public ArrayList<PersonnelDuCentre> getListePointageEntreePersonnelParCentre(PersonnelDuCentre pc) {
        ArrayList<PersonnelDuCentre> lpdc = new ArrayList();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

//		
        String sql = "SELECT niss, prenom, nom, date, heure, centre_attribue FROM pointage_personnel_entre WHERE centre_attribue = ? AND date = ?;";
        try {

            ps = c.prepareStatement(sql);

            ps.setInt(1, pc.getCentre_attribue());
            ps.setString(2, pc.getDate());
            System.out.println(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                PersonnelDuCentre pdc = new PersonnelDuCentre();

                pdc.setNiss(rs.getString(1));
                pdc.setNom(rs.getString(3));
                pdc.setPrenom(rs.getString(2));
                pdc.setDate(rs.getString(4));
                pdc.setHeure(rs.getString(5));
                pdc.setCentre_attribue(rs.getInt(6));

                lpdc.add(pdc);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }
        return lpdc;
    }

    public ArrayList<PersonnelDuCentre> getListePointageSortiePersonnelParCentre(PersonnelDuCentre pc) {
        ArrayList<PersonnelDuCentre> lpdc = new ArrayList();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

//		
        String sql = "SELECT niss, prenom, nom, date, heure, centre_attribue FROM pointage_personnel_sortie WHERE centre_attribue = ? AND date = ?;";
        try {

            ps = c.prepareStatement(sql);

            ps.setInt(1, pc.getCentre_attribue());
            ps.setString(2, pc.getDate());

            rs = ps.executeQuery();

            while (rs.next()) {

                PersonnelDuCentre pdc = new PersonnelDuCentre();

                pdc.setNiss(rs.getString(1));
                pdc.setNom(rs.getString(3));
                pdc.setPrenom(rs.getString(2));
                pdc.setDate(rs.getString(4));
                pdc.setHeure(rs.getString(5));
                pdc.setCentre_attribue(rs.getInt(6));

                lpdc.add(pdc);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }
        return lpdc;
    }
}
