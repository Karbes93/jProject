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
import dhbwka.wwi.vertsys.javaee.jproject.tasks.jpa.Category;
import dhbwka.wwi.vertsys.javaee.jproject.tasks.jpa.Task;
import dhbwka.wwi.vertsys.javaee.jproject.tasks.jpa.TaskStatus;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Nils
 */
public class TaskDTO {
    public User owner;
    public Category category;
    public String shortText;
    public String longText;
    public String longText1;
    public Date dueDate;
    public Time dueTime;
    public TaskStatus status;
    
/**
 * Konstruktor
 * @param owner
 * @param category
 * @param shortText
 * @param longText
 * @param longText1
 * @param dueDate
 * @param dueTime
 * @param status 
 */    
    public TaskDTO (User owner, Category category, String shortText, String longText, String longText1, 
            Date dueDate, Time dueTime, TaskStatus status){
        this.category = category;
        this.owner = owner;
        this.shortText = shortText;
        this.longText = longText;
        this.longText1 = longText1;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.status = status;
    }
    
    public TaskDTO(){
        
    }

    TaskDTO(Task task) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

/**
 * Getter und Setter
 * @return 
 */    
    
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getLongText() {
        return longText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public String getLongText1() {
        return longText1;
    }

    public void setLongText1(String longText1) {
        this.longText1 = longText1;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Time getDueTime() {
        return dueTime;
    }

    public void setDueTime(Time dueTime) {
        this.dueTime = dueTime;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    
    
}
