/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import view.SalesFrame;

/**
 *
 * @author moheb
 */
public class HeaderTableModel extends AbstractTableModel {
      private ArrayList<INVOICEHeader> invoices;
    private String[] columns = {"Num", "Name", "Date", "Total"};

    public HeaderTableModel(ArrayList<INVOICEHeader> invoices) {
        this.invoices = invoices;
    }
   
    public int getRowCount() {
        return invoices.size();
    }

  
    public int getColumnCount() {
        return columns.length;
    }

   
    public Object getValueAt(int rowIndex, int columnIndex) {
        INVOICEHeader inv = invoices.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inv.getNum();
            case 1: 
                return inv.getName();
            case 2:
                return SalesFrame.df.format(inv.getDate());
            case 3:
                return inv.getTotal();
            default:
                return "";
        }
        
    }


    public String getColumnName(int column) {
        return columns[column];
    }
    
}
