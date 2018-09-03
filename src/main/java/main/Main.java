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

    private VBox vBox;
    private Stage stage;
    private PersonView personView;

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        loadView();

    }

    public void loadView() {
        //FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/RootView.fxml"));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/RootView.fxml"));
        try {
            vBox = loader.load();
            Scene scene = new Scene(vBox);
            stage.setScene(scene);
            stage.show();

            PersonController personController = loader.getController();
            PersonView personView = new PersonView();
            personController.setPersonView(personView);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
