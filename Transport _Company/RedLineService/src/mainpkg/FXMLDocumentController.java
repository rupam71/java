/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField idTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox loginComboBox;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginLabel;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginLabel.setText("Admin");
        loginComboBox.getItems().addAll("Admin","Account Officer","Bus Supervisor","Courier Service User","Delivery Boy","Passanger");
        loginComboBox.setValue("Admin");
    }    
    
    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        Parent root = null;
        
        if (loginComboBox.getValue().toString() == "Admin" && Integer.parseInt(idTextField.getText()) == 111 && Integer.parseInt(passwordTextField.getText()) == 1234) root = FXMLLoader.load(getClass().getResource("Admin.fxml") );
        if (loginComboBox.getValue().toString() == "Account Officer" && Integer.parseInt(idTextField.getText()) == 112 && Integer.parseInt(passwordTextField.getText()) == 1234) root = FXMLLoader.load(getClass().getResource("AccountOfficer.fxml") );
        if (loginComboBox.getValue().toString() == "Bus Supervisor" && Integer.parseInt(idTextField.getText()) == 211 && Integer.parseInt(passwordTextField.getText()) == 1234) root = FXMLLoader.load(getClass().getResource("BusSupervisor.fxml") );
        if (loginComboBox.getValue().toString() == "Courier Service User" && Integer.parseInt(idTextField.getText()) == 312 && Integer.parseInt(passwordTextField.getText()) == 1234) root = FXMLLoader.load(getClass().getResource("CourierServiceUser.fxml") );
        if (loginComboBox.getValue().toString() == "Delivery Boy" && Integer.parseInt(idTextField.getText()) == 212 && Integer.parseInt(passwordTextField.getText()) == 1234) root = FXMLLoader.load(getClass().getResource("DeliveryBoy.fxml") );
        if (loginComboBox.getValue().toString() == "Passanger" && Integer.parseInt(idTextField.getText()) == 311 && Integer.parseInt(passwordTextField.getText()) == 1234) root = FXMLLoader.load(getClass().getResource("Passenger.fxml") );
        
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
         
    }

//    if (loginComboBox.getValue().toString() == "Admin" ){
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        
//        Scene scene = new Scene(root);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//         }
    @FXML
    private void loginComboBoxIsUpdate(ActionEvent event) {
        this.loginLabel.setText(loginComboBox.getValue().toString());
    }

    @FXML
    private void idTextFieldOnClick(MouseEvent event) {
        idTextField.setText("");
    }

    @FXML
    private void passwordTextFieldOnClick(MouseEvent event) {
        passwordTextField.setText("");
    }
    
}
