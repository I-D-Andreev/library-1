import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller class for the requested resources window.
 * Handles the interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class RequestedResourcesController extends Controller {

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="requestedResourcesTable"
    private TableView<?> requestedResourcesTable; // Value injected by FXMLLoader

    @FXML // fx:id="requestedResourcesColumn"
    private TableColumn<?, ?> requestedResourcesColumn; // Value injected by FXMLLoader

    @FXML
    void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

}
