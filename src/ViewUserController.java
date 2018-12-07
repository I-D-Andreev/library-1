import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Controller class for the View User Window.  Handles user actions when the UI is interacted with.
 *
 * @author Sian Pike
 */

public class ViewUserController extends Controller {

    @FXML // fx:id="searchUserTab"
    private Tab searchUserTab; // Value injected by FXMLLoader

    @FXML // fx:id="searchUserTextField"
    private TextField searchUserTextField; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="createUserTab"
    private Tab createUserTab; // Value injected by FXMLLoader

    @FXML // fx:id="usernameTextField"
    private TextField usernameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="firstNameTextField"
    private TextField firstNameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="surnameTextField"
    private TextField surnameTextField; // Value injected by FXMLLoader

    @FXML // fx:id="phoneNumberTextField"
    private TextField phoneNumberTextField; // Value injected by FXMLLoader

    @FXML // fx:id="addressTextField"
    private TextField addressTextField1; // Value injected by FXMLLoader

    @FXML // fx:id="addressTextField"
    private TextField addressTextField2; // Value injected by FXMLLoader

    @FXML
    private TextField addressCountryTextField; // Value injected by FXMLLoader

    @FXML
    private TextField addressPostcodeTextField; // Value injected by FXMLLoader

    @FXML // fx:id="employmentDatePicker"
    private DatePicker employmentDatePicker; // Value injected by FXMLLoader

    @FXML // fx:id="staffNumberTextField"
    private TextField staffNumberTextField; // Value injected by FXMLLoader

    @FXML
    private Button chooseProfileImageButton;

    @FXML
    private Button drawProfileImageButton;


    @FXML // fx:id="profileImageFileLabel"
    private Label profileImageFileLabel; // Value injected by FXMLLoader


    @FXML // fx:id="addUserButton"
    private Button addUserButton; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    @FXML
    private RadioButton librarianRadioButton;

    @FXML
    private RadioButton userRadioButton;

    @FXML
    private TextField addressCityTextField;

    @FXML
    private Label imagePathLabel;


    /**
     * Goes back to the librarian dashboard when clicked.
     *
     * @param event The current event.
     */
    @FXML
    void backButtonClicked(ActionEvent event) {

        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

    @FXML
    void searchButtonClicked(ActionEvent event) {
        User user = getLibrary().getUserManager().getUserByUsername(searchUserTextField.getText());
        if (user == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "A user with username " + searchUserTextField.getText()
                    + " does not exist.",
                    ButtonType.OK);
            alert.show();
        } else {
            String content = "Username: " + user.getUsername() +
                    "\nFirst name: " + user.getFirstName() +
                    "\nLast name: " + user.getLastName() +
                    "\nPhone number: " + user.getPhoneNumber() +
                    "\nAddress:\n" + user.getAddress().toString();
            // display some contact info about the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION, content, ButtonType.OK);
            alert.setTitle("User Information");
            alert.setHeaderText("Contact information");
            alert.show();
        }

    }

    @FXML
    public void addUserButtonClicked(ActionEvent event) {
        // mandatory info - username, first name,last name, phone number, address line 1, city,
        // country, postcode, librarian / user radio button/ image path one of the two
        // optional info - address line 2

        // gather info
        String username = usernameTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = surnameTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String addressLine1 = addressTextField1.getText();
        String addressLine2 = addressTextField2.getText();
        String city = addressCityTextField.getText();
        String country = addressCountryTextField.getText();
        String addressPostcode = addressPostcodeTextField.getText();
        boolean isLibrarian = librarianRadioButton.isSelected();
        boolean isUser = userRadioButton.isSelected();
        String imagePath = imagePathLabel.getText();

        // check if info is filled in
        if (username.isEmpty() || firstName.isEmpty() || lastName.isEmpty()
                || phoneNumber.isEmpty() || addressLine1.isEmpty() || city.isEmpty()
                || country.isEmpty() || addressPostcode.isEmpty() //|| imagePath.isEmpty()
                || (!isLibrarian && !isUser)   // has not selected any of the two radio buttons
        ) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all the required fields.",
                    ButtonType.OK);
            alert.show();
        } else if (getLibrary().getUserManager().getUserByUsername(username) != null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Username already taken.",
                    ButtonType.OK);
            alert.show();
        } else {
            // create the address
            Address address = new Address(addressLine1, addressLine2, city, country, addressPostcode);

            String typeOfAccount="";
            if(isLibrarian){
                getLibrary().getUserManager().addUser(new Librarian(firstName, lastName, username, phoneNumber,
                        imagePath, address));
                typeOfAccount = "Librarian";
            } else if(isUser){
                getLibrary().getUserManager().addUser(new NormalUser(firstName, lastName, username, phoneNumber,
                        imagePath, address));
                typeOfAccount = "User";
            }


            Alert alert = new Alert(Alert.AlertType.INFORMATION, typeOfAccount + " account has been created successfully.",
                    ButtonType.OK);
            alert.show();

            this.clearAllCreateAccountFields();
        }
    }

    private void clearAllCreateAccountFields(){
        usernameTextField.clear();
        firstNameTextField.clear();
        surnameTextField.clear();
        phoneNumberTextField.clear();
        addressTextField1.clear();
        addressTextField2.clear();
        addressCityTextField.clear();
        addressCountryTextField.clear();
        addressPostcodeTextField.clear();
        librarianRadioButton.setSelected(false);
        userRadioButton.setSelected(false);
        imagePathLabel.setText("No File Chosen.");
    }


    @FXML
    public void userRadioButtonSelected(ActionEvent event) {
        librarianRadioButton.setSelected(false);
    }

    @FXML
    public void librarianRadioButtonSelected(ActionEvent event) {
        userRadioButton.setSelected(false);
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