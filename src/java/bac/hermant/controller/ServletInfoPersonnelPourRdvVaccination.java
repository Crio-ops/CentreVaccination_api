/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.controller.message.Message;
import bac.hermant.model.CentreVaccination;
import bac.hermant.model.Citoyens;
import bac.hermant.model.bean.Login;
import bac.hermant.model.security.PasswordHash;
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
public class ServletInfoPersonnelPourRdvVaccination extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Citoyens c = new Citoyens();
        Citoyens cit = new Citoyens();
        ObjectMapper mapper = new ObjectMapper();
        Login log = new Login();

        log = mapper.readValue(req.getReader(), Login.class);
        c.setNiss(log.getNiss().toString());

        cit = c.getInfoPatient(c);

        log.setNiss(cit.getNiss());
        log.setNom(cit.getNom());
        log.setPrenom(cit.getPrenom());
        log.setRole(cit.getRole());
        log.setStateVaccinRdv(cit.getStateVaccinRdv());
        log.setDateNaissance(cit.getDateNaissance());
        log.setCentre_attribue(cit.getCentre_attribue());

        resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(log));

    }

}
