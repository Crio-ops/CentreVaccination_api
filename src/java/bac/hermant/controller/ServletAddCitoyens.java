/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.controller.message.Message;

import bac.hermant.model.Citoyens;
import bac.hermant.model.security.PasswordHash;
import bac.hermant.model.security.RandomStringForPswd;
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
public class ServletAddCitoyens extends HttpServlet{
    
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession session = req.getSession();
       List<Citoyens> listCitoyens;
       Citoyens p = new Citoyens();
       Citoyens cit = new Citoyens();
       ObjectMapper mapper = new ObjectMapper();
       boolean result = true;
       

        try{
            listCitoyens = mapper.readValue(req.getReader(), new TypeReference<List<Citoyens>>(){});

                for (Iterator<Citoyens> it = listCitoyens.iterator(); it.hasNext();) {
                    p = it.next();
                    String password = PasswordHash.hashPassword(p.getMotDePasse());
                    p.setMotDePasse(password);
                    System.out.println("patient apres hash : " + p.toString());
                    cit.getCitoyensInVacCentre(p);
                    }
                 
    
        }catch(Exception e){
            
            result = false;
            
                }
        if(result != true){
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().print("false");
        }else{
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().print("true");
        }
        
    }   
    
}
