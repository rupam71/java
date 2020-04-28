/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.stage.FileChooser;


/**
 * FXML Controller class
 *
 * @author USER
 */
public class AllComplainController implements Initializable {

    @FXML
    private TextArea outputTextArea;
    @FXML
    private Button allComplainButton;
    @FXML
    private Button openFromAButton;

    ArrayList<String> fileTypeList;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileTypeList = new  ArrayList<String>();
        fileTypeList.add("*.txt");
        fileTypeList.add("*.doc");
        fileTypeList.add("*.docx");
        fileTypeList.add("*.TXT");
        fileTypeList.add("*.DOC");
        fileTypeList.add("*.DOCX");
    }    

    @FXML
    private void outputTextAreaOnClick(MouseEvent event) {
        outputTextArea.setText("");
    }

    @FXML
    private void allComplainButtonOnClick(ActionEvent event) {
        File f = null;
        try {
            f = new File("Complain.txt");
            Scanner s2 = new Scanner(f);
            
            while(s2.hasNextLine()){
            String line = s2.nextLine();
            String[] lineTokens = line.split("\n");
            
            for (int i=0; i<lineTokens.length; i++){
                System.out.println(lineTokens[i]+"\n"); //not needed. Just use for check.
                outputTextArea.appendText(lineTokens[i]+"\n");
            }
            }
        }  catch (IOException ex) {   
            System.out.println(ex);
        } 
       

    }

    @FXML
    private void openFromAButtonOnClick(ActionEvent event) {
        //open multiple file
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", fileTypeList));
        List<File> files = fc.showOpenMultipleDialog(null);
        String str = "";
        for (File f: files){
            if( f!=null ){
                try{
                    Scanner s = new Scanner(f);
                    while(s.hasNextLine()){
                    str += s.nextLine()+"\n";
                    }
                    str += "\n";
                } catch (FileNotFoundException ex){System.out.println(ex);}
            }
        }
        outputTextArea.setText(str);

        





            
        
    }
    }
    

