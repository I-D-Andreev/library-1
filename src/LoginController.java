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
    private ArrayList<User> userList = new ArrayList<User>();

    @FXML // fx:id="usernameTextField"
    private TextField usernameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button loginButton; // Value injected by FXMLLoader


    @FXML
    private void loginButtonClicked(ActionEvent event) {

        Parent root;
        userList.add(user1);
        userList.add(user2);

        if (equals(usernameTextField.getText(), userList)) {

            try {
                
                root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/UserDashboard.fxml"));
                Stage stage = new Stage();
                
                stage.setTitle("Dashboard");
                stage.setScene(new Scene(root));
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();

            } catch (IOException e) {

                //Changing later
                e.printStackTrace();

            } catch(Exception e) {

                e.printStackTrace();
                System.exit(0);
            }
        }
    }

    private Boolean equals(String usernameText, ArrayList<User> userList) {

        Boolean exists = false;
        usernameText = usernameText.toLowerCase();

        for (User user : userList) {

            if (user.getUsername().toLowerCase().equals(usernameText)) {

                exists = true;

            }
        }

        return exists;
    }
}
