/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package News;

import dal.NewsDAO;
import dataobj.News;
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
public class DeleteNewsServlet extends HttpServlet {

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
            out.println("<title>Servlet DeleteNewsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteNewsServlet at " + request.getContextPath() + "</h1>");
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
        NewsDAO news = new NewsDAO();
        ArrayList<News> ne = new ArrayList<>();
        ne = news.getAllNews();
        //Ph??n trang
        int page=1;
        String pageStr = request.getParameter("page");
        if (pageStr!=null) {
            page=Integer.parseInt(pageStr);
        }
        int page_Size=5;
        int totolPage=ne.size()/ page_Size + (ne.size()%page_Size==0?0:1);
        if (page > totolPage) {
            page = 1;
        }
        int pageStart = page * page_Size - page_Size;
        int pageEnd = page * page_Size - 1;
        if (pageEnd > ne.size() - 1) {
            pageEnd = ne.size() - 1;
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
        request.setAttribute("ListNews", news.getAllNews());
        request.getRequestDispatcher("DeleteNews.jsp").forward(request, response);
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
        NewsDAO news = new NewsDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        news.deleteNews(id);
        response.sendRedirect("DeleteNewsServlet");
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
