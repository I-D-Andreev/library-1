import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Main extends Application {

    public static void main(String[] args) {
        //Launches the application - do not remove.
        launch(args);

//        Date today = new Date();
//        System.out.println(today);
//        today.setTime(today.getTime() + (3600*24*1000));
//        System.out.println(today);
    }

    /**
     * Initialises and shows the login window.
     *
     * @param primaryStage The current window.
     */
    public void start(Stage primaryStage) {

        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/Login.fxml"));

        } catch (IOException e) {
            //Changing later
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
        }


        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("TaweLib - Login");
        primaryStage.show();

        // something might need to be closed here

    }
}