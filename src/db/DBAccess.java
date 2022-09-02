/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;


import java.sql.*;


/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class DBAccess implements AutoCloseable{
    private String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String user = "root";
    private String password = "C_1kr2161240";

    public DBAccess() {
    }
    //MySQL connection method
    public Statement getCon() throws SQLException{
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stm = con.createStatement();
        return stm;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
