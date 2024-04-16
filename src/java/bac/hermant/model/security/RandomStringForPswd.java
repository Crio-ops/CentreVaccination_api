/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.security;

/**
 *
 * @author kevin
 */
public class RandomStringForPswd {
    
    public static String getRandomString(String rp) 
    { 
        int i =8;
        String theAlphaNumericS;
        StringBuilder builder;
        
        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"; 

        //create the StringBuffer
        builder = new StringBuilder(i); 

        for (int m = 0; m < i; m++) { 

            // generate numeric
            int myindex 
                = (int)(theAlphaNumericS.length() 
                        * Math.random()); 

            // add the characters
            builder.append(theAlphaNumericS 
                        .charAt(myindex)); 
        } 
                  rp = builder.toString();
        
        return rp; 
    } 

}
