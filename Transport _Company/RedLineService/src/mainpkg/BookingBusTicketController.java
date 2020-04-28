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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class BookingBusTicketController implements Initializable {

    @FXML
    private Button checkBusButton;
    @FXML
    private TextField busIdTextField;
    @FXML
    private TextField noOfSeatTextField;
    @FXML
    private Button ticketBookingButton;
    @FXML
    private TextArea outputTextArea;
    @FXML
    private TextField PassengerIdTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void checkBusButtonOnClick(ActionEvent event) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            File f = new File("BusInfo.bin");
            if(!f.exists())
                outputTextArea.setText("File Does Not Exists!!");
            else {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                outputTextArea.setText("");
                try{
                    Bus a;
                    while(true){
                        a = (Bus)ois.readObject();
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
    private void ticketBookingButtonOnClick(ActionEvent event) {
        int passengerId, busId, noOfSeat;
        passengerId = Integer.parseInt(PassengerIdTextField.getText());
        busId = Integer.parseInt(busIdTextField.getText());
        noOfSeat = Integer.parseInt(noOfSeatTextField.getText());
        
        Passenger p = new Passenger();
        p.ticketBooking(busId, passengerId, noOfSeat);
    }
    
}
