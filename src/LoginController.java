import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Chris McAuley, Sian Pike
 *
 * Controller class for the Login Window.  Handles user interaction with the UI.
 */
public class LoginController {

    private User user1 = new NormalUser("Sian", "Pike", "sianspike",
            "07813931066", "", new Address("14 Bryn Y Mor Crescent",
            "Swansea", "Wales", "SA14QT"));
    private User user2 = new Librarian("Joe", "Bloggs", "librarian1",
            "12345678", "", new Address("Somewhere", "Cardiff", "Wales",
            "AB12CD"));

    @FXML // fx:id="usernameTextField"
    private TextField usernameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader


    @FXML
    /**
     * When the login button is clicked, this method retrieves the text from the usernameTextField and checks
     * whether the user exists.
     */
    private void loginButtonClicked(ActionEvent event) {

        UserManager userManager = new UserManager();
        userManager.addUser(user1);
        userManager.addUser(user2);
        User existingUser = exists(usernameTextField.getText(), userManager.getAllUsers());

        //Checks whether the user exists.
        if (existingUser != null) {

            //Checks whether the user is a librarian.
            if (existingUser.hasAdminAccess()) {

                new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib");
                //loadDashboard("resources/LibrarianDashboard.fxml", event);

            } else {

                new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib");
                //loadDashboard("resources/UserDashboard.fxml", event);
            }
        }
    }

    /**
     * Checks whether a user exists in an array of users.
     *
     * @param usernameText The username input in the text field.
     * @param userList The array of users.
     * @return The user if it exists or null.
     */
    private User exists(String usernameText, ArrayList<User> userList) {

        usernameText = usernameText.toLowerCase();

        for (User user : userList) {

            if (user.getUsername().toLowerCase().equals(usernameText)) {

                return user;

            }
        }

        return null;
    }
}
