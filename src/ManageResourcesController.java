import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

/**
 * @author Chris McAuley, Sian Pike
 *
 * Controller class for the Manage Resources Window.
 * Handles interaction with the UI from the user.
 */

public class ManageResourcesController extends Controller {

    /**
     * Tab showing information related to borrowing.
     */
    @FXML // fx:id="borrowTab"
    private Tab borrowTab; // Value injected by FXMLLoader

    /**
     * The field showing the user name of the borrower.
     */
    @FXML
    private TextField borrowUserUsernameTextField;

    /**
     * The field showing the borrowed resource's ID.
     */
    @FXML // fx:id="borrowResourceIDTextField"
    private TextField borrowResourceIDTextField; // Value injected by FXMLLoader

    /**
     * The button for borrowing.
     */
    @FXML // fx:id="borrowButton"
    private Button borrowButton; // Value injected by FXMLLoader

    /**
     * The tab showing information related to returns.
     */
    @FXML // fx:id="returnTab"
    private Tab returnTab; // Value injected by FXMLLoader

    /**
     * Field showing the return copy ID.
     */
    @FXML
    private TextField returnCopyIDTextField;

    /**
     * Button to return a resource.
     */
    @FXML // fx:id="returnButton"
    private Button returnButton; // Value injected by FXMLLoader

    /**
     * The tab showing information related to fines.
     */
    @FXML // fx:id="fineTab"
    private Tab fineTab; // Value injected by FXMLLoader

    /**
     * The field showing the username of the user fined.
     */
    @FXML // fx:id="fineUserUsernameTextField"
    private TextField fineUserUsernameTextField; // Value injected by FXMLLoader

    /**
     * Button for searches.
     */
    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    /**
     * Field showing how much was paid by the user.
     */
    @FXML // fx:id="payTextField"
    private TextField payTextField; // Value injected by FXMLLoader

    /**
     * Button for paying fines.
     */
    @FXML // fx:id="payButton"
    private Button payButton; // Value injected by FXMLLoader

    /**
     * Button to return back to dashboard.
     */
    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    /**
     * Field that shows the user's username that has reserved a resource.
     */
    @FXML
    private TextField reserveUserUsernameTextField;

    /**
     * Field showing the resources ID that have been reserved.
     */
    @FXML
    private TextField reserveResourceIDTextField;

    /**
     * Button for reserving resources.
     */
    @FXML
    private Button reserveButton;

    /**
     * Label showing the outstanding amount to be paid by the user.
     */
    @FXML // fx:id="outstandingAmountLabel"
    private Label outstandingAmountLabel; // Value injected by FXMLLoader

    /**
     * When a copy is to be borrowed checks if the user is eligible for a loan and loans a copy to the user,
     * if one is available, otherwise one is reserved.
     *
     * @param event The button is clicked.
     */
    @FXML
    public void borrowButtonClicked(ActionEvent event) {

        User user = getLibrary().getUserManager().getUserByUsername(borrowUserUsernameTextField.getText());
        Resource resource = getLibrary().getResourceManager().getResourceById(borrowResourceIDTextField.getText());

        if (user == null || (user instanceof Librarian)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username.",
                    ButtonType.OK);
            alert.show();
        } else if (!((NormalUser) user).canBorrowCopy()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "This user can not borrow a copy" +
                    " because they have outstanding fines or overdue items to return.",
                    ButtonType.OK);
            alert.show();
        } else if (resource == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid resource ID.",
                    ButtonType.OK);
            alert.show();
        } else {
            // Successfully lend a copy.
            Copy copy = getLibrary().getResourceManager().loanCopy(resource, user);

            if (copy == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No available copies.\n"
                        + "Try reserving one.",
                        ButtonType.OK);
                alert.show();
            } else {
                String content = "The user has successfully been given a copy - ID: "
                        + copy.getUniqueCopyID() + ". It loan duration is " + copy.getLoanDurationInDays() +
                        " day(s)!";

                Alert alert = new Alert(Alert.AlertType.INFORMATION, content,
                        ButtonType.OK);
                alert.show();
            }

            // clear fields
            borrowUserUsernameTextField.clear();
            borrowResourceIDTextField.clear();
        }
    }

    /**
     * User goes back to the dashboard when clicked.
     *
     * @param event The button is pressed.
     */
    @FXML
    public void backButtonClicked(ActionEvent event) {

        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

    /**
     * When the button is pressed a copy is reserved to a user if none are available,
     * otherwise it tells the user to borrow it instead.
     *
     * @param event The button is clicked.
     */
    @FXML
    public void reserveButtonClicked(ActionEvent event) {
        User user = getLibrary().getUserManager().getUserByUsername(reserveUserUsernameTextField.getText());
        Resource resource = getLibrary().getResourceManager().getResourceById(reserveResourceIDTextField.getText());

        if (user == null || (user instanceof Librarian)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username.",
                    ButtonType.OK);
            alert.show();
        } else if (resource == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid resource ID.",
                    ButtonType.OK);
            alert.show();
        } else if (resource.getCopyManager().getNumOfAvailableCopies() > 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "There are available copies. Please borrow one.",
                    ButtonType.OK);
            alert.show();
        } else {
            getLibrary().getResourceManager().reserveCopy(resource, user);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "User " + user.getUsername()
                    + " has been put on the waiting list.",
                    ButtonType.OK);
            alert.show();

            // clear fields
            reserveUserUsernameTextField.clear();
            reserveResourceIDTextField.clear();
        }

        for (Copy copy : resource.getCopyManager().getListOfAllCopies()) {
            System.out.println(copy.getUniqueCopyID() + " - " + copy.getDueDate());
        }
    }

    /**
     * When the button is pressed the fine of the user is paid.
     *
     * @param event The button is clicked.
     */
    @FXML
    public void payButtonClicked(ActionEvent event) {
        NormalUser user = (NormalUser) getLibrary().getUserManager()
                .getUserByUsername(fineUserUsernameTextField.getText());
        String fineText = payTextField.getText();

        if (!isStringNumber(fineText)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The fine must be a number.",
                    ButtonType.OK);
            alert.show();
        } else {
            double fine = Double.parseDouble(fineText);
            if (fine < 0.01 || fine > user.getBalance()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "You should pay between 0.01 and the fine amount.",
                        ButtonType.OK);
                alert.show();
            } else {
                getLibrary().getUserManager().payFine(fine, user);

                Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        "Successfully paid fine. Current amount owed: " + user.getBalance(),
                        ButtonType.OK);
                alert.show();

                // unlock username box
                fineUserUsernameTextField.setDisable(false);

                // clear fields
                fineUserUsernameTextField.clear();
                payTextField.clear();
                outstandingAmountLabel.setText("");
            }

        }
    }

    /**
     * Check if a certain string contains digits only.
     *
     * @param s The string.
     * @return True if the string contains only digits, false otherwise.
     */
    public boolean isStringNumber(String s) {
        // regular expression
        // a number is: digits(0 or more) + comma/dot + digits(at least 1)
        return s.matches("\\d*[.,]?\\d+");
    }

    /**
     * When the button is clicked the copy is returned to the library and we check if the user is to be fined.
     *
     * @param event The button is clicked.
     */
    @FXML
    public void returnButtonClicked(ActionEvent event) {
        Copy copy = getLibrary().getResourceManager().getCopyById(returnCopyIDTextField.getText());

        if (copy == null || copy.getBorrowedBy() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid copy ID.",
                    ButtonType.OK);
            alert.show();
        } else {

            // All the data is correct so now we are returning the copy.
            User user = copy.getBorrowedBy();

            // set up a confirmation dialog
            // to prevent return by  mistake
            Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationDialog.setTitle("Confirm choice");
            confirmationDialog.setHeaderText("Copy return confirmation");
            confirmationDialog.setContentText("Return copy with ID: " + copy.getUniqueCopyID()
                    + " , which is returned by user " + user.getUsername() + "?");

            Optional<ButtonType> result = confirmationDialog.showAndWait();

            // proceed only if the librarian is sure of their choice
            if (result.get() == ButtonType.OK) {
                double fineAmount = getLibrary().getResourceManager().returnCopy(copy);

                if (fineAmount == 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully returned copy." +
                            " No fine incurred for user " + user.getUsername() + ".",
                            ButtonType.OK);
                    alert.show();
                } else {
                    String content = "This copy is overdue. User " + user.getUsername() + " has been fined " +
                            fineAmount + ".";

                    Alert alert = new Alert(Alert.AlertType.ERROR, content,
                            ButtonType.OK);
                    alert.show();
                }

                // nullify fields
                returnCopyIDTextField.clear();
            }
        }
    }

    /**
     * When the button is clicked we search for a user and check his balance.
     *
     * @param event The button is clicked.
     */
    @FXML
    void searchButtonClicked(ActionEvent event) {
        User searchUser = getLibrary().getUserManager().getUserByUsername(fineUserUsernameTextField.getText());
        if (searchUser == null || !(searchUser instanceof NormalUser)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username.",
                    ButtonType.OK);
            alert.show();
        } else {
            // the username is legitimate
            NormalUser user = (NormalUser) searchUser;

            if (user.getBalance() == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "User has no fines.",
                        ButtonType.OK);
                alert.show();
            } else {
                outstandingAmountLabel.setText(String.valueOf(user.getBalance()));

                // lock the username text field
                fineUserUsernameTextField.setDisable(true);
            }
        }
    }
}
/*

            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all the required fields.",
                    ButtonType.OK);
            alert.show();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book resource created successfully.",
                    ButtonType.OK);
            alert.show();

 */