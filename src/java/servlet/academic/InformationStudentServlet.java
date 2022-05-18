package servlet.academic;

import dal.AcademicStudentDAO;
import dal.CampusDAO;
import dal.ImageStudentDAO;
import dal.ParentDAO;
import dal.StudentDAO;
import dataobj.AcademicStudent;
import dataobj.Image_Student;
import dataobj.Parent;
import dataobj.Student;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TuanAnh
 */
public class InformationStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));

        StudentDAO stdDao = new StudentDAO();
        Student student = stdDao.getStudentById(studentId);
        
        ParentDAO parent = new ParentDAO();
        Parent pa = parent.getParentByID(studentId);

        AcademicStudentDAO acdsDAO = new AcademicStudentDAO();
        AcademicStudent acds = acdsDAO.getAcademicStudent(studentId);

        request.setAttribute("student", student);
        request.setAttribute("parent", pa);
        request.setAttribute("acaStudent", acds);

        CampusDAO cpDao = new CampusDAO();
        String campusName = cpDao.getShortNameCampus(student.getCampusId());
        HttpSession session = request.getSession();
        session.setAttribute("campusName", campusName);
        
        ImageStudentDAO img = new ImageStudentDAO();
        Image_Student im = img.getImageById(studentId);
        session.setAttribute("image", im);

        request.getRequestDispatcher("infostudent.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
