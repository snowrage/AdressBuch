package adressbuch;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class ViewController
    implements Initializable {

    @FXML //  fx:id="emailEdit"
    private TextField emailEdit; // Value injected by FXMLLoader

    @FXML //  fx:id="firstNameColumn"
    private TableColumn<Person, String> firstNameColumn; // Value injected by FXMLLoader

    @FXML //  fx:id="firstNameEdit"
    private TextField firstNameEdit; // Value injected by FXMLLoader

    @FXML //  fx:id="mailColumn"
    private TableColumn<Person, String> mailColumn; // Value injected by FXMLLoader

    @FXML //  fx:id="nameColumn"
    private TableColumn<Person, String> nameColumn; // Value injected by FXMLLoader

    @FXML //  fx:id="nameEdit"
    private TextField nameEdit; // Value injected by FXMLLoader

    @FXML //  fx:id="table"
    private TableView<?> table; // Value injected by FXMLLoader


    // Handler for Button[Button[id=null, styleClass=button]] onMouseClicked
    public void deleteButtonClicked(MouseEvent event) {
        table.getItems().remove(table.getSelectionModel().getSelectedItem());
    }

    // Handler for Button[Button[id=null, styleClass=button]] onMouseClicked
    public void newButtonClicked(MouseEvent event) {
        ObservableList<Person> data = (ObservableList<Person>) table.getItems();
        data.add(new Person(firstNameEdit.getText(),
            nameEdit.getText(),
            emailEdit.getText()
        ));
        
        firstNameEdit.setText("");
        nameEdit.setText("");
        emailEdit.setText(""); 
    }

    // Handler for Button[Button[id=null, styleClass=button]] onMouseClicked
    public void saveButtonClicked(MouseEvent event) {
        // handle the event here
    }

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert emailEdit != null : "fx:id=\"emailEdit\" was not injected: check your FXML file 'View.fxml'.";
        assert firstNameColumn != null : "fx:id=\"firstNameColumn\" was not injected: check your FXML file 'View.fxml'.";
        assert firstNameEdit != null : "fx:id=\"firstNameEdit\" was not injected: check your FXML file 'View.fxml'.";
        assert mailColumn != null : "fx:id=\"mailColumn\" was not injected: check your FXML file 'View.fxml'.";
        assert nameColumn != null : "fx:id=\"nameColumn\" was not injected: check your FXML file 'View.fxml'.";
        assert nameEdit != null : "fx:id=\"nameEdit\" was not injected: check your FXML file 'View.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'View.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected
        firstNameColumn.setCellValueFactory(
            new PropertyValueFactory<Person,String>("firstName")
        );
        nameColumn.setCellValueFactory(
            new PropertyValueFactory<Person,String>("lastName")
        );
        mailColumn.setCellValueFactory(
            new PropertyValueFactory<Person,String>("email")
        );
    }

}

