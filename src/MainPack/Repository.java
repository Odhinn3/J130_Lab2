/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPack;

import db.DBAccess;
import mod.Model;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class Repository {
    
    
    //получение списка продуктов
    public List<Model> getModelList(String table){
        
        List<Model> list = new ArrayList<>();
        String query = "SELECT * FROM " + table;
        try (DBAccess db = new DBAccess()){
            ResultSet rs = db.getExecuteQuery(query);
            while (rs.next()){
                if(table.equals("javadev.products")){
                    Model mod = new Model();
                    mod.setArticul(rs.getString(1));
                    mod.setName(rs.getString(2));
                    mod.setColor(rs.getString(3));
                    mod.setPrice(rs.getInt(4));
                    mod.setRemain(rs.getInt(5));
                    list.add(mod);
                } else if(table.equals("javadev.orders")){
                    Model mod = new Model();
                    mod.setId(rs.getInt(1));
                    mod.setOrderdate(rs.getDate(2).toLocalDate());
                    mod.setCustomername(rs.getString(3));
                    mod.setPhone(rs.getString(4));
                    mod.setEmail(rs.getString(5));
                    mod.setAddress(rs.getString(6));
                    mod.setStatus(rs.getString(7));
                    if(rs.getDate(8)!=null) mod.setShipdate(rs.getDate(8).toLocalDate());
                    else mod.setShipdate(null);
                    list.add(mod);
                } else if(table.equals("javadev.orderpos")){
                    Model mod = new Model();
                    mod.setOrdercode(rs.getInt(1));
                    mod.setArticul(rs.getString(2));
                    mod.setPrice(rs.getInt(3));
                    mod.setNumber(rs.getInt(4));
                    list.add(mod);
                }
            }
//            db.close();
        } catch (Exception ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list; 
    } 
    //вывод в консоль списка наименований товаров заказов с заданным ID
    public List<Model> getModelByID(int id){
        List<Model> list = new ArrayList<>();
        String query = "SELECT javadev.products.name, javadev.products.color\\n\" +\n" +
"                \"FROM javadev.products, javadev.orders, javadev.orderpos\\n\" +\n" +
"                \"WHERE orders.id = orderpos.ordercode AND orders.id = \" + id + \n" +
"                \" AND orderpos.articul = products.articul";
        try (DBAccess db = new DBAccess()){
            ResultSet rs = db.getExecuteQuery(query);
            while (rs.next()){
                Model mod = new Model();
                mod.setName(rs.getString(1));
                if(rs.getString(2) != null){
                    mod.setColor(rs.getString(2));
                } else {
                    mod.setColor(null);
                }
                if(mod.getColor() != null){
                    System.out.println("Order " + id + ": " + mod.getName() + ", " + mod.getColor());
                } else {
                    System.out.println("Order " + id + ": " + mod.getName());
                }
                list.add(mod);
            }
        } catch (SQLException ex) {
        ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //регистрация заказа
    public void regOrder(String name, String phone, String email, String address, Map<String, Integer> orderpos) throws SQLException{
        if(name == null || phone == null || email == null || address == null ||
                orderpos == null){
            throw new IllegalArgumentException("Не заданы аргументы!");
        } 
        try (DBAccess db = new DBAccess()){
                db.getExecuteUpdate("INSERT INTO javadev.orders "
                    + "(id, orderdate, customername, phone, email, address, status, shipdate) VALUES"
                    + "((SELECT * FROM (SELECT MAX(id) FROM javadev.orders) AS t)+1, '"
                    + LocalDate.now() + "', \""
                    + name + "\", \"" + phone + "\", \"" + email + "\", \"" + address
                    + "\", \"P"  + "\", null)");
                for (Map.Entry o : orderpos.entrySet()){
                    String a = (String) o.getKey();
                    int n = (int) o.getValue();
                        db.getExecuteUpdate("INSERT INTO javadev.orderpos (ordercode, articul, price, num)\n" +
                            "VALUES ((SELECT MAX(id) FROM javadev.orders), \"" + a
                            + "\", (SELECT price FROM javadev.products WHERE javadev.products.articul=\""
                            + a + "\"), " + n + ")");
            }
        } catch (SQLException ex) {
        ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        orderpos.clear();
    }
    
    
}