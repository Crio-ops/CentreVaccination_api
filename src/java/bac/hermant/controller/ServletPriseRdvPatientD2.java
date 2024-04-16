/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;


import bac.hermant.model.CentreVaccination;
import bac.hermant.model.Citoyens;
import bac.hermant.model.Vaccins;
import bac.hermant.model.bean.BeanInfoPatientD2;
import bac.hermant.model.bean.RendezVous;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kevin
 */
public class ServletPriseRdvPatientD2 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Citoyens cit = new Citoyens();
        Citoyens citInfo = new Citoyens();
        Vaccins vac = new Vaccins();
        CentreVaccination cv = new CentreVaccination();
        BeanInfoPatientD2 bean = new BeanInfoPatientD2();
        ObjectMapper mapper = new ObjectMapper();
        
        cit = mapper.readValue(req.getReader(), Citoyens.class);
        
        
        citInfo = cit.getInfoPatientForD2(cit);
        
        vac.setNom(citInfo.getVaccin_attribue());
        vac = vac.getInfoVaccins(vac);
        
        
        String miniD = cv.weekMiniBtw2Doses(citInfo, vac);
        String maxiD = cv.weekMaxiBtw2Doses(citInfo, vac);
        
        bean.setDateMax(maxiD);
        bean.setDateMin(miniD);
        bean.setNiss(citInfo.getNiss());
       

         resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean));
        
    }
}
