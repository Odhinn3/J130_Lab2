/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MySQL_DB;

import java.time.*;
import java.util.Objects;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class Orders {
    public int id;
    public LocalDate orderdate;
    public String customername;
    public String phone;
    public String email;
    public String address;
    public String status;
    public LocalDate shipdate;

    public Orders() {
    }

    public Orders(int id, LocalDate orderdate, String customername, String phone, String email, String address, String status, LocalDate shipdate) {
        this.id = id;
        this.orderdate = orderdate;
        this.customername = customername;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.shipdate = shipdate;
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

    @Override
    public String toString() {
        return "Orders{" + "id=" + id + ", orderdate=" + orderdate + ", customername=" + customername + ", phone=" + phone + ", email=" + email + ", address=" + address + ", status=" + status + ", shipdate=" + shipdate + '}';
    }
    
    
    
    
}
