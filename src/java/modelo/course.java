/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author sebas
 */
public class course implements Serializable{
    private int idTeacher;
    private String name,themes,project;
    
    public course(){        
        this.idTeacher=0;
        this.name="";
        this.project="";
        this.themes="";
    }

    public course(int idTeacher, String name, String themes, String project) {
        
        this.idTeacher = idTeacher;
        this.name = name;
        this.themes = themes;
        this.project = project;
    } 

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThemes() {
        return themes;
    }

    public void setThemes(String themes) {
        this.themes = themes;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
    
}
