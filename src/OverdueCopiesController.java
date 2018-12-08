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
public class OverdueCopiesController extends Controller{

    @FXML
    private TableView<TableRepresentationCopyInformation> overdueCopiesTable;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> copyIDColumn;


    @FXML
    public void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

}
