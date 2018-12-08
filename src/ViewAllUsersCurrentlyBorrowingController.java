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
 * Controller class for the view all users window.
 * Handles the interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class ViewAllUsersCurrentlyBorrowingController extends Controller{

    @FXML
    private TableView<TableRepresentationCopyInformation> userTable;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> copyIDColumn;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> copyNameColumn;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> usernameColumn;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> borrowedOnColumn;

    @FXML
    private ObservableList<TableRepresentationCopyInformation> data;

    @FXML
    private Button okButton;
    @FXML
    void okButtonClicked(ActionEvent event) {
        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

    @Override
    public void onStart(){
        data = FXCollections.observableArrayList();
        copyIDColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("copyID"));

        copyNameColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("resourceName"));

        usernameColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("borrowedBy"));

        borrowedOnColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("borrowDate"));


        this.fillInData();
        userTable.getItems().addAll(data);
    }

    private void fillInData() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for(Copy copy : getLibrary().getResourceManager().getAllCopies()){
            if(copy.getBorrowedBy() != null){
                String copyID = copy.getUniqueCopyID();
                String copyName = copy.getCopyOf().getTitle();
                String username = copy.getBorrowedBy().getUsername();
                String borrowedOn = dateFormat.format(copy.getBorrowedOn());

                data.add(new TableRepresentationCopyInformation(copyID, username, copyName, borrowedOn));
            }
        }
    }

}