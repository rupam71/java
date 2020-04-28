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
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SendSalaryController implements Initializable {

    @FXML
    private Button sendSalaryButton;
    private TextArea outputTextArea;
    @FXML
    private TextField employeeNameTextFeild;
    @FXML
    private Button employeeViewButton;
    @FXML
    private TableView<SendSalary> tableView;
    @FXML
    private TableColumn<SendSalary, String> nameColoumn;
    @FXML
    private TableColumn<SendSalary, Integer> idColoumn;
    @FXML
    private TableColumn<SendSalary, Float> salaryColoumn;
    @FXML
    private TableColumn<SendSalary, String> typeColoumn;
    @FXML
    private TextField salaryTextFeild;
    @FXML
    private TextField idTextFeild;
    @FXML
    private TextField typeTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColoumn.setCellValueFactory(new PropertyValueFactory<SendSalary,String>("name"));
        idColoumn.setCellValueFactory(new PropertyValueFactory<SendSalary, Integer>("id"));
        typeColoumn.setCellValueFactory(new PropertyValueFactory<SendSalary,String>("type"));
        salaryColoumn.setCellValueFactory(new PropertyValueFactory<SendSalary,Float>("salary"));
        
        tableView.setEditable(true);
        nameColoumn.setCellFactory(TextFieldTableCell.forTableColumn());
        typeColoumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
   
    }    



    @FXML
    private void sendSalaryButtonOnClick(ActionEvent event) {
        SendSalary newPerson = new SendSalary(
                Integer.parseInt(idTextFeild.getText()),
                employeeNameTextFeild.getText(),
                                       typeTextField.getText(),
                Float.parseFloat(salaryTextFeild.getText()));
        tableView.getItems().add(newPerson);
        
    }

    @FXML
    private void employeeIdTextFeildOnClick(MouseEvent event) {
        employeeNameTextFeild.setText("");
    }

    private void employeeButtonOnClick(ActionEvent event) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File f = new File("AllEmployeeInformation.bin");
            if(!f.exists())
                outputTextArea.setText("File Does Not Exists!!");
            else {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                outputTextArea.setText("");
                try{
                    Emp a;
                    while(true){
                        a = (Emp)ois.readObject();
                        
                        outputTextArea.appendText(a.toString()+"\n");
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

    @FXML
    private void employeeViewButtonOnClick(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("PersonViewScene.fxml"));
//        Parent personViewParent = loader.load();
//        
//        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
//        Scene personViewScene = new Scene(personViewParent);
//        
//        //access the controller
//        PersonViewSceneController controller = loader.getController();
//        controller.initData(tableView.getSelectionModel().getSelectedItem());
//        
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        
//        window.setScene(personViewScene);
//        window.show();
    }
    
}
