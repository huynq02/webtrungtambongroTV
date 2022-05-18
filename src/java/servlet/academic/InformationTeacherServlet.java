/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.academic;

import dal.ClassStudentDAO;
import dal.SubjectDAO;
import dal.TeacherDAO;
import dataobj.ClassStudent;
import dataobj.Subject;
import dataobj.Teacher;
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
public class InformationTeacherServlet extends HttpServlet {

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
            out.println("<title>Servlet InformationTeacherServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InformationTeacherServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        int teacherid= Integer.parseInt(request.getParameter("teacherId"));
        
        TeacherDAO teacher = new TeacherDAO();
        Teacher tea = teacher.getListTeacherById(teacherid);
        request.setAttribute("teacher", tea);
        
        ClassStudentDAO classStu = new ClassStudentDAO();
        ArrayList<ClassStudent> classstu = classStu.getAllClass();
        ArrayList<ClassStudent> cls = classStu.getAllClassByTeacher(teacherid);
        request.setAttribute("ListByTea", cls);
        request.setAttribute("ListClass", classstu);
        
        SubjectDAO subject = new SubjectDAO();
        ArrayList<Subject> subje = subject.getAllCampus();
        ArrayList<Subject> sub =  subject.getAllSubjectByTeacher(teacherid);
        request.setAttribute("ListSuject", subje);
        request.setAttribute("ListSubByTe", sub);
        
        request.getRequestDispatcher("inforteacher.jsp").forward(request, response);
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
