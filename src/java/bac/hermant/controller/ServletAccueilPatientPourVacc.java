/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.controller.message.Message;
import bac.hermant.model.CentreVaccination;
import bac.hermant.model.Citoyens;
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
public class ServletAccueilPatientPourVacc extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Message m = new Message();
        Citoyens c = new Citoyens();
        Citoyens citoyen = new Citoyens();
        CentreVaccination cv = new CentreVaccination();
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");

        if (session.getAttribute("role").toString().equals("accueil")) {
            c = mapper.readValue(req.getReader(), Citoyens.class);
            citoyen.getInfoPatient(c);

            if (c.getNiss().equals(citoyen.getNiss())) {
                m.setMessage("rendez-vous le " + citoyen.getDateRdv_Dose1() + " - " + citoyen.getHeureRdv_Dose1());
                m.setPatient(citoyen.getPrenom() + " " + citoyen.getNom());
                resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(m.getPatient() + " - " + m.getMessage()));

            }

        } else {
            resp.setCharacterEncoding("UTF-8");
            m.setMessage("Vous n'êtes pas autorisé à faire ceci");
            resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(m.getMessage()));
        }

    }

}
