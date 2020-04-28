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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CreateBusController implements Initializable {

    @FXML
    private TextField busIdTextFeild;
    @FXML
    private TextField busNameTextFeild;
    @FXML
    private TextField busGoingToTextFeild;
    @FXML
    private TextField busTotalSeatTextLabel;
    @FXML
    private TextField busCouchTextFeild;
    @FXML
    private TextField busStartFromTextFeild;
    @FXML
    private Button createNewBusButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createNewBusButtonOnClick(ActionEvent event) {
        int id, seat;
        String name, from, to, couch;
        
        id = Integer.parseInt(busIdTextFeild.getText());
        name = busNameTextFeild.getText();
        couch = busCouchTextFeild.getText();
        from = busStartFromTextFeild.getText(); 
        to = busGoingToTextFeild.getText();
        seat = Integer.parseInt(busTotalSeatTextLabel.getText());
        
        Admin a = new Admin();
        a.createNewBus(id, name, couch, from, to, seat);
    }
    
}
