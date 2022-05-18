/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class TeacherSubJectDAO {
    
    public void insertTeacher(int teacherid, int subjectid) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Teacher_Subject_HE151369 VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, teacherid);
            stmt.setInt(2, subjectid);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
