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

import java.util.ArrayList;

/**
 * Controller class for the Browse Resources Page for Librarian/User.
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

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    private ObservableList<Resource> data;
    private ArrayList<String> acceptableTypes;

    public void initialize() {
        data = FXCollections.observableArrayList();
        acceptableTypes = new ArrayList<>();
        uniqueIDColumn.setCellValueFactory(new PropertyValueFactory<Resource, String>("uniqueID"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Resource, String>("title"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Resource, Integer>("year"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Resource, String>("type"));
      //  this.updateTable();
    }


    @FXML
    public void updateTable() {
        // clear previous data
        data.clear();
        displayTable.getItems().clear();

        // see which of the checked boxes are ticked
        this.manageCheckedBoxTypes();

        //Search for resource in list then populate table.
        String searchCriteria = browseResourcesSearchTextField.getText();

        // If search criteria is empty show all/ else show only the ones that match
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

        // if none of the types have been ticked accept all
        // else remove the resources that are not permitted
        ArrayList <Resource> shouldNotBeDisplayed = new ArrayList<>();
        if(acceptableTypes.size() != 0) {
            for(Resource resource : data){
                if(!acceptableTypes.contains(resource.getType())){
                    shouldNotBeDisplayed.add(resource);
                }
            }
        }
       data.removeAll(shouldNotBeDisplayed);

        displayTable.getItems().addAll(data);
    }

    /**
     * Goes back to the previous window when the back button is clicked.
     * @param event The current event.
     */
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

    private void manageCheckedBoxTypes(){
        acceptableTypes.clear();
        if(dvdFilter.isSelected()){
            acceptableTypes.add("DVD");
        }

        if(bookFilter.isSelected()){
            acceptableTypes.add("Book");
        }

        if(laptopFilter.isSelected()){
            acceptableTypes.add("Laptop");
        }
    }


}

