import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Main extends Application {

    public static void main(String[] args) {
        //Launches the application - do not remove.
        launch(args);


//        Library l = new Library();
//        l.save();

        System.exit(0);
    }

    /**
     * Initialises and shows the login window.
     *
     * @param primaryStage The current window.
     */
    public void start(Stage primaryStage) {
        // window size constraints
        final int windowHeight = 600;
        final int windowWidth = 700;

        // load the library info
        Library library = new Library();
        Parent root = null;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("resources/Login.fxml"));
            root = fxmlLoader.load();
            fxmlLoader.<Controller>getController().setLibrary(library);


        } catch (IOException e) {

            System.exit(1);

        } catch (Exception e) {

            e.printStackTrace();
            System.exit(0);
        }

        primaryStage.setMinHeight(windowHeight);
        primaryStage.setMaxHeight(windowHeight);
        primaryStage.setMinWidth(windowWidth);
        primaryStage.setMaxWidth(windowWidth);

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("TaweLib - Login");
        primaryStage.show();
    }
}
