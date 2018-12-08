import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller for the copy history window.
 * Handles the interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class CopyHistoryController extends Controller{

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="copyHistoryTable"
    private TableView<?> copyHistoryTable; // Value injected by FXMLLoader

    @FXML // fx:id="copyHistoryColumn"
    private TableColumn<?, ?> copyHistoryColumn; // Value injected by FXMLLoader

    @FXML
    void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

}
