/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.academic;

import dal.AcademicDAO;
import dal.ParentDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class SaveStudentServlet extends HttpServlet {

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
            out.println("<title>Servlet SaveStudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveStudentServlet at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("utf-8");
        String studentId = request.getParameter("studentId");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String DOB = request.getParameter("dob");
        String strGender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
       
        String parentName = request.getParameter("parentname");
        String phone = request.getParameter("parentphone");
        String add = request.getParameter("paddress");
        String mail = request.getParameter("parentmail");
        String job= request.getParameter("parentjob");
        String pow = request.getParameter("pow");
        
        System.out.println(parentName);
        System.out.println(phone);
        System.out.println(add);
        System.out.println(mail);
        System.out.println(job);
        System.out.println(pow);
        try {
            int gender = Integer.parseInt(strGender);
            int id = Integer.parseInt(studentId);
            int IdCard = Integer.parseInt(idCard);
            int pphone = Integer.parseInt(phone);
            StudentDAO stdDao = new StudentDAO();
            stdDao.updateStudent(id, firstName, lastName, DOB, gender, IdCard, address, telephone, email);
            System.out.println(stdDao.getStudentById(id));
            
            ParentDAO prDao = new ParentDAO();
            prDao.updateParent(id, parentName, pphone, add, mail, job, pow);
            //System.out.println(prDao.getParentByID(id));
            
            response.sendRedirect("ShowListStudentFPTServlet");
        } catch (Exception ex) {
            request.setAttribute("error", "You must be input All field");
            request.getRequestDispatcher("../public/error.jsp").forward(request, response);
        }
    }
    
    private int getSpecializedId(String specialized) {
        if (specialized.equalsIgnoreCase("se")) {
            return 1;
        } else if (specialized.equalsIgnoreCase("ia")) {
            return 2;
        } else {
            return 3;
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
