/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.academic;

import dal.TeacherDAO;
import dataobj.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class InforTeacherServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InforAdminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InforAdminServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        TeacherDAO teacher = new TeacherDAO();
        ArrayList<Teacher> listTeacher = new ArrayList<>();
        //request.setAttribute("listTeacher", teacher.getListTeacher());
        listTeacher = teacher.getListTeacher();
        
        //Phân trang
        int page=1;
        String pageStr = request.getParameter("page");
        if (pageStr!=null) {
            page=Integer.parseInt(pageStr);
        }
        int page_Size=5;
        int totolPage=listTeacher.size()/ page_Size + (listTeacher.size()%page_Size==0?0:1);
        if (page > totolPage) {
            page = 1;
        }
        int pageStart = page * page_Size - page_Size;
        int pageEnd = page * page_Size - 1;
        if (pageEnd > listTeacher.size() - 1) {
            pageEnd = listTeacher.size() - 1;
        }
        
        int btnStart = page - 2;
        if (btnStart <= 0) {
            btnStart = 1;
        }
        int btnEnd = page + 2;
        if (btnEnd > totolPage) {
            btnEnd = totolPage;
        }
        boolean next = true;
        boolean prev = true;
        if (page == 1) {
            prev = false;
        }
        if (page == totolPage) {
            next = false;
        }
        request.setAttribute("pageStart", pageStart);
        request.setAttribute("pageEnd", pageEnd);
        request.setAttribute("btnStart", btnStart);
        request.setAttribute("btnEnd", btnEnd);
        request.setAttribute("next", next);
        request.setAttribute("prev", prev);
        request.setAttribute("p", page);
        //request.setAttribute("spec", speci);
        request.setAttribute("listTeacher", listTeacher);
        request.getRequestDispatcher("listTeacher.jsp").forward(request, response);
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
        processRequest(request, response);
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
