/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao.mysql;

import bac.hermant.model.Ticket;
import bac.hermant.model.dao.TicketDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class MySqlTicketDAO implements TicketDAO {

    private static MySqlTicketDAO myInstance;

    static {
        myInstance = new MySqlTicketDAO();
    }

    public static MySqlTicketDAO getInstance() {
        return myInstance;
    }

    public Ticket createTicket(Ticket t) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "INSERT INTO ticket (niss, nom, prenom, vaccin_attribue, centre_attribue, id_ticket) VALUES (?,?,?,?,?,?);";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, t.getNiss());
            ps.setString(2, t.getNom());
            ps.setString(3, t.getPrenom());
            ps.setString(4, t.getVaccin_attribue());
            ps.setInt(5, t.getCentre_attribue());
            ps.setInt(6, t.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return t;
    }

    public ArrayList<Ticket> getListeDesTickets(Ticket ticket) {
        ArrayList<Ticket> arrayResult = new ArrayList<Ticket>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "select niss, nom, prenom, vaccin_attribue, centre_attribue, gestionnaire, id_ticket, etatDeVaccination from ticket where centre_attribue = ? AND gestionnaire IS NULL;";

        try {

            ps = c.prepareStatement(sql);

            ps.setInt(1, ticket.getCentre_attribue());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                Ticket t = new Ticket();

                t.setNiss(result.getString(1));
                t.setNom(result.getString(2));
                t.setPrenom(result.getString(3));
                t.setVaccin_attribue(result.getString(4));
                t.setCentre_attribue(result.getInt(5));
                t.setGestionnaire(result.getString(6));
                t.setId(result.getInt(7));
                t.setEtatDeVaccination(result.getString(8));

                arrayResult.add(t);

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
    
        public ArrayList<Ticket> getListeDesTicketsFini(Ticket ticket) {
        ArrayList<Ticket> arrayResult = new ArrayList<Ticket>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "select niss, nom, prenom, vaccin_attribue, centre_attribue, gestionnaire, id_ticket, etatDeVaccination, numLot, heure_modification from ticket where centre_attribue = ? AND gestionnaire = ? ;";

        try {

            ps = c.prepareStatement(sql);

            ps.setInt(1, ticket.getCentre_attribue());
            ps.setString(2, ticket.getGestionnaire());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                Ticket t = new Ticket();

                t.setNiss(result.getString(1));
                t.setNom(result.getString(2));
                t.setPrenom(result.getString(3));
                t.setVaccin_attribue(result.getString(4));
                t.setCentre_attribue(result.getInt(5));
                t.setGestionnaire(result.getString(6));
                t.setId(result.getInt(7));
                t.setEtatDeVaccination(result.getString(8));
                t.setNumLot(result.getString(9));
                t.setHeure_de_depart(result.getString(10));
                arrayResult.add(t);

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

    public Ticket validerPriseEnChargeTicket(Ticket t) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "UPDATE ticket SET gestionnaire = ?  where niss = ? ;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, t.getGestionnaire());
            ps.setString(2, t.getNiss());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return t;

    }

    public Ticket cloturerLeTicket(Ticket t) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "UPDATE ticket SET gestionnaire = ? , numLot = ?  where niss = ?;";
        System.out.println(sql);
        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, t.getGestionnaire());
            ps.setString(2, t.getNumLot());
            ps.setString(3, t.getNiss());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return t;

    }

    public Ticket deleteTicket(Ticket t) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "DELETE FROM ticket WHERE niss = ?;";
        System.out.println(sql);
        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, t.getNiss());
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
    
    public Ticket getTicketDuPatient(Ticket t){
    
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "select niss, nom, prenom, vaccin_attribue, centre_attribue, gestionnaire, id_ticket, etatDeVaccination from ticket where centre_attribue = ? AND gestionnaire =?;";

        try {

            ps = c.prepareStatement(sql);

            ps.setInt(1, t.getCentre_attribue());
            ps.setString(2, t.getGestionnaire());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                t.setNiss(result.getString(1));
                t.setNom(result.getString(2));
                t.setPrenom(result.getString(3));
                t.setVaccin_attribue(result.getString(4));
                t.setCentre_attribue(result.getInt(5));
                t.setGestionnaire(result.getString(6));
                t.setId(result.getInt(7));
                t.setEtatDeVaccination(result.getString(8));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return t;
    }

}
