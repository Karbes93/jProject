/*
 * Copyright © 2019 Jonathan Martin, Nicolas Waguet, Nils Karbstein
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package service.DTOClasses;

import dhbwka.wwi.vertsys.javaee.jproject.common.jpa.User;

/**
 *
 * @author Nils
 */
public class UserDTO {

    public String username;
    public String vorname;
    public String nachname;
    
    /**
     * Konstruktor
     * @param username
     * @param vorname
     * @param nachname 
     */
    
    public UserDTO (String username, String vorname, String nachname){
        this.username = username;
        this.vorname = vorname;
        this.nachname = nachname;
    }
    
    public UserDTO (User user){
        this.username = user.getUsername();
        this.vorname = user.getVorname();
        this.nachname = user.getNachname();
    }
    
    public UserDTO(){
        
    }

/**
 * Getter und Setter
 * @return 
 */    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

      
}
