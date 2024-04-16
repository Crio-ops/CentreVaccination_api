/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.PersonnelDuCentre;
import bac.hermant.model.Ticket;
import bac.hermant.model.bean.BeanTicket;
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
public class ServletGetTicketPatient extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper ob = new ObjectMapper();
        BeanTicket bt = new BeanTicket();
        PersonnelDuCentre pc = new PersonnelDuCentre();
        Ticket t = new Ticket();

        bt = ob.readValue(req.getReader(), BeanTicket.class);
        
        pc.setNiss(bt.getGestionnaire());
        pc.selectPersonnel(pc);
        
        
        t.setCentre_attribue(bt.getCentre_attribue());
        t.setGestionnaire(pc.getNom() + " " + pc.getPrenom());

        t.getTicketDuPatient(t);

        
        bt.setNiss(t.getNiss());
        bt.setNom(t.getNom());
        bt.setPrenom(t.getPrenom());
        bt.setVaccin_attribue(t.getVaccin_attribue());
        bt.setCentre_attribue(t.getCentre_attribue());
        bt.setGestionnaire(t.getGestionnaire());
        bt.setId(t.getId());
        bt.setEtatDeVaccination(t.getEtatDeVaccination());

        String json = ob.writeValueAsString(bt);
        
        resp.getWriter().print(json);
    }
}
