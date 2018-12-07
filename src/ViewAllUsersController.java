import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller class for the view all users window.
 * Handles the interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class ViewAllUsersController extends Controller{

    @FXML // fx:id="userTable"
    private TableView<?> userTable; // Value injected by FXMLLoader

    @FXML // fx:id="usernameColumn"
    private TableColumn<?, ?> usernameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="firstNameColumn"
    private TableColumn<?, ?> firstNameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="lastNameColumn"
    private TableColumn<?, ?> lastNameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="phoneNumberColumn"
    private TableColumn<?, ?> phoneNumberColumn; // Value injected by FXMLLoader

    @FXML // fx:id="addressColumn"
    private TableColumn<?, ?> addressColumn; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML
    void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

}