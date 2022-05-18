/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.academic;

import dal.TeacherClassDAO;
import dal.TeacherDAO;
import dal.TeacherSubJectDAO;
import dataobj.TeacherClass;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class SaveTeacherServlet extends HttpServlet {

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
            out.println("<title>Servlet SaveTeacherServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveTeacherServlet at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("teacherId");
        String name = request.getParameter("name");
        String gen = request.getParameter("gender");
        String cardNo = request.getParameter("idCard");
        String email = request.getParameter("email");
        String phone = request.getParameter("telephone");
        String address= request.getParameter("address");
        String [] classid = request.getParameterValues("class");
        String [] subid = request.getParameterValues("sub");
        
        try {
            int ID = Integer.parseInt(id);
            int Phone = Integer.parseInt(phone);
            int cardid= Integer.parseInt(cardNo);
            boolean gender = gen.equals("1");
            TeacherDAO teacher = new TeacherDAO();
            teacher.UpdateTeacher(ID, name, gender, cardid, Phone, address, email);
            TeacherSubJectDAO tesub = new TeacherSubJectDAO();
            for (int i = 0; i < subid.length; i++) {
                int sid = Integer.parseInt(subid[i]);
                tesub.insertTeacher(ID, sid);
            }
            TeacherClassDAO teclas = new TeacherClassDAO();
            for (int i = 0; i < classid.length; i++) {
                int cid = Integer.parseInt(classid[i]);
                teclas.insertTeacher(ID, cid);
            }
            response.sendRedirect("InforTeacherServlet");
        } catch (Exception e) {
            request.setAttribute("error", "You must be input All field");
            request.getRequestDispatcher("../public/error.jsp").forward(request, response);
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
