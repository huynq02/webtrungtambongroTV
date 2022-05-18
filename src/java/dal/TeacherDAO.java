/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dataobj.Teacher;
import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import query.Query;

/**
 *
 * @author Admin
 */
public class TeacherDAO {
    
    public ArrayList<Teacher> getListTeacher() {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Teacher> listTeacher = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "select * from Teacher_HE151369";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt(1), rs.getString(2), rs.getBoolean(3), 
                        rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7));
                listTeacher.add(teacher);
            }
            rs.close();
            stmt.close();
            con.close();
            return listTeacher;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Teacher getListTeacherById(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        ArrayList<Teacher> listTeacher = new ArrayList<>();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "select * from Teacher_HE151369 where id="+id+"";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Teacher teacher = new Teacher(rs.getInt(1), rs.getString(2), rs.getBoolean(3), 
                        rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7));
                //listTeacher.add(teacher);
                return teacher;
            }
            rs.close();
            stmt.close();
            con.close();
            //return listTeacher;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void UpdateTeacher(int id, String name, boolean gender, int cardNo, int phone, String addr, String email) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "UPDATE Teacher_HE151369 SET name=?, gender=?, cardNo=?, phoneNumber=?, address=?, email=? where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setBoolean(2, gender);
            stmt.setInt(3, cardNo);
            stmt.setInt(4, phone);
            stmt.setString(5, addr);
            stmt.setString(6, email);
            stmt.setInt(7, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
