import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller class for the users currently borrowing window.
 * Handles the interaction between the user and the UI.
 *
 * @author Sian Pike
 */
public class UsersBorrowingController extends Controller {

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="usersBorrowingTable"
    private TableView<?> usersBorrowingTable; // Value injected by FXMLLoader

    @FXML // fx:id="usersBorrowingColumn"
    private TableColumn<?, ?> usersBorrowingColumn; // Value injected by FXMLLoader

    /**
     * Takes the user to the dashboard tab when the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

}