import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controller class for the transaction history window.
 * Handles the interaction between the user and the UI.
 *
 * @author Sian Pike
 */
public class TransactionHistoryController extends Controller {

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="transactionHistoryTable"
    private TableView<?> transactionHistoryTable; // Value injected by FXMLLoader

    @FXML // fx:id="transactionHistoryColumn"
    private TableColumn<?, ?> transactionHistoryColumn; // Value injected by FXMLLoader

    /**
     * Returns the user back to the dashboard when the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

}