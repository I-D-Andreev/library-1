import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Pair;

import javax.annotation.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private Label accountCreationLabel;

    /**
     * Takes the user to the borrowed resources tab after the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    public void borrowedResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/BorrowedResources.fxml", event, "Borrowed Resources - TaweLib",
                getLibrary());
    }

    /**
     * Takes the user to the edit account tab when the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    public void editProfileButtonClicked(ActionEvent event) {
        new NewWindow("resources/EditAccount.fxml", event,
                "Edit Account - TaweLib", getLibrary());
    }

    /**
     * todo comment this
     *
     * @param event
     */
    @FXML
    public void mostPopularResourceButtonClicked(ActionEvent event) {
        if (getLibrary().getResourceManager().getAllResources().size() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "There are no resources in the library.",
                    ButtonType.OK);
        } else {
            Pair<Resource, Integer> mostPopularResourcePair = getLibrary().getResourceManager().mostPopularResource();
            String content = "The most popular resource in the library is " +
                    mostPopularResourcePair.getKey().getTitle() + "! It was borrowed " +
                    mostPopularResourcePair.getValue() + " times!";
            Alert alert = new Alert(Alert.AlertType.INFORMATION, content, ButtonType.OK);
            alert.setTitle("Most Popular Resource");
            alert.setHeaderText("Most Popular Resource");
            alert.show();
        }
    }

    /**
     * Loads information into the user dashboard.
     */
    @Override
    public void onStart() {
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
        getLibrary().save();
        new NewWindow("resources/Login.fxml", event,
                "Login - TaweLib", getLibrary());
    }

    /**
     * Takes the user to the overdue resources tab when the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    void overdueResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/OverdueResources.fxml", event, "Overdue Resources - TaweLib",
                getLibrary());
    }

    /**
     * Takes the user to the resources requested tab after the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    void requestedResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/RequestedResources.fxml", event, "Requested Resources - TaweLib",
                getLibrary());
    }

    /**
     * Takes the user to the reserved resources tab after the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    void reservedResourcesButtonClicked(ActionEvent event) {

        new NewWindow("resources/ReservedResources.fxml", event, "Reserved Resources - TaweLib",
                getLibrary());
    }

    /**
     * Takes the user to the transaction history tab after the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    void transHistoryButtonClicked(ActionEvent event) {

        new NewWindow("resources/TransactionHistory.fxml", event, "Transaction History - TaweLib",
                getLibrary());
    }

    private void loadUserInformation() {

        try {
            String path = getLibrary().getCurrentUserLoggedIn().getProfileImagePath();
            Image image;
            // relative path
            if (path.charAt(0) >= 'a' && path.charAt(0) <= 'z') {
                image = new Image(path);
            } else {
                // absolute path
                image = new Image(new File(path).toURI().toString());
            }
            userImage.setImage(image);

        } catch (IllegalArgumentException e) {
            userImage.setImage(new Image("resources/noImage.png"));
        } catch (NullPointerException e) {
            userImage.setImage(null);
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        usernameLabel.setText(getLibrary().getCurrentUserLoggedIn().getUsername());
        firstNameLabel.setText(getLibrary().getCurrentUserLoggedIn().getFirstName());
        lastNameLabel.setText(getLibrary().getCurrentUserLoggedIn().getLastName());
        phoneNumberLabel.setText(getLibrary().getCurrentUserLoggedIn().getPhoneNumber());
        balanceLabel.setText(String.valueOf(((NormalUser) getLibrary().getCurrentUserLoggedIn()).getBalance()));
        accountCreationLabel.setText(
                dateFormat.format(
                        ((NormalUser) getLibrary().getCurrentUserLoggedIn()).getAccountCreationDate()
                )
        );


    }
}