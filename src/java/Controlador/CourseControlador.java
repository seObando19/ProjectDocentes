/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.courseDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.course;

/**
 *
 * @author sebas
 */
public class CourseControlador extends HttpServlet {

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
            out.println("<title>Servlet CourseControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
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
        
                //Recibir datos
        int idTeacher = Integer.parseInt(request.getParameter("txtTeacher"));
        String name = request.getParameter("txtnomCurso");
        String themes = request.getParameter("txtTheme");
        String project = request.getParameter("txtProject");
        
        //Tomar valor de la variable accion
        String accion = request.getParameter("accion");
        
        //enviar los datos al modelo
        course Course = new course();
        Course.setIdTeacher(idTeacher);
        Course.setName(name);
        Course.setThemes(themes);
        Course.setProject(project);                
        
        //validar valor de la variable accion
        switch(accion){
        case "registrar":
                if(courseDao.InsertarCourse(Course)){
                    request.setAttribute("mensaje", "Curso registrado");
                }else{
                    request.setAttribute("mensaje", "Curso no registrado");
                }
                break;
        case "actualizar":
                if(courseDao.ActualizarCourse(Course)){
                    request.setAttribute("mensaje", "Curso actualizado");
                }else{
                    request.setAttribute("mensaje", "Curso no actualizado");
                }
                break;
        case "eliminar":
                if(courseDao.EliminarCourse(Course)){
                    request.setAttribute("mensaje", "Curos eliminado");
                }else{
                    request.setAttribute("mensaje", "Curso no eliminado");
                }
                break;
        }
        request.getRequestDispatcher("registrarCourse.jsp").forward(request, response);
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
