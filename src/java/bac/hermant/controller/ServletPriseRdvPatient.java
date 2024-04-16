/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.controller.message.Message;
import bac.hermant.model.Calendrier;
import bac.hermant.model.CentreVaccination;
import bac.hermant.model.Citoyens;
import bac.hermant.model.bean.RendezVous;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kevin
 */
public class ServletPriseRdvPatient extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Citoyens cit = new Citoyens();

        RendezVous rdv = new RendezVous();
        Calendrier c = new Calendrier();
        Calendrier cal = new Calendrier();

        ArrayList<Calendrier> listHeureIndispo = new ArrayList<Calendrier>();
        ArrayList<Calendrier> listHeure = new ArrayList<Calendrier>();

        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        rdv = mapper.readValue(req.getReader(), RendezVous.class);

        cal.setDate(rdv.getDate());
        cal.setCentre_attribue(rdv.getCentre_attribue());
        System.out.println("calendrier :" + cal);

        listHeure = c.getRDVDisponible(cal);

//        for (Calendrier calendrier : listHeure) {
//            System.out.println(calendrier.toString());
//            if (c.controleNbrLigne(calendrier) != true) {
//
//                listHeureIndispo.add(calendrier);
//
//            }
//        }

        String jsonResp = mapper.writeValueAsString(listHeure);

        System.out.println("apres mapper");

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(jsonResp);
    }
}
