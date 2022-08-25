/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL_DB;

import java.util.Objects;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class Model {
    public String articul;
    public String name;
    public String color;
    public int price;
    public int remain;

    public Model() {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.articul);
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.color);
        hash = 19 * hash + this.price;
        hash = 19 * hash + this.remain;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Model other = (Model) obj;
        if (this.price != other.price) {
            return false;
        }
        if (this.remain != other.remain) {
            return false;
        }
        if (!Objects.equals(this.articul, other.articul)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.color, other.color);
    }
    
    @Override
    public String toString(){
        return
                "Product: " + articul + ", " + name + ", " + color + ", " +
                price + ", " + remain + ", ";
    }   
}
