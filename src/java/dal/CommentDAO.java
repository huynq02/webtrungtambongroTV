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
public class CommentDAO {
    
    public ArrayList<Comment> getAllComment() {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            ArrayList<Comment> comment= new ArrayList<>();
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Comment_HE151369";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Comment com = new Comment(rs.getInt(1), rs.getString(2), rs.getString(3));
                comment.add(com);
            }
            rs.close();
            stmt.close();
            con.close();
            return comment;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        CommentDAO c = new CommentDAO();
        System.out.println(c.getAllComment());
    }
}
