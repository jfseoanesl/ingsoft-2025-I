/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.openclosed.bad;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author JAIRO
 */
public abstract class Vehicle {
    
    private String matricule;
    private String type;


    public Vehicle(String matricule, String type) {
        this.matricule = matricule;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the matricula
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * @param matricule the matricula to set
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public abstract double getRate();
    

    
    
}
