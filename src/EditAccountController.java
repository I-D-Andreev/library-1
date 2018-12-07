import com.sun.org.glassfish.gmbal.ManagedObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class EditAccountController extends Controller{

    @FXML
    private Button backButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField addressLine1TextField;

    @FXML
    private TextField addressLine2TextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField postcodeTextField;

    @FXML
    private Button chooseProfileImageButton;

    @FXML
    private Label imagePathLabel;

    @FXML
    private Button drawProfileImageButton;

    @FXML
    private Button editAccountButton;


    @Override
    public void onStart(){
        this.fillInData();
    }

    private void fillInData(){
        User user = getLibrary().getCurrentUserLoggedIn();
        usernameTextField.setText(user.getUsername());
        firstNameTextField.setText(user.getFirstName());
        lastNameTextField.setText(user.getLastName());
        phoneNumberTextField.setText(user.getPhoneNumber());
        addressLine1TextField.setText(user.getAddress().getAddressLine1());
        addressLine2TextField.setText(user.getAddress().getAddressLine2());
        cityTextField.setText(user.getAddress().getCity());
        countryTextField.setText(user.getAddress().getCountry());
        postcodeTextField.setText(user.getAddress().getPostcode());
        imagePathLabel.setText(user.getProfileImagePath());
    }

    @FXML
    void backButtonClicked(ActionEvent event) {
        //if librarian then go back to librarian dashboard else go back to user dashboard
        if(getLibrary().getCurrentUserLoggedIn().hasAdminAccess()){
            new NewWindow("resources/LibrarianDashboard.fxml", event,
                    "Browse Resources - TaweLib", getLibrary());
        } else {
            new NewWindow("resources/UserDashboard.fxml", event,
                    "Dashboard - TaweLib", getLibrary());
        }
    }

    @FXML
    void chooseProfileImageButtonClicked(ActionEvent event) {

    }

    @FXML
    void drawProfileImageButtonClicked(ActionEvent event) {

    }

    @FXML
    void editAccountButtonClicked(ActionEvent event) {

    }

}
