/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;


import MainPack.DataBaseProperties;
import java.sql.*;



/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class DBAccess implements AutoCloseable{
    private String url = DataBaseProperties.get().getProperty("db.url");
    private String user = DataBaseProperties.get().getProperty("db.user");
    private String password = DataBaseProperties.get().getProperty("db.password");

    public DBAccess() {
    }
    //MySQL connection method
    public ResultSet getExecuteQuery(String query) throws SQLException{
        Statement stm;
        Connection con = DriverManager.getConnection(url, user, password);
        stm = con.createStatement();
        return stm.executeQuery(query);
        
    }
    
    public int getExecuteUpdate(String query) throws SQLException{
        Statement stm;
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            stm = con.createStatement();
        return stm.executeUpdate(query);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void close() throws Exception {
        System.out.println("closed");
    }
}
