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
public class ServletValiderLaPriseEnCharge extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper ob = new ObjectMapper();
        BeanTicket bt = new BeanTicket();
        PersonnelDuCentre pc = new PersonnelDuCentre();
        Ticket t = new Ticket();

        bt = ob.readValue(req.getReader(), BeanTicket.class);
        
        pc.setNiss(bt.getGestionnaire());
        pc.selectPersonnel(pc);
        
        
        t.setNiss(bt.getNiss());
        t.setGestionnaire(pc.getNom() + " " + pc.getPrenom());
        
        t.validerPriseEnChargeTicket(t);
        
        String json = ob.writeValueAsString(bt);
    }
}
