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
import modelo.teacher;

/**
 *
 * @author sebas
 */
public class teacherDao {
    //Metodo Insertar
    public static boolean InsertarTeacher(teacher tech){
        try {
            Connection conex = librConexion.conexionDB();
            String SQL ="INSERT INTO teacher (cedula,name,avatar) VALUES (?,?,?)";
            PreparedStatement st = conex.prepareStatement(SQL);
            st.setString(1, tech.getCedula());
            st.setString(2, tech.getName());
            st.setString(3, tech.getAvatar());
            return st.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    //Metodo listar
    public static ArrayList<teacher> listarTeacher(){
        try {
            String SQL = "SELECT *FROM teacher";
            Connection conex = librConexion.conexionDB();
            PreparedStatement st = conex.prepareStatement(SQL);
            ResultSet resultadoTeacher = st.executeQuery();
            ArrayList<teacher> listarTech = new ArrayList<>();
            teacher Teacher;
            
            while (resultadoTeacher.next()) {
                Teacher = new teacher();
                Teacher.setCedula(resultadoTeacher.getString("cedula"));
                Teacher.setName(resultadoTeacher.getString("name"));
                Teacher.setAvatar(resultadoTeacher.getString("avatar"));
                listarTech.add(Teacher);
            }
            return listarTech;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //Metodo Actualizar
    public static boolean ActualizarTeacher(teacher tech){
        try {
            Connection conex = librConexion.conexionDB();
            String SQL = "UPDATE teacher SET " +
                         "  name=?," +
                         "  avatar=?" +
                         "  WHERE cedula=?";
            PreparedStatement st = conex.prepareStatement(SQL);
            
            st.setString(3, tech.getCedula());
            st.setString(1, tech.getName());
            st.setString(2, tech.getAvatar());
            
            
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
    public static boolean eliminarTeacher(teacher tech){
        try {
            Connection conex = librConexion.conexionDB();
            String SQl = "DELETE FROM teacher WHERE cedula=?";
            PreparedStatement st = conex.prepareStatement(SQl);
            st.setString(1, tech.getCedula());
            
            if(st.executeUpdate() > 0)
            {
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
}
    

    