import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller class for the reserved resources window.
 * Handles the interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class ReservedResourcesController extends Controller {

    @FXML
    private Button okButton;

    @FXML
    private TableView<TableRepresentationCopyInformation> reservedResourcesTable;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> copyIDColumn;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> resourceNameColumn;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> resourceTypeColumn;

    /**
     * When the user clicks the button he is returned to the dashboard.
     *
     * @param event The button is clicked.
     */
    @FXML
    private ObservableList<TableRepresentationCopyInformation> data;

    @FXML
    public void okButtonClicked(ActionEvent event) {
        new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

    @Override
    public void onStart(){
        data = FXCollections.observableArrayList();
        copyIDColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("copyID"));
        resourceNameColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("resourceName"));
        resourceTypeColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("resourceType"));

        this.fillInData();
        reservedResourcesTable.getItems().addAll(data);
    }

    private void fillInData() {
        User userCurrentlyLoggedIn = getLibrary().getCurrentUserLoggedIn();
        for(Copy copy : getLibrary().getResourceManager().getReservedCopiesFor(userCurrentlyLoggedIn)){
            String copyID = copy.getUniqueCopyID();
            String resourceName = copy.getCopyOf().getTitle();
            String resourceType = copy.getCopyOf().getType();

            data.add(new TableRepresentationCopyInformation(copyID, resourceName, resourceType));
        }
    }

}