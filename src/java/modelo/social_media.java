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
public class social_media implements Serializable{
    private int idSocialMedia;
    private String name,icon;
    
    public social_media(){
        this.idSocialMedia=0;
        this.name="";
        this.icon="";
    }

    public social_media(int idSocialMedia, String name, String icon) {
        this.idSocialMedia = idSocialMedia;
        this.name = name;
        this.icon = icon;
    }

    public int getIdSocialMedia() {
        return idSocialMedia;
    }

    public void setIdSocialMedia(int idSocialMedia) {
        this.idSocialMedia = idSocialMedia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
}
