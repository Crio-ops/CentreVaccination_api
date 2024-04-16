/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.controller.message.Message;
import bac.hermant.model.CentreVaccination;
import bac.hermant.model.Citoyens;
import bac.hermant.model.bean.Login;
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
public class ServletCitoyensChangePassword extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    Citoyens c = new Citoyens();
    Citoyens cit = new Citoyens();
    Login log = new Login();
    ObjectMapper mapper = new ObjectMapper();
    Message m = new Message();   
 
        log = mapper.readValue(req.getReader(),Login.class);
//        log.setEnss(session.getAttribute("enss").toString());
        cit.setMotDePasse(log.getPassword());
        
           String password = PasswordHash.hashPassword(cit.getMotDePasse());
           cit.setMotDePasse(password);
           c.changePassword(cit);

        
    }
}
