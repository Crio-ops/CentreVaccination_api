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
public class BeanPatientChoisiCentre {
    private String niss;
    private int centre_attribue;

    public String getNiss() {
        return niss;
    }

    public void setNiss(String niss) {
        this.niss = niss;
    }

    public int getCentre_attribue() {
        return centre_attribue;
    }

    public void setCentre_attribue(int centre_attribue) {
        this.centre_attribue = centre_attribue;
    }

    @Override
    public String toString() {
        return "BeanPatientChoisiCentre{" + "niss=" + niss + ", centre_attribue=" + centre_attribue + '}';
    }
    
              
}
