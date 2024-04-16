/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model;

import bac.hermant.model.dao.AbstractDAOFactory;
import bac.hermant.model.dao.CalendrierDAO;
import bac.hermant.model.dao.CentreVaccinationDAO;
import bac.hermant.model.dao.mysql.MySqlDAOFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author kevin
 */
public class Calendrier {

    private String heure, date, concat_date_heure, datePointageEntree, datePointageSortie, heurePointageEntree, heurePointageSortie;
    private int nbrLigne, id, centre_attribue;

    ArrayList<String> calendrier = new ArrayList<String>();
    ArrayList<Calendrier> heure_calendrier = new ArrayList<Calendrier>();
    Calendar calheure = new GregorianCalendar();
    Calendar calendar = new GregorianCalendar();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdf_heure = new SimpleDateFormat("HH:mm");

    public Calendrier() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbrLigne() {
        return nbrLigne;
    }

    public void setNbrLigne(int nbrLigne) {
        this.nbrLigne = nbrLigne;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConcat_date_heure() {
        return concat_date_heure;
    }

    public void setConcat_date_heure(String concat_date_heure) {
        this.concat_date_heure = concat_date_heure;
    }

    public int getCentre_attribue() {
        return centre_attribue;
    }

    public void setCentre_attribue(int centre_attribue) {
        this.centre_attribue = centre_attribue;
    }

    public String getDatePointageEntree() {
        Date date = new Date();
        datePointageEntree = sdf.format(date);
        return datePointageEntree;
    }

    public String getDatePointageSortie() {
        Date date = new Date();
        datePointageSortie = sdf.format(date);
        return datePointageSortie;
    }

    public String getHeurePointageEntree() {
        Date date = new Date();
        heurePointageEntree = sdf_heure.format(date);
        return heurePointageEntree;
    }

    public String getHeurePointageSortie() {
        Date date = new Date();
        heurePointageSortie = sdf_heure.format(date);
        return heurePointageSortie;
    }

    @Override
    public String toString() {
        return "Calendrier{" + "heure=" + heure + ", date=" + date + ", concat_date_heure=" + concat_date_heure + ", nbrLigne=" + nbrLigne + ", id=" + id + ", centre_attribue=" + centre_attribue + '}';
    }

    public String concatDateHeure(String date, String heure) {

        concat_date_heure = this.date + "_" + this.heure;

        return concat_date_heure;
    }

    public boolean controleNbrLigne(Calendrier cal) {

        if (cal.getNbrLigne() >= 4) {

            return false;

        } else {

            return true;
        }

    }

    public String calculerHeureDeDepartPatient(String str) throws ParseException {
        String split[] = str.split(" ");
        String heure1 = split[1];
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date d = df.parse(heure1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MINUTE, 15);
        String heureDeDepart = df.format(cal.getTime());
        System.out.println(heureDeDepart);
        return heureDeDepart;

    }

    public ArrayList<Calendrier> getRDVDisponible(Calendrier dateHeure) {
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        CalendrierDAO calDAO = AbstractDAOFactory.getFactory().createCalendrierDAO();

        return calDAO.getRDVDisponible(dateHeure);
    }

    public ArrayList<Calendrier> verifRdvEstDisponible(Calendrier dateHeure) {
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        CalendrierDAO calDAO = AbstractDAOFactory.getFactory().createCalendrierDAO();

        return calDAO.verifRdvEstDisponible(dateHeure);
    }

    public Calendrier insertRdvIndisponible(Calendrier cal) {
        AbstractDAOFactory.setFactory(MySqlDAOFactory.getInstance());
        CalendrierDAO calDAO = AbstractDAOFactory.getFactory().createCalendrierDAO();

        return calDAO.insertRdvIndisponible(cal);
    }

}
