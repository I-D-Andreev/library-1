import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller class for the borrowed resources window.
 * Handles the interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class BorrowedResourcesController extends Controller {

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="borrowedResourcesTable"
    private TableView<?> borrowedResourcesTable; // Value injected by FXMLLoader

    @FXML // fx:id="borrowedResourcesColumn"
    private TableColumn<?, ?> borrowedResourcesColumn; // Value injected by FXMLLoader

    @FXML
    void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

}
