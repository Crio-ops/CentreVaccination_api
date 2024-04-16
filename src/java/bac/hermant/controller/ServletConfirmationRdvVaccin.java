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
import bac.hermant.model.bean.BeanValidation;
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
public class ServletConfirmationRdvVaccin extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
            HttpSession session = req.getSession();
            RendezVous rdv = new RendezVous();
            Citoyens p = new Citoyens();
            Citoyens citoyen = new Citoyens();
            Vaccins v = new Vaccins();
            Vaccins v_result = new Vaccins();
            Vaccins infoVac = new Vaccins();
            Citoyens cit = new Citoyens();
            CentreVaccination cv = new CentreVaccination();
            ObjectMapper mapper = new ObjectMapper();
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");
            int stateVaccinRdv = 0;
            int age = 0;
            
            rdv = mapper.readValue(req.getReader(), RendezVous.class);
         
            
            System.out.println("rdv back end : " + rdv);
            p.setDateRdv_Dose1(rdv.getDate());
            p.setHeureRdv_Dose1(rdv.getHeure());
            p.setNiss(rdv.getNiss());
            p.setDateNaissance(rdv.getDateNaissance());
            p.setCentre_attribue(rdv.getCentre_attribue());
        try {
            age = p.getAge(p.getDateNaissance());
        } catch (ParseException ex) {
            Logger.getLogger(ServletConfirmationRdvVaccin.class.getName()).log(Level.SEVERE, null, ex);
        }           
            v_result = v.vaccinPourPatient(age);       
            p.setVaccin_attribue(v_result.getNom()); 
            infoVac = cit.getInfoVaccins(v_result);
            cit.callProcedurePatient_dose1(p);
            
            if(infoVac.getNbrDoses()>1){
                p.setStateVaccinRdv(1);
                p = cit.getRdvPatient(p);
                
                BeanValidation bv = new BeanValidation();
                bv.setMessage("Validé");
                
                String jsonResp = mapper.writeValueAsString(bv);
        
            }else{    
                
                p.setStateVaccinRdv(2);
                p = cit.getRdvPatient(p);
                
                BeanValidation bv = new BeanValidation();
                bv.setMessage("Validé");
                
                String jsonResp = mapper.writeValueAsString(bv);
                
                resp.getWriter().print(jsonResp);
                
            }
            
            Calendrier cal = new Calendrier();
            cal.setDate(rdv.getDate());
            cal.setHeure(rdv.getHeure()); 
            cal.setNbrLigne(1);
            cal.setCentre_attribue(rdv.getCentre_attribue());
            ArrayList<Calendrier> rdvList = cal.verifRdvEstDisponible(cal);
            int count = rdvList.size();
            if(count >= 3){

                cal.insertRdvIndisponible(cal);
            };

        }
    }

