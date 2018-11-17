import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller class for the User Dashboard.
 * Handles what happens when the user interacts with the UI.
 * @author Sian Pike
 */

public class UserDashboardController {

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

}