/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Calendrier;
import bac.hermant.model.PersonnelDuCentre;
import bac.hermant.model.TicketPointage;
import bac.hermant.model.bean.BeanPointagePersonnel;
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
public class Servlet_Pointage_Sortie extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper ob = new ObjectMapper();
        BeanPointagePersonnel bp = new BeanPointagePersonnel();
        Calendrier cal = new Calendrier();
        PersonnelDuCentre pc = new PersonnelDuCentre();
        PersonnelDuCentre perso = new PersonnelDuCentre();
        bp = ob.readValue(req.getReader(), BeanPointagePersonnel.class);
        
        TicketPointage tp = new TicketPointage();
        
        pc.setNiss(bp.getNiss());
        perso = pc.selectPersonnel(pc);
        
        perso.setHeure(cal.getHeurePointageEntree());
        perso.setDate(cal.getDatePointageEntree());
        
        pc.insertTicketPointageSortie(perso);

        bp.setCentre_attribue(perso.getCentre_attribue());
        bp.setDate(perso.getDate());
        bp.setHeure(perso.getHeure());
        bp.setNom(perso.getNom());
        bp.setPrenom(perso.getPrenom());
        bp.setNiss(perso.getNiss());
        
        String jsonResp = ob.writeValueAsString(bp);
        
        resp.getWriter().print(jsonResp);
        
    }
    
}
