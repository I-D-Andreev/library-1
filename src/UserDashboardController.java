import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for the User Dashboard.
 * Handles what happens when the user interacts with the UI.
 * @author Sian Pike
 */

public class UserDashboardController extends Controller {

    @FXML // fx:id="browseResourcesButton"
    private Button browseResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="logOutButton"
    private Button logOutButton; // Value injected by FXMLLoader

    @FXML // fx:id="dashboardTable"
    private TableView<?> dashboardTable; // Value injected by FXMLLoader

    @FXML // fx:id="borrowedResourcesColumn"
    private TableColumn<?, ?> borrowedResourcesColumn; // Value injected by FXMLLoader

    @FXML // fx:id="requestedResourcesColumn"
    private TableColumn<?, ?> requestedResourcesColumn; // Value injected by FXMLLoader

    @FXML // fx:id="reservedResourcesColumn"
    private TableColumn<?, ?> reservedResourcesColumn; // Value injected by FXMLLoader

    @FXML // fx:id="overdueResourcesColumn"
    private TableColumn<?, ?> overdueResourcesColumn; // Value injected by FXMLLoader

    @FXML // fx:id="transactionHistoryColumn"
    private TableColumn<?, ?> transactionHistoryColumn; // Value injected by FXMLLoader

    @FXML
    /**
     * Opens the browse resources window.
     */
    void browseResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/BrowseResources.fxml", event, "Browse Resources - TaweLib");

    }

    @FXML
    /**
     * Takes the user back to the login screen.
     */
    void logOutButtonClicked(ActionEvent event) {

        new NewWindow("resources/Login.fxml", event, "Login - TaweLib");
    }
}