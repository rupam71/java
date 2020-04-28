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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TrackParcelController implements Initializable {

    @FXML
    private Label productNameLabel;
    @FXML
    private Label productIdLabel;
    @FXML
    private Label productLocationLabel;
    @FXML
    private TextField productIdTextField;
    @FXML
    private Button trackButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void productIdTextFieldOnClick(MouseEvent event) {
        productIdTextField.setText("");
    }

    @FXML
    private void trackButtonOnClick(ActionEvent event) {
        int id;
        id = Integer.parseInt(productIdTextField.getText());
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File f = new File("AllParcel.bin");
            if(!f.exists())
                System.out.println("File Does Not Exists!!");
            else {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                try{
                    Parcel a;
                    while(true){
                        a = (Parcel)ois.readObject();
                        if(a.getParcelNo()==id){
                            productNameLabel.setText(a.getParcelName());
                            productIdLabel.setText(""+a.getCustomerId());
                            productLocationLabel.setText("Comilla");
                        }
                        else{
                            productNameLabel.setText("No Match");
                            productIdLabel.setText("No Match");
                            productLocationLabel.setText("No Match");
                        }
  //                      outputTextArea.appendText(a.toString()+"\n");
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
