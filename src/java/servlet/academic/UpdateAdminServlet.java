/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.academic;

import dal.AcademicLogin;
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
public class UpdateAdminServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateAdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateAdminServlet at " + request.getContextPath() + "</h1>");
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
        AcademicLogin ac = new AcademicLogin();
        String ID = (String) request.getSession().getAttribute("newid");
        if (ID ==null) {
            ID = "-1";
        }
        System.out.println(ID);
        String Id = request.getParameter("id");
        int id=-1;
        if (Id!=null) {
            id = Integer.parseInt(Id);
            request.getSession().setAttribute("newid", id);
        } else {
            int nId = Integer.parseInt(ID);
            id  = nId;
        }
        request.setAttribute("academic", ac.getAccountByUserId(id));
        String textCapcha = generateCaptchaText();
        request.setAttribute("Capcha", textCapcha);
        request.getRequestDispatcher("UpdateInfoAdmin.jsp").forward(request, response);
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
        AcademicLogin ac = new AcademicLogin();
        String id = request.getParameter("id");
        String user = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String pass1 = request.getParameter("pass1");
        String cap = request.getParameter("cap");
        String capcha = request.getParameter("capcha");
        try {
            if (!pass1.equals(pass)) {
                //int ID = Integer.parseInt(id);
                request.getSession().setAttribute("newid", id);
                request.setAttribute("error", "Wrong pass");
                response.sendRedirect("UpdateAdminServlet");
                return;
            } else {
                if (cap.equals(capcha)) {
                    int ID = Integer.parseInt(id);
                    request.getSession().setAttribute("newid", id);
                    ac.updateAdmin(ID, user, pass1, email);
                    response.sendRedirect("InforAdminServlet");
                    return;
                } else {
                    request.getSession().setAttribute("newid", id);
                    request.setAttribute("error", "Wrong capcha");
                    response.sendRedirect("UpdateAdminServlet");
                }
            }
        } catch (Exception ex) {
            request.getSession().setAttribute("newid", id);
            request.setAttribute("error", "You must be input All field");
            request.getRequestDispatcher("../public/error.jsp").forward(request, response);
        }
    }

    static final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};

    static String generateCaptchaText() {
        String randomStrValue = "";
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
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
