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
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DeliveryBoyController implements Initializable {

    @FXML
    private Button logoutButton;
    @FXML
    private MenuItem createReportMenuItem;
    @FXML
    private MenuItem noticeMenuItem;
    @FXML
    private BorderPane deliveryBoyBorder;
    @FXML
    private AnchorPane deliveryBoyAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logoutButtonOnClick(ActionEvent event) {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        
	Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();

	stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
        } catch(IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void createReportMenuItemOnClick(ActionEvent event) {
        try{
            Parent scene = FXMLLoader.load(getClass().getResource("createReport.fxml"));
            deliveryBoyBorder.setCenter(scene);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void noticeMenuItemOnClick(ActionEvent event) {
         try{
            Parent scene = FXMLLoader.load(getClass().getResource("veiwNotice.fxml"));
            deliveryBoyBorder.setCenter(scene);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }
    
}
