/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.INVOICELine;
 import java.time.LocalDateTime;
/**
 *
 * @author moheb
 */
public class ClientDetail {
    private int ClientID;
    private int InvoiceNum;
    private String CustomerName;
    private int InvoiceTotal;
    private LocalDateTime time; 
        private INVOICELine [] Item;
    public ClientDetail(int ClientID, int InvoiceNum, String CustomerName, int InvoiceTotal, LocalDateTime time, INVOICELine[] Item) {
        this.ClientID = ClientID;
        this.InvoiceNum = InvoiceNum;
        this.CustomerName = CustomerName;
        this.InvoiceTotal = InvoiceTotal;
        this.time = time;
        this.Item = Item;
    }

    public LocalDateTime getTime() {
        return time.now();
    }

    public int getClientID() {
        return ClientID;
    }

    public void setClientID(int ClientID) {
        this.ClientID = ClientID;
    }

    public int getInvoiceNum() {
        return InvoiceNum;
    }

    public void setInvoiceNum(int InvoiceNum) {
        this.InvoiceNum = InvoiceNum;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public int getInvoiceTotal() {
        return InvoiceTotal;
    }

    public void setInvoiceTotal(int InvoiceTotal) {
        this.InvoiceTotal = InvoiceTotal;
    }

    public INVOICELine[] getItem() {
        return Item;
    }

    public void setItem(INVOICELine[] Item) {
        this.Item = Item;
    }

    
}
