/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.controller;

import bac.hermant.model.Calendrier;
import bac.hermant.model.Citoyens;
import bac.hermant.model.bean.BeanListeCitoyens;
import bac.hermant.model.bean.RendezVous;
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
public class ServletGetRdvDateSelection extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RendezVous rdv = new RendezVous();
        Citoyens c = new Citoyens();
        ArrayList<Citoyens> lc = new ArrayList<Citoyens>();
        Calendrier cal = new Calendrier();
        BeanListeCitoyens blc = new BeanListeCitoyens();
        ObjectMapper ob = new ObjectMapper();
        StringBuilder stb = new StringBuilder();
        StringBuilder stb1 = new StringBuilder();
        String json = "";
        req.setCharacterEncoding("UTF-8");
        rdv = ob.readValue(req.getReader(), RendezVous.class);

        cal.setDate(rdv.getDate());
        cal.setHeure(rdv.getHeure());

        lc = c.getListeRdvDuJour(cal);

        for (Citoyens str : lc) {
            blc.setNiss(str.getNiss());
            blc.setDateRdv_Dose1(str.getDateRdv_Dose1());
            blc.setDateRdv_Dose2(str.getDateRdv_Dose2());
            blc.setHeureRdv_Dose1(str.getHeureRdv_Dose1());
            blc.setHeureRdv_Dose2(str.getHeureRdv_Dose2());
            blc.setPresenceRdv1(str.getPresenceRdv1());
            blc.setPresenceRdv2(str.getPresenceRdv2());
            json = ob.writeValueAsString(blc);
            stb.append(json + ",");
        }
        stb1.append("[" + stb + "]");
        int length = stb1.length();
        stb1.delete(length - 2, length - 1);
        resp.getWriter().print(stb1);
    }
}
