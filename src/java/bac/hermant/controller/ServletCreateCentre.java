/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.CentreVaccination;
import bac.hermant.model.bean.BeanCentreDeVaccination;
import bac.hermant.model.bean.BeanReturnedMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
public class ServletCreateCentre extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        CentreVaccination cv = new CentreVaccination();
        CentreVaccination centreVac = new CentreVaccination();
        BeanCentreDeVaccination bcv = new BeanCentreDeVaccination();
        BeanReturnedMessage brm = new BeanReturnedMessage();
        ObjectMapper ob = new ObjectMapper();
         
        req.setCharacterEncoding("UTF-8");
        System.out.println("ici");
        bcv = ob.readValue(req.getReader(), BeanCentreDeVaccination.class);
        
       
        System.out.println("brv : " + bcv);
    
        cv.setNomDuCentre(bcv.getNomDuCentre());
//        cv.setRue(bcv.getRue());
//        cv.setNumero(bcv.getNumero());
        cv.setRue(bcv.getRue());
        cv.setNumero(bcv.getNumero());
        cv.setPostCode(bcv.getPostCode());
        cv.setVille(bcv.getVille());
        cv.setLat(bcv.getLat());
        cv.setLng(bcv.getLng());
        cv.setConcatAdresse(bcv.getRue(), bcv.getNumero());
        
         System.out.println("Backend : "+cv);
         
         
         
        try {
               
        centreVac.createCentre(cv);          
        brm.setMessage("Nouveau centre de vaccination enregistré");
        resp.getWriter().print(ob.writerWithDefaultPrettyPrinter().writeValueAsString(brm));
        
        } catch (Exception e) {
            
        brm.setMessage("Erreur dans l'enregistrement, veuillez recommencer");
        resp.getWriter().print(ob.writerWithDefaultPrettyPrinter().writeValueAsString(brm));
    
        }

    }
    
}
