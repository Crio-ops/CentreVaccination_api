/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.controller.message.Message;
import bac.hermant.model.CentreVaccination;
import bac.hermant.model.Citoyens;
import bac.hermant.model.Vaccins;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.SQLException;
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
public class ServletSortiePatientAccueil_Dose1 extends HttpServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Message m = new Message();
        Citoyens c = new Citoyens();
        Citoyens citoyen = new Citoyens();
        Vaccins v = new Vaccins();
        Vaccins vac = new Vaccins();
        CentreVaccination cv = new CentreVaccination();
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
   

        c = mapper.readValue(req.getReader(),Citoyens.class);
        String vacAtt = c.getVaccin_attribue();
        v.setNum_Lot(vacAtt);  
        try {
            vac.verifNumLot(v);
        } catch (SQLException ex) {
            Logger.getLogger(ServletSortiePatientAccueil_Dose1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        citoyen.vuePatient(c);
        if(citoyen.getVaccin_attribue().equals(vac.getNom())){
            citoyen.vaccination_D1(c);
            m.setMessage("Les informations sont enregistrée");
            resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(m.getMessage()));

        }else{
            m.setMessage("Le numéro de lot est incorrecte");
        resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(m.getMessage()));
         }
        }

}
