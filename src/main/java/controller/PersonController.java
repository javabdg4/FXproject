package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Person;
import view.PersonView;

public class PersonController {

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> nameCol;

    @FXML
    private TableColumn<Person, String> lastName;

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

    public void setPersonView(PersonView personView) {
        this.personView = personView;
        personTableView.setItems(personView.getPersonList());
    }

    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        lastName.setCellValueFactory(cell -> cell.getValue().lastnameProperty());
        //dodawanie listenera na jednym itemku w liście
        personTableView.getSelectionModel().selectedItemProperty().addListener(
                //można to zrobić lamdą albo klasą anonimową
                //(observable, oldField, newField) -> viewPersonInfoOnLabel(newField)
                new ChangeListener<Person>() {
                    @Override
                    public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
                        viewPersonInfoOnLabel(newValue);
                    }
                }
        );
    }

    public void viewPersonInfoOnLabel(Person person) {
        nameLabel.setText(person.getName());
        lastnameLabel.setText(person.getLastname());
        streetLabel.setText(person.getStreet());
        cityLabel.setText(person.getCity());
        postalCodeLabel.setText(person.getPostalCode());
        telephoneLabel.setText(person.getTelephone());
    }


    public void handleDeleteButton(ActionEvent actionEvent) {
        Person selectPerson = personTableView.getSelectionModel().getSelectedItem();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure MOFO?", ButtonType.YES,ButtonType.NO);
        alert.showAndWait();
        if(alert.getResult() == ButtonType.YES){
            personView.getPersonList().remove(selectPerson);
        }

    }

    public void handleEditButton(ActionEvent actionEvent) {
        //zwraca obiekt ktory kliknelismy
        Person selectPerson = personTableView.getSelectionModel().getSelectedItem();
        //pobiera index kliknietego elementu
        int index = personTableView.getSelectionModel().getFocusedIndex();

        //odniesienie do person view, person view
        personView.loadPersonEdit(selectPerson,index);
    }

    public void handleSaveButton(ActionEvent actionEvent) {
    }

    public void handleNewButton(ActionEvent actionEvent) {
        personView.loadNewPersonView();
    }
}
