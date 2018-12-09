import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Controller for the copy history window.
 * Handles the interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class CopyHistoryController extends Controller {

    /**
     * Button to take user back to the dashboard.
     */
    @FXML
    private Button okButton;

    /**
     * The table for the copy's history.
     */
    @FXML
    private TableView<TableRepresentationItemTransaction> copyHistoryTable;

    @FXML
    private TableColumn<TableRepresentationItemTransaction, String> borrowReturnColumn;

    @FXML
    private TableColumn<TableRepresentationItemTransaction, String> usernameColumn;

    @FXML
    private TableColumn<TableRepresentationItemTransaction, String> dateColumn;

    @FXML
    private TextField copyIDTextField;

    @FXML
    private Button copySearchButton;

    @FXML
    private ObservableList<TableRepresentationItemTransaction> data;


    /**
     * Takes the user back to the dashboard when the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    public void okButtonClicked(ActionEvent event) {
        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }


    @FXML
    public void copySearchButtonClicked(ActionEvent event) {
        String copyID = copyIDTextField.getText();
        Copy copy = getLibrary().getResourceManager().getCopyById(copyID);

        if(copy == null){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect Copy ID.",
                    ButtonType.OK);
            alert.show();
        } else {
            this.fillTable(copy);
        }
    }

    @Override
    public void onStart(){
        data = FXCollections.observableArrayList();

        borrowReturnColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationItemTransaction, String>("borrowedOrReturned"));

        usernameColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationItemTransaction, String>("username"));

        dateColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationItemTransaction, String>("date"));
    }

    private void fillTable(Copy copy) {

        // clear previous data
        copyHistoryTable.getItems().clear();
        data.clear();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


        for(HistoryEntry eachEntry : copy.getLoanHistory().getHistory()){
            HistoryEntryItemTransaction entry = (HistoryEntryItemTransaction) eachEntry;
            String borrowOrReturn = (entry.isBorrowed()) ? "borrowed" : "returned";
            String username = entry.getBorrowedBy().getUsername();
            String date = dateFormat.format(entry.getDate());

            data.add(new TableRepresentationItemTransaction(borrowOrReturn, username, date));
        }

        copyHistoryTable.getItems().addAll(data);
    }

}
