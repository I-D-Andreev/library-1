import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller class for the Overdue Copies window.
 * Handles user interaction with the UI.
 *
 * @author Sian Pike
 */
public class OverdueCopiesController extends Controller {

    @FXML // fx:id="overdueCopiesTable"
    private TableView<?> overdueCopiesTable; // Value injected by FXMLLoader

    @FXML // fx:id="overdueCopiesColumn"
    private TableColumn<?, ?> overdueCopiesColumn; // Value injected by FXMLLoader

    @FXML // fx:id="daysOverdueColumn"
    private TableColumn<?, ?> daysOverdueColumn; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    /**
     * When the button is clicked the user is returned to the main dashboard.
     *
     * @param event The button is clicked.
     */
    @FXML
    void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

}
