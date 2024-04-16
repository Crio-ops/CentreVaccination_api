/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.controller.message.Message;
import bac.hermant.model.CentreVaccination;
import bac.hermant.model.Citoyens;
import bac.hermant.model.bean.Patient;
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
public class ServletVuePatient extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    Citoyens c = new Citoyens();
    Citoyens citoyen = new Citoyens();
    Patient p = new Patient();
    ObjectMapper mapper = new ObjectMapper();
        
    
    
      c = mapper.readValue(req.getReader(),Citoyens.class);


            citoyen= citoyen.getInfoPatient(c);

            p.setNiss(citoyen.getNiss());
            p.setNom(citoyen.getNom());
            p.setPrenom(citoyen.getPrenom());
            p.setDateRdv_Dose1(citoyen.getDateRdv_Dose1());
            p.setHeureRdv_Dose1(citoyen.getHeureRdv_Dose1());
            p.setDateRdv_Dose2(citoyen.getDateRdv_Dose2());
            p.setHeureRdv_Dose2(citoyen.getHeureRdv_Dose2());
            p.setVaccin_attribue(citoyen.getVaccin_attribue());
            
            String jsonResp = mapper.writeValueAsString(p);
            String jsonResponse = "["+ jsonResp +"]";

       resp.getWriter().print(jsonResponse);
 
    }
}
 