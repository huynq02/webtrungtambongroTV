package servlet.academic;

import dal.StudentDAO;
import dataobj.Student;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TuanAnh
 */
public class ShowListStudentRegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO stdDao = new StudentDAO();
        ArrayList<Student> listStudentRegister = new ArrayList<>();
        listStudentRegister = stdDao.getListStudentRegister();
        if (listStudentRegister.isEmpty()) {
            request.setAttribute("A", "1");
            request.getRequestDispatcher("listregister.jsp").forward(request, response);
            return;
        }
        
        int page=1;
        String pageStr = request.getParameter("page");
        if (pageStr!=null) {
            page=Integer.parseInt(pageStr);
        }
        int page_Size=5;
        int totolPage=listStudentRegister.size()/ page_Size + (listStudentRegister.size()%page_Size==0?0:1);
        if (page > totolPage) {
            page = 1;
        }
        int pageStart = page * page_Size - page_Size;
        int pageEnd = page * page_Size - 1;
        if (pageEnd > listStudentRegister.size() - 1) {
            pageEnd = listStudentRegister.size() - 1;
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
        request.setAttribute("A", "0");
        request.setAttribute("listRegister", listStudentRegister);
        request.getRequestDispatcher("listregister.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
