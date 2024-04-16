/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Citoyens;
import bac.hermant.model.Ticket;
import bac.hermant.model.bean.RendezVous;
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
//créer un ticket pour le rendez-vous du patient afin d'être pris en charge par un membre du personnel - Inf ou Med
public class ServletValiderPresencePatient extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RendezVous rdv = new RendezVous();
        Ticket t = new Ticket();
        Ticket ticket = new Ticket();
        ArrayList<Ticket> arrayTicket = new ArrayList<Ticket>();
        Citoyens c = new Citoyens();
        Citoyens cit = new Citoyens();
        ObjectMapper ob = new ObjectMapper();
        rdv = ob.readValue(req.getReader(), RendezVous.class);

        c.setNiss(rdv.getNiss());
        c.setPresenceRdv1(rdv.getPresenceRdv1());
        cit.validerPresencePatientRdv1(c);

        cit = c.getInfoForTicket(c);

        t.setNiss(cit.getNiss());
        t.setNom(cit.getNom());
        t.setPrenom(cit.getPrenom());
        t.setVaccin_attribue(cit.getVaccin_attribue());
        t.setCentre_attribue(rdv.getCentre_attribue());
        t.setEtatDeVaccination(cit.getEtatDeVaccination());

        arrayTicket = ticket.getListeDesTickets(t);
        int id_ticket = arrayTicket.size();

        id_ticket = id_ticket + 1;
        t.setId(id_ticket);

        ticket.createTicket(t);

        resp.getWriter().print("Le ticket a bien été créé");
    }
}
