import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller class for the reserved resources window.
 * Handles the interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class ReservedResourcesController extends Controller {

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="reservedResourcesTable"
    private TableView<?> reservedResourcesTable; // Value injected by FXMLLoader

    @FXML // fx:id="reservedResourcesColumn"
    private TableColumn<?, ?> reservedResourcesColumn; // Value injected by FXMLLoader

    /**
     * When the user clicks the button he is returned to the dashboard.
     *
     * @param event The button is clicked.
     */
    @FXML
    void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

}