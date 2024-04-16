/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.controller.message.Message;
import bac.hermant.model.Vaccins;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kevin
 */
public class ServletAddVaccins extends HttpServlet {
    
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Message m = new Message();
        List<Vaccins> listVaccins;
        Vaccins v = new Vaccins();
        Vaccins vac = new Vaccins();
        ObjectMapper mapper = new ObjectMapper();

        req.setCharacterEncoding("UTF-8");
        
//    if(session.getAttribute("role").equals("administrateur")){ 
        //Déserialisation de la requete dans une liste
        listVaccins= mapper.readValue(req.getReader(), new TypeReference<List<Vaccins>>(){});      
        for (Iterator<Vaccins> it = listVaccins.iterator(); it.hasNext();) {
            v = it.next();
            vac.getVaccinsInVacCentre(v);
            System.out.println(v);
        }
     

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(v));
  
    
//      }else{
//        m.setMessage("Vous n'êtes pas autorisé à faire ceci");
//        resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(m.getMessage()));
//        }
    }
        
}
