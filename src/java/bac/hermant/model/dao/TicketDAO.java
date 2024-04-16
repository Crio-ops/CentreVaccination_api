/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao;

import bac.hermant.model.Ticket;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author kevin
 */
public interface TicketDAO {

    public Ticket createTicket(Ticket t);

    public ArrayList<Ticket> getListeDesTickets(Ticket ticket);
    
    public ArrayList<Ticket> getListeDesTicketsFini(Ticket ticket);

    public Ticket validerPriseEnChargeTicket(Ticket t);

    public Ticket deleteTicket(Ticket t);

    public Ticket cloturerLeTicket(Ticket t);
    
    public Ticket getTicketDuPatient(Ticket t);
}
