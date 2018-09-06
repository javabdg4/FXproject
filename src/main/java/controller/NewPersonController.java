package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;
import view.PersonView;


public class NewPersonController {


    int indexPersonToEdit;

    boolean flag;

    private PersonView personView;

    public void setPersonView(PersonView personView) {
        this.personView = personView;
    }

    @FXML
    TextField nameTextField;

    @FXML
    TextField lastNameTextField;

    @FXML
    TextField streetTextField;

    @FXML
    TextField cityTextField;

    @FXML
    TextField postalCodeTextField;

    @FXML
    TextField telephoneTextField;


    @FXML
    Button closeButton;

    @FXML
    Button saveButton;

    public void handleSaveButton(ActionEvent actionEvent) {

        Person person = new Person(
                nameTextField.getText(),
                lastNameTextField.getText(),
                streetTextField.getText(),
                cityTextField.getText(),
                postalCodeTextField.getText(),
                telephoneTextField.getText());
        if (flag) {
            personView.getPersonList().add(person);
        }
        if (!flag) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure MOFO?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("asdasdasd");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                personView.getPersonList().set(indexPersonToEdit, person);
            }

        }

        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    public void handleCancelButton(ActionEvent actionEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void setPerson(Person person) {
        nameTextField.setText(person.getName());
        lastNameTextField.setText(person.getLastname());
        streetTextField.setText(person.getStreet());
        cityTextField.setText(person.getCity());
        postalCodeTextField.setText(person.getPostalCode());
        telephoneTextField.setText(person.getTelephone());
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setIndexPersonToEdit(int indexPersonToEdit) {
        this.indexPersonToEdit = indexPersonToEdit;
    }
}
