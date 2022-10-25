/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author moheb
 */
public class INVOICELine {
    
    private String name;
    private int count;
    private double price;
    private INVOICEHeader inv;

    public INVOICELine(String name, int count, double price, INVOICEHeader inv) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.inv = inv;
        inv.getItems().add(this);
    }

    public double getTotal() {
        return count * price;
    }
    
    public INVOICEHeader getInv() {
        return inv;
    }

    public void setInv(INVOICEHeader inv) {
        this.inv = inv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" + "name=" + name + ", count=" + count + ", price=" + price + '}';
    }
    
    
}
