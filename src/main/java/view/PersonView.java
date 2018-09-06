package view;

import controller.NewPersonController;
import controller.PersonController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Main;
import model.Person;

import java.io.IOException;

public class PersonView {

    private VBox vBox;
    private Stage stage;
    private ObservableList<Person> personList = FXCollections.observableArrayList();


    public PersonView(Stage stage) {
        this.stage = stage;
        personList.add(new Person("asdf1", "aaa", "aaa", "aaa", "aaa", "aaa"));
        personList.add(new Person("asdf2", "bbb", "bbb", "bbb", "bbb", "bbb"));
        personList.add(new Person("asdf3", "ccc", "ccc", "ccc", "ccc", "ccc"));
        personList.add(new Person("asdf4", "ddd", "ddd", "ddd", "ddd", "ddd"));
        personList.add(new Person("asdf5", "eee", "eee", "eee", "eee", "eee"));
        personList.add(new Person("asdf6", "fff", "fff", "fff", "fff", "fff"));
        personList.add(new Person("asdf7", "ggg", "ggg", "ggg", "ggg", "ggg"));
        personList.add(new Person("asdf8", "hhh", "hhh", "hhh", "hhh", "hhh"));

    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public PersonView() {
    }

    public void loadView() {
        //FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/RootView.fxml"));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/RootView.fxml"));
        try {
            vBox = loader.load();
            Scene scene = new Scene(vBox);
            stage.setTitle("Aplikacja testowa");
            stage.setScene(scene);
            stage.show();

            PersonController personController = loader.getController();
            personController.setPersonView(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadNewPersonView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/AddNewPersonView.fxml"));
        VBox newPersonView = null;
        try {
            newPersonView = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        NewPersonController newPersonController = loader.getController();
        newPersonController.setPersonView(this);

        newPersonController.setFlag(true);

        Stage newPersonStage = new Stage();
        Scene newPersonScene = new Scene(newPersonView);
        newPersonStage.setScene(newPersonScene);
        newPersonStage.setTitle("Dodaj pracownika");
        newPersonStage.show();

    }
//
    public void loadPersonEdit(Person person, int index) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/AddNewPersonView.fxml"));
        VBox newPersonView = null;
        try {
            newPersonView = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        NewPersonController newPersonController = loader.getController();
        newPersonController.setPersonView(this);
        newPersonController.setPerson(person);

        newPersonController.setFlag(false);
        newPersonController.setIndexPersonToEdit(index);

        Stage newPersonStage = new Stage();
        Scene newPersonScene = new Scene(newPersonView);
        newPersonStage.setScene(newPersonScene);
        newPersonStage.setTitle("Dodaj pracownika");
        newPersonStage.show();

    }


}
