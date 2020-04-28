/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class UseMoneyController implements Initializable {

    @FXML
    private TextField amountTextField;
    @FXML
    private TextField moneyUserTextField;
    @FXML
    private TextField receiverTextField;
    @FXML
    private TextField detailsTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitButtonOnclick(ActionEvent event) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        try{
            File f = new File("ExpenceMoneyReport.bin");
            if(f.exists())  fos = new FileOutputStream(f, true);
            else fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);
            
            dos.writeInt(Integer.parseInt(amountTextField.getText()));
            dos.writeUTF(moneyUserTextField.getText());
            dos.writeUTF(receiverTextField.getText());
            dos.writeUTF(detailsTextField.getText());
            
        } catch (IOException ex){
            System.out.println(ex);
        }
        
        finally{
            try{
                if(dos!=null) dos.close();
            } catch (IOException ex){
            System.out.println(ex);
        }
        }
    }
    
}
