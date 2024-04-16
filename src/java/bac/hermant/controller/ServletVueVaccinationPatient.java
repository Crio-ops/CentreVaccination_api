/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Citoyens;
import bac.hermant.model.bean.BeanVueVaccinationPatient;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
public class ServletVueVaccinationPatient extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        Citoyens cit = new Citoyens();
        Citoyens citInfoVaccin = new Citoyens();
        BeanVueVaccinationPatient bvvp = new BeanVueVaccinationPatient();
        ObjectMapper ob = new ObjectMapper();
        ObjectMapper mapper = new ObjectMapper();
        
        bvvp = ob.readValue(req.getReader(), BeanVueVaccinationPatient.class);
        
        cit.setNiss(bvvp.getNiss());

       citInfoVaccin = citInfoVaccin.getVaccinationPourVuePatient(cit);

       
       bvvp.setNom(citInfoVaccin.getNom());
       bvvp.setPrenom(citInfoVaccin.getPrenom());
       bvvp.setNomVaccin(citInfoVaccin.getVaccin_attribue());
       bvvp.setDateRdv_d1(citInfoVaccin.getDateRdv_Dose1());
       bvvp.setDateRdv_d2(citInfoVaccin.getDateRdv_Dose2());
       String jsonResp = mapper.writeValueAsString(bvvp);
        
        resp.getWriter().print(jsonResp);
    }    
}
