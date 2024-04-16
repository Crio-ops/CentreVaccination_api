/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Citoyens;
import bac.hermant.model.PersonnelDuCentre;
import bac.hermant.model.bean.BeanListeCitoyens;
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
public class ServletListeCitoyens extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper ob = new ObjectMapper();
        ArrayList<Citoyens> lc = new ArrayList();
        BeanListeCitoyens blc = new BeanListeCitoyens();
        String json = "";
        StringBuilder stb = new StringBuilder();
        StringBuilder stb1 = new StringBuilder();

        PersonnelDuCentre pdcAdmin = new PersonnelDuCentre();
        BeanPersonnelCentre blcRequest = new BeanPersonnelCentre();
        blcRequest = ob.readValue(req.getReader(), BeanPersonnelCentre.class);

        pdcAdmin.setId_Role(blcRequest.getId_Role());
        pdcAdmin.setCentre_attribue(blcRequest.getCentre_attribue());
        System.out.println("back role : " + pdcAdmin);
        if (pdcAdmin.getId_Role() == 7) {
            Citoyens cit = new Citoyens();
            lc = cit.getListeDesCitoyensDuCentre(pdcAdmin);

        } else {
            Citoyens cit = new Citoyens();
            lc = cit.getListeDesCitoyens();
        }

        for (Citoyens str : lc) {
            blc.setNiss(str.getNiss());
            blc.setNom(str.getNom());
            blc.setPrenom(str.getPrenom());
            blc.setAdresse(str.getAdresse());
            blc.setEtatDeVaccination(str.getEtatDeVaccination());
            blc.setVaccin_attribue(str.getVaccin_attribue());
            blc.setDateRdv_Dose1(str.getDateRdv_Dose1());
            blc.setDateRdv_Dose2(str.getDateRdv_Dose2());
            blc.setHeureRdv_Dose1(str.getHeureRdv_Dose1());
            blc.setHeureRdv_Dose2(str.getHeureRdv_Dose2());
            json = ob.writeValueAsString(blc);
            stb.append(json + ",");
        }
        stb1.append("[" + stb + "]");
        int length = stb1.length();
        stb1.delete(length - 2, length - 1);
        resp.getWriter().print(stb1);
    }
}
