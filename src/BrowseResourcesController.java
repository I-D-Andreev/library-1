import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller class for the Browse Resources Page for Lirarian/User.
 * Handles what happens when the user interacts with the UI.
 *
 * @author Chris McAuley.
 */

public class BrowseResourcesController extends Controller {

    @FXML// fx:id="closeButton"
    private Button closeButton;// Value injected by FXMLLoader

    @FXML// fx:id="dvdFilter"
    private CheckBox dvdFilter;// Value injected by FXMLLoader

    @FXML// fx:id="bookFilter"
    private CheckBox bookFilter;// Value injected by FXMLLoader

    @FXML// fx:id="laptopFilter"
    private CheckBox laptopFilter;// Value injected by FXMLLoader

    @FXML// fx:id="browseResourcesSearchTextField"
    private TextField browseResourcesSearchTextField;// Value injected by FXMLLoader

    @FXML// fx:id="searchButton"
    private Button searchButton;// Value injected by FXMLLoader


    @FXML// fx:id="displayTable"
    private TableView<Resource> displayTable;

    @FXML// fx:id="uniqueIDColumn"
    private TableColumn<Resource, String> uniqueIDColumn;

    @FXML// fx:id="titleColumn"
    private TableColumn<Resource, String> titleColumn;

    @FXML// fx:id="yearColumn"
    private TableColumn<Resource, Integer> yearColumn;

    @FXML// fx:id="typeColumn"
    private TableColumn<Resource, String> typeColumn;


    private ObservableList<Resource> data;

    public void initialize() {
        data = FXCollections.observableArrayList();
        uniqueIDColumn.setCellValueFactory(new PropertyValueFactory<Resource, String>("uniqueID"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Resource, String>("title"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Resource, Integer>("year"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Resource, String>("title"));
    }

    @FXML
    /**
     * Close the application.
     */
    void closeButtonClicked(ActionEvent event) {

        System.exit(0);
    }

    @FXML
    void searchButtonClicked(ActionEvent event) {
        // clear previous data
        data.clear();
        displayTable.getItems().clear();

        //Search for resource in list then populate table.
        String searchCriteria = browseResourcesSearchTextField.getText();

        // If empty show all
        if (searchCriteria.equals("")) {
            for (Resource resource : getLibrary().getResourceManager().getAllResources()) {
                data.add(resource);
            }

        } else {
            for (Resource resource : getLibrary().getResourceManager().getAllResources()) {
                if (resource.getTitle().toLowerCase().indexOf(searchCriteria.toLowerCase()) != -1) {
                    data.add(resource);
                }
            }
        }
        displayTable.getItems().addAll(data);
    }
}

