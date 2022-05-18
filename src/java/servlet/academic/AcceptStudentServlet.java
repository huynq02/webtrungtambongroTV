package servlet.academic;

import dal.AcademicDAO;
import dal.SendMailDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TuanAnh
 */
public class AcceptStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String studentId = request.getParameter("studentId");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String DOB = request.getParameter("dob");
        String strGender = request.getParameter("gender");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String specialized = request.getParameter("specialized");
        HttpSession session = request.getSession();
        String rollNumber = session.getAttribute("campusName") + studentId;
        String membercode = request.getParameter("membercode");
        String mode = request.getParameter("mode");
        Date enrollDate = null;
        try {
            enrollDate = Date.valueOf(request.getParameter("enrolldate"));
            if (membercode == null || membercode.trim().isEmpty()
                    || mode == null || mode.trim().isEmpty()
                    || enrollDate == null) {
                
                request.setAttribute("error", "You must be input Member Code and Mode, Enroll Date");
                request.getRequestDispatcher("../academic/error.jsp").forward(request, response);

            } else {
                int gender = Integer.parseInt(strGender);
                int id = Integer.parseInt(studentId);

                StudentDAO stdDao = new StudentDAO();
                stdDao.acceptStudent(firstName, lastName, DOB, gender, address,
                        telephone, membercode + "@fpt.edu.vn", getSpecializedId(specialized), id);
                AcademicDAO acdDao = new AcademicDAO();
                acdDao.insertStudent(rollNumber, membercode, mode, enrollDate, id);
                String subject = "Notice of Completing Admission Application";
                String message = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "\n"
                + "<head>\n"
                + "<meta charset=\"utf-8\">\n"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "    <h3 style=\"color: blue;\">Notification</h3>\n"
                + "    <div>Full Name : "+firstName+lastName+"</div>\n"
                + "    <div>Phone : "+telephone+"</div>\n"
                + "    <div>address : "+address+"</div>\n"
                + "    <h3 style=\"color: blue;\">You have been accepted into FPT University!</h3>\n"
                + " <div>Invite you to the focus school and complete the admission application</div>\n"
                + " <div>For any questions, please contact the hotline: <b>0912929232</b>to be answered by the school.</div>"
                + "\n"
                + "</body>\n"
                + "\n"
                + "</html>";
                SendMailDAO.send("tuananh462001@gmail.com", subject, message, "anhnkthe151369@fpt.edu.vn", "123456789");
                
                response.sendRedirect("ShowListStudentRegisterServlet");
            }
        } catch (Exception ex) {
            request.setAttribute("error", "You must be input Member Code and Mode, Enroll Date");
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
