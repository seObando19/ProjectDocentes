/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.teacherDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.teacher;

/**
 *
 * @author sebas
 */
public class TeacherControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TeacherControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeacherControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        //recibir los datos
        String cedula = request.getParameter("txtCedula");
        String name = request.getParameter("txtNombre");
        String avatar = request.getParameter("txtAvatar");
        
        //Tomar valode de la variable accion
        String accion = request.getParameter("accion");
        
        //Pasando datos al modelo
        teacher Teacher = new teacher();
        Teacher.setCedula(cedula);
        Teacher.setName(name);
        Teacher.setAvatar(avatar);
        
        //Validar accion a realizar
        switch(accion){
        case "registrar":
                if(teacherDao.InsertarTeacher(Teacher)){
                    request.setAttribute("mensaje", "Docente registrado");
                }else{
                    request.setAttribute("mensaje", "Docente no registrado");
                }
                break;
        case "actualizar":
                if(teacherDao.ActualizarTeacher(Teacher)){
                    request.setAttribute("mensaje", "Docente actualizar");
                }else{
                    request.setAttribute("mensaje", "Docente no actualizado");
                }
                break;
        case "eliminar":
                if(teacherDao.eliminarTeacher(Teacher)){
                    request.setAttribute("mensaje", "Docente eliminado");
                }else{
                    request.setAttribute("mensaje", "Docente no eliminado");
                }
                break;
        }
        request.getRequestDispatcher("registrarTeacher.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
