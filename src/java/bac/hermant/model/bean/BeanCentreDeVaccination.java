/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.bean;

/**
 *
 * @author kevin
 */
public class BeanCentreDeVaccination {
    
    private String nomDuCentre, rue, ville, county,numero, postCode, lat, lng, adresse, num_centre;
    private int nombre_ligne;

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
    
    
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
        return "BeanCentreDeVaccination{" + "nomDuCentre=" + nomDuCentre + ", rue=" + rue + ", ville=" + ville + ", county=" + county + ", numero=" + numero + ", postCode=" + postCode + ", lat=" + lat + ", lng=" + lng + ", adresse=" + adresse + ", num_centre=" + num_centre + ", nombre_ligne=" + nombre_ligne + '}';
    }

}
