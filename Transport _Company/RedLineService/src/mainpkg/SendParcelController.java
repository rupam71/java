package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SendParcelController implements Initializable {

    @FXML
    private TextField parcelNameTextField;
    @FXML
    private TextField parcelFromTextField;
    @FXML
    private TextField parcelToTextField;
    @FXML
    private TextField dateTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField cusNameTextField;
    @FXML
    private TextField cusIdTextField;
    @FXML
    private Button sendParcelButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendParcelButtonOnClick(ActionEvent event) {
         int customerId;
        String parcelName, from, to, date, customerName;
        float weight;
        
        customerId = Integer.parseInt(cusIdTextField.getText());
      parcelName = parcelNameTextField.getText();   
      from = parcelFromTextField.getText(); 
      to = parcelToTextField.getText();
      date = dateTextField.getText();   
      customerName = cusNameTextField.getText();
      weight = Float.parseFloat(weightTextField.getText());
      
      CourierServiceUser c = new CourierServiceUser();
      c.sendParcel(parcelName,from,to,date,  weight,  customerId,  customerName);
    }
    
}
