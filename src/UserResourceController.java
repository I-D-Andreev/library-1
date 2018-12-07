import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Controller for the User Resource Window.
 * Handles user interaction with the UI.
 *
 * @author Sian Pike
 */
public class UserResourceController extends Controller {

    @FXML // fx:id="resourceImage"
    private ImageView resourceImage; // Value injected by FXMLLoader

    @FXML // fx:id="copyIdLabel"
    private Label copyIdLabel; // Value injected by FXMLLoader

    @FXML // fx:id="isAvailableLabel"
    private Label isAvailableLabel; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML
    void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/BrowseResources.fxml", event, "Browse Resources - TaweLib", getLibrary());
    }

}