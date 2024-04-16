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
import bac.hermant.model.dao.AbstractDAOFactory;
import bac.hermant.model.dao.CitoyensDAO;
import bac.hermant.model.dao.mysql.MySqlDAOFactory;
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
public class ServletLoginCitoyens extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Citoyens c = new Citoyens();
        Citoyens cit = new Citoyens();
        Citoyens infoRdv = new Citoyens();
        Citoyens infoVaccination = new Citoyens();
        CentreVaccination cv = new CentreVaccination();
        ObjectMapper mapper = new ObjectMapper();
        Login log = new Login();
        Message m = new Message();

        log = mapper.readValue(req.getReader(), Login.class);
        c.setNiss(log.getNiss().toString());
        c.setMotDePasse(log.getPassword().toString());
        String password = PasswordHash.hashPassword(c.getMotDePasse());
        c.setMotDePasse(password);
        cit = cit.getLoginPatient(c);
        infoRdv = cit.getInfoPatient(c);
        infoVaccination = infoVaccination.getInfoVaccinationPatient(c);
        cit.setStateVaccinRdv(infoRdv.getStateVaccinRdv());

        System.out.println("cit == " + cit.toString());

        if (c.getNiss().equals(cit.getNiss()) && c.getMotDePasse().equals(cit.getMotDePasse())) {
            session.setAttribute("niss", cit.getNiss());
            session.setAttribute("password", cit.getMotDePasse());
            session.setAttribute("nom", cit.getNom());
            session.setAttribute("prenom", cit.getPrenom());
            session.setAttribute("role", cit.getRole());
            session.setAttribute("EtatRdvVacc", cit.getStateVaccinRdv());
            session.setAttribute("dateNaissance", cit.getDateNaissance());
            log.setNiss(cit.getNiss());
            log.setPassword(cit.getMotDePasse());
            log.setNom(cit.getNom());
            log.setPrenom(cit.getPrenom());
            log.setRole(cit.getRole());
            log.setStateVaccinRdv(cit.getStateVaccinRdv());
            log.setDateNaissance(cit.getDateNaissance());
            log.setCentre_attribue(cit.getCentre_attribue());

            if (infoVaccination.getNiss() != null) {
                log.setEtatDeVaccination(infoVaccination.getEtatDeVaccination());
                log.setVaccin_attribue(infoVaccination.getVaccin_attribue());
            }else{
                log.setEtatDeVaccination("0");
            }

            resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(log));

        } else {

            log.setErreurLogin("erreur dans le l'identifiant ou le mot de passe");

            resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(log));

        }

    }

}
