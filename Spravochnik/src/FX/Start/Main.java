package FX.Start;

import FX.Control.MainController;
import FX.Object.Collection;
import FX.Object.Lang;
import FX.Utils.Local1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class Main extends Application implements Observer {
    private FXMLLoader Loader;
    private Parent root;
    private MainController ob;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("../fxml/Main.fxml"));
        Loader.setResources(ResourceBundle.getBundle("FX.bundle.Locale", Local1.RU));
        root = Loader.load();
        ob = Loader.getController();
        ob.addObserver(this);
        ob.setstage(primaryStage);

        primaryStage.setTitle(Loader.getResources().getString("phonebook"));
        primaryStage.setMinHeight(550);
        primaryStage.setMinWidth(430);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void update(Observable o, Object arg) {
        Lang lan = (Lang) arg;
        Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("../fxml/Main.fxml"));
        Loader.setResources(ResourceBundle.getBundle("FX.bundle.Locale", lan.getLocale()));
        GridPane node = null;
        stage.setTitle(Loader.getResources().getString("phonebook"));
        try {
            node = (GridPane) Loader.load();
            ob = Loader.getController();
            ob.addObserver(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GridPane current = (GridPane) root;
        current.getChildren().setAll(node.getChildren());

    }
}
