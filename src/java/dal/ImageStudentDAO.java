/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dataobj.Image_Student;
import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TuanAnh
 */
public class ImageStudentDAO {
    public Image_Student getImageById(int sid) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Image_Student_HE151369 WHERE studentId = '" + sid + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Image_Student img = new Image_Student(rs.getInt(1), rs.getString(2), rs.getInt(3));
                return img;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
