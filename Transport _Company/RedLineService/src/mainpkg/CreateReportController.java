/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CreateReportController implements Initializable {

    @FXML
    private TextField dipositMoneyTextField;
    @FXML
    private TextField textField;
    @FXML
    private TextField transectionNumberTextField;
    @FXML
    private Button sendButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendButtonOnClick(ActionEvent event) {
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            File f = new File("Account.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);                               
            }
     //       Account a = new Account(Integer.parseInt(dipositMoneyTextField.getText()), Integer.parseInt(transectionNumberTextField.getText()), textField.getText());
            
     Account a;
            a = new Account(Integer.parseInt(transectionNumberTextField.getText()), textField.getText());
            a.diposit(Integer.parseInt(dipositMoneyTextField.getText()));
            oos.writeObject(a);
            System.out.println("write done");
        } catch(Exception ex){
            System.out.println("Oops! Please a valid minimum salary...");
            System.out.println(ex);
        }
        finally{
            if(oos != null) try {
                oos.close();
                fos.close();
            } catch (IOException ex) { System.out.println(ex);}
        }
    
    }
    
}
