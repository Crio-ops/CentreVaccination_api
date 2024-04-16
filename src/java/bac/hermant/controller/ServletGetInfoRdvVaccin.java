/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Citoyens;
import bac.hermant.model.bean.BeanInfoVaccinRdvPatient;
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
public class ServletGetInfoRdvVaccin extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BeanInfoVaccinRdvPatient irdv = new BeanInfoVaccinRdvPatient();
        Citoyens c = new Citoyens();
        Citoyens cit = new Citoyens();
        ObjectMapper ob = new ObjectMapper();

        irdv = ob.readValue(req.getReader(), BeanInfoVaccinRdvPatient.class);

        cit.setNiss(irdv.getNiss());
        
//        c.getListeDesTickets(cit);
//        
//        irdv.setEnss(cit.getEnss());
//        irdv.setNom(cit.getNom());
//        irdv.setPrenom(cit.getPrenom());
//        irdv.setDateRdv_Dose1(cit.getDateRdv_Dose1());
//        irdv.setDateRdv_Dose2(cit.getDateRdv_Dose2());
//        irdv.setHeureRdv_Dose1(cit.getHeureRdv_Dose1());
//        irdv.setHeureRdv_Dose2(cit.getHeureRdv_Dose2());
//        irdv.setPresenceRdv1(cit.getPresenceRdv1());
//        irdv.setPresenceRdv2(cit.getPresenceRdv2());
//        
//        String json = ob.writeValueAsString(p);
//        
//        System.out.println(json);
//        
//        resp.getWriter().print(json);
//    }
}
    
}
