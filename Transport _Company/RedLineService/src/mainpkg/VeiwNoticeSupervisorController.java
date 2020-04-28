/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class VeiwNoticeSupervisorController implements Initializable {

    @FXML
    private Label senderField;
    @FXML
    private TextArea noticeTextArea;
    @FXML
    private Button showNoticeButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showNoticeButtonOnClick(ActionEvent event) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        try{
            File f = new File("notice.bin");
            if(!f.exists())
                System.out.println("OOPS!! File not Found...");
            else{
                fis = new FileInputStream(f);
                bis = new BufferedInputStream(fis);
                dis = new DataInputStream(bis);
                
                String str = "";
                while(true){
                    str += "Notice:: " + dis.readUTF()+" \n";
                    noticeTextArea.appendText(str);
                    str="";
                }
            }
        } catch (IOException ex) {   
            System.out.println(ex);
        } 
        
        finally{
            try{
                if(dis!=null) dis.close();
            } catch (IOException ex) {   
            System.out.println(ex);
        }
        }
    }
    
    
}
