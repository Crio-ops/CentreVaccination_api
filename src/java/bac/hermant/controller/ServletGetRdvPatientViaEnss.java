/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Citoyens;
import bac.hermant.model.bean.Patient;
import bac.hermant.model.bean.RendezVous;
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
public class ServletGetRdvPatientViaEnss extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RendezVous rdv = new RendezVous();
        Patient p = new Patient();
        Citoyens c = new Citoyens();
        Citoyens cit = new Citoyens();
        ObjectMapper ob = new ObjectMapper();

        rdv = ob.readValue(req.getReader(), RendezVous.class);

        cit.setNiss(rdv.getNiss());
        
        c.getRdvPatientViaEnss(cit);
        
        p.setNiss(cit.getNiss());
        p.setNom(cit.getNom());
        p.setPrenom(cit.getPrenom());
        p.setDateRdv_Dose1(cit.getDateRdv_Dose1());
        p.setDateRdv_Dose2(cit.getDateRdv_Dose2());
        p.setHeureRdv_Dose1(cit.getHeureRdv_Dose1());
        p.setHeureRdv_Dose2(cit.getHeureRdv_Dose2());
        p.setPresenceRdv1(cit.getPresenceRdv1());
        p.setPresenceRdv2(cit.getPresenceRdv2());
        p.setCentre_attribue(cit.getCentre_attribue());
        
        String json = ob.writeValueAsString(p);
        
        System.out.println(json);
        
        resp.getWriter().print(json);
    }
}
