package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Person;
import view.PersonView;

public class PersonController {

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person,String> nameCol;

    @FXML
    private TableColumn<Person,String> lastName;

    @FXML
    private Label nameLabel;

    @FXML
    private Label lastnameLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label telephoneLabel;

    private PersonView personView;

    public void setPersonView(PersonView personView){
        this.personView = personView;
        personTableView.setItems(personView.getPersonList());
    }

    @FXML
    public void initialize(){
        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        lastName.setCellValueFactory(cell -> cell.getValue().lastnameProperty());
    }


}
