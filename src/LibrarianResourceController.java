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
 * Controller class for the librarian resource window.
 * Handles interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class LibrarianResourceController extends Controller {

    @FXML // fx:id="resourceImage"
    private ImageView resourceImage; // Value injected by FXMLLoader

    @FXML // fx:id="borrowedByLabel"
    private Label borrowedByLabel; // Value injected by FXMLLoader

    @FXML // fx:id="dueDateLabel"
    private Label dueDateLabel; // Value injected by FXMLLoader

    @FXML // fx:id="copyHistoryTable"
    private TableView<TableRepresentationCopyAvailable> displayTable; // Value injected by FXMLLoader

    @FXML // fx:id="copyHistoryColumn"
    private TableColumn<TableRepresentationCopyAvailable, String> copyIDColumn; // Value injected by FXMLLoader

    @FXML
    private TableColumn<TableRepresentationCopyAvailable, String> copyAvailableColumn; // Value injected by FXMLLoader

    @FXML
    private TableColumn<TableRepresentationCopyAvailable, String> copyBorrowedByColumn; // Value injected by FXMLLoader

    @FXML
    private TableColumn<TableRepresentationCopyAvailable, String> copyReservedForColumn; // Value injected by FXMLLoader

    @FXML
    private ObservableList<TableRepresentationCopyAvailable> data;

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML
    private static Resource clickedResource;

    @FXML
    public void okButtonClicked(ActionEvent event) {
        clickedResource = null;
        new NewWindow("resources/BrowseResources.fxml", event, "Librarian Copy View", getLibrary());
    }

    public static void setClickedResource(Resource resource) {
        clickedResource = resource;
    }

    @Override
    public void onStart() {
        data = FXCollections.observableArrayList();
        copyIDColumn.setCellValueFactory(new PropertyValueFactory<TableRepresentationCopyAvailable, String>("uniqueCopyID"));
        copyAvailableColumn.setCellValueFactory(new PropertyValueFactory<TableRepresentationCopyAvailable, String>("isAvailable"));
        copyBorrowedByColumn.setCellValueFactory(new PropertyValueFactory<TableRepresentationCopyAvailable, String>("borrowedBy"));
        copyReservedForColumn.setCellValueFactory(new PropertyValueFactory<TableRepresentationCopyAvailable, String>("reservedFor"));

        for (Copy copy : clickedResource.getCopyManager().getListOfAllCopies()) {


            data.add(
                    new TableRepresentationCopyAvailable(copy.getUniqueCopyID(),
                            (copy.isAvailable()) ? "available" : "not available",
                            (copy.getBorrowedBy() == null) ? "no one" : copy.getBorrowedBy().getUsername(),
                            (copy.getReservedFor() == null) ? "no one" : copy.getReservedFor().getUsername())
            );

        }

        displayTable.getItems().addAll(data);
    }


}