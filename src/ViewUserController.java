import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Controller class for the View User Window.  Handles user actions when the UI is interacted with.
 *
 * @author Sian Pike
 */

public class ViewUserController extends Controller {

    @FXML // fx:id="searchUserTab"
    private Tab searchUserTab; // Value injected by FXMLLoader

    @FXML // fx:id="searchUserTextField"
    private TextField searchUserTextField; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="createUserTab"
    private Tab createUserTab; // Value injected by FXMLLoader

    @FXML // fx:id="usernameTextField"
    private TextField usernameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="firstNameTextField"
    private TextField firstNameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="surnameTextField"
    private TextField surnameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="phoneNumberTextField"
    private TextField phoneNumberTextField; // Value injected by FXMLLoader

    @FXML // fx:id="addressTextField"
    private TextField addressTextField1; // Value injected by FXMLLoader

    @FXML // fx:id="addressTextField"
    private TextField addressTextField2; // Value injected by FXMLLoader

    @FXML
    private TextField addressCountry; // Value injected by FXMLLoader

    @FXML
    private TextField addressPostcode; // Value injected by FXMLLoader

    @FXML // fx:id="employmentDatePicker"
    private DatePicker employmentDatePicker; // Value injected by FXMLLoader

    @FXML // fx:id="staffNumberTextField"
    private TextField staffNumberTextField; // Value injected by FXMLLoader

    @FXML // fx:id="profileImageButton"
    private Button profileImageButton; // Value injected by FXMLLoader

    @FXML // fx:id="profileImageFileLabel"
    private Label profileImageFileLabel; // Value injected by FXMLLoader

    @FXML // fx:id="addUserButton"
    private Button addUserButton; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    /**
     * Goes back to the librarian dashboard when clicked.
     *
     * @param event The current event.
     */
    @FXML
    void backButtonClicked(ActionEvent event) {

        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

    @FXML
    void searchButtonClicked(ActionEvent event) {
        User user = getLibrary().getUserManager().getUserByUsername(searchUserTextField.getText());
        if(user == null){
            Alert alert = new Alert(Alert.AlertType.ERROR, "A user with username " + searchUserTextField.getText()
                    + " does not exist.",
                    ButtonType.OK);
            alert.show();
        } else {
            String content = "Username: " + user.getUsername() +
                    "\nFirst name: " + user.getFirstName() +
                    "\nLast name: " + user.getLastName() +
                    "\nPhone number: " + user.getPhoneNumber() +
                    "\nAddress:\n" + user.getAddress().toString();
            // display some contact info about the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION,content, ButtonType.OK);
            alert.setTitle("User Information");
            alert.setHeaderText("Contact information");
            alert.show();
        }

    }

}

/*

            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all the required fields.",
                    ButtonType.OK);
            alert.show();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book resource created successfully.",
                    ButtonType.OK);
            alert.show();

 */