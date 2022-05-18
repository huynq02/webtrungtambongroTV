/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dataobj.Academic;
import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class AcademicLogin {
    
    public Academic getAccountByUserName(String name) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "select * from Academic_HE151369 where username='"+name+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Academic ac= new Academic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return ac;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Academic getAccountByUserId(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "select * from Academic_HE151369 where id='"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Academic ac= new Academic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return ac;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Academic getAccountByNameandPass(String name, String pass) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "select * from Academic_HE151369 where username='"+name+"' and password='"+pass+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Academic ac= new Academic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return ac;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Academic getAccountByUserEmail(String email) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "select * from Academic_HE151369 where email='"+email+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Academic ac= new Academic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return ac;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Academic getAccountByUserPass(String pass) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "select * from Academic_HE151369 where password='"+pass+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Academic ac= new Academic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return ac;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void updateAdmin(int id, String user, String password, String email) {
        Connection con = null;
        DBContext db = new DBContext();
        //int id=10;
        try {
            con = db.getConnection();
            String sql = "UPDATE Academic_HE151369 SET username = ?, password=?, email=? where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setInt(1, id);
            stmt.setString(1, user);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
