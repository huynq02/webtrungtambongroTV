/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.academic;

import dal.ClassStudentDAO;
import dal.StudentDAO;
import dataobj.ClassStudent;
import dataobj.Student;
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
public class MoveOutClassServlet extends HttpServlet {

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
            out.println("<title>Servlet MoveOutClassServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MoveOutClassServlet at " + request.getContextPath() + "</h1>");
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
        StudentDAO stu = new StudentDAO();
        ArrayList<Student> st = stu.getStudentByNameNoClass();
        if (st.isEmpty()) {
            request.setAttribute("A", "No Result");
            request.getRequestDispatcher("MoveOutClass.jsp").forward(request, response);
            return;
        }
        ClassStudentDAO cl = new ClassStudentDAO();
        request.setAttribute("LstClass", cl.getAllClass());
        request.setAttribute("ListStu", stu.getStudentByNameNoClass());
        request.getRequestDispatcher("MoveOutClass.jsp").forward(request, response);
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
        String id = request.getParameter("studentId");
        String cl = request.getParameter("cl");
        
        try {
            int Id = Integer.parseInt(id);
            int Cl = Integer.parseInt(cl);
            StudentDAO stu = new StudentDAO();
            stu.updateStudentClass(Id, Cl);
            response.sendRedirect("ClassTimeTableServlet");
        } catch (Exception e) {
        }
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
