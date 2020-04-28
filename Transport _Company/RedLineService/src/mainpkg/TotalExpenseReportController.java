/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TotalExpenseReportController implements Initializable {

    @FXML
    private TextArea outputTextArea;
    @FXML
    private Button loadButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadButtonOnClick(ActionEvent event) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        try{
            File f = new File("ExpenceMoneyReport.bin");
            if(!f.exists())
                System.out.println("OOPS!! File not Found...");
            else{
                fis = new FileInputStream(f);
                bis = new BufferedInputStream(fis);
                dis = new DataInputStream(bis);
                
                String str = "";
                
                
                while(true){
                    str += "Amount: " + Integer.toString(dis.readInt())+" \n";
                    str += "Money User: " + dis.readUTF()+" \n";
                    str += "Money Recever: " + dis.readUTF()+" \n";
                    str += "Details: " + dis.readUTF()+" \n"+" \n"+" \n";
                    outputTextArea.appendText(str);
                    str="";
                }
            }
        } catch (IOException ex) {   
            System.out.println(ex);
        } 
        
        finally{
            try{
                if(dis!=null) dis.close();
            } catch (IOException ex) {   
            System.out.println(ex);
        }
        }
    }
    
}
