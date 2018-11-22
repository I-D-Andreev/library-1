import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @author Chris McAuley, Sian Pike
 *
 * Controller class for the Manage Resources Window.  Handles interaction with the UI from the user.
 */

public class ManageResourcesController {

    @FXML // fx:id="borrowTab"
    private Tab borrowTab; // Value injected by FXMLLoader

    @FXML // fx:id="borrowUserIDTextField"
    private TextField borrowUserIDTextField; // Value injected by FXMLLoader

    @FXML // fx:id="borrowResourceIDTextField"
    private TextField borrowResourceIDTextField; // Value injected by FXMLLoader

    @FXML // fx:id="borrowButton"
    private Button borrowButton; // Value injected by FXMLLoader

    @FXML // fx:id="returnTab"
    private Tab returnTab; // Value injected by FXMLLoader

    @FXML // fx:id="returnResourceIDTextField"
    private TextField returnResourceIDTextField; // Value injected by FXMLLoader

    @FXML // fx:id="returnButton"
    private Button returnButton; // Value injected by FXMLLoader

    @FXML // fx:id="returnUserIDTextField"
    private TextField returnUserIDTextField; // Value injected by FXMLLoader

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

}