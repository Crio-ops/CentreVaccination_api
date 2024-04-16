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
public class BeanStatistique {

    private int vac, nonVac, partiellementVac , total;

    public int getVac() {
        return vac;
    }

    public void setVac(int vac) {
        this.vac = vac;
    }

    public int getNonVac() {
        return nonVac;
    }

    public void setNonVac(int nonVac) {
        this.nonVac = nonVac;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPartiellementVac() {
        return partiellementVac;
    }

    public void setPartiellementVac(int partiellementVac) {
        this.partiellementVac = partiellementVac;
    }

    @Override
    public String toString() {
        return "BeanStatistique{" + "vac=" + vac + ", nonVac=" + nonVac + ", partiellementVac=" + partiellementVac + ", total=" + total + '}';
    }
    
    
}
