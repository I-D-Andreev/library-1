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
import java.util.Date;

/**
 * Controller class for the overdue resources window.
 * Handles the interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class OverdueResourcesController extends Controller {

    @FXML
    private Button okButton;

    @FXML
    private TableView<TableRepresentationCopyInformation> overdueResourcesTable;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> copyIDColumn;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> borrowedOnColumn;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, String> dueDateColumn;

    @FXML
    private TableColumn<TableRepresentationCopyInformation, Integer> daysOverdueColumn;

    @FXML
    private ObservableList<TableRepresentationCopyInformation> data;

    /**
     * When the button is clicked the user is returned to the main dashboard.
     *
     * @param event The button is clicked.
     */
    @FXML
    public void okButtonClicked(ActionEvent event) {
        new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

    @Override
    public void onStart(){
        NormalUser currentlyLoggedIn = (NormalUser) getLibrary().getCurrentUserLoggedIn();
        data = FXCollections.observableArrayList();
        copyIDColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("copyID"));



        borrowedOnColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("borrowDate"));

        dueDateColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, String>("dueDate"));


        daysOverdueColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationCopyInformation, Integer>("daysOverdue"));

        this.fillInData();
        overdueResourcesTable.getItems().addAll(data);
    }

    private void fillInData() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        //final long oneDayInMilliseconds = 3600 * 24 * 1000;
        final long oneDayInMilliseconds = 15 * 1000;

        // current date
        Date today = new Date();

        for (Copy copy : getLibrary().getResourceManager().getOverdueCopies()) {
            String copyID = copy.getUniqueCopyID();
            String borrowedOn = dateFormat.format(copy.getBorrowedOn());
            String dueDate = dateFormat.format(copy.getDueDate());
            Integer daysOverdue = Math.toIntExact ((today.getTime() - copy.getDueDate().getTime()) / oneDayInMilliseconds);

            data.add(new TableRepresentationCopyInformation(copyID, borrowedOn, dueDate, daysOverdue));
        }
    }

}
