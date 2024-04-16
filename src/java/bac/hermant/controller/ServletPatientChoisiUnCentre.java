/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Citoyens;
import bac.hermant.model.bean.BeanPatientChoisiCentre;
import bac.hermant.model.bean.BeanValidation;
import bac.hermant.model.bean.Patient;
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
public class ServletPatientChoisiUnCentre extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        ObjectMapper mapper = new ObjectMapper();
        Citoyens c = new Citoyens();
        Citoyens cit = new Citoyens();
        BeanPatientChoisiCentre p = new BeanPatientChoisiCentre();
        System.out.println("ici");
        System.out.println(p);
        p = mapper.readValue(req.getReader(), BeanPatientChoisiCentre.class);
        
        cit.setNiss(p.getNiss());
        cit.setCentre_attribue(p.getCentre_attribue());
        System.out.println("Backend :" + cit);
 
            c.updateCentreAttribueAuPatient(cit);
            BeanValidation bv = new BeanValidation();
            bv.setValidation(true);
            
            String jsonResp = mapper.writeValueAsString(bv);
            resp.getWriter().print(jsonResp);

  }    
}
