package dal;

import dataobj.Student;
import db.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import query.Query;

/**
 *
 * @author TuanAnh
 */
public class StudentDAO {

    public void insertStudent(String firstName, String lastName, String DOB,
            int gender, String address, String telephone, String email,
            int specializedId, int campusId) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = Query.INSERT_STUDENT;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, DOB);
            stmt.setInt(4, gender);
            stmt.setString(5, address);
            stmt.setString(6, telephone);
            stmt.setString(7, email);
            stmt.setInt(8, specializedId);
            stmt.setInt(9, campusId);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Student> getListStudentRegister() {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = Query.SELECT_LIST_STUDENT_REGISTER;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Date DOB = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                int cardNo = rs.getInt(6);
                Date cardDate = rs.getDate(7);
                String cardPlace = rs.getString(8);
                String address = rs.getString(9);
                int telephone = rs.getInt(10);
                String email = rs.getString(11);
                int specializedId = rs.getInt(12);
                int campusId = rs.getInt(13);

                Student std = new Student(id, firstName, lastName, DOB, gender,
                        cardNo, cardDate, cardPlace, address, telephone, email,
                        specializedId, campusId, 0);
                listStudent.add(std);
            }
            rs.close();
            stmt.close();
            con.close();
            return listStudent;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Student> getListStudentFPT() {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = Query.SELECT_LIST_STUDENT_ACCEPT;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Date DOB = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                int cardNo = rs.getInt(6);
                Date cardDate = rs.getDate(7);
                String cardPlace = rs.getString(8);
                String address = rs.getString(9);
                int telephone = rs.getInt(10);
                String email = rs.getString(11);
                int specializedId = rs.getInt(12);
                int campusId = rs.getInt(13);

                Student std = new Student(id, firstName, lastName, DOB, gender,
                        cardNo, cardDate, cardPlace, address, telephone, email,
                        specializedId, campusId, 0);
                listStudent.add(std);
            }
            rs.close();
            stmt.close();
            con.close();
            return listStudent;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Student getStudentById(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT firstName, lastName, DOB, gender, cardNo, "
                    + "cardDate, cardPlace, address, telephone, email, "
                    + "specializedId, campusId FROM "
                    + "Student_HE151369 WHERE id = '" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                Date DOB = rs.getDate(3);
                boolean gender = rs.getBoolean(4);
                int cardNo = rs.getInt(5);
                Date cardDate = rs.getDate(6);
                String cardPlace = rs.getString(7);
                String address = rs.getString(8);
                int telephone = rs.getInt(9);
                String email = rs.getString(10);
                int specializedId = rs.getInt(11);
                int campusId = rs.getInt(12);

                Student std = new Student(id, firstName, lastName, DOB, gender,
                        cardNo, cardDate, cardPlace, address, telephone, email,
                        specializedId, campusId, 0);
                listStudent.add(std);
                return std;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String getNameFPT(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT lastname, dbo.getNameFPT(firstName) FROM Student_HE151369 WHERE id = " + id + "";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String preName = rs.getString(1);
                //convert utf8 to ASCII
                String convert = java.text.Normalizer.normalize(preName, java.text.Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                String postName = rs.getString(2);
                return convert + postName;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void acceptStudent(String firstName, String lastName, String DOB,
            int gender, String address, String telephone, String email,
            int specializedId, int studentId) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = Query.UPDATE_STUDENT;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, DOB);
            stmt.setInt(4, gender);
            stmt.setString(5, address);
            stmt.setString(6, telephone);
            stmt.setString(7, email);
            stmt.setInt(8, specializedId);
            stmt.setInt(9, studentId);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateStudent(int studentId, String firstName, String lastName, String DOB,
            int gender, int idCard, String address, String telephone, String email) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql= "UPDATE Student_HE151369 SET firstName = ?, lastName = ?, DOB = ?, gender = ?, cardNo=?, address = ?, telephone = ?, email = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, DOB);
            stmt.setInt(4, gender);
            stmt.setInt(5, idCard);
            stmt.setString(6, address);
            stmt.setString(7, telephone);
            stmt.setString(8, email);
            stmt.setInt(9, studentId);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteStudent(String id) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = Query.DELETE_STUDENT;
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return;
    }

    public ArrayList<Student> getListStudentFPTBySpec(int pid) {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql ="select s.id, s.firstName, s.lastName, s.DOB, s.gender, s.cardNo, s.cardDate, s.cardPlace, s.address, s.telephone, s.email, s.specializedId, s.campusId from student_HE151369 s left outer join academic_student_HE151369 sa on s.id = sa.studentid where sa.studentId is not null and s.specializedId='"+pid+"'";
            //PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setInt(1, pid);
            //String sql = Query.SELECT_LIST_STUDENT_ACCEPT;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Date DOB = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                int cardNo = rs.getInt(6);
                Date cardDate = rs.getDate(7);
                String cardPlace = rs.getString(8);
                String address = rs.getString(9);
                int telephone = rs.getInt(10);
                String email = rs.getString(11);
                int specializedId = rs.getInt(12);
                int campusId = rs.getInt(13);

                Student std = new Student(id, firstName, lastName, DOB, gender,
                        cardNo, cardDate, cardPlace, address, telephone, email,
                        specializedId, campusId, 0);
                listStudent.add(std);
            }
            rs.close();
            stmt.close();
            con.close();
            return listStudent;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Student> getStudentByNameandSpec(int spec, String name) {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql ="select s.id, s.firstName, s.lastName, s.DOB, s.gender, s.cardNo, s.cardDate, s.cardPlace, s.address, s.telephone, s.email, s.specializedId, s.campusId from student_HE151369 s left outer join academic_student_HE151369 sa on s.id = sa.studentid where sa.studentId is not null and s.specializedId='"+spec+"' and (s.firstName like '%"+name+"%' or s.lastName like '%"+name+"%')";
            //PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setInt(1, pid);
            //String sql = Query.SELECT_LIST_STUDENT_ACCEPT;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Date DOB = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                int cardNo = rs.getInt(6);
                Date cardDate = rs.getDate(7);
                String cardPlace = rs.getString(8);
                String address = rs.getString(9);
                int telephone = rs.getInt(10);
                String email = rs.getString(11);
                int specializedId = rs.getInt(12);
                int campusId = rs.getInt(13);

                Student std = new Student(id, firstName, lastName, DOB, gender,
                        cardNo, cardDate, cardPlace, address, telephone, email,
                        specializedId, campusId, 0);
                listStudent.add(std);
            }
            rs.close();
            stmt.close();
            con.close();
            return listStudent;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Student> getStudentByName(String name) {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql ="select s.id, s.firstName, s.lastName, s.DOB, s.gender, s.cardNo, s.cardDate, s.cardPlace, s.address, s.telephone, s.email, s.specializedId, s.campusId from student_HE151369 s left outer join academic_student_HE151369 sa on s.id = sa.studentid where sa.studentId is not null and (s.firstName like '%"+name+"%' or s.lastName like '%"+name+"%')";
            //PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setInt(1, pid);
            //String sql = Query.SELECT_LIST_STUDENT_ACCEPT;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Date DOB = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                int cardNo = rs.getInt(6);
                Date cardDate = rs.getDate(7);
                String cardPlace = rs.getString(8);
                String address = rs.getString(9);
                int telephone = rs.getInt(10);
                String email = rs.getString(11);
                int specializedId = rs.getInt(12);
                int campusId = rs.getInt(13);

                Student std = new Student(id, firstName, lastName, DOB, gender,
                        cardNo, cardDate, cardPlace, address, telephone, email,
                        specializedId, campusId, 0);
                listStudent.add(std);
            }
            rs.close();
            stmt.close();
            con.close();
            return listStudent;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Student> getStudentByNameandCampAndSpec(String name, int Camp, int spec) {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql ="select s.id, s.firstName, s.lastName, s.DOB, s.gender, s.cardNo, s.cardDate, s.cardPlace, s.address, s.telephone, s.email, s.specializedId, s.campusId from student_HE151369 s left outer join academic_student_HE151369 sa on s.id = sa.studentid where sa.studentId is not null and (s.firstName like '%"+name+"%' or s.lastName like '%"+name+"%') and s.campusId="+Camp+" and s.specializedId="+spec+"";
            //PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setInt(1, pid);
            //String sql = Query.SELECT_LIST_STUDENT_ACCEPT;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Date DOB = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                int cardNo = rs.getInt(6);
                Date cardDate = rs.getDate(7);
                String cardPlace = rs.getString(8);
                String address = rs.getString(9);
                int telephone = rs.getInt(10);
                String email = rs.getString(11);
                int specializedId = rs.getInt(12);
                int campusId = rs.getInt(13);

                Student std = new Student(id, firstName, lastName, DOB, gender,
                        cardNo, cardDate, cardPlace, address, telephone, email,
                        specializedId, campusId, 0);
                listStudent.add(std);
            }
            rs.close();
            stmt.close();
            con.close();
            return listStudent;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Student> getStudentByNameandCamp(String name, int Camp) {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql ="select s.id, s.firstName, s.lastName, s.DOB, s.gender, s.cardNo, s.cardDate, s.cardPlace, s.address, s.telephone, s.email, s.specializedId, s.campusId from student_HE151369 s left outer join academic_student_HE151369 sa on s.id = sa.studentid where sa.studentId is not null and (s.firstName like '%"+name+"%' or s.lastName like '%"+name+"%') and s.campusId="+Camp+"";
            //PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setInt(1, pid);
            //String sql = Query.SELECT_LIST_STUDENT_ACCEPT;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Date DOB = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                int cardNo = rs.getInt(6);
                Date cardDate = rs.getDate(7);
                String cardPlace = rs.getString(8);
                String address = rs.getString(9);
                int telephone = rs.getInt(10);
                String email = rs.getString(11);
                int specializedId = rs.getInt(12);
                int campusId = rs.getInt(13);

                Student std = new Student(id, firstName, lastName, DOB, gender,
                        cardNo, cardDate, cardPlace, address, telephone, email,
                        specializedId, campusId, 0);
                listStudent.add(std);
            }
            rs.close();
            stmt.close();
            con.close();
            return listStudent;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Student getStudentByIdClass(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT firstName, lastName, DOB, gender, cardNo, "
                    + "cardDate, cardPlace, address, telephone, email, "
                    + "specializedId, campusId, classId FROM "
                    + "Student_HE151369 WHERE id = '" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                Date DOB = rs.getDate(3);
                boolean gender = rs.getBoolean(4);
                int cardNo = rs.getInt(5);
                Date cardDate = rs.getDate(6);
                String cardPlace = rs.getString(7);
                String address = rs.getString(8);
                int telephone = rs.getInt(9);
                String email = rs.getString(10);
                int specializedId = rs.getInt(11);
                int campusId = rs.getInt(12);
                int classId = rs.getInt(13);
                
                Student std = new Student(id, firstName, lastName, DOB, gender,
                        cardNo, cardDate, cardPlace, address, telephone, email,
                        specializedId, campusId, classId);
                listStudent.add(std);
                return std;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Student> getStudentByNameByClass(int classId) {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql ="select * from Student_HE151369 where classId="+classId+"";
            //PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setInt(1, pid);
            //String sql = Query.SELECT_LIST_STUDENT_ACCEPT;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Date DOB = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                int cardNo = rs.getInt(6);
                Date cardDate = rs.getDate(7);
                String cardPlace = rs.getString(8);
                String address = rs.getString(9);
                int telephone = rs.getInt(10);
                String email = rs.getString(11);
                int specializedId = rs.getInt(12);
                int campusId = rs.getInt(13);
                int clId = rs.getInt(14);

                Student std = new Student(id, firstName, lastName, DOB, gender,
                        cardNo, cardDate, cardPlace, address, telephone, email,
                        specializedId, campusId, clId);
                listStudent.add(std);
            }
            rs.close();
            stmt.close();
            con.close();
            return listStudent;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void updateStudentClass(int sid, int classId) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql= "UPDATE Student_HE151369 SET classId=? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, classId);
            stmt.setInt(2, sid);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Student> getStudentByNameNoClass() {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql ="select s.id, s.firstName, s.lastName, s.DOB, s.gender, s.cardNo, s.cardDate, s.cardPlace, s.address, s.telephone, s.email, s.specializedId, s.campusId, s.classId from student_HE151369 s left outer join academic_student_HE151369 sa on s.id = sa.studentid where sa.studentId is not null and s.classId is null";
            //stmt.setInt(1, pid);
            //String sql = Query.SELECT_LIST_STUDENT_ACCEPT;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                Date DOB = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                int cardNo = rs.getInt(6);
                Date cardDate = rs.getDate(7);
                String cardPlace = rs.getString(8);
                String address = rs.getString(9);
                int telephone = rs.getInt(10);
                String email = rs.getString(11);
                int specializedId = rs.getInt(12);
                int campusId = rs.getInt(13);
                int clId = rs.getInt(14);

                Student std = new Student(id, firstName, lastName, DOB, gender,
                        cardNo, cardDate, cardPlace, address, telephone, email,
                        specializedId, campusId, clId);
                listStudent.add(std);
            }
            rs.close();
            stmt.close();
            con.close();
            return listStudent;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
 
}
