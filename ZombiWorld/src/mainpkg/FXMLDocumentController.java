/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static mainpkg.Admin.createNewStudent;

/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private AnchorPane idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField mobileTextField;
    @FXML
    private TextField cgpaTextField;
    private TextField deptTextField;
    @FXML
    private TextArea outputTextFeild;
    @FXML
    private Button showStudentButton;
    @FXML
    private TextField idTextFeild;
    @FXML
    private Button addStudBtn;
    private TextField courseidTextFeild1;
    private TextField courseTitleTextField1;
    @FXML
    private TextField courseSeclTextField1;
    private TextField courseSemTextField1;
    @FXML
    private TextField yearTextField1;
    private TextField capacityTextField1;
    @FXML
    private Button offerdCourseBtn;
    @FXML
    private Button showOfferdCourseBtn;
    @FXML
    private ComboBox deptComboBox;
    @FXML
    private Label deptLabel;
    @FXML
    private ComboBox semComboBox;
    @FXML
    private ComboBox courseIdtComboBox;
    @FXML
    private Label courseIdLabel;
    @FXML
    private Label semLabel;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deptLabel.setText("CSE");
        deptComboBox.getItems().addAll("CSE","PS","EEE","ECN");
        deptComboBox.setValue("CSE");
        
        courseIdLabel.setText("CSE203");
        courseIdtComboBox.getItems().addAll("CSE203","PS301","EEE104","ECN208");
        courseIdtComboBox.setValue("CSE203");
        
        semLabel.setText("Authumn");
        semComboBox.getItems().addAll("Authumn","Summer","Fall");
        semComboBox.setValue("Authumn");
    }    

    @FXML
    private void idTextFieldButtonOnclick(MouseEvent event) {
               idTextFeild.setText("");
               courseidTextFeild1.setText("");
    }

    @FXML
    private void nameTextFieldButtonOnclick(MouseEvent event) {
        nameTextField.setText("");
        courseTitleTextField1.setText("");
    }

    @FXML
    private void emailTextFieldButtonOnclick(MouseEvent event) {
        emailTextField.setText("");
        courseSeclTextField1.setText("");
    }

    @FXML
    private void mobileTextFieldButtonOnclick(MouseEvent event) {
        courseSemTextField1.setText("");
    }

    @FXML
    private void cgpaTextFieldButtonOnclick(MouseEvent event) {
        yearTextField1.setText("");
        cgpaTextField.setText("");
    }

    private void deptTextFieldButtonOnclick(MouseEvent event) {
        deptTextField.setText("");
        capacityTextField1.setText("");
    }


    @FXML
    private void showStudentButtonOnclick(ActionEvent event) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
             File f = new File("student.bin");
            if(!f.exists())
                outputTextFeild.setText("File Does Not Exists!!");
            
            else {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                outputTextFeild.setText("");

            try{
//                    Student s;
                    while(true){
                       Student s = (Student) ois.readObject();
                        System.out.println(s.toString());
                        outputTextFeild.appendText(s.toString());
                    }
            } catch (Exception ex){
                    System.out.println(ex);
                }
            }
            
        } catch (IOException ex) {
//            Logger.getLogger(FXMLMainSceneController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void addStudBtnOnClick(ActionEvent event) {
        int id; String name, email, mobile, dept; float cgpa;
         id = Integer.parseInt(idTextFeild.getText());
         name = nameTextField.getText();
         email = emailTextField.getText();
         mobile = mobileTextField.getText();
         cgpa = Float.parseFloat(cgpaTextField.getText());
         dept = deptLabel.getText();
        
        Admin.createNewStudent(id, name, email, mobile, cgpa, dept);
    }

    @FXML
    private void offerdCourseBtnOnClick(ActionEvent event) {
        FileWriter fw2 = null;
        
        try {
            String str2 = "Course ID: "+ courseIdLabel.getText()
                    +", Course Section: "+ courseSeclTextField1.getText()
                    +", Year: "+ yearTextField1.getText()
                    +", Course Semister : "+ semLabel.getText()+";";
            
            // here we separate file by ";" this sign
            
            File f2 = new File("offeredCourses.txt ");
            
            if (f2.exists()) fw2 = new FileWriter (f2, true);
            else fw2 = new FileWriter (f2);
            
            fw2.write(str2);
            
            System.out.println("Complete");
        } catch (IOException ex) {System.out.println(ex);}
        
        finally {
            try {
                fw2.close();
        } catch (IOException ex) {System.out.println(ex);}
        }
    }

    @FXML
    private void showOfferdCourseBtnOnClick(ActionEvent event) {
        File f = null;
        try {
            f = new File("offeredCourses.txt ");
            Scanner s2 = new Scanner(f);
            
            String line = s2.nextLine();
            String[] lineTokens = line.split(";");
            
            for (int i=0; i<lineTokens.length; i++){
                System.out.println(lineTokens[i]+"\n"); //not needed. Just use for check.
                outputTextFeild.appendText(lineTokens[i]+"\n");
            }
        }  catch (IOException ex) {   
            System.out.println(ex);
        } 
    }

    @FXML
    private void deptComboBoxIsUpdate(ActionEvent event) {
        this.deptLabel.setText(deptComboBox.getValue().toString());
    }

    @FXML
    private void semComboBoxIsUpdate(ActionEvent event) {
        this.semLabel.setText(semComboBox.getValue().toString());
    }

    @FXML
    private void courseIdtComboBoxIsUpdate(ActionEvent event) {
        this.courseIdLabel.setText(courseIdtComboBox.getValue().toString());
    }
    
}
