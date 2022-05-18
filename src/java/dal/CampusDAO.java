package dal;

import dataobj.Campus;
import db.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.persistence.Cache;

/**
 *
 * @author TuanAnh
 */
public class CampusDAO {

    public String getShortNameCampus(int campusId) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT name FROM Campus_HE151369 WHERE id = '" + campusId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString(1);
                return name;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Campus> getAllCampus() {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            ArrayList<Campus> cam = new ArrayList<>();
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Campus_HE151369";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Campus c= new Campus(rs.getInt(1), rs.getString(2));
                cam.add(c);
            }
            rs.close();
            stmt.close();
            con.close();
            return cam;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
