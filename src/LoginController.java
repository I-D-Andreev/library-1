import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Chris McAuley, Sian Pike
 * <p>
 * Controller class for the Login Window.  Handles user interaction with the UI.
 */
public class LoginController extends Controller {


    @FXML // fx:id="usernameTextField"
    private TextField usernameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader


  //  private Library library = new Library();


    @FXML
    /**
     * When the login button is clicked, this method retrieves the text from the usernameTextField and checks
     * whether the user exists.
     */
    private void loginButtonClicked(ActionEvent event) {
        String username = usernameTextField.getText();
        User existingUser = getLibrary().getUserManager().getUserByUsername(username);

        //Checks whether the user exists.
        if (existingUser == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Username " + username + " doesn't exist.",
                    ButtonType.OK);
            alert.show();
        } else {

            //Checks whether the user is a librarian.
            if (existingUser.hasAdminAccess()) {

                new NewWindow("resources/LibrarianDashboard.fxml", event,
                        "Dashboard - TaweLib", getLibrary());
                //loadDashboard("resources/LibrarianDashboard.fxml", event);

            } else {

                new NewWindow("resources/UserDashboard.fxml", event,
                        "Dashboard - TaweLib", getLibrary());
                //loadDashboard("resources/UserDashboard.fxml", event);
            }
        }

    }


}
