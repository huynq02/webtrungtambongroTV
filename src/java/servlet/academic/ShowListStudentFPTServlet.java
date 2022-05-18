package servlet.academic;

import dal.CampusDAO;
import dal.SpecializedDAO;
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
public class ShowListStudentFPTServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO stdDao = new StudentDAO();
        ArrayList<Student> listStudentFPT = new ArrayList<>();
        int speci=-1;
        String spec = request.getParameter("Spec");
        if (spec!=null) {
            speci = Integer.parseInt(spec);
        }
  
        //List Student FPT
//        if (speci==-1) {
//            listStudentFPT= stdDao.getListStudentFPT();
//        } else {
//            listStudentFPT= stdDao.getListStudentFPTBySpec(speci);
//        }
        
        //List Specialized 
        SpecializedDAO special = new SpecializedDAO();
        int speCode = -1;
        String seName="";
        String code = request.getParameter("chuyen");
        String Name = request.getParameter("seName");
        if (Name!=null) {
            seName=Name;
        }
        
        if (code!=null) {
            speCode=Integer.parseInt(code);
        }
        
        int camP=7;
        String campN = request.getParameter("campN");
        if (campN !=null) {
            camP=Integer.parseInt(campN);
        }
        
        if (speCode==-1 && seName.equals("") && camP==7) {
            if (speci==-1) {
                listStudentFPT= stdDao.getListStudentFPT();
            } else {
                listStudentFPT= stdDao.getListStudentFPTBySpec(speci);
            } 
        } else {
            if (speCode==-1 && camP==7) {
                listStudentFPT = stdDao.getStudentByName(seName);
                if(listStudentFPT.isEmpty()) {
                    request.setAttribute("Key", "No Result");
                    request.getRequestDispatcher("listFPT.jsp").forward(request, response);
                    //return;
                }
            } else if (camP==7) {
                listStudentFPT= stdDao.getStudentByNameandSpec(speCode, seName);
                if(listStudentFPT.isEmpty()) {
                    request.setAttribute("Key", "No Result");
                    request.setAttribute("seName", seName);
                    request.getRequestDispatcher("listFPT.jsp").forward(request, response);
                    //return;
                }
            } else if (speCode==-1) {
                listStudentFPT = stdDao.getStudentByNameandCamp(seName, camP);
                if(listStudentFPT.isEmpty()) {
                    request.setAttribute("Key", "No Result");
                    request.setAttribute("seName", seName);
                    request.getRequestDispatcher("listFPT.jsp").forward(request, response);
                    //return;
                }
            } else {
                listStudentFPT = stdDao.getStudentByNameandCampAndSpec(seName, camP, speCode);
                if(listStudentFPT.isEmpty()) {
                    request.setAttribute("Key", "No Result");
                    request.setAttribute("seName", seName);
                    request.getRequestDispatcher("listFPT.jsp").forward(request, response);
                    //return;
                }
            }
        }
        
        //Phân trang
        int page=1;
        String pageStr = request.getParameter("page");
        if (pageStr!=null) {
            page=Integer.parseInt(pageStr);
        }
        int page_Size=5;
        int totolPage=listStudentFPT.size()/ page_Size + (listStudentFPT.size()%page_Size==0?0:1);
        if (page > totolPage) {
            page = 1;
        }
        int pageStart = page * page_Size - page_Size;
        int pageEnd = page * page_Size - 1;
        if (pageEnd > listStudentFPT.size() - 1) {
            pageEnd = listStudentFPT.size() - 1;
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
        request.setAttribute("spec", speci);
        request.setAttribute("listFPT", listStudentFPT);
        CampusDAO ca = new CampusDAO();
        request.setAttribute("Camp", ca.getAllCampus());
        request.setAttribute("camP", camP);
        request.setAttribute("seName", seName);
        
        request.setAttribute("code", code);
        request.setAttribute("special", special.getSpecialized());
        request.getRequestDispatcher("listFPT.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
