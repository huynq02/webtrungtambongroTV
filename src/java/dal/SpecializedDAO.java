package dal;

import dataobj.Specialized;
import db.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author TuanAnh
 */
public class SpecializedDAO {

    public String getCodeSpecialized(int specializedId) {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT code FROM Specialized_HE151369 WHERE id = '" + specializedId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String code = rs.getString(1);
                return code;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Specialized> getSpecialized() {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            ArrayList<Specialized> spec = new ArrayList<>();
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Specialized_HE151369 ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Specialized sp= new Specialized(rs.getString(1), rs.getString(2));
                spec.add(sp);
            }
            rs.close();
            stmt.close();
            con.close();
            return spec;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
