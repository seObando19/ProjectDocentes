/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.social_media;

/**
 *
 * @author sebas
 */
public class socialMediaDao {
    
    //Metodo Insertar
    public static boolean InsertarSocialM(social_media sm){
        try {
            Connection conex = librConexion.conexionDB();
            String SQL = "INSERT INTO social_media (name,icon) VALUES(?,?)";
            PreparedStatement st = conex.prepareStatement(SQL);
            st.setString(1,sm.getName());
            st.setString(2, sm.getIcon());
            
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    //Metodo Listar
    public static ArrayList<social_media> listarSM(){
        try {
            String SQL = "SELECT *FROM social_media";
            Connection conex = librConexion.conexionDB();
            PreparedStatement st = conex.prepareStatement(SQL);
            ResultSet resultadoSM = st.executeQuery();
            ArrayList<social_media> listarSM = new ArrayList<>();
            social_media SocialMedia;
            
            while(resultadoSM.next()){
                SocialMedia = new social_media();
                SocialMedia.setName(resultadoSM.getString("name"));
                SocialMedia.setIcon(resultadoSM.getString("icon"));
                listarSM.add(SocialMedia);
            }
            return listarSM;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //Metodo Actualizar
    public static boolean ActualizarSocialM(social_media sm){
        try {
            Connection conex = librConexion.conexionDB();
            String SQL = "UPDATE social_media SET " +
                         "  icon=?" +
                         "  WHERE name=?";
            PreparedStatement st = conex.prepareStatement(SQL);
            st.setString(1, sm.getIcon());
            st.setString(2, sm.getName());
            
            if(st.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
             return false;
        }
    }
    
    //Metodo Eliminar
    public static boolean EliminarScoailM(social_media sm){
        try {
            Connection conex = librConexion.conexionDB();
            String SQL = "DELETE FROM social_media WHERE name=?";
            PreparedStatement st = conex.prepareStatement(SQL);
            st.setString(1, sm.getName());
            
            if(st.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            return false;
        }
    }  
    
    
    
}
