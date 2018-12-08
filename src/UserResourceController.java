import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

/**
 * Controller for the User Resource Window.
 * Handles user interaction with the UI.
 *
 * @author Sian Pike
 */
public class UserResourceController extends Controller {

    @FXML // fx:id="resourceImage"
    private ImageView resourceImage; // Value injected by FXMLLoader

    @FXML // fx:id="copyIdLabel"
    private Label copyIdLabel; // Value injected by FXMLLoader

    @FXML // fx:id="isAvailableLabel"
    private Label isAvailableLabel; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML
    private static Resource clickedResource;

    @FXML
    private TableView <Copy> tableView;

    @FXML
    private TableColumn<Copy, String> uniqueIDColumn;

    @FXML
    private TableColumn<Copy, String> isAvailableColumn;


    @FXML
    private ObservableList<Copy> data;

    @FXML
    public void okButtonClicked(ActionEvent event) {
        clickedResource = null;
        new NewWindow("resources/BrowseResources.fxml", event,
                "Browse Resources - TaweLib", getLibrary());
    }

    public static void setClickedResource(Resource resource){
        clickedResource = resource;
    }

    @Override
    public void onStart(){
        data = FXCollections.observableArrayList();
        uniqueIDColumn.setCellValueFactory(new PropertyValueFactory<Copy, String>("uniqueCopyID"));
        isAvailableColumn.setCellValueFactory(new PropertyValueFactory<Copy, String>("isAvailable"));

        for (Copy copy : clickedResource.getCopyManager().getListOfAllCopies()){
            data.add(copy);
        }

        tableView.getItems().addAll(data);
    }

}