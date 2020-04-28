/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ModifyFXMLController implements Initializable {

    @FXML
    private ComboBox fromComboBox;
    @FXML
    private Label fromLabel;
    @FXML
    private TextField maxWeightTextField;
    @FXML
    private Button searchParcelButton;
    @FXML
    private TextArea outputTextArea;
    @FXML
    private Button writeToTextFile;
    String str="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fromLabel.setText("Chittagong");
        fromComboBox.getItems().addAll("Chittagong");
        fromComboBox.setValue("Chittagong");
    }    

    @FXML
    private void fromComboBoxIsUpdate(ActionEvent event) {
        this.fromLabel.setText(fromComboBox.getValue().toString());
    }

    @FXML
    private void searchParcelButtonOnClick(ActionEvent event) {
        float weight;
        String from="";
        from = fromLabel.getText();
        weight = Float.parseFloat(maxWeightTextField.getText());
        
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
                        if(a.getWeight() <= weight ){
                            //Chittagong
                            outputTextArea.appendText(a.toString()+"\n");
                        }
                        if(a.getWeight() <= 1){
                            str += a.toString()+"\n";
                        }
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
    private void writeToTextFileOnClick(ActionEvent event) {
        FileWriter fw = null;
        try {
            
            
            File f = new File("lightParcel.txt");
            
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
    
}
