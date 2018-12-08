
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Controller class for the Librarian Dashboard.
 * Handles what happens when the user interacts with the UI.
 *
 * @author Sian Pike
 */

public class LibrarianDashboardController extends Controller {

    @FXML // fx:id="logOutButton"
    private Button logOutButton; // Value injected by FXMLLoader

    @FXML // fx:id="manageResourcesButton"
    private Button manageResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="createEditResourcesButton"
    private Button createEditResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="browseResourcesButton"
    private Button browseResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="viewUserButton"
    private Button viewUserButton; // Value injected by FXMLLoader

    @FXML // fx:id="userButton"
    private Button userButton; // Value injected by FXMLLoader

    @FXML // fx:id="overdueResourcesButton"
    private Button overdueResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="copyHistoryButton"
    private Button copyHistoryButton; // Value injected by FXMLLoader

    @FXML
    private Button editAccountButton;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Label staffIDLabel;

    @FXML
    private ImageView librarianImage;

    @FXML // fx:id="viewAllUsersButton"
    private Button viewAllUsersButton; // Value injected by FXMLLoader

    /**
     * Loads the librarian information on startup.
     */
    @Override
    public void onStart() {
        this.loadLibrarianInformation();
    }

    /**
     * Loads the librarian information into the dashboard.
     */
    private void loadLibrarianInformation() {

        try {
            Image image = new Image(getLibrary().getCurrentUserLoggedIn().getProfileImagePath());
            librarianImage.setImage(image);
        } catch (IllegalArgumentException e) {
            librarianImage.setImage(null);
        }

        usernameLabel.setText(getLibrary().getCurrentUserLoggedIn().getUsername());
        firstNameLabel.setText(getLibrary().getCurrentUserLoggedIn().getFirstName());
        lastNameLabel.setText(getLibrary().getCurrentUserLoggedIn().getLastName());
        phoneNumberLabel.setText(getLibrary().getCurrentUserLoggedIn().getPhoneNumber());
        staffIDLabel.setText(((Librarian) (getLibrary().getCurrentUserLoggedIn())).getStaffNumber());
    }

    /**
     * Opens the browse resources window.
     */
    @FXML
    public void browseButtonClicked(ActionEvent event) {

        new NewWindow("resources/BrowseResources.fxml", event,
                "Browse Resources - TaweLib", getLibrary());
    }

    public void editAccountButtonClicked(ActionEvent event) {
        new NewWindow("resources/EditAccount.fxml", event,
                "Browse Resources - TaweLib", getLibrary());
    }

    /**
     * Opens the create/edit resources window.
     */
    @FXML
    public void createEditButtonClicked(ActionEvent event) {

        new NewWindow("resources/CreateEdit.fxml", event,
                "Create/Edit Resources - TaweLib", getLibrary());
    }

    /**
     * Takes the user back to the login window.
     */
    @FXML
    public void logOutButtonClicked(ActionEvent event) {

        new NewWindow("resources/Login.fxml", event,
                "Login - TaweLib", getLibrary());
    }

    /**
     * Opens the manage resources window.
     */
    @FXML
    public void manageResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/ManageResources.fxml", event, "Manage Resources - TaweLib",
                getLibrary());
    }

    /**
     * Opens the view user window.
     */
    @FXML
    public void viewUserButtonClicked(ActionEvent event) {

        new NewWindow("resources/ViewUser.fxml", event, "View User - TaweLib",
                getLibrary());
    }

    /**
     * The copy history button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    public void copyHistoryButtonClicked(ActionEvent event) {

    }

    /**
     * Shows the overdue resources when the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    public void overdueResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/OverdueCopies.fxml", event, "Overdue Copies - TaweLib", getLibrary());
    }

    /**
     * The user button being clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    public void userButtonClicked(ActionEvent event) {

    }

    /**
     * All the users are shown.
     *
     * @param event The button is clicked.
     */
    @FXML
    void viewAllUsersButtonClicked(ActionEvent event) {

        new NewWindow("resources/ViewAllUsers.fxml", event, "View All Users", getLibrary());

    }
}
