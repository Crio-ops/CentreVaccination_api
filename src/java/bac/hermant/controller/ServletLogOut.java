/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.controller.message.Message;
import bac.hermant.model.Citoyens;
import bac.hermant.model.bean.Login;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author kevin
 */
public class ServletLogOut extends HttpServlet  {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ObjectMapper mapper = new ObjectMapper();
        Login log = new Login();
        
        log = mapper.readValue(req.getReader(),Login.class);
        session.setAttribute("enss", log.getNiss());
        
        if(session.getAttribute("enss") == null){
            log.setErreurLogin("Vous n'êtes pas connecté");
            resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(log.getErreurLogin()));
         
        }else{
       
            log.setNiss(session.getAttribute("enss").toString());;

            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(log));
            session.invalidate();
        
        }
        
        
    }

   
}
