package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MySQLR {
    
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;

    public boolean connect(String address, String port, String dataBaseName, String user, String password) {
        boolean status = false; 
        try {
        	conn = DriverManager.getConnection("jdbc:mysql://"+ address + ":" + port +"/"+ dataBaseName + "?user=" + user + "&password=" + password + "&useTimezone=true&serverTimezone=UTC&useSSL=false");; 
            status = true;
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            
        }
        return status;
    }
    // Para inserções, alterações e exclusões   
    public int executeUpdate(String query) {     
        int status = 0;
        try {
            stmt = conn.createStatement();           
            status = stmt.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
   
        }
        return status;
    }
    
    // Para consultas
    public ResultSet executeQuery(String query) {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return rs;   
    }
    
}