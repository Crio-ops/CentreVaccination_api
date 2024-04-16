/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Calendrier;
import bac.hermant.model.Citoyens;
import bac.hermant.model.Ticket;
import bac.hermant.model.bean.BeanTicket;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
public class ServletGetListeDesTickets extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper ob = new ObjectMapper();
        ArrayList<Ticket> lt = new ArrayList();
        BeanTicket bt = new BeanTicket();
        Calendrier cal = new Calendrier();
        String json = "";
        StringBuilder stb = new StringBuilder();
        StringBuilder stb1 = new StringBuilder();

        bt = ob.readValue(req.getReader(), BeanTicket.class);

        Ticket t = new Ticket();

        t.setCentre_attribue(bt.getCentre_attribue());
        t.setGestionnaire(bt.getGestionnaire());

        if (t.getGestionnaire().equals("2") || t.getGestionnaire().equals("3")) {

            lt = t.getListeDesTickets(t);

            for (Ticket str : lt) {
                t.setNiss(str.getNiss());
                t.setNom(str.getNom());
                t.setPrenom(str.getPrenom());
                t.setVaccin_attribue(str.getVaccin_attribue());
                t.setCentre_attribue(str.getCentre_attribue());
                t.setGestionnaire(str.getGestionnaire());
                t.setId(str.getId());
                t.setEtatDeVaccination(str.getEtatDeVaccination());
                t.setNumLot(str.getNumLot());

                json = ob.writeValueAsString(t);
                stb.append(json + ",");
                
            }

        } else if (t.getGestionnaire().equals("5")) {

            t.setGestionnaire("fini");
            lt = t.getListeDesTicketsFini(t);

            for (Ticket str : lt) {
                t.setNiss(str.getNiss());
                t.setNom(str.getNom());
                t.setPrenom(str.getPrenom());
                t.setVaccin_attribue(str.getVaccin_attribue());
                t.setCentre_attribue(str.getCentre_attribue());
                t.setGestionnaire(str.getGestionnaire());
                t.setId(str.getId());
                t.setEtatDeVaccination(str.getEtatDeVaccination());
                t.setNumLot(str.getNumLot());

                String heure = str.getHeure_de_depart();
                String heureDeDepart = null;
                try {
                    heureDeDepart = cal.calculerHeureDeDepartPatient(heure);
                } catch (ParseException ex) {
                    Logger.getLogger(ServletGetListeDesTickets.class.getName()).log(Level.SEVERE, null, ex);
                }
                t.setHeure_de_depart(heureDeDepart);

                json = ob.writeValueAsString(t);
                stb.append(json + ",");

            }

        }
        stb1.append("[" + stb + "]");
        int length = stb1.length();
        stb1.delete(length - 2, length - 1);

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(stb1);
    }
}
