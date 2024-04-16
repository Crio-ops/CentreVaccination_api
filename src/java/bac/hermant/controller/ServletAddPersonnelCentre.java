/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Citoyens;
import bac.hermant.model.PersonnelDuCentre;
import bac.hermant.model.bean.BeanPersonnelCentre;
import bac.hermant.model.bean.BeanValidation;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kevin
 */
public class ServletAddPersonnelCentre extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ObjectMapper ob = new ObjectMapper();

        BeanValidation bean_reponse = new BeanValidation(); 
        BeanPersonnelCentre bpc = new BeanPersonnelCentre();
        Citoyens c = new Citoyens();
        Citoyens cit = new Citoyens();

        bpc = ob.readValue(req.getReader(), BeanPersonnelCentre.class);

        PersonnelDuCentre pdc = new PersonnelDuCentre();
        ArrayList<PersonnelDuCentre> lpdc = new ArrayList();

        pdc.setNiss(bpc.getNiss());
        pdc.setNom(bpc.getNom());
        pdc.setPrenom(bpc.getPrenom());
        pdc.setId_Role(bpc.getId_Role());
        pdc.setCentre_attribue(bpc.getCentre_attribue());
        System.out.println(pdc);
        lpdc = pdc.getListeDesMedecinsParCentre(pdc);
        
// vérification de la possibilité d'engager de nouveaux medecins

//        Boolean bool = PersonnelDuCentre.checkPersonnelEnroll(lpdc);

//        if (bool == false) {
//
//            System.out.println("REPONSE : " + bool);

            cit.setNiss(pdc.getNiss());
            cit.setNom(pdc.getNom());

            c = c.getInfoCitoyen(cit);

            if (c.getNiss().equals(cit.getNiss()) && c.getNom().equals(cit.getNom())) {

                pdc.setMotDePasse(c.getMotDePasse());

                pdc.setPersonnelInVacCentre(pdc);
                c.setCentre_attribue(pdc.getCentre_attribue());
                c.setRole(pdc.getId_Role());
                c.updateRolePersonnelInCitoyens(c);
                c.updateCentreAttribueAuPatient(c);
                
                bean_reponse.setValidation(false);
                

            } else {

                bean_reponse.setValidation(false);
                bean_reponse.setMessage("Erreur, veuillez recommencer");

            }
            
//        }else{
//            bean_reponse.setValidation(false);
//            bean_reponse.setMessage("Vous ne pouvez pas engager plus de médecin, veuillez employer de nouveaux infirmiers");
//        }
        
//        String json_resp = ob.writeValueAsString(bool);
//        resp.getWriter().print(json_resp);

    }
}
