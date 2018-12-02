import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

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
    private TextField addressTextField; // Value injected by FXMLLoader

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

    @FXML // fx:id="closeButton"
    private Button closeButton; // Value injected by FXMLLoader


}