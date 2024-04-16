/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao.mysql;

import bac.hermant.model.Calendrier;
import bac.hermant.model.Citoyens;
import bac.hermant.model.PersonnelDuCentre;
import bac.hermant.model.dao.CitoyensDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class MySqlCitoyensDAO implements CitoyensDAO {

    private static MySqlCitoyensDAO myInstance;

    static {
        myInstance = new MySqlCitoyensDAO();
    }

    public static MySqlCitoyensDAO getInstance() {
        return myInstance;
    }

    // les méthodes crud pour Mysql seront placées ici 
    public ArrayList<Citoyens> getListeDesCitoyens() {
        ArrayList<Citoyens> lc = new ArrayList();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

//		 String sql = "SELECT c.enss, c.prenom, c.nom, c.adresse, c.dateNaissance, c.code_postal, p.etatDeVaccination, p.nomVaccin FROM citoyens c LEFT JOIN patients p ON c.enss=p.enss;";
        String sql = "SELECT c.niss, c.prenom, c.nom, c.adresse, c.dateNaissance, c.code_postal, p.etatDeVaccination, p.nomVaccin, rd.dateRdv_Dose1, rd.dateRdv_Dose2, rd.heureRdv_Dose1, rd.heureRdv_dose2 FROM citoyens c LEFT JOIN patients p ON c.niss=p.niss LEFT JOIN rdv_patient rd ON rd.niss = c.niss;";
        try {

            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Citoyens cit = new Citoyens();

                cit.setNiss(rs.getString(1));
                cit.setNom(rs.getString(3));
                cit.setPrenom(rs.getString(2));
                cit.setAdresse(rs.getString(4));
                cit.setDateNaissance(rs.getString(5));
                cit.setCode_postal(rs.getInt(6));
                cit.setEtatDeVaccination(rs.getString(7));
                cit.setVaccin_attribue(rs.getString(8));
                cit.setDateRdv_Dose1(rs.getString(9));
                cit.setDateRdv_Dose2(rs.getString(10));
                cit.setHeureRdv_Dose1(rs.getString(11));
                cit.setHeureRdv_Dose2(rs.getString(12));

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
    
    
    public ArrayList<Citoyens> getListeDesCitoyensDuCentre(PersonnelDuCentre pdc) {
        ArrayList<Citoyens> lc = new ArrayList();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

//		 String sql = "SELECT c.enss, c.prenom, c.nom, c.adresse, c.dateNaissance, c.code_postal, p.etatDeVaccination, p.nomVaccin FROM citoyens c LEFT JOIN patients p ON c.enss=p.enss;";
        String sql = "SELECT c.niss, c.prenom, c.nom, c.adresse, c.dateNaissance, c.code_postal, p.etatDeVaccination, p.nomVaccin, rd.dateRdv_Dose1, rd.dateRdv_Dose2, rd.heureRdv_Dose1, rd.heureRdv_dose2 FROM citoyens c LEFT JOIN patients p ON c.niss=p.niss LEFT JOIN rdv_patient rd ON rd.niss = c.niss WHERE centre_attribue = ?;";
        try {

            ps = c.prepareStatement(sql);
            ps.setInt(1, pdc.getCentre_attribue());
            rs = ps.executeQuery();

            while (rs.next()) {

                Citoyens cit = new Citoyens();

                cit.setNiss(rs.getString(1));
                cit.setNom(rs.getString(3));
                cit.setPrenom(rs.getString(2));
                cit.setAdresse(rs.getString(4));
                cit.setDateNaissance(rs.getString(5));
                cit.setCode_postal(rs.getInt(6));
                cit.setEtatDeVaccination(rs.getString(7));
                cit.setVaccin_attribue(rs.getString(8));
                cit.setDateRdv_Dose1(rs.getString(9));
                cit.setDateRdv_Dose2(rs.getString(10));
                cit.setHeureRdv_Dose1(rs.getString(11));
                cit.setHeureRdv_Dose2(rs.getString(12));

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
    
    

    public Citoyens getCitoyensInVacCentre(Citoyens p) {

        Citoyens result;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "INSERT INTO citoyens (niss ,prenom, nom, adresse, dateNaissance, lieuNaissance, code_postal, motDePasse) VALUES (?,?,?,?,?,?,?,?);";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getNiss());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getNom());
            ps.setString(4, p.getAdresse());
            ps.setString(5, p.getDateNaissance());
            ps.setString(6, p.getLieuNaissance());
            ps.setInt(7, p.getCode_postal());
            ps.setString(8, p.getMotDePasse());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return p;

    }

    public Citoyens getLoginPatient(Citoyens p) {

        Citoyens patient = new Citoyens();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "SELECT niss, motDePasse, nom, prenom, role, dateNaissance, centre_attribue FROM citoyens WHERE niss = ? AND motDePasse = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getNiss());
            ps.setString(2, p.getMotDePasse());
            ResultSet result = ps.executeQuery();

            while (result.next()) {

                patient.setNiss(result.getString(1));
                patient.setMotDePasse(result.getString(2));
                patient.setNom(result.getString(3));
                patient.setPrenom(result.getString(4));
                patient.setRole(result.getInt(5));
                patient.setDateNaissance(result.getString(6));
                patient.setCentre_attribue(result.getInt(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }
        return patient;
    }

    public Citoyens CitoyensEnPersonnelVac(Citoyens p) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "UPDATE citoyens SET role = ?  where niss = ? ;";

        try {

            ps = c.prepareStatement(sql);
            ps.setInt(1, p.getRole());
            ps.setString(2, p.getNiss());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return p;
    }

    public Citoyens getInfoPatient(Citoyens p) {

        Citoyens patient = new Citoyens();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "SELECT rp.niss, rp.dateRdv_Dose1, rp.heureRdv_Dose1,rp.dateRdv_Dose2, rp.heureRdv_Dose2, rp.stateVaccinRdv, c.nom, c.prenom,  p.nomVaccin FROM rdv_patient rp JOIN citoyens c ON rp.niss = c.niss LEFT JOIN patients p ON rp.niss=p.niss WHERE rp.niss = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getNiss());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                patient.setNiss(result.getString(1));
                patient.setDateRdv_Dose1(result.getString(2));
                patient.setHeureRdv_Dose1(result.getString(3));
                patient.setDateRdv_Dose2(result.getString(4));
                patient.setHeureRdv_Dose2(result.getString(5));
                patient.setStateVaccinRdv(result.getInt(6));
                patient.setNom(result.getString(7));
                patient.setPrenom(result.getString(8));
                patient.setVaccin_attribue(result.getString(9));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return patient;
    }

    public Citoyens getInfoPatientForD2(Citoyens p) {

        Citoyens patient = new Citoyens();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "select c.niss, p.nomVaccin, rd.dateRdv_Dose1 from citoyens c LEFT JOIN patients p ON c.niss=p.niss LEFT JOIN rdv_patient rd ON c.niss=rd.niss WHERE c.niss = ? ;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getNiss());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                patient.setNiss(result.getString(1));
                patient.setVaccin_attribue(result.getString(2));
                patient.setDateRdv_Dose1(result.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return patient;
    }

    public Citoyens changePassword(Citoyens p) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "UPDATE citoyens SET motDePasse = ? WHERE niss = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getMotDePasse());
            ps.setString(2, p.getNiss());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return p;
    }

    public Citoyens vuePatient(Citoyens p) {

        Citoyens patient = new Citoyens();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "SELECT p.nomVaccin, c.nom, c.prenom, c.motDePasse, p.etatDeVaccination FROM patients p JOIN citoyens c ON p.niss = c.niss WHERE c.niss = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getNiss());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                patient.setVaccin_attribue(result.getString(1));
                patient.setNom(result.getString(2));
                patient.setPrenom(result.getString(3));
                patient.setMotDePasse(result.getString(4));
                patient.setEtatDeVaccination(result.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return patient;
    }

    public Citoyens vaccination_D1(Citoyens p) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "UPDATE patients SET etatDeVaccination = ?, numLot_dose_1= ? WHERE niss = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getEtatDeVaccination());
            ps.setString(2, p.getNumLot_vaccin_attribue_dose1());
            ps.setString(3, p.getNiss());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return p;
    }

    public Citoyens vaccination_D2(Citoyens p) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "UPDATE patients SET etatDeVaccination = ? , numLot_dose_2= ? WHERE niss = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getEtatDeVaccination());
            ps.setString(2, p.getNumLot_vaccin_attribue_dose2());
            ps.setString(3, p.getNiss());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return p;
    }

    public Citoyens callProcedurePatient_dose1(Citoyens p) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "CALL addVaccinEtPatientInTablePatients(?,?);";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getNiss());
            ps.setString(2, p.getVaccin_attribue());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return p;
    }

    public Citoyens getRdvPatient(Citoyens p) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "INSERT INTO rdv_patient (dateRdv_Dose1, heureRdv_Dose1, niss, stateVaccinRdv, centre_attribue) VALUES (?,?,?,?,?);";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getDateRdv_Dose1());
            ps.setString(2, p.getHeureRdv_Dose1());
            ps.setString(3, p.getNiss());
            ps.setInt(4, p.getStateVaccinRdv());
            ps.setInt(5, p.getCentre_attribue());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return p;
    }

    public Citoyens getRdvPatient_Dose2(Citoyens p) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "UPDATE rdv_patient SET dateRdv_Dose2= ?, heureRdv_Dose2= ?, stateVaccinRdv = ? WHERE niss = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, p.getDateRdv_Dose2());
            ps.setString(2, p.getHeureRdv_Dose2());
            ps.setInt(3, p.getStateVaccinRdv());
            ps.setString(4, p.getNiss());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return p;
    }

    public Citoyens getInfoCitoyen(Citoyens citoyen) {

        Citoyens cit = new Citoyens();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "SELECT niss, nom, motDePasse from citoyens WHERE niss = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, citoyen.getNiss());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                cit.setNiss(result.getString(1));
                cit.setNom(result.getString(2));
                cit.setMotDePasse(result.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }
        return cit;

    }

    public Citoyens updateRolePersonnelInCitoyens(Citoyens p) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "UPDATE citoyens SET role = ? WHERE niss = ?;";

        try {

            ps = c.prepareStatement(sql);

            ps.setInt(1, p.getRole());
            ps.setString(2, p.getNiss());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return p;
    }

    public Citoyens updateCentreAttribueAuPatient(Citoyens p) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "UPDATE citoyens SET centre_attribue = ?  where niss = ? ;";

        try {

            ps = c.prepareStatement(sql);
            ps.setInt(1, p.getCentre_attribue());
            ps.setString(2, p.getNiss());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return p;
    }

    public ArrayList<Citoyens> getListeRdvDuJour(Calendrier cal) {
        ArrayList<Citoyens> arrayResult = new ArrayList<Citoyens>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "select niss, dateRdv_Dose1, heureRdv_Dose1, dateRdv_Dose2, heureRdv_Dose2, presenceRdv1, presenceRdv2 from rdv_patient where (dateRdv_Dose1 =? AND heureRdv_Dose1 =?) OR (dateRdv_Dose2 =? AND heureRdv_Dose2 =?);";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, cal.getDate());
            ps.setString(2, cal.getHeure());
            ps.setString(3, cal.getDate());
            ps.setString(4, cal.getHeure());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                Citoyens citResult = new Citoyens();

                citResult.setNiss(result.getString(1));
                citResult.setDateRdv_Dose1(result.getString(2));
                citResult.setHeureRdv_Dose1(result.getString(3));
                citResult.setDateRdv_Dose2(result.getString(4));
                citResult.setHeureRdv_Dose2(result.getString(5));
                citResult.setPresenceRdv1(result.getString(6));
                citResult.setPresenceRdv2(result.getString(7));

                arrayResult.add(citResult);

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

    public Citoyens validerPresencePatientRdv1(Citoyens cit) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "UPDATE rdv_patient SET presenceRdv1 = ?  where niss = ? ;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, cit.getPresenceRdv1());
            ps.setString(2, cit.getNiss());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return cit;
    }

    public Citoyens validerPresencePatientRdv2(Citoyens cit) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "UPDATE rdv_patient SET presenceRdv2 = ?  where niss = ? ;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, cit.getPresenceRdv2());
            ps.setString(2, cit.getNiss());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return cit;
    }

    public Citoyens getRdvPatientViaEnss(Citoyens cit) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "select rp.niss, rp.dateRdv_Dose1, rp.heureRdv_Dose1, rp.dateRdv_Dose2, rp.heureRdv_Dose2, rp.presenceRdv1, rp.presenceRdv2, c.nom, c.prenom, c.centre_attribue FROM rdv_patient rp JOIN citoyens c ON rp.niss = c.niss WHERE rp.niss = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, cit.getNiss());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                cit.setNiss(result.getString(1));
                cit.setDateRdv_Dose1(result.getString(2));
                cit.setHeureRdv_Dose1(result.getString(3));
                cit.setDateRdv_Dose2(result.getString(4));
                cit.setHeureRdv_Dose2(result.getString(5));
                cit.setPresenceRdv1(result.getString(6));
                cit.setPresenceRdv2(result.getString(7));
                cit.setNom(result.getString(8));
                cit.setPrenom(result.getString(9));
                cit.setCentre_attribue(result.getInt(10));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return cit;
    }

    public Citoyens getInfoForTicket(Citoyens cit) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "Select c.niss, c.nom ,c.prenom, p.nomVaccin, p.etatDeVaccination from citoyens c JOIN patients p ON c.niss = p.niss WHERE c.niss = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, cit.getNiss());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                cit.setNiss(result.getString(1));
                cit.setNom(result.getString(2));
                cit.setPrenom(result.getString(3));
                cit.setVaccin_attribue(result.getString(4));
                cit.setEtatDeVaccination(result.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return cit;
    }

    public Citoyens getInfoVaccinationPatient(Citoyens cit) {
        Citoyens citoyen = new Citoyens();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "Select niss, nomVaccin, etatDeVaccination, numLot_dose_1, numLot_dose_2  from patients where niss = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, cit.getNiss());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                citoyen.setNiss(result.getString(1));
                citoyen.setVaccin_attribue(result.getString(2));
                citoyen.setEtatDeVaccination(result.getString(3));
                citoyen.setNumLot_vaccin_attribue_dose1(result.getString(4));
                citoyen.setNumLot_vaccin_attribue_dose2(result.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return citoyen;
    }
    
       public Citoyens getVaccinationPourVuePatient(Citoyens cit) {
        Citoyens citoyen = new Citoyens();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        c = MySqlDAOFactory.getConnection();

        String sql = "Select c.niss, c.nom, c.prenom, p.nomVaccin, p.etatDeVaccination, rp.dateRdv_dose1, rp.dateRdv_dose2 from citoyens c LEFT JOIN patients p ON c.niss=p.niss LEFT JOIN rdv_patient rp ON c.niss=rp.niss WHERE c.niss = ?;";

        try {

            ps = c.prepareStatement(sql);
            ps.setString(1, cit.getNiss());

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                citoyen.setNiss(result.getString(1));
                citoyen.setNom(result.getString(2));
                citoyen.setPrenom(result.getString(3));
                citoyen.setVaccin_attribue(result.getString(4));
                citoyen.setEtatDeVaccination(result.getString(5));
                citoyen.setDateRdv_Dose1(result.getString(6));
                citoyen.setDateRdv_Dose2(result.getString(7));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDAOFactory.closeResultSet(rs);
            MySqlDAOFactory.closeStatement(ps);
            MySqlDAOFactory.closeConnection(c);
        }

        return citoyen;
    }
}
