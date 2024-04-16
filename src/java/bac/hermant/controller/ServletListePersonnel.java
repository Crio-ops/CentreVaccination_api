/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.CentreVaccination;
import bac.hermant.model.PersonnelDuCentre;
import bac.hermant.model.bean.BeanListePersonnelDuCentre;
import bac.hermant.model.bean.BeanPersonnelCentre;
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
public class ServletListePersonnel extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper ob = new ObjectMapper();
        PersonnelDuCentre pdcAdmin = new PersonnelDuCentre();
        PersonnelDuCentre pdc = new PersonnelDuCentre();
        ArrayList<PersonnelDuCentre> lpdc = new ArrayList();
        BeanListePersonnelDuCentre blc = new BeanListePersonnelDuCentre();
        BeanPersonnelCentre blcRequest = new BeanPersonnelCentre();
        String json = "";
        StringBuilder stb = new StringBuilder();
        StringBuilder stb1 = new StringBuilder();
        blcRequest = ob.readValue(req.getReader(), BeanPersonnelCentre.class);
        
        pdcAdmin.setId_Role(blcRequest.getId_Role());
        pdcAdmin.setCentre_attribue(blcRequest.getCentre_attribue());
        System.out.println("admin : " + pdcAdmin.getCentre_attribue());
        
        
        
        if(pdcAdmin.getId_Role() == 7){
            lpdc = pdc.getListeDuPersonnelDuCentre(pdcAdmin);

        }else{
            lpdc = pdc.getListeDuPersonnel();
        }  

        for (PersonnelDuCentre str : lpdc) {

            CentreVaccination centre = new CentreVaccination();
            centre.setNum_centre(String.valueOf(str.getCentre_attribue()));
            CentreVaccination centrevac = new CentreVaccination();
            centrevac = centrevac.getInfoDuCentre(centre);
            System.out.println("Personnel centre : " + centrevac);
            blc.setNiss(str.getNiss());
            blc.setNom(str.getNom());
            blc.setPrenom(str.getPrenom());
            blc.setId_Role(str.getId_Role());
            blc.setCentre_attribue(centrevac.getNomDuCentre());

            if (blc.getId_Role() == 2) {
                blc.setRole("Médecin");
            } else if (blc.getId_Role() == 3) {
                blc.setRole("Infirmier");
            } else if (blc.getId_Role() == 5) {
                blc.setRole("Opérateur de sortie");
            } else if (blc.getId_Role() == 6) {
                blc.setRole("Opérateur d'entrée");
            } else if (blc.getId_Role() == 7) {
                blc.setRole("Gérant");
            }
            json = ob.writeValueAsString(blc);
            stb.append(json + ",");
        }
        stb1.append("[" + stb + "]");
        int length = stb1.length();
        stb1.delete(length - 2, length - 1);

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(stb1);
    }
}
