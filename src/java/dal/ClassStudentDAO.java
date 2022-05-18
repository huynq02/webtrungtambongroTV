/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dataobj.*;
import db.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ClassStudentDAO {
    public ArrayList<ClassStudent> getAllClass() {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            ArrayList<ClassStudent> cls = new ArrayList<>();
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM ClassStudent_HE151369 ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ClassStudent stu = new ClassStudent(rs.getInt(1), rs.getString(2), rs.getString(3));
                cls.add(stu);
            }
            rs.close();
            stmt.close();
            con.close();
            return cls;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<ClassStudent> getAllClassBySpec(int spec) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            ArrayList<ClassStudent> cls = new ArrayList<>();
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "select DISTINCT cs.* from Student_HE151369 as a join ClassStudent_HE151369 as cs on a.classId=cs.id where a.specializedId="+spec+"";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ClassStudent stu = new ClassStudent(rs.getInt(1), rs.getString(2), rs.getString(3));
                cls.add(stu);
            }
            rs.close();
            stmt.close();
            con.close();
            return cls;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<ClassStudent> getAllClassByTeacher(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            ArrayList<ClassStudent> cls = new ArrayList<>();
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT CS.* FROM ClassStudent_HE151369 as CS join Teacher_Class_HE151369 as TC ON TC.classId=CS.Id where TC.teacherId="+id+"";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ClassStudent stu = new ClassStudent(rs.getInt(1), rs.getString(2), rs.getString(3));
                cls.add(stu);
            }
            rs.close();
            stmt.close();
            con.close();
            return cls;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
