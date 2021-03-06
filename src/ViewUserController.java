import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Controller class for the View User Window.  Handles user actions when the UI is interacted with.
 *
 * @author Sian Pike
 */

public class ViewUserController extends Controller {

    /**
     * The tab to search users.
     */
    @FXML // fx:id="searchUserTab"
    private Tab searchUserTab;

    /**
     * Field to type the user to search in.
     */
    @FXML // fx:id="searchUserTextField"
    private TextField searchUserTextField;

    /**
     * Button to press when we want to search for a user.
     */
    @FXML // fx:id="searchButton"
    private Button searchButton;

    /**
     * The tab where we can create a user.
     */
    @FXML // fx:id="createUserTab"
    private Tab createUserTab;

    /**
     * The field showing username.
     */
    @FXML // fx:id="usernameTextField"
    private TextField usernameTextField;

    /**
     * The field showing first name.
     */
    @FXML // fx:id="firstNameTextField"
    private TextField firstNameTextField;

    /**
     * The field showing surname.
     */
    @FXML // fx:id="surnameTextField"
    private TextField surnameTextField;

    /**
     * The field showing the phone number.
     */
    @FXML // fx:id="phoneNumberTextField"
    private TextField phoneNumberTextField;

    /**
     * The field showing the first address line.
     */
    @FXML // fx:id="addressTextField"
    private TextField addressTextField1;

    /**
     * The field showing the second address line.
     */
    @FXML // fx:id="addressTextField"
    private TextField addressTextField2;

    /**
     * The field showing the country of the address.
     */
    @FXML
    private TextField addressCountryTextField;

    /**
     * The field showing the address post code.
     */
    @FXML
    private TextField addressPostcodeTextField;

    /**
     * Shows the date the librarian was employed.
     */
    @FXML // fx:id="employmentDatePicker"
    private DatePicker employmentDatePicker;

    /**
     * Field showing the stuff ID number.
     */
    @FXML // fx:id="staffNumberTextField"
    private TextField staffNumberTextField;

    /**
     * Button to choose profile image.
     */
    @FXML
    private Button chooseProfileImageButton;

    /**
     * Button to draw your own profile image.
     */
    @FXML
    private Button drawProfileImageButton;

    /**
     * Label showing the profile image.
     */
    @FXML // fx:id="profileImageFileLabel"
    private Label profileImageFileLabel;

    /**
     * Button to add a new user.
     */
    @FXML // fx:id="addUserButton"
    private Button addUserButton;

    /**
     * Button to go back to the dashboard.
     */
    @FXML // fx:id="backButton"
    private Button backButton;

    /**
     * Button to filter librarians.
     */
    @FXML
    private RadioButton librarianRadioButton;

    /**
     * Button to filter normal users.
     */
    @FXML
    private RadioButton userRadioButton;

    /**
     * Field showing the city the address is from.
     */
    @FXML
    private TextField addressCityTextField;

    /**
     * Label showing the thumbnail image path.
     */
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

    /**
     * Shows a tab with the user information if the user is found, when the button is pressed.
     *
     * @param event The button is pressed.
     */
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

    /**
     * Adds a user when the button is clicked.
     *
     * @param event The button is clicked.
     */
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

            String typeOfAccount = "";
            if (isLibrarian) {
                getLibrary().getUserManager().addUser(new Librarian(firstName, lastName, username, phoneNumber,
                        imagePath, address));
                typeOfAccount = "Librarian";
            } else if (isUser) {
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

    /**
     * Clears all the fields for creating an account, to be used after we make an account.
     */
    private void clearAllCreateAccountFields() {
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

    /**
     * Clicking the button makes the user view only normal user.
     *
     * @param event Clicking the button.
     */
    @FXML
    public void userRadioButtonSelected(ActionEvent event) {
        librarianRadioButton.setSelected(false);
    }

    /**
     * Clicking the button makes the user view only librarians.
     *
     * @param event Clicking the button.
     */
    @FXML
    public void librarianRadioButtonSelected(ActionEvent event) {
        userRadioButton.setSelected(false);
    }

    /**
     * Takes the user to choose a profile image tab after the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    void chooseProfileImageButtonClicked(ActionEvent event) {

        new NewWindow("resources/ProfileImage.fxml", event, "Choose Image - TaweLib", getLibrary());

    }

    /**
     * Takes the user to the draw an image tab after the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    void drawProfileImageButtonClicked(ActionEvent event) {

    }
}

