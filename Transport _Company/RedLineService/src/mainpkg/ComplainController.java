/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ComplainController implements Initializable {

    @FXML
    private Button sendButton;
    @FXML
    private TextArea complainTextArea;
    @FXML
    private TextField nameTextField;
    private ComboBox personComboBox;
    @FXML
    private Label personLabel;
    @FXML
    private RadioButton passengerRadioButton;
    @FXML
    private RadioButton courierServiceUserRadioButton;
    private ToggleGroup tg;
    @FXML
    private Button saveToFileButton;
    
    ArrayList<String> fileTypeList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg = new ToggleGroup();
        passengerRadioButton.setToggleGroup(tg);
        courierServiceUserRadioButton.setToggleGroup(tg);
        passengerRadioButton.setSelected(true);
        personLabel.setText("Passenger");
        
        fileTypeList = new  ArrayList<String>();
        fileTypeList.add("*.txt");
        fileTypeList.add("*.doc");
        fileTypeList.add("*.docx");
        fileTypeList.add("*.TXT");
        fileTypeList.add("*.DOC");
        fileTypeList.add("*.DOCX");
    }    

    @FXML
    private void sendButtonOnclick(ActionEvent event) {
        FileWriter fw = null;
        try {
            String str = "Name: "+ nameTextField.getText()+", Customer Type: "+ personLabel.getText()+"\n"
                    +"Complain: "+ complainTextArea.getText()+"\n"+"\n";
            
            File f = new File("Complain.txt");
            
            if (f.exists()) fw = new FileWriter (f, true);
            else fw = new FileWriter (f);
            
            
            fw.write(str);
            
            System.out.println("Complete Register This Time");
        } catch (IOException ex) {System.out.println(ex);}
        
        finally {
            try {
                fw.close();
        } catch (IOException ex) {System.out.println(ex);}
        }
    }

    @FXML
    private void textAreaOnClick(MouseEvent event) {
        complainTextArea.setText("");
    }

    @FXML
    private void radioButtonOnClick(ActionEvent event) {
        if(passengerRadioButton.isSelected()) personLabel.setText("Passenger");
        else if(courierServiceUserRadioButton.isSelected()) personLabel.setText("Courier Service User");
        
    }

    @FXML
    private void saveToFileButtonOnClick(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", fileTypeList));
        File f = fc.showSaveDialog(null);
        System.out.println("Edited Content will be written in: "+f.getAbsolutePath());
        
        String content = "Name: "+ nameTextField.getText()+", Customer Type: "+ personLabel.getText()+"\n"
                    +"Complain: "+ complainTextArea.getText()+"\n"+"\n";
        
        if(f != null){
            try {
            PrintWriter writer;
            writer = new PrintWriter(f);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
                System.out.println(ex);
        }
        }
    }
    
}
