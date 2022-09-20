/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.time.LocalDate;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class Model {
    private String articul;
    private String name;
    private String color;
    private int price;
    private int remain;
    private int id;
    private LocalDate orderdate;
    private String customername;
    private String phone;
    private String email;
    private String address;
    private String status;
    private LocalDate shipdate;
    private int ordercode;
    private int number;
    

    public Model() {
    }

    public Model(int ordercode, String articul, int price, int number) {
        this.ordercode = ordercode;
        this.articul = articul;
        this.price = price;
        this.number = number;
    }

    public Model(int id, LocalDate orderdate, String customername, String phone, String email, String address, String status, LocalDate shipdate) {
        this.id = id;
        this.orderdate = orderdate;
        this.customername = customername;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.shipdate = shipdate;
    }

    public Model(String articul, String name, String color, int price, int remain) {
        this.articul = articul;
        this.name = name;
        this.color = color;
        this.price = price;
        this.remain = remain;
    }

    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDate orderdate) {
        this.orderdate = orderdate;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getShipdate() {
        return shipdate;
    }

    public void setShipdate(LocalDate shipdate) {
        this.shipdate = shipdate;
    }

    public int getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(int ordercode) {
        this.ordercode = ordercode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Model{" + "articul=" + articul + ", name=" + name + ", color="
                + color + ", price=" + price + ", remain=" + remain + ", id="
                + id + ", orderdate=" + orderdate + ", customername="
                + customername + ", phone=" + phone + ", email=" + email
                + ", address=" + address + ", status=" + status + ", shipdate="
                + shipdate + ", ordercode=" + ordercode + ", number=" + number + '}';
    }

      
}
