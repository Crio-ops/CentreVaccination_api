/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Citoyens;
import bac.hermant.model.PersonnelDuCentre;
import bac.hermant.model.bean.BeanError;
import bac.hermant.model.bean.BeanPersonnelCentre;
import bac.hermant.model.bean.BeanValidation;

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
public class ServletDeletePersonnelCentre extends HttpServlet{
    
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ObjectMapper ob = new ObjectMapper();
        
        BeanPersonnelCentre bpc = new BeanPersonnelCentre();
        Citoyens c = new Citoyens();
        Citoyens cit = new Citoyens();
        
        bpc = ob.readValue(req.getReader(), BeanPersonnelCentre.class);
        
        PersonnelDuCentre pdc = new PersonnelDuCentre();
        
        pdc.setNiss(bpc.getNiss());
        pdc.setNom(bpc.getNom());
//        pdc.setPrenom(bpc.getPrenom());
//        pdc.setID_Role(bpc.getID_Role());
        
        cit.setNiss(pdc.getNiss());
        cit.setNom(pdc.getNom());
            try {
                pdc.deletePersonnel(pdc);
                cit.setRole(4);
                cit.updateRolePersonnelInCitoyens(cit);

            } catch (Exception e) {
                BeanError be = new BeanError("erreur lors de la suppression du membre du personnel");
                be.printStackTrace();
                BeanValidation bn = new BeanValidation();
                bn.setValidation(false);
                String jsonResp = ob.writeValueAsString(bn);
                resp.getWriter().print(jsonResp);
            }
        
        BeanValidation bn = new BeanValidation();
        bn.setValidation(true);
        String jsonResp = ob.writeValueAsString(bn);
        resp.getWriter().print(jsonResp);
        }
}
