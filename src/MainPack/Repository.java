/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPack;

import MySQL_DB.Model;
import java.sql.*;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class Repository {
    public String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
    public String user = "root";
    public String password = "C_1kr2161240";

    //получение списка продуктов
    public List<Model> getModelList(){
        List<Model> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "C_1kr2161240");
                Statement stm = con.createStatement()){
            ResultSet rs = stm.executeQuery("SELECT * FROM javadev.products");
            while (rs.next()){
                Model mod = new Model();
                mod.setArticul(rs.getString(1));
                mod.setName(rs.getString(2));
                mod.setColor(rs.getString(3));
                mod.setPrice(rs.getInt(4));
                mod.setRemain(rs.getInt(5));
                list.add(mod);
            }
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
        return list; 
    }
        
    /*public List<Orders> getOrdersListByID(int id) throws SQLException{
        List<Orders> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "C_1kr2161240");
                Statement stm = con.createStatement()){
            ResultSet rs = stm.executeQuery("SELECT * FROM javadev.orders WHERE id = " + id);
            while (rs.next()){
                Orders ord = new Orders();
                ord.setId(rs.getInt(1));
                ord.setOrderdate(rs.getDate(2).toLocalDate());
                ord.setCustomername(rs.getString(3));
                ord.setPhone(rs.getString(4));
                ord.setEmail(rs.getString(5));
                ord.setAddress(rs.getString(6));
                ord.setStatus(rs.getString(7));
                if (rs.getDate(8) != null){
                    ord.setShipdate(rs.getDate(8).toLocalDate());
                } else {
                    ord.setShipdate(null);
                }
                list.add(ord);
            }
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
        return list;            
    }*/
    
    //вывод в консоль списка наименований товаров заказов с заданным ID
    public List<Model> getModelByID(int id){
        List<Model> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "C_1kr2161240");
                Statement stm = con.createStatement()){
            ResultSet rs = stm.executeQuery("SELECT javadev.products.name, javadev.products.color\n" +
                "FROM javadev.products, javadev.orders, javadev.orderpos\n" +
                "WHERE orders.id = orderpos.ordercode AND orders.id = " + id + 
                " AND orderpos.articul = products.articul");
            while (rs.next()){
                Model mod = new Model();
                mod.setName(rs.getString(1));
                if(rs.getString(2) != null){
                    mod.setColor(rs.getString(2));
                } else {
                    mod.color = null;
                }
                if(mod.color != null){
                    System.out.println("Order " + id + ": " + mod.name + ", " + mod.color);
                } else {
                    System.out.println("Order " + id + ": " + mod.name);
                }
                list.add(mod);
            }
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
        return list;
    }
    
    public void regOrder(String name, String phone, String email, String address, int[] articuls, int num) throws SQLException{
        /*if(name == null || phone == null || email == null || address == null ||
                articuls == null || num == 0){
            throw new IllegalArgumentException("Не заданы аргументы!");
        }*/
        int dbid = 0;
        LocalDate date;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "C_1kr2161240");
            Statement stm = con.createStatement()){
                ResultSet rs = stm.executeQuery("SELECT MAX(id) FROM javadev.orders");
                while(rs.next()){
                dbid = rs.getInt(1);
                }
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
        System.out.println(dbid);
        dbid++;
        System.out.println(dbid);
        
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "C_1kr2161240");
            Statement stm = con.createStatement()){
            if(articuls.length==1){
                stm.executeUpdate("INSERT INTO javadev.orders "
                        + "(id, orderdate, customername, phone, email, address, status, shipdate) VALUES (" +
                        + dbid + ", '" + LocalDate.now() + "', \""
                        + name + "\", \"" + phone + "\", \"" + email + "\", \"" + address + "\", \"S"  + "\", '" + LocalDate.now() + "')");
            } else {
                
            }
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
    }
}
