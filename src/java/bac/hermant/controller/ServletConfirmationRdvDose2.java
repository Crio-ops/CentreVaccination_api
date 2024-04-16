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
import bac.hermant.model.Vaccins;
import bac.hermant.model.bean.RendezVous;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author kevin
 */
public class ServletConfirmationRdvDose2 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Citoyens p = new Citoyens();
        Citoyens citoyen = new Citoyens();
        Message m = new Message();
        Vaccins v = new Vaccins();
        Vaccins v_result = new Vaccins();
        Vaccins infoVac = new Vaccins();
        RendezVous rdv = new RendezVous();
        CentreVaccination cv = new CentreVaccination();
        ObjectMapper mapper = new ObjectMapper();
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        rdv = mapper.readValue(req.getReader(), RendezVous.class);

        p.setDateRdv_Dose2(rdv.getDate());
        p.setHeureRdv_Dose2(rdv.getHeure());
        p.setNiss(rdv.getNiss());
        p.setStateVaccinRdv(2);

        citoyen.getRdvPatient_Dose2(p);
        
            Calendrier cal = new Calendrier();
            cal.setDate(rdv.getDate());
            cal.setHeure(rdv.getHeure());
            cal.setNbrLigne(1);
            cal.setCentre_attribue(rdv.getCentre_attribue());
            ArrayList<Calendrier> rdvList = cal.verifRdvEstDisponible(cal);
            int count = rdvList.size();
            if(count >= 3){;
                cal.insertRdvIndisponible(cal);
            }
        }

}
