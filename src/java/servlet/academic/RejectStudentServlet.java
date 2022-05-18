package servlet.academic;

import dal.AcademicDAO;
import dal.SendMailDAO;
import dal.StudentDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TuanAnh
 */
public class RejectStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        
        AcademicDAO acdDao = new AcademicDAO();
        acdDao.deleteStudent(studentId);

        StudentDAO stdDao = new StudentDAO();
        stdDao.deleteStudent(studentId);
        
        String subject = "Notice of FPT University";
                String message = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "\n"
                + "<head>\n"
                + "<meta charset=\"utf-8\">\n"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "    <h3 style=\"color: blue;\">Notice</h3>\n"
                + "    <div>Full Name : "+firstName+lastName+"</div>\n"
                + "    <h3 style=\"color: blue;\">You have not been admitted to FPT University!</h3>\n"
                + "    <div>If you have any questions, please contact the hotline: <b>0912929232</b> to be answered by the school.</div>"
                + "</body>\n"
                + "\n"
                + "</html>";
                SendMailDAO.send("tuananh462001@gmail.com", subject, message, "anhnkthe151369@fpt.edu.vn", "123456789");
        response.sendRedirect("ShowListStudentRegisterServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
