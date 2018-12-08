import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller class for the requested resources window.
 * Handles the interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class RequestedResourcesController extends Controller {

    @FXML
    private Button okButton;

    @FXML
    private TableView<TableRepresentationResourceInformation> requestedResourcesTable;

    @FXML
    private TableColumn<TableRepresentationResourceInformation, String> resourceID;

    @FXML
    private TableColumn<TableRepresentationResourceInformation, String> resourceName;

    @FXML
    private TableColumn<TableRepresentationResourceInformation, String> resourceType;

    @FXML
    private TableColumn<TableRepresentationResourceInformation, Integer> numberInQueue;

    @FXML
    private ObservableList<TableRepresentationResourceInformation> data;

    @FXML
    public void okButtonClicked(ActionEvent event) {
        new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

    @Override
    public void onStart(){
        data = FXCollections.observableArrayList();
        resourceID.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationResourceInformation, String>("resourceID"));

        resourceName.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationResourceInformation, String>("resourceName"));

        resourceType.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationResourceInformation, String>("resourceType"));

        numberInQueue.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationResourceInformation, Integer>("positionInQueue"));

        this.fillInData();
        requestedResourcesTable.getItems().addAll(data);
    }

    private void fillInData() {
        User currentlyLoggedIn = getLibrary().getCurrentUserLoggedIn();
        for(Resource resource : getLibrary().getResourceManager().getRequestedResourcesBy(currentlyLoggedIn)){
            String resID = resource.getUniqueID();
            String name = resource.getTitle();
            String type = resource.getType();
            Integer positionInQueue = resource.getCopyManager().positionInQueue(currentlyLoggedIn);
            data.add(new TableRepresentationResourceInformation(resID, name, type, positionInQueue));
        }
    }

}
