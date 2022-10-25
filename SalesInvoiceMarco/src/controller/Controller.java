/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.HeaderTableModel;
import model.INVOICEHeader;
import model.INVOICELine;
import view.SalesFrame;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.INVOICELine;
import model.ItemTableModel;
//import view.NewJFrame;

/**
 *
 * @author moheb
 */
public class Controller implements ActionListener, ListSelectionListener {
    int invNum=0;
     List<String> lLines;
    private SalesFrame frame;
  //  private NewJFrame  frame1;
    private List<String> hLines;
    File hFile;
    File lFile;

    public List<String> getlLines() {
        return lLines;
    }

    public void setlLines(List<String> lLines) {
        this.lLines = lLines;
    }

    public SalesFrame getFrame() {
        return frame;
    }

    public void setFrame(SalesFrame frame) {
        this.frame = frame;
    }

    public List<String> gethLines() {
        return hLines;
    }

    public void sethLines(List<String> hLines) {
        this.hLines = hLines;
    }

    public File gethFile() {
        return hFile;
    }

    public void sethFile(File hFile) {
        this.hFile = hFile;
    }

    public File getlFile() {
        return lFile;
    }

    public void setlFile(File lFile) {
        this.lFile = lFile;
    }
    public Controller(SalesFrame frame) {
        this.frame = frame;
    }
  /*   public Controller(NewJFrame frame) { 
        this.frame1 = frame;
    }*/
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "New Invoice":
        {
            try {
                newInvoice();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;

            case "Delete Invoice":
        {
           
                deleteInvoice();
            
            }
        
                break;

            case "New Line":
                newLine();
                break;

            case "Delete Line":
                deleteLine();
                break;

            case "Load":
                load(null, null);
                break;

            case "Save":
        {
            try {
                save();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;

        }
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = frame.getInvoicesTable().getSelectedRow();
        System.out.println("Row Selected " + selectedRow);
        if (selectedRow != -1) {
            INVOICEHeader selectedInv = frame.getInvoices().get(selectedRow);
            frame.getCustomerNameLbl().setText(selectedInv.getName());
            frame.getInvDateLbl().setText(frame.df.format(selectedInv.getDate()));
            frame.getInvNumLbl().setText(""+selectedInv.getNum());
            frame.getInvTotalLbl().setText(""+selectedInv.getTotal());
            frame.setItemTableModel(new ItemTableModel(selectedInv.getItems()));
        } else {
            
        }
    }

    private void newInvoice() throws IOException {
        File myObj = new File("New Invoice");
        INVOICEHeader newON = new INVOICEHeader(0,null,null);
      myObj.createNewFile();
      load(myObj.getPath(),lFile.getPath());
        JOptionPane.showMessageDialog(frame,myObj.getName() + " created");
        frame.getInvoices().add(newON);
    }

    private void deleteInvoice()  {
        //hFile.getPath.delete();
                //file to be delete  
        this.hFile.deleteOnExit();              
        this.lFile.deleteOnExit();        //returns Boolean value   
JOptionPane.showMessageDialog(frame,hFile.getName() + " deleted");

JOptionPane.showMessageDialog(frame,lFile.getName() + " deleted");
lFile=null;
hFile=null;
load(null,null);
 //getting and printing the file name  
}  
    

    private void newLine() {
        INVOICELine newL = new INVOICELine(null,0,0.0,frame.getInvoiceByNum(invNum));
        this.getlLines().add("");
        frame.getInvoiceByNum(invNum).getItems().add(newL);
        System.out.print(this.getlLines().toString());
    }

    private void deleteLine() {
     int f= frame.getLinesTable().getSelectedRow();
     frame.getLinesTable().remove(f);
     JOptionPane.showMessageDialog(frame,"Line" + f + "is deleted");
     
    }

    public void load(String hPath, String lPath) {
        //System.out.println("Load File");
        //File hFile = null;
        //File lFile = null;
        if (hPath == null && lPath == null) {
            JFileChooser fc = new JFileChooser();
            JOptionPane.showMessageDialog(frame, "Choose Header File!", "Header", JOptionPane.WARNING_MESSAGE);
            int result = fc.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                hFile = fc.getSelectedFile();
                JOptionPane.showMessageDialog(frame, "Choose Line File!", "Line", JOptionPane.WARNING_MESSAGE);
                result = fc.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    lFile = fc.getSelectedFile();
                }
            }
        } else {
            hFile = new File(hPath);
            lFile = new File(lPath);
        }
        
        if (hFile != null && lFile != null) {
            try {
                this.hLines = readFile(hFile);
                /*
                [
                    "1,12-11-2020,Sameer", 
                    "2,23-10-2021,Rana"
                ]
                */
                
                 lLines = readFile(lFile);
                /*
                [
                    "1,Mobile,3200,1",
                    "1,Cover,90,2",
                    "1,Headphone,130,1",
                    "2,Laptop,9000,1",
                    "2,Mouse,135,2"
                ]
                */
                System.out.println("check");
                for (String hLine : this.hLines) {
                    /*
                        hLine = "1,12-11-2020,Sameer"
                    */
                    String[] parts = hLine.split(",");
                    /*
                        parts = ["1", "12-11-2020", "Sameer"]
                    */
                    Date d = new Date();
                    int num = Integer.parseInt(parts[0]);
                    try{d = SalesFrame.df.parse(parts[1]);}catch (ParseException pex) {}
                    String name = parts[2];
                    INVOICEHeader inv = new INVOICEHeader(num, name, d);
                    frame.getInvoices().add(inv);
                   // System.out.print(parts[2]);
                }
                frame.setHeaderTableModel(new HeaderTableModel(frame.getInvoices()));
                
                for (String lLine : lLines) {
                    /*
                        lLine = "1,Mobile,3200,1"
                    */
                    String[] parts = lLine.split(",");
                    /*
                        parts = ["1", "Mobile", "3200", "1"]
                    */
                     invNum = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int price = Integer.parseInt(parts[2]);
                    int count = Integer.parseInt(parts[3]);
                    INVOICEHeader invoice = frame.getInvoiceByNum(invNum);
                    INVOICELine item = new INVOICELine(name, price, count, invoice);
                }
                System.out.println("Check");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error while loading files", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private List<String> readFile(File f) throws IOException {
        List<String> lines = new ArrayList<>();

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        return lines;
    }

    public void save() throws IOException {
        try(FileWriter writer = new FileWriter("output.txt")) {
            ArrayList<INVOICEHeader>head= frame.getInvoices();
            frame.getInvoiceByNum(1);
            for(int j=0;j<head.size();j++){
               
            for(int i=0;i<this.hLines.size();i++){
                writer.write(head.get(j).toString());
    writer.write(this.hLines.get(i).toString());}}
    System.out.print("done");
}
catch(IOException e){
    // Handle the exception
}
    }
}