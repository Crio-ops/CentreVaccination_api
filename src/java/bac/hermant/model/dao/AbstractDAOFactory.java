/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao;


/**
 *
 * @author kevin
 */
public abstract class AbstractDAOFactory {
    
    private static AbstractDAOFactory factory;
    
    public static AbstractDAOFactory getFactory(){
        return factory;
    }
    
    public static void setFactory(AbstractDAOFactory factory){
        AbstractDAOFactory.factory = factory;
    }
    
    public abstract CitoyensDAO createCitoyensDAO();

    public abstract PersonnelDuCentreDAO createPersonnelDAO();
    
    public abstract VaccinDAO createVaccinDAO();
    
    public abstract CentreVaccinationDAO createCentreVaccinationDAO();
   
    public abstract CalendrierDAO createCalendrierDAO(); 
    
    public abstract PersonnelDuCentreDAO createPersonnelDuCentreDAO();
    
    public abstract TicketDAO createTicketDAO();
}
 


