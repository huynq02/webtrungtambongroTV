package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TuanAnh
 */
public class DBContext {

    public Connection getConnection() throws SQLException {
        try {
            Connection con = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433; databaseName=PRJ301_SP22_KIEU; user = sa; password = sa";
            con = DriverManager.getConnection(url);
            return con;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        try {
            DBContext a = new DBContext();
            a.getConnection();
            System.out.println("Ket noi thanh cong");
        }catch(Exception e) {
            System.out.println("Ket noi false: "+ e.getMessage());
        }
    }
}
