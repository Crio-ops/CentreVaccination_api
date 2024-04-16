/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;


import bac.hermant.model.CentreVaccination;
import bac.hermant.model.bean.BeanListeCentreVaccination;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
public class ServletAfficherLesCentres extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
               
            ObjectMapper ob = new ObjectMapper(); 
            ArrayList<CentreVaccination> lcv = new ArrayList();
            BeanListeCentreVaccination blcv = new BeanListeCentreVaccination();
            String json = "";
            StringBuilder stb = new StringBuilder();
            StringBuilder stb1 = new StringBuilder();
            
            CentreVaccination cv = new CentreVaccination();
            lcv = cv.getListeDesCentres();
           
            for (CentreVaccination str : lcv) {
            blcv.setNomDuCentre(str.getNomDuCentre());
            blcv.setAdresse(str.getAdresse());
            blcv.setLat(str.getLat());
            blcv.setLng(str.getLng());
            blcv.setNum_centre(str.getNum_centre());
                System.out.println(lcv);
                json = ob.writeValueAsString(blcv);
            stb.append(json + ",");
        }
            stb1.append("[" + stb + "]");
            int length = stb1.length();
            stb1.delete(length-2, length-1);
             resp.getWriter().print(stb1);
    }
}

        
