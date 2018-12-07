import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

/**
 * @author Chris McAuley, Sian Pike
 *
 * Controller class for the Manage Resources Window.  Handles interaction with the UI from the user.
 */

public class ManageResourcesController extends Controller {

    @FXML // fx:id="borrowTab"
    private Tab borrowTab; // Value injected by FXMLLoader

    @FXML
    private TextField borrowUserUsernameTextField;

    @FXML // fx:id="borrowResourceIDTextField"
    private TextField borrowResourceIDTextField; // Value injected by FXMLLoader

    @FXML // fx:id="borrowButton"
    private Button borrowButton; // Value injected by FXMLLoader

    @FXML // fx:id="returnTab"
    private Tab returnTab; // Value injected by FXMLLoader

    @FXML
    private TextField returnCopyIDTextField;

    @FXML // fx:id="returnButton"
    private Button returnButton; // Value injected by FXMLLoader


    @FXML // fx:id="fineTab"
    private Tab fineTab; // Value injected by FXMLLoader

    @FXML // fx:id="fineUserIDTextField"
    private TextField fineUserIDTextField; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="fineTable"
    private TableView<?> fineTable; // Value injected by FXMLLoader

    @FXML // fx:id="amountPaidColumn"
    private TableColumn<?, ?> amountPaidColumn; // Value injected by FXMLLoader

    @FXML // fx:id="outstandingAmountColumn"
    private TableColumn<?, ?> outstandingAmountColumn; // Value injected by FXMLLoader

    @FXML // fx:id="payTextField"
    private TextField payTextField; // Value injected by FXMLLoader

    @FXML // fx:id="payButton"
    private Button payButton; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    @FXML
    private TextField reserveUserUsernameTextField;

    @FXML
    private TextField reserveResourceIDTextField;

    @FXML
    private Button reserveButton;

    @FXML
    public void borrowButtonClicked(ActionEvent event) {

        User user = getLibrary().getUserManager().getUserByUsername(borrowUserUsernameTextField.getText());
        Resource resource = getLibrary().getResourceManager().getResourceById(borrowResourceIDTextField.getText());

        if(user == null || (user instanceof Librarian )){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username.",
                    ButtonType.OK);
            alert.show();
        } else if(!((NormalUser)user).canBorrowCopy()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "This user can not borrow a copy" +
                    " because they have outstanding fines or overdue items to return.",
                    ButtonType.OK);
            alert.show();
        } else if(resource == null){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid resource ID.",
                    ButtonType.OK);
            alert.show();
        } else {
            // Successfully lend a copy.
            Copy copy = getLibrary().getResourceManager().loanCopy(resource, user);

            if(copy == null){
                Alert alert = new Alert(Alert.AlertType.ERROR, "No available copies.\n"
                        + "Try reserving one.",
                        ButtonType.OK);
                alert.show();
            } else {
                String content = "The user has successfully been given a copy - ID: "
                        + copy.getUniqueCopyID() + ". It should be returned in " + copy.getLoanDurationInDays() +
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
     * Goes back to the librarian dashboard when clicked.
     *
     * @param event The current event.
     */
    @FXML
    public void backButtonClicked(ActionEvent event) {

        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

    @FXML
    public void reserveButtonClicked(ActionEvent event){
        User user = getLibrary().getUserManager().getUserByUsername(reserveUserUsernameTextField.getText());
        Resource resource = getLibrary().getResourceManager().getResourceById(reserveResourceIDTextField.getText());

        if(user == null || (user instanceof Librarian)){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid user ID.",
                    ButtonType.OK);
            alert.show();
        } else if(resource == null){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid resource ID.",
                    ButtonType.OK);
            alert.show();
        } else if(resource.getCopyManager().getNumOfAvailableCopies() > 0){
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
    }

    @FXML
    public void payButtonClicked(ActionEvent event) {

    }

    @FXML
    public void returnButtonClicked(ActionEvent event) {
        Copy copy = getLibrary().getResourceManager().getCopyById(returnCopyIDTextField.getText());

         if(copy == null || copy.getBorrowedBy() == null){
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
             if(result.get() == ButtonType.OK) {
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

    @FXML
    void searchButtonClicked(ActionEvent event) {

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