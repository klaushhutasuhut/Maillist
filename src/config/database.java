/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import java.sql.*;
/**
 *
 * @author Klaus
 */
public class database {
    String directory = "";
    static String Ucandriver = "net.ucanaccess.jdbc.UcanaccessDriver";
    public Connection conn = null;
    public Statement st;
    public PreparedStatement pstmt;
    public ResultSet rs;
    protected ResultSetMetaData m; 
    
    public String getDirectori(){
        return directory;
    }
    
    public void setDirectori(String directory){
        this.directory = directory;
    }
    
    public Connection koneksi(){
        String URL = "jdbc:ucanaccess://" + getDirectori();
        try {
            Class.forName(Ucandriver);
            conn = DriverManager.getConnection(URL);
            st = conn.createStatement();
        }catch(ClassNotFoundException | SQLException e){
            
        }
    return conn;
    }
}
