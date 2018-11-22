import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class Main extends Application {

    public static void main(String[] args) {
        //System.out.println("Hello world");
        Address ad1 = new Address("Bay Campus, Fabian Way, Crymlyn Burrows", "Swansea", "UK", "SA1 8EP");
        Address ad2 = new Address("Bay Campus, Fabian Way", "Crymlyn Burrows", "Swansea", "UK", "SA1 8EP");

        System.out.println(ad1.toString());
        System.out.println("--------");
        System.out.println(ad2);

        Date d = new Date();
        System.out.println(d);

        launch(args);
    }

    /**
     * Initialises and shows the login window.
     *
     * @param primaryStage The current window.
     */
    public void start(Stage primaryStage) {

        Parent root = null;

        try {

            root = FXMLLoader.load(getClass().getClassLoader().getResource("Login.fxml"));

        } catch (IOException e) {
            //Changing later
            e.printStackTrace();
        }

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("TaweLib - Login");
        primaryStage.show();
    }
}