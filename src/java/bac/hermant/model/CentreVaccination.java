/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model;

import bac.hermant.model.dao.AbstractDAOFactory;
import bac.hermant.model.dao.CentreVaccinationDAO;
import java.util.ArrayList;


/**
 *
 * @author kevin
 */
public class CentreVaccination {
     private String nomDuCentre, rue, ville, county,numero, postCode, lat, lng, adresse, concatAdresse, num_centre;
     private int nombre_ligne;
     
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getConcatAdresse() {
        return concatAdresse;
    }

    public void setConcatAdresse(String rue, String numero) {
        adresse = this.rue + ", " + this.numero + ", " + this.postCode + ", " + ville;
    }

    public String getNomDuCentre() {
        return nomDuCentre;
    }

    public void setNomDuCentre(String nomDuCentre) {
        this.nomDuCentre = nomDuCentre;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getNum_centre() {
        return num_centre;
    }

    public void setNum_centre(String num_centre) {
        this.num_centre = num_centre;
    }

    public int getNombre_ligne() {
        return nombre_ligne;
    }

    public void setNombre_ligne(int nombre_ligne) {
        this.nombre_ligne = nombre_ligne;
    }

    @Override
    public String toString() {
        return "CentreVaccination{" + "nomDuCentre=" + nomDuCentre + ", rue=" + rue + ", ville=" + ville + ", county=" + county + ", numero=" + numero + ", postCode=" + postCode + ", lat=" + lat + ", lng=" + lng + ", adresse=" + adresse + ", concatAdresse=" + concatAdresse + ", num_centre=" + num_centre + ", nombre_ligne=" + nombre_ligne + '}';
    }


    public String weekMiniBtw2Doses(Citoyens p, Vaccins v ){
      CentreVaccinationDAO cvDAO = AbstractDAOFactory.getFactory().createCentreVaccinationDAO();

        return cvDAO.weekMiniBtw2Doses(p, v);

     }

    public String weekMaxiBtw2Doses(Citoyens p, Vaccins v ){
      CentreVaccinationDAO cvDAO = AbstractDAOFactory.getFactory().createCentreVaccinationDAO();

        return cvDAO.weekMaxiBtw2Doses(p, v);

     }
    
     public CentreVaccination createCentre(CentreVaccination cv) throws Exception{
      CentreVaccinationDAO cvDAO = AbstractDAOFactory.getFactory().createCentreVaccinationDAO();

        return cvDAO.createCentre(cv);

     }
     
     public ArrayList<CentreVaccination> getListeDesCentres(){
      CentreVaccinationDAO cvDAO = AbstractDAOFactory.getFactory().createCentreVaccinationDAO();

        return cvDAO.getListeDesCentres();

     }
     
     public CentreVaccination getInfoDuCentre(CentreVaccination cv){
      CentreVaccinationDAO cvDAO = AbstractDAOFactory.getFactory().createCentreVaccinationDAO();

        return cvDAO.getInfoDuCentre(cv);

     }
     public ArrayList<Citoyens> getStatistiqueEtatVaccinalPatient(){
      CentreVaccinationDAO cvDAO = AbstractDAOFactory.getFactory().createCentreVaccinationDAO();

        return cvDAO.getStatistiqueEtatVaccinalPatient();

     }
}


 