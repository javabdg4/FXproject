package main;

import controller.PersonController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Person;
import view.PersonView;
import java.io.IOException;

public class Main extends Application {

    private Stage stage;
    private PersonView personView;

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        personView = new PersonView(this.stage);
        personView.loadView();

    }
}
