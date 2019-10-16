/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.socialMediaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.social_media;

/**
 *
 * @author sebas
 */
public class SocialMediaControlador extends HttpServlet {

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
            out.println("<title>Servlet SocialMediaControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SocialMediaControlador at " + request.getContextPath() + "</h1>");
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
        
        //enviar los datos
        //int idSocialMedia = Integer.parseInt(request.getParameter(""));
        String name = request.getParameter("txtNomsocial");
        String icon = request.getParameter("txtIcon");
        String accion = request.getParameter("accion");
        
        //enviando datos al modelo
        social_media socialMedia = new social_media();
        socialMedia.setName(name);
        socialMedia.setIcon(icon);
        
        //Validar accion a realizar
        switch(accion){
        case "registrar":
                if(socialMediaDao.InsertarSocialM(socialMedia)){
                    request.setAttribute("mensaje", "Social Media registrado");
                }else{
                    request.setAttribute("mensaje", "Social Media no registrado");
                }
                break;
        case "actualizar":
                if(socialMediaDao.ActualizarSocialM(socialMedia)){
                    request.setAttribute("mensaje", "Social Media actualizar");
                }else{
                    request.setAttribute("mensaje", "Social Media no actualizado");
                }
                break;
        case "eliminar":
                if(socialMediaDao.EliminarScoailM(socialMedia)){
                    request.setAttribute("mensaje", "Social Media eliminado");
                }else{
                    request.setAttribute("mensaje", "Social Media no eliminado");
                }
                break;
        }
        request.getRequestDispatcher("registrarSocialMedia.jsp").forward(request, response);
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
