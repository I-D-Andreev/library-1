import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller class for the overdue resources window.
 * Handles the interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class OverdueResourcesController extends Controller {

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="overdueResourcesTable"
    private TableView<?> overdueResourcesTable; // Value injected by FXMLLoader

    @FXML // fx:id="overdueResourcesColumn"
    private TableColumn<?, ?> overdueResourcesColumn; // Value injected by FXMLLoader

    /**
     * When the button is clicked the user is returned to the main dashboard.
     *
     * @param event The button is clicked.
     */
    @FXML
    void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

}
