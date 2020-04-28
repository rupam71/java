/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ParcelHistoryController implements Initializable {

    @FXML
    private TextField cusIdTextField;
    @FXML
    private TextArea outputTextField;
    @FXML
    private Button loadHistoryButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cusIdTextFieldOnClick(MouseEvent event) {
        cusIdTextField.setText("");
    }

    @FXML
    private void loadHistoryButtonOnClick(ActionEvent event) {
        int customerId;
        customerId = Integer.parseInt(cusIdTextField.getText());
        
        String str = null;
        
        CourierServiceUser c = new CourierServiceUser();
        str = c.parcelHistory(customerId);
        
        outputTextField.setText(str);
    }
    
}
