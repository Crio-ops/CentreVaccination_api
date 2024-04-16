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
public class BeanListeCentreVaccination {
    private String nomDuCentre, lat , lng, adresse, num_centre;

    public String getNomDuCentre() {
        return nomDuCentre;
    }

    public void setNomDuCentre(String nomDuCentre) {
        this.nomDuCentre = nomDuCentre;
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

    @Override
    public String toString() {
        return "BeanListeCentreVaccination{" + "nomDuCentre=" + nomDuCentre + ", lat=" + lat + ", lng=" + lng + ", adresse=" + adresse + ", num_centre=" + num_centre + '}';
    }

    
    
    
}
