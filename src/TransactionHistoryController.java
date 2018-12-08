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
 * Controller class for the transaction history window.
 * Handles the interaction between the user and the UI.
 *
 * @author Sian Pike
 */
public class TransactionHistoryController extends Controller {

    @FXML
    private Button okButton;

    @FXML
    private TableView<TableRepresentationMoneyTransaction> transactionHistoryTable;

    @FXML
    private TableColumn<TableRepresentationMoneyTransaction, String> typeColumn;

    @FXML
    private TableColumn<TableRepresentationMoneyTransaction, String> dateColumn;

    @FXML
    private TableColumn<TableRepresentationMoneyTransaction, Double> amountColumn;

    @FXML
    private TableColumn<TableRepresentationMoneyTransaction, String> itemID;

    @FXML
    private TableColumn<TableRepresentationMoneyTransaction, Integer> daysOverdue;

    @FXML
    private ObservableList<TableRepresentationMoneyTransaction> data;

    @FXML
    void okButtonClicked(ActionEvent event) {
        new NewWindow("resources/UserDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

    @Override
    public void onStart() {
        data = FXCollections.observableArrayList();
        typeColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationMoneyTransaction, String>("type"));

        dateColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationMoneyTransaction, String>("date"));

        amountColumn.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationMoneyTransaction, Double>("amount"));

        itemID.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationMoneyTransaction, String>("itemID"));

        daysOverdue.setCellValueFactory(
                new PropertyValueFactory<TableRepresentationMoneyTransaction, Integer>("daysOverdue"));


        this.fillInData();
        transactionHistoryTable.getItems().addAll(data);
    }

    private void fillInData() {

        NormalUser currentlyLoggedIn = (NormalUser) getLibrary().getCurrentUserLoggedIn();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (HistoryEntry entry : currentlyLoggedIn.getTransactionHistory().getHistory()) {
            if (entry instanceof HistoryEntryFine) {
                String type = "fine";
                String date = dateFormat.format(entry.getDate());
                Double amount = ((HistoryEntryFine) entry).getAmount();
                String itemID = ((HistoryEntryFine) entry).getItem().getUniqueCopyID();
                Integer daysOverdue = ((HistoryEntryFine) entry).getDaysOverdue();

                data.add(new TableRepresentationMoneyTransaction(type, date, amount, itemID, daysOverdue));
            } else if (entry instanceof HistoryEntryMoneyTransaction) {
                data.add(new TableRepresentationMoneyTransaction("payment",
                        dateFormat.format(entry.getDate()),
                        ((HistoryEntryMoneyTransaction) entry).getAmount()));
            }
        }
    }

}