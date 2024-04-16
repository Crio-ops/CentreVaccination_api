/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.hermant.model.bean;

/**
 *
 * @author kevin
 */

//Permet d'envoyer des messages de validation d'action sans retour d'objet réel
public class BeanValidation {
    
    private String message;
    private Boolean validation;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }

    @Override
    public String toString() {
        return "BeanValidation{" + "message=" + message + ", validation=" + validation + '}';
    }


    
}

