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
public class SubjectDAO {
    
    public ArrayList<Subject> getAllCampus() {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            ArrayList<Subject> sub = new ArrayList<>();
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Subject_HE151369";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Subject subj = new Subject(rs.getInt(1), rs.getString(2), rs.getString(3));
                sub.add(subj);
            }
            rs.close();
            stmt.close();
            con.close();
            return sub;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Subject getAllSubjectById(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            ArrayList<Subject> sub = new ArrayList<>();
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Subject_HE151369 where id="+id+"";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Subject subj = new Subject(rs.getInt(1), rs.getString(2), rs.getString(3));
               return subj;
            }
            rs.close();
            stmt.close();
            con.close();
            //return sub;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Subject> getAllSubjectByTeacher(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            ArrayList<Subject> sub = new ArrayList<>();
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM [Subject_HE151369] as S join Teacher_Subject_HE151369 as TS on S.id = TS.subjectId where TS.teacherId="+id+"";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Subject subj = new Subject(rs.getInt(1), rs.getString(2), rs.getString(3));
                sub.add(subj);
            }
            rs.close();
            stmt.close();
            con.close();
            return sub;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
