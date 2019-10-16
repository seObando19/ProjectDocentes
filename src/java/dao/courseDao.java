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
import modelo.course;

/**
 *
 * @author sebas
 */
public class courseDao {
    //Metodo Insertar
    public static boolean InsertarCourse(course cor){
        try {
            Connection conex = librConexion.conexionDB();
            String SQL = "INSERT INTO course (idTeacher,name,themes,project) VALUES (?,?,?,?)";
            PreparedStatement st = conex.prepareStatement(SQL);
            st.setInt(1, cor.getIdTeacher());
            st.setString(2, cor.getName());
            st.setString(3, cor.getThemes());
            st.setString(4, cor.getProject());            
            return st.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
    //Metodo Listar
    public static ArrayList<course> listarCourse(){
        try {
            String SQL = "SELECT *FROM course";
            Connection conex = librConexion.conexionDB();
            PreparedStatement st = conex.prepareStatement(SQL);
            ResultSet resultadoCourse = st.executeQuery();
            ArrayList<course> listarCourse = new ArrayList<>();
            course Course;
            
            while(resultadoCourse.next()){
                Course = new course();
                Course.setIdTeacher(resultadoCourse.getInt("idTeacher"));
                Course.setName(resultadoCourse.getString("name"));
                Course.setThemes(resultadoCourse.getString("themes"));
                Course.setProject(resultadoCourse.getString("project"));
                listarCourse.add(Course);
            }
            return listarCourse;
            
        } catch (SQLException ex) {
            return null;
        }
    }
    
    //Metodo Actualizar
    public static boolean ActualizarCourse(course cor){
        try {
            Connection conex = librConexion.conexionDB();
            String SQL = "UPDATE course SET " +
                         "  name=?," +
                         "  themes=?," +
                         "  project=?" +
                         "  WHERE idTeacher=?";
            PreparedStatement st = conex.prepareStatement(SQL);
            
            st.setString(1, cor.getName());
            st.setString(2, cor.getThemes());
            st.setString(3, cor.getProject());
            st.setInt(4, cor.getIdTeacher());
            
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
    public static boolean EliminarCourse(course cor){
        try {
            Connection conex = librConexion.conexionDB();
            String SQL = "DELETE FROM course WHERE idTeacher=?";
            PreparedStatement st = conex.prepareStatement(SQL);
            st.setInt(1, cor.getIdTeacher());
            
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
