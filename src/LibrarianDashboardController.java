
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

    @FXML // fx:id="dashboardTable"
    private TableView<?> dashboardTable; // Value injected by FXMLLoader

    @FXML // fx:id="userColumn"
    private TableColumn<?, ?> userColumn; // Value injected by FXMLLoader

    @FXML // fx:id="borrowedColumn"
    private TableColumn<?, ?> borrowedColumn; // Value injected by FXMLLoader

    @FXML // fx:id="requestedColumn"
    private TableColumn<?, ?> requestedColumn; // Value injected by FXMLLoader

    @FXML // fx:id="reservedColumn"
    private TableColumn<?, ?> reservedColumn; // Value injected by FXMLLoader

    @FXML // fx:id="overdueColumn"
    private TableColumn<?, ?> overdueColumn; // Value injected by FXMLLoader

    @FXML // fx:id="transHistoryColumn"
    private TableColumn<?, ?> transHistoryColumn; // Value injected by FXMLLoader

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

    @FXML
    /**
     * Opens the browse resources window.
     */
    void browseButtonClicked(ActionEvent event) {

        new NewWindow("resources/BrowseResources.fxml", event, "Browse Resources - TaweLib");
    }

    @FXML
    /**
     * Opens the create/edit resources window.
     */
    void createEditButtonClicked(ActionEvent event) {

        new NewWindow("resources/CreateEdit.fxml", event, "Create/Edit Resources - TaweLib");
    }

    @FXML
    /**
     * Takes the user back to the login window.
     */
    void logOutButtonClicked(ActionEvent event) {

        new NewWindow("resources/Login.fxml", event, "Login - TaweLib");
    }

    @FXML
    /**
     * Opens the manage resources window.
     */
    void manageResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/ManageResources.fxml", event, "Manage Resources - TaweLib");
    }

    @FXML
    /**
     * Opens the view user window.
     */
    void viewUserButtonClicked(ActionEvent event) {

        new NewWindow("resources/ViewUser.fxml", event, "View User - TaweLib");
    }
}
