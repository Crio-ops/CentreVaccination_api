/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Citoyens;
import bac.hermant.model.Ticket;
import bac.hermant.model.Vaccins;
import bac.hermant.model.bean.BeanError;
import bac.hermant.model.bean.BeanTicket;
import bac.hermant.model.bean.BeanValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.SQLException;
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
public class ServletValiderLaVaccination extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");

        ObjectMapper ob = new ObjectMapper();
        BeanTicket bt = new BeanTicket();
        Citoyens cit = new Citoyens();
        Citoyens c = new Citoyens();
        Vaccins vacDuPatient = new Vaccins();
        Vaccins vacDb = new Vaccins();
        Vaccins vacVerification = new Vaccins();
        Citoyens patient = new Citoyens();
        Ticket t = new Ticket();
        Ticket ticket = new Ticket();

        bt = ob.readValue(req.getReader(), BeanTicket.class);

        cit.setNiss(bt.getNiss());
        cit.setCentre_attribue(bt.getCentre_attribue());
        System.out.println("citoyen : " + cit);
        patient = c.getInfoVaccinationPatient(cit);
        System.out.println("patient : " + patient);
        try {

            patient.getNiss().toString().equals(cit.getNiss().toString());

            //vérification du lot disponible
            vacDuPatient.setNum_Lot(bt.getNumLot());
            vacDuPatient.setNom(patient.getVaccin_attribue());

            vacVerification.setNum_Lot(bt.getNumLot());

            try {
                vacDb = vacVerification.verifNumLot(vacVerification);
            } catch (SQLException ex) {
                Logger.getLogger(ServletValiderLaVaccination.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {

                vacDuPatient.getNum_Lot().toString().equals(vacDb.getNum_Lot().toString());

                //vérification de la dose administrée et cloture du rendez vous, 
                //si l'etat vaccinal est de 0, c'est le premier rdv.
                if (patient.getEtatDeVaccination().equals("0")) {

                    System.out.println("etat 0");
                    
                    patient.setNumLot_vaccin_attribue_dose1(bt.getNumLot());
                    patient.setPresenceRdv1("cloturé");
                    patient.validerPresencePatientRdv1(patient);

                    if (patient.getVaccin_attribue().equals("Johnson_Johnson")) {

                        System.out.println("vac 1 dose");
                        
                        patient.setEtatDeVaccination("2");
                        patient.vaccination_D1(patient);

                    } else {

                        System.out.println("vac 2 doses");
                        
                        patient.setEtatDeVaccination("1");
                        patient.vaccination_D1(patient);

                    }

                } else {
                    System.out.println("patient a eu 2 doses");
                    
                    patient.setEtatDeVaccination("2");
                    patient.setNumLot_vaccin_attribue_dose2(bt.getNumLot());
                    patient.setPresenceRdv2("cloturé");
                    patient.validerPresencePatientRdv2(patient);
                    patient.vaccination_D2(patient);
                }

                //suppression du ticket du patient
                
                t.setNiss(bt.getNiss());
                System.out.println("ticket enss : " + t);
                ticket.deleteTicket(t);

                BeanValidation bv = new BeanValidation();
                bv.setMessage("Validation de la vaccination effectuée");
                resp.getWriter().print(bv);

            } catch (Exception e) {
                BeanError be = new BeanError("erreur, le numéro de lot n'est pas bon");
                resp.getWriter().print(be);

            }

        } catch (Exception e) {

            BeanError be = new BeanError("erreur, le NISS du patient n'est pas bon");
            resp.getWriter().print(be);
        }

    }
}
