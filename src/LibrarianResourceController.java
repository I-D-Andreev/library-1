import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

/**
 * Controller class for the librarian resource window.
 * Handles interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class LibrarianResourceController extends Controller {

    @FXML // fx:id="resourceImage"
    private ImageView resourceImage; // Value injected by FXMLLoader

    @FXML // fx:id="borrowedByLabel"
    private Label borrowedByLabel; // Value injected by FXMLLoader

    @FXML // fx:id="dueDateLabel"
    private Label dueDateLabel; // Value injected by FXMLLoader

    @FXML // fx:id="copyHistoryTable"
    private TableView<?> copyHistoryTable; // Value injected by FXMLLoader

    @FXML // fx:id="copyHistoryColumn"
    private TableColumn<?, ?> copyHistoryColumn; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML
    void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/BrowseResources.fxml", event, "Librarian Copy View", getLibrary());
    }

}