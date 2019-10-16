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
public class tsocialmedia implements Serializable{
    private int idTeacherSocialMedia,idTeacher,idSocialMedia;
    private String nickname;
    
    public tsocialmedia(){
        this.idTeacherSocialMedia=0;
        this.idTeacher=0;
        this.idSocialMedia=0;
        this.nickname="";
    }

    public tsocialmedia(int idTeacherSocialMedia, int idTeacher, int idSocialMedia, String nickname) {
        this.idTeacherSocialMedia = idTeacherSocialMedia;
        this.idTeacher = idTeacher;
        this.idSocialMedia = idSocialMedia;
        this.nickname = nickname;
    }

    public int getIdTeacherSocialMedia() {
        return idTeacherSocialMedia;
    }

    public void setIdTeacherSocialMedia(int idTeacherSocialMedia) {
        this.idTeacherSocialMedia = idTeacherSocialMedia;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getIdSocialMedia() {
        return idSocialMedia;
    }

    public void setIdSocialMedia(int idSocialMedia) {
        this.idSocialMedia = idSocialMedia;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
}
