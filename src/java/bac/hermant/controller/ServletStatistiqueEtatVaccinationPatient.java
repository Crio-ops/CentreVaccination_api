/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.CentreVaccination;
import bac.hermant.model.Citoyens;
import bac.hermant.model.bean.BeanListeCitoyens;
import bac.hermant.model.bean.BeanPersonnelCentre;
import bac.hermant.model.bean.BeanStatistique;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
public class ServletStatistiqueEtatVaccinationPatient extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper ob = new ObjectMapper();
        ArrayList<Citoyens> lc = new ArrayList();
        CentreVaccination v = new CentreVaccination();
        StringBuilder stb = new StringBuilder();
        StringBuilder stb1 = new StringBuilder();

        lc = v.getStatistiqueEtatVaccinalPatient();
        for (Citoyens c : lc) {
            System.out.println("STATISTIQUE : " + c.toString());
        }
        
        int totalPatient = 0 ;
        int nonVac = 0;
        int partiellementVac = 0;
        int vac = 0;
        int total = lc.size();
        for (Citoyens str : lc) {
            if(str.getEtatDeVaccination().equals("0")){
                nonVac ++;
            }else if(str.getEtatDeVaccination().equals("2")){
                vac ++;
            }else{
                partiellementVac ++;
            }
            
            
            
        }
        
        BeanStatistique bs = new BeanStatistique();
        bs.setNonVac(nonVac);
        bs.setVac(vac);
        bs.setTotal(total);
        bs.setPartiellementVac(partiellementVac);
        System.out.println("vac : " + vac + "non vac : " + nonVac + " part : " + partiellementVac + " total : " + total);
        String json = ob.writeValueAsString(bs);
        resp.getWriter().write(json);
        
    }

}
