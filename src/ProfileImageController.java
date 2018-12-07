import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controller class for the Profile Image UI.  Handles interactions from the user.
 *
 * @author Sian Pike
 */
public class ProfileImageController extends Controller {

    @FXML // fx:id="imageOneButton"
    private Button imageOneButton; // Value injected by FXMLLoader

    @FXML // fx:id="imageTwoButton"
    private Button imageTwoButton; // Value injected by FXMLLoader

    @FXML // fx:id="imageThreeButton"
    private Button imageThreeButton; // Value injected by FXMLLoader

    @FXML // fx:id="imageFourButton"
    private Button imageFourButton; // Value injected by FXMLLoader

    @FXML // fx:id="imageFiveButton"
    private Button imageFiveButton; // Value injected by FXMLLoader

    @FXML // fx:id="imageSixButton"
    private Button imageSixButton; // Value injected by FXMLLoader

    @FXML // fx:id="imageSevenButton"
    private Button imageSevenButton; // Value injected by FXMLLoader

    @FXML // fx:id="imageEightButton"
    private Button imageEightButton; // Value injected by FXMLLoader

    @FXML // fx:id="imageNineButton"
    private Button imageNineButton; // Value injected by FXMLLoader

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    @FXML
    void cancelButtonClicked(ActionEvent event) {

        if(getLibrary().getCurrentUserLoggedIn().hasAdminAccess()) {

            new NewWindow("resources/ViewUser.fxml", event, "View User - TaweLib", getLibrary());

        } else {

            new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
        }

    }

}