/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.dao.mysql;

import bac.hermant.model.Citoyens;
import bac.hermant.model.Vaccins;
import bac.hermant.model.dao.CitoyensDAO;
import bac.hermant.model.dao.VaccinDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public class MySqlVaccinDAO implements VaccinDAO{
     
    private static  MySqlVaccinDAO myInstance;
    
    static {
		myInstance = new MySqlVaccinDAO();
	}

    public static MySqlVaccinDAO getInstance() {
		return myInstance;
	}
    
    
    
      public Vaccins getVaccinsInVacCentre (Vaccins v){
                
                 Vaccins result;
		 Connection c = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 c=MySqlDAOFactory.getConnection();
		 
		 String sql = "INSERT INTO vaccins (num_Lot,nom, nbrDoses, joursMiniDose2, joursMaxiDose2) VALUES (?,?,?,?,?);";
                 
		 
		 try {
                     
			ps=c.prepareStatement(sql);
                        ps.setString(1, v.getNum_Lot());
                        ps.setString(2,v.getNom());
			ps.setInt(3,v.getNbrDoses());
			ps.setInt(4,v.getJoursMiniDose2());
                        ps.setInt(5,v.getJoursMaxiDose2());
                        
			ps.executeUpdate();
                        System.out.println(sql.toString());
			
			
		 }catch(SQLException e) {e.printStackTrace();}
		 finally{
			 MySqlDAOFactory.closeResultSet(rs);
			 MySqlDAOFactory.closeStatement(ps);
			 MySqlDAOFactory.closeConnection(c);
		 }
		
		
		
		return v;
            }
      
        public Vaccins verifNumLot(Vaccins v) throws SQLException{

         Vaccins vac = new Vaccins();

           Connection c = null;
           PreparedStatement ps = null;
           ResultSet rs = null;
           c=MySqlDAOFactory.getConnection();

           String sql = "SELECT nom, num_Lot FROM vaccins WHERE num_Lot = ?;";


           try { 

                ps = c.prepareStatement(sql); 
                ps.setString(1, v.getNum_Lot()); 

                ResultSet result = ps.executeQuery();

                while(result.next()){

                vac.setNom(result.getString(1));
                vac.setNum_Lot(result.getString(2));

                }

            }catch(SQLException e) {
                e.printStackTrace();
                throw e;
            }
                     finally{
                             MySqlDAOFactory.closeResultSet(rs);
                             MySqlDAOFactory.closeStatement(ps);
                             MySqlDAOFactory.closeConnection(c);
                     }

           return vac;
        } 
        
    public Vaccins getInfoVaccins(Vaccins v){
    
     Vaccins vac = new Vaccins();
     
       Connection c = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       c=MySqlDAOFactory.getConnection();
       
       String sql = "SELECT nom, nbrDoses, joursMiniDose2, joursMaxiDose2  FROM vaccins WHERE nom = ?;";

       try { 
           
            ps = c.prepareStatement(sql);
            ps.setString(1, v.getNom()); 
            ResultSet result = ps.executeQuery();
             
            while(result.next()){
            
            vac.setNom(result.getString(1));
            vac.setNbrDoses(result.getInt(2));
            vac.setJoursMiniDose2(result.getInt(3));
            vac.setJoursMaxiDose2(result.getInt(4));
            
             
            }
       
        }catch(SQLException e) {e.printStackTrace();}
		 finally{
			 MySqlDAOFactory.closeResultSet(rs);
			 MySqlDAOFactory.closeStatement(ps);
			 MySqlDAOFactory.closeConnection(c);
		 }
       return vac;
    }   
    
}
