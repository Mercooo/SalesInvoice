/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author moheb
 */
public class INVOICEHeader {
    private int num;
    private String name;
    private Date date;
    private ArrayList<INVOICELine> items;

    public INVOICEHeader(int num, String name, Date date) {
        this.num = num;
        this.name = name;
        this.date = date;
    }

  
    
    public int getTotal() {
        int total = 0;
        for (INVOICELine item : getItems()) {
            total += item.getTotal();
        }
        return total;
    }
    
    public ArrayList<INVOICELine> getItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 
    public String toString() {
        return "InvoiceHeader{" + "num=" + num + ", name=" + name + ", date=" + date + '}';
    }
    
}
