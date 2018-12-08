import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.annotation.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the User Dashboard.
 * Handles what happens when the user interacts with the UI.
 *
 * @author Sian Pike
 */

public class UserDashboardController extends Controller {

    @FXML // fx:id="browseResourcesButton"
    private Button browseResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="logOutButton"
    private Button logOutButton; // Value injected by FXMLLoader

    @FXML // fx:id="borrowedResourcesButton"
    private Button borrowedResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="requestedResourcesButton"
    private Button requestedResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="reservedResourcesButton"
    private Button reservedResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="overdueResourcesButton"
    private Button overdueResourcesButton; // Value injected by FXMLLoader

    @FXML // fx:id="transHistoryButton"
    private Button transHistoryButton; // Value injected by FXMLLoader

    @FXML // fx:id="userImage"
    private ImageView userImage; // Value injected by FXMLLoader

    @FXML // fx:id="usernameLabel"
    private Label usernameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="firstNameLabel"
    private Label firstNameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="lastNameLabel"
    private Label lastNameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="phoneNumberLabel"
    private Label phoneNumberLabel; // Value injected by FXMLLoader


    @FXML // fx:id="popularResourceLabel"
    private Label popularResourceLabel; // Value injected by FXMLLoader

    @FXML
    private Button editProfileButton;

    @FXML
    private Button mostPopularResourceButton;

    @FXML
    private Label balanceLabel;



    @FXML
    public void borrowedResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/BorrowedResources.fxml", event, "Borrowed Resources - TaweLib",
                getLibrary());
    }

    @FXML
    public void editProfileButtonClicked(ActionEvent event) {
        new NewWindow("resources/EditAccount.fxml", event,
                "Edit Account - TaweLib", getLibrary());
    }

    @FXML
    public void mostPopularResourceButtonClicked(ActionEvent event) {

    }


    @Override
    public void onStart(){
        this.loadUserInformation();
    }

    @FXML
    /**
     * Opens the browse resources window.
     */
    void browseResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/BrowseResources.fxml", event,
                "Browse Resources - TaweLib", getLibrary());

    }

    @FXML
    /**
     * Takes the user back to the login screen.
     */
    void logOutButtonClicked(ActionEvent event) {

        new NewWindow("resources/Login.fxml", event,
                "Login - TaweLib", getLibrary());
    }

    @FXML
    void overdueResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/OverdueResources.fxml", event, "Overdue Resources - TaweLib",
                getLibrary());
    }

    @FXML
    void requestedResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/RequestedResources.fxml", event, "Requested Resources - TaweLib",
                getLibrary());
    }

    @FXML
    void reservedResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/ReservedResources.fxml", event, "Reserved Resources - TaweLib",
                getLibrary());
    }

    @FXML
    void transHistoryButtonClicked(ActionEvent event) {

    }


    private void loadUserInformation(){

        try {
            Image image = new Image(getLibrary().getCurrentUserLoggedIn().getProfileImagePath());
            userImage.setImage(image);
        } catch (IllegalArgumentException e) {
            userImage.setImage(null);
        } catch (NullPointerException e) {
            userImage.setImage(null);
        }

        usernameLabel.setText(getLibrary().getCurrentUserLoggedIn().getUsername());
        firstNameLabel.setText(getLibrary().getCurrentUserLoggedIn().getFirstName());
        lastNameLabel.setText(getLibrary().getCurrentUserLoggedIn().getLastName());
        phoneNumberLabel.setText(getLibrary().getCurrentUserLoggedIn().getPhoneNumber());
        balanceLabel.setText(String.valueOf(((NormalUser) getLibrary().getCurrentUserLoggedIn()).getBalance()));

    }
}