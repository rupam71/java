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
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AdminController implements Initializable {

    @FXML
    private Label loginAccountOfficer;
    @FXML
    private MenuItem useMoneyMenuItem;
    @FXML
    private MenuItem sendNoticeMenuItem;
    @FXML
    private MenuItem busTicketStutusMenuItem;
    @FXML
    private MenuItem showEmployeeInfoMenuItem;
    @FXML
    private MenuItem appParcelInfoMenuItem;
    @FXML
    private MenuItem monthlyReportMenuItem;
    @FXML
    private Button logoutButton;
    @FXML
    private BorderPane adminBorder;
    @FXML
    private AnchorPane adminAnchorPane;
    @FXML
    private MenuItem allComplainMenuItem;
    @FXML
    private MenuItem createNewBusMenuItem;

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

	
        stage.setScene(scene);
        stage.show();
        } catch(IOException ex){
            System.out.println(ex);
        }
    }


    @FXML
    private void useMoneyMenuItemOnclick(ActionEvent event) {
        try{
            Parent scene = FXMLLoader.load(getClass().getResource("useMoney.fxml"));
            adminBorder.setCenter(scene);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void sendNoticeMenuItemOnClick(ActionEvent event) {
        try{
            Parent scene = FXMLLoader.load(getClass().getResource("sendNotice.fxml"));
            adminBorder.setCenter(scene);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void busTicketStutusMenuItemOnClick(ActionEvent event) {
        try{
            Parent scene = FXMLLoader.load(getClass().getResource("busTicketStutus.fxml"));
            adminBorder.setCenter(scene);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void showEmployeeInfoMenuItemOnClick(ActionEvent event) {
        try{
            Parent scene = FXMLLoader.load(getClass().getResource("emplyeeInformation.fxml"));
            adminBorder.setCenter(scene);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void appParcelInfoMenuItemOnClick(ActionEvent event) {
        try{
            Parent scene = FXMLLoader.load(getClass().getResource("allProductStutus.fxml"));
            adminBorder.setCenter(scene);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void monthlyReportMenuItemOnClick(ActionEvent event) {
        try{
            Parent scene = FXMLLoader.load(getClass().getResource("monthlyReport.fxml"));
            adminBorder.setCenter(scene);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void allComplainMenuItemOnClick(ActionEvent event) {
        try{
            Parent scene = FXMLLoader.load(getClass().getResource("allComplain.fxml"));
            adminBorder.setCenter(scene);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void createNewBusMenuItemOnClick(ActionEvent event) {
        try{
            Parent scene = FXMLLoader.load(getClass().getResource("createBus.fxml"));
            adminBorder.setCenter(scene);
        } catch (IOException ex){
            System.out.println(ex);
        }
    }



    
}
