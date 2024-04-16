///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package bac.hermant.controller;
//
//import bac.hermant.controller.message.Message;
//import bac.hermant.model.Administrateur;
//import bac.hermant.model.CentreVaccination;
//import bac.hermant.model.Citoyens;
//import bac.hermant.model.dao.AbstractDAOFactory;
//import bac.hermant.model.dao.mysql.MySqlDAOFactory;
//import bac.hermant.model.security.PasswordHash;
//import bac.hermant.model.security.RandomStringForPswd;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import bac.hermant.model.bean.Login;
///**
// *
// * @author kevin
// */
//public class ServletLoginAdmin extends HttpServlet {
//        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Citoyens c = new Citoyens();
//        Citoyens cit = new Citoyens();
//        Login log = new Login();
//        CentreVaccination cv = new CentreVaccination();
//        ObjectMapper mapper = new ObjectMapper();
//        Message m = new Message();
//
//
//        log = mapper.readValue(req.getReader(), Login.class);
//        c.setEnss(log.getEnss().toString());
//        c.setMotDePasse(log.getPassword().toString());
//
//        System.out.println("Hi Back, I'm comming from Http : " + c.toString());
//            
//        
//        cit.getLogin(c);
//        
////        System.out.println(cit.toString());
//        
////        String password = PasswordHash.hashPassword(cit.getMotDePasse());
////        cit.setMotDePasse(password);
//        
//      
////            System.out.println(log.toString());
//        
//    if(c.getEnss().equals(cit.getEnss()) && c.getMotDePasse().equals(cit.getMotDePasse())){
//        
//        log.setEnss(cit.getEnss());
//        log.setPassword(cit.getMotDePasse());
//        log.setNom(cit.getNom());
//        log.setPrenom(cit.getPrenom());
//
//        resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(log));
//           
//        } 
//    
//    else{
//        
//        log.setErreurLogin("erreur dans le l'identifiant ou le mot de passe");
//        System.out.println(log.toString());
//        
//        resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(log));
//    }
//        
//        
//        
//        
////         this.getServletContext().getRequestDispatcher("http://localhost:8080/CentreVaccService/servletVaccination").forward(req, resp);
////        System.out.println(a.getEnss() + a.getPassword());
////        adm.setEnss(a.getEnss());
////        adm.setMotDePasse(a.getPassword());
////        adm = cv.getLoginAdmin(adm);
////        if(a.getEnss().equals(adm.getEnss()) && a.getPassword().equals(adm.getMotDePasse())){
////            System.out.println(adm.toString());
////            HttpSession session = req.getSession();
////            session.setAttribute("nom",adm.getNom());
////            session.setAttribute("prenom",adm.getPrenom());
////        a = mapper.readValue(req.getReader(),Login.class);
//
////            
////        System.out.println("après hash : " + a.toString());
////        System.out.println("après hash : " + adm.toString());
//       
////        
////        if(adm.getRole().equals("administrateur")){   
////            
////         
////        HttpSession session = req.getSession();
////        session.setAttribute("role",adm.getRole());
////        session.setAttribute("nom",adm.getNom());
////        session.setAttribute("prenom",adm.getPrenom());
////        
////        m.setPatient(adm.getPrenom());
////        m.setMessage("administrateur");
////        resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(m));
////        
////        // TEST //
////             System.out.println("Je suis là !");
////           
////        // TEST //
////            }else{
////             m.setMessage("Vous n'êtes pas administrateur");
////            resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(m.getMessage()));
////                }
////        }else{
////           m.setMessage("Erreur dans le mot de passe ou dans l'identifiant");
////       resp.getWriter().print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(m.getMessage()));
////       } 
//        
//    }
//}
