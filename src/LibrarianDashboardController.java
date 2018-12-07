
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller class for the Librarian Dashboard.
 * Handles what happens when the user interacts with the UI.
 * @author Sian Pike
 */

public class LibrarianDashboardController extends Controller {

    @FXML // fx:id="logOutButton"
    private Button logOutButton; // Value injected by FXMLLoader

    @FXML // fx:id="manageResourcesButton"
    private Button manageResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="createEditResourcesButton"
    private Button createEditResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="browseResourcesButton"
    private Button browseResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="viewUserButton"
    private Button viewUserButton; // Value injected by FXMLLoader

    @FXML // fx:id="userButton"
    private Button userButton; // Value injected by FXMLLoader

    @FXML // fx:id="overdueResourcesButton"
    private Button overdueResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="copyHistoryButton"
    private Button copyHistoryButton; // Value injected by FXMLLoader

    @FXML
    private Button editAccountButton;


    @FXML
    /**
     * Opens the browse resources window.
     */
    public void browseButtonClicked(ActionEvent event) {

        new NewWindow("resources/BrowseResources.fxml", event,
                "Browse Resources - TaweLib", getLibrary());
    }

    public void editAccountButtonClicked(ActionEvent event) {
        new NewWindow("resources/EditAccount.fxml", event,
                "Browse Resources - TaweLib", getLibrary());
    }

    @FXML
    /**
     * Opens the create/edit resources window.
     */
    public void createEditButtonClicked(ActionEvent event) {

        new NewWindow("resources/CreateEdit.fxml", event,
                "Create/Edit Resources - TaweLib", getLibrary());
    }

    @FXML
    /**
     * Takes the user back to the login window.
     */
    public void logOutButtonClicked(ActionEvent event) {

        new NewWindow("resources/Login.fxml", event,
                "Login - TaweLib", getLibrary());
    }

    @FXML
    /**
     * Opens the manage resources window.
     */
    public void manageResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/ManageResources.fxml", event, "Manage Resources - TaweLib",
                getLibrary());
    }

    @FXML
    /**
     * Opens the view user window.
     */
    public void viewUserButtonClicked(ActionEvent event) {

        new NewWindow("resources/ViewUser.fxml", event, "Manage Resources - TaweLib",
                getLibrary());
    }


    @FXML
    public void copyHistoryButtonClicked(ActionEvent event) {

    }


    @FXML
    public void overdueResourcesButtonClicked(ActionEvent event) {

    }

    @FXML
    public void userButtonClicked(ActionEvent event) {

    }
}
