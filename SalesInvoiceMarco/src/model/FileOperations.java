/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.INVOICEHeader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.SalesFrame;

/**
 *
 * @author moheb
 */
public class FileOperations {
    

public ArrayList<INVOICEHeader> readFile(){
 String filename = null;
        BufferedReader file = null;
        try {
            // TODO add your handling code here:
             file = new BufferedReader(new FileReader(filename));
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(SalesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            file.readLine();
        } catch (IOException ex) {
            Logger.getLogger(SalesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
}


public static void main(String [] args){

}}