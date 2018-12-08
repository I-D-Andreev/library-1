import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Controller class for the Profile Image UI.  Handles interactions from the user.
 *
 * @author Sian Pike
 */
public class ProfileImageController extends Controller {

    private String filePath;

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
    private void initialize() {

        imageOneButton.setGraphic(new ImageView("resources/avatar1.png"));
        imageOneButton.setText("");

        imageTwoButton.setGraphic(new ImageView("resources/avatar2.png"));
        imageTwoButton.setText("");

        imageThreeButton.setGraphic(new ImageView("resources/avatar3.png"));
        imageThreeButton.setText("");

        imageFourButton.setGraphic(new ImageView("resources/avatar4.png"));
        imageFourButton.setText("");

        imageFiveButton.setGraphic(new ImageView("resources/avatar5.png"));
        imageFiveButton.setText("");

        imageSixButton.setGraphic(new ImageView("resources/avatar6.png"));
        imageSixButton.setText("");

        imageSevenButton.setGraphic(new ImageView("resources/avatar7.png"));
        imageSevenButton.setText("");

        imageEightButton.setGraphic(new ImageView("resources/avatar8.png"));
        imageEightButton.setText("");

        imageNineButton.setGraphic(new ImageView("resources/avatar9.png"));
        imageNineButton.setText("");
    }

    @FXML
    void cancelButtonClicked(ActionEvent event) {

        if (getLibrary().getCurrentUserLoggedIn().hasAdminAccess()) {

            new NewWindow("resources/ViewUser.fxml", event, "View User - TaweLib", getLibrary());

        } else {

            new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
        }

    }

    @FXML
    void imageEightButtonClicked(ActionEvent event) {

    }

    @FXML
    void imageFiveButtonClicked(ActionEvent event) {

    }

    @FXML
    void imageFourButtonClicked(ActionEvent event) {

    }

    @FXML
    void imageNineButtonClicked(ActionEvent event) {

    }

    @FXML
    void imageOneButtonClicked(ActionEvent event) {

        new NewWindow("resources/ViewUser.fxml", event, "View User - TaweLib", getLibrary());
    }

    @FXML
    void imageSevenButtonClicked(ActionEvent event) {

    }

    @FXML
    void imageSixButtonClicked(ActionEvent event) {

    }

    @FXML
    void imageThreeButtonClicked(ActionEvent event) {

    }

    @FXML
    void imageTwoButtonClicked(ActionEvent event) {

    }

    public String getFilePath() {

        return filePath;
    }

    public void setFilePath(String filePath) {

        this.filePath = filePath;
    }
}