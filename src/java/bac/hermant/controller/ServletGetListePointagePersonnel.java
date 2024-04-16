/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Calendrier;
import bac.hermant.model.PersonnelDuCentre;
import bac.hermant.model.bean.BeanPointagePersonnel;
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
public class ServletGetListePointagePersonnel extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper ob = new ObjectMapper();
        ArrayList<PersonnelDuCentre> tp = new ArrayList();
        BeanPointagePersonnel bp = new BeanPointagePersonnel();
        Calendrier cal = new Calendrier();
        String json = "";
        StringBuilder stb = new StringBuilder();
        StringBuilder stb1 = new StringBuilder();

        bp = ob.readValue(req.getReader(), BeanPointagePersonnel.class);

        PersonnelDuCentre pdc = new PersonnelDuCentre();

        pdc.setCentre_attribue(bp.getCentre_attribue());
        pdc.setDate(bp.getDate());
        System.out.println("date : " + pdc.getDate());
        
//      Type 1 = entrer ** Type 2 = sortie  

        if (bp.getType() == 1) {

            tp = pdc.getListePointageEntreePersonnelParCentre(pdc);

            for (PersonnelDuCentre str : tp) {
                
                PersonnelDuCentre pc = new PersonnelDuCentre();
                
                bp.setNiss(str.getNiss());
                bp.setNom(str.getNom());
                bp.setPrenom(str.getPrenom());
                bp.setDate(str.getDate());
                bp.setHeure(str.getHeure());
                bp.setCentre_attribue(str.getCentre_attribue());
           
                json = ob.writeValueAsString(bp);
                stb.append(json + ",");
                
            }

        } else if (bp.getType() == 2) {

            tp = pdc.getListePointageSortiePersonnelParCentre(pdc);

            for (PersonnelDuCentre str : tp) {
                bp.setNiss(str.getNiss());
                bp.setNom(str.getNom());
                bp.setPrenom(str.getPrenom());
                bp.setDate(str.getDate());
                bp.setHeure(str.getHeure());
                bp.setCentre_attribue(str.getCentre_attribue());
                System.out.println(bp);
                json = ob.writeValueAsString(bp);
                stb.append(json + ",");
                
            }

        }
        stb1.append("[" + stb  + "]");
        int length = stb1.length();
        stb1.delete(length - 2, length - 1);

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(stb1);
    }
    
}
