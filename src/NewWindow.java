import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Creates a new window.
 *
 * @author Sian Pike
 */

public class NewWindow {

    /**
     * Creates a new window when called.
     *
     * @param fxmlResource The location of the fxml document for the new window.
     * @param event The current event being executed.
     * @param title The title of the window.
     */
    public NewWindow(String fxmlResource, ActionEvent event, String title) {

        Parent root;

        //Attempt to load the fxml file and set the scene.
        try {

            root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlResource));
            Stage stage = new Stage();

            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {

            System.exit(0);

        } catch (Exception e) {

            System.exit(1);
        }
    }


    //for now override
    // might change later
    public NewWindow(String fxmlResource, ActionEvent event, String title, Library library) {

        Parent root;

        //Attempt to load the fxml file and set the scene.
        try {

            //root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlResource));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlResource));
            root = fxmlLoader.load();
            fxmlLoader.<Controller>getController().setLibrary(library);

            Stage stage = new Stage();

            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

            // save data on stage close
            stage.setOnCloseRequest(eventHandler -> {
                library.save();
            });

        } catch (IOException e) {

            e.printStackTrace();
            System.exit(0);

        } catch (Exception e) {

            System.exit(1);
        }
    }

}
