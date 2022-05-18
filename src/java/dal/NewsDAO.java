/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dataobj.*;
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
public class NewsDAO {
    
    public ArrayList<News> getAllNews() {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            ArrayList<News> news = new ArrayList<>();
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM News_HE151369";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                News n = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                news.add(n);
            }
            rs.close();
            stmt.close();
            con.close();
            return news;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public News getShortNews(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM News_HE151369 WHERE id = "+id+"";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                News n = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                return n;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void insertNews(String title, String content, String des, String date, String images) {
        Connection con = null;
        DBContext db = new DBContext();
        int id=10;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO News_HE151369 VALUES(?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setInt(1, id);
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setString(3, des);
            stmt.setString(4, date);
            stmt.setString(5, images);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateNews(int id, String title, String content, String des, String date, String images) {
        Connection con = null;
        DBContext db = new DBContext();
        //int id=10;
        try {
            con = db.getConnection();
            String sql = "UPDATE News_HE151369 SET title = ?, [content]=?, discreption=?, createddate=?, images=? where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setInt(1, id);
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setString(3, des);
            stmt.setString(4, date);
            stmt.setString(5, images);
            stmt.setInt(6, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteNews(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "Delete FROM News_HE151369 WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
