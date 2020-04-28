package fxmlapplicationpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
//import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLMainSceneController implements Initializable {
    
    @FXML private Button addToArrayListBtn;
    @FXML private TextField idTxt;
    @FXML private TextField nameTxt;
    @FXML private TextField cgpaTxt;
    @FXML private Button createFileBtn;
    @FXML private CheckBox isTextFileChkBox;
    @FXML private CheckBox isBintFileChkBox;
    @FXML private Button readFromTextFileBtn;
    @FXML private Button readFromBinFileBtn;
    @FXML private TextArea outputTxtArea;
    @FXML private ComboBox deptComboBox;
    @FXML private Label deptLabel;
    
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;
    
    ArrayList<Student> studArr = new ArrayList<Student>();
    @FXML private Button showArrayListBtn;
    @FXML private Button goToScene2Button;
    @FXML private Button goToStage2Button;
       
    //instance variables to create new Person
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private DatePicker birthdayDatePicker;
    @FXML
    private Button addNewPersonButton;
    @FXML
    private Button detailedPersonViewButton;
    @FXML
    private Button deletePersonsButton;
    
    
    
    
    @FXML
    public void deptComboBoxIsUpdated(){
        this.deptLabel.setText("Selected Dept is: "+ deptComboBox.getValue().toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deptLabel.setText("Selected Dept is: PS");
        deptComboBox.getItems().add("CSE");
        deptComboBox.getItems().addAll("EEE","PS","ECN");
        deptComboBox.setValue("PS");        

        //set up the columns in the table
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person,String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person,LocalDate>("birthday"));
        
        //load dummy data
        tableView.setItems(getPeople());    
        
        //Allow first and last name to be edittable
        tableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    
    
    //create a new Person Object instance and add it to the table
    @FXML
    public void addNewPersonButtonOnClick(){
        Person newPerson = new Person(firstNameTextField.getText(),
                                       lastNameTextField.getText(),
                                       birthdayDatePicker.getValue()
                                    );
        tableView.getItems().add(newPerson);
        
    }

    public ObservableList<Person> getPeople(){
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Ahsan", "Habib", LocalDate.of(1998, Month.AUGUST, 12)));
        people.add(new Person("Lisa", "Rahman", LocalDate.of(2000, Month.JUNE, 30)));
        people.add(new Person("Farid", "Uddin", LocalDate.of(2001, Month.APRIL, 17)));
        return people;
    } 
    
    //updating first name by clicking a corresponding table cell
    @FXML
    public void changeFirstNameCellEvent(CellEditEvent edittedCell){
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setFirstName(edittedCell.getNewValue().toString());
    }
    
    //updating last name by clicking a corresponding table cell
    @FXML
    public void changeLasttNameCellEvent(CellEditEvent edittedCell){
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setLastName(edittedCell.getNewValue().toString());
    }
    
    @FXML
    private void addToArrayListBtnOnClick(ActionEvent event) {
        studArr.add(
            new Student(  
                    Integer.parseInt(idTxt.getText()),
                    nameTxt.getText(),
                    Float.parseFloat(cgpaTxt.getText())  
                )
        );
    }

    @FXML
    private void createFileBtnOnClick(ActionEvent event) {
        if(isTextFileChkBox.isSelected()){
            //write code to dump studArr in Stud.txt
            //use FileWriter OR BufferedWriter
        }
        if(isBintFileChkBox.isSelected()){
            //write code to dump studArr in Stud.bin
            //use ObjectOutputStream
        }
    }

    @FXML
    private void readFromTextFileBtnOnClick(ActionEvent event) {
        //use BufferedReader OR Scanner
        File file = new File("Stud.txt");
        Scanner sc; String str=null;
        try {
            sc = new Scanner(file);
            outputTxtArea.setText(null);
            while(sc.hasNextLine()){
                str=sc.nextLine();
                outputTxtArea.appendText(str+"\n");
                //outputTxtArea.appendText("\n");               
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLMainSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @FXML
    private void readFromBinFileBtnOnClick(ActionEvent event) {
        //use ObjectInputStream
         try {
             Student s;
             ObjectInputStream in = new ObjectInputStream(
                 new FileInputStream("Stud.bin")
             );
            outputTxtArea.setText(null);
            while(true){
                s = (Student) in.readObject();
                outputTxtArea.appendText(s.toString()+"\n");
            }
        } catch (Exception ex) {
            Logger.getLogger(FXMLMainSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void idTxtOnMouseClick(MouseEvent event) {
        idTxt.setText(null);
    }

    @FXML
    private void nameTxtOnMouseClick(MouseEvent event) {
        nameTxt.setText(null);
    }

    @FXML
    private void cgpaTxtOnMouseClick(MouseEvent event) {
        cgpaTxt.setText(null);
    }

    @FXML
    private void showArrayListBtnOnClick(ActionEvent event) {
        for(Student s: studArr) s.display();
    }

    @FXML
    private void goToScene2ButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }

    @FXML
    private void goToStage2ButtonOnClick(ActionEvent event) throws IOException{
        Parent fileChooserViewParent = FXMLLoader.load(getClass().getResource("FileChooserView.fxml"));
        Scene fileChooserViewScene = new Scene(fileChooserViewParent);
        //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage window  = new Stage();
        
        window.setTitle("File Chooser Test Stage");
        window.setScene(fileChooserViewScene);
        window.show();
    }
    
    //pass selected row to detailed person view scene
    @FXML
    private void detailedPersonViewButtonOnClick(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PersonViewScene.fxml"));
        Parent personViewParent = loader.load();
        
        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
        Scene personViewScene = new Scene(personViewParent);
        
        //access the controller
        PersonViewSceneController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
    }

    @FXML
    private void deletePersonsButtonOnClick(ActionEvent event) {
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        
        for(Person p: selectedRows){
            allPeople.remove(p);
        }
    }
}
