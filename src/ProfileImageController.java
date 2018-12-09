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

    /**
     * The path where the file of the image is located.
     */
    private String filePath;

    /**
     * The button for the first image.
     */
    @FXML // fx:id="imageOneButton"
    private Button imageOneButton; // Value injected by FXMLLoader

    /**
     * The button for the second image.
     */
    @FXML // fx:id="imageTwoButton"
    private Button imageTwoButton; // Value injected by FXMLLoader

    /**
     * The button for the third image.
     */
    @FXML // fx:id="imageThreeButton"
    private Button imageThreeButton; // Value injected by FXMLLoader

    /**
     * The button for the fourth image.
     */
    @FXML // fx:id="imageFourButton"
    private Button imageFourButton; // Value injected by FXMLLoader

    /**
     * The button for the fifth image.
     */
    @FXML // fx:id="imageFiveButton"
    private Button imageFiveButton; // Value injected by FXMLLoader

    /**
     * The button for the sixth image.
     */
    @FXML // fx:id="imageSixButton"
    private Button imageSixButton; // Value injected by FXMLLoader

    /**
     * The button for the seventh image.
     */
    @FXML // fx:id="imageSevenButton"
    private Button imageSevenButton; // Value injected by FXMLLoader

    /**
     * The button for the eighth image.
     */
    @FXML // fx:id="imageEightButton"
    private Button imageEightButton; // Value injected by FXMLLoader

    /**
     * The button for the ninth image.
     */
    @FXML // fx:id="imageNineButton"
    private Button imageNineButton; // Value injected by FXMLLoader

    /**
     * Button to cancel current action.
     */
    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    /**
     * Initializes the images for the user to select.
     */
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

    /**
     * Returns user to the dashboard when the button is clicked.
     *
     * @param event The button is pressed.
     */
    @FXML
    void cancelButtonClicked(ActionEvent event) {

        if (getLibrary().getCurrentUserLoggedIn().hasAdminAccess()) {

            new NewWindow("resources/ViewUser.fxml", event, "View User - TaweLib", getLibrary());

        } else {

            new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
        }

    }

    //todo comment this.
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

    /**
     * Gets the path of the image file.
     *
     * @return The path of the image file.
     */
    public String getFilePath() {

        return filePath;
    }

    /**
     * Sets the path of the image file.
     *
     * @param filePath The path of the image file.
     */
    public void setFilePath(String filePath) {

        this.filePath = filePath;
    }
}