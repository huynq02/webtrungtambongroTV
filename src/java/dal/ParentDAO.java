/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dataobj.Parent;
import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author TuanAnh
 */
public class ParentDAO {

    public Parent getParentByID(int id) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT P.* FROM Parent_HE151369 AS P JOIN Student_HE151369 AS S ON P.id=S.parentId where S.id='" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Parent pa = new Parent(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                return pa;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void updateParent(int id, String name, int phone, String address,
            String email, String job, String pow) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "UPDATE Parent_HE151369 SET name = ?, phoneNumber = ?, address = ?, email = ?, job= ?, placeWork = ? WHERE id = (select P.id from Student_HE151369 as S join Parent_HE151369 as P on P.id=S.parentId where S.id=?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, phone);
            stmt.setString(3, address);
            stmt.setString(4, email);
            stmt.setString(5, job);
            stmt.setString(6, pow);
            stmt.setInt(7, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
