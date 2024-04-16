/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao.mysql;

import bac.hermant.model.dao.AbstractDAOFactory;
import bac.hermant.model.dao.CalendrierDAO;
import bac.hermant.model.dao.CentreVaccinationDAO;
import bac.hermant.model.dao.CitoyensDAO;
import bac.hermant.model.dao.VaccinDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import bac.hermant.model.dao.PersonnelDuCentreDAO;
import bac.hermant.model.dao.TicketDAO;

/**
 *
 * @author kevin
 */
public class MySqlDAOFactory extends AbstractDAOFactory {

    private static MySqlDAOFactory myinstance;

    static {
        myinstance = new MySqlDAOFactory();
    }

    public static MySqlDAOFactory getInstance() {
        return myinstance;
    }

    public static Connection getConnection() {
        Connection c = null;
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/vaccinationcenter?user=root&password=";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CitoyensDAO createCitoyensDAO() {

        return MySqlCitoyensDAO.getInstance();
    }

    public PersonnelDuCentreDAO createPersonnelDAO() {

        return MySqlPersonnelDAO.getInstance();
    }

    public VaccinDAO createVaccinDAO() {

        return MySqlVaccinDAO.getInstance();
    }

    public CalendrierDAO createCalendrierDAO() {

        return MySqlCalendrierDAO.getInstance();
    }

    public CentreVaccinationDAO createCentreVaccinationDAO() {

        return MySqlCentreVaccinationDAO.getInstance();
    }

    public PersonnelDuCentreDAO createPersonnelDuCentreDAO() {

        return MySqlPersonnelDAO.getInstance();

    }

    public TicketDAO createTicketDAO() {

        return MySqlTicketDAO.getInstance();

    }
}
