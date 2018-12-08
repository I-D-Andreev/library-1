import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Controller class for the borrowed resources window.
 * Handles the interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class BorrowedResourcesController extends Controller {

    @FXML
    private Button okButton;

    @FXML
    private TableView<TableRepresentationCopyInformation> borrowedResourcesTable;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> copyIDColumn;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> nameColumn;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> typeColumn;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> borrowDateColumn;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> dueDateColumn;

    @FXML
    private ObservableList<TableRepresentationCopyInformation> data;


    @FXML
    public void okButtonClicked(ActionEvent event) {

        new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

    @Override
    public void onStart() {
        data = FXCollections.observableArrayList();
        copyIDColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("copyID"));
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("resourceName"));
        typeColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("resourceType"));
        borrowDateColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("borrowDate"));
        dueDateColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("dueDate"));

        this.fillInData();
        borrowedResourcesTable.getItems().addAll(data);
    }

    private void fillInData() {
        User currentlyLoggedIn = getLibrary().getCurrentUserLoggedIn();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Copy copy : getLibrary().getResourceManager().getBorrowedCopiesBy(currentlyLoggedIn)) {
            System.out.println(copy.getUniqueCopyID());
            String copyID = copy.getUniqueCopyID();
            String resourceName = copy.getCopyOf().getTitle();
            String resourceTpe = copy.getCopyOf().getType();
            String borrowDate = dateFormat.format(copy.getBorrowedOn());
            String dueDate = (copy.getDueDate() == null) ? "no due date" : dateFormat.format(copy.getDueDate());

            data.add(new TableRepresentationCopyInformation(copyID, resourceName, resourceTpe,
                    borrowDate, dueDate));
        }
    }


}
