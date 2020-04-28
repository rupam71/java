/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TicketHistoryController implements Initializable {

    @FXML
    private TextField passengerIdTextField;
    @FXML
    private Button showHistoryButton;
    @FXML
    private TextArea outputTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showHistoryButtonOnClick(ActionEvent event) {
        int id;
        id = Integer.parseInt(passengerIdTextField.getText());
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File f = new File("AllTicket.bin");
            if(!f.exists())
                System.out.println("File Does Not Exists!!");
            else {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                try{
                    Ticket a;
                    while(true){
                        a = (Ticket)ois.readObject();
                        if(a.getPassengerId() == id){
                            outputTextField.appendText(a.toString()+"\n");
                        }
                    }
                } catch (Exception ex){
                    System.out.println(ex);
                }
            }
        } catch (IOException ex){
            System.out.println(ex);
        }
        
        finally{
            if(ois != null)
            try{
                 ois.close();
            } catch (IOException ex){
            System.out.println(ex);
        }
        }
    }
    
}
