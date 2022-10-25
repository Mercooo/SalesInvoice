/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author moheb
 */
public class ItemTableModel extends AbstractTableModel{
     private ArrayList<INVOICELine> items;
    private String[] columns = {"Name", "Price", "Count", "Total"};

    public ItemTableModel(ArrayList<INVOICELine> items) {
        this.items = items;
    }
    
    
     @Override
    public int getRowCount() {
        return items.size();
    }

    
     @Override
    public int getColumnCount() {
        return columns.length;
    }

    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        INVOICELine item = items.get(rowIndex);
        switch (columnIndex) {
            case 0: return item.getName();
            case 1: return item.getPrice();
            case 2: return item.getCount();
            case 3: return item.getTotal();
            default: return "";
        }
    }

    
     @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
}
