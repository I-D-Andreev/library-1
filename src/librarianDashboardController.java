/**
 * @author Sian Pike
 *
 * Controller class for the librarian dashboard - this is where the events are handled after user interaction
 * with the UI.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class librarianDashboardController {

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
}
