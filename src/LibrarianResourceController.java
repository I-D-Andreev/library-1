import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

/**
 * Controller class for the librarian resource window.
 * Handles interaction between the user and UI.
 *
 * @author Sian Pike
 */
public class LibrarianResourceController extends Controller {

    /**
     * Shows the image of the resource.
     */
    @FXML // fx:id="resourceImage"
    private ImageView resourceImage; // Value injected by FXMLLoader

    /**
     * Label that shows who borrowed the resource.
     */
    @FXML // fx:id="borrowedByLabel"
    private Label borrowedByLabel; // Value injected by FXMLLoader

    /**
     * Label that shows the due date of the resource.
     */
    @FXML // fx:id="dueDateLabel"
    private Label dueDateLabel; // Value injected by FXMLLoader

    /**
     * The table showing the available copies.
     */
    @FXML // fx:id="copyHistoryTable"
    private TableView<TableRepresentationCopyAvailable> displayTable; // Value injected by FXMLLoader

    /**
     * The column showing the copy Id.
     */
    @FXML // fx:id="copyHistoryColumn"
    private TableColumn<TableRepresentationCopyAvailable, String> copyIDColumn; // Value injected by FXMLLoader

    /**
     * The column showing the available copies.
     */
    @FXML
    private TableColumn<TableRepresentationCopyAvailable, String> copyAvailableColumn; // Value injected by FXMLLoader

    /**
     * The column showing showing the borrowed by column.
     */
    @FXML
    private TableColumn<TableRepresentationCopyAvailable, String> copyBorrowedByColumn; // Value injected by FXMLLoader

    /**
     * Column showing the who the copies are reserved for.
     */
    @FXML
    private TableColumn<TableRepresentationCopyAvailable, String> copyReservedForColumn; // Value injected by FXMLLoader

    /**
     * The data for the table.
     */
    @FXML
    private ObservableList<TableRepresentationCopyAvailable> data;

    /**
     * Button to return user to dashboard.
     */
    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    /**
     * The resource we clicked on the table.
     */
    @FXML
    private static Resource clickedResource;

    /**
     * Returns the user to the dashboard when the button is clicked.
     *
     * @param event The button is clicked.
     */
    @FXML
    public void okButtonClicked(ActionEvent event) {
        clickedResource = null;
        new NewWindow("resources/BrowseResources.fxml", event, "Librarian Copy View", getLibrary());
    }

    /**
     * Sets the clicked resource.
     *
     * @param resource The resource we clicked on.
     */
    public static void setClickedResource(Resource resource) {
        clickedResource = resource;
    }

    /**
     * Initializes the table and fills it with data.
     */
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

        this.loadImage();
    }

    /**
     * Tries to load an image.
     */
    private void loadImage() {
        try {
            String path = clickedResource.getThumbnailImagePath();
            Image image;
            // relative path
            if (path.charAt(0) >= 'a' && path.charAt(0) <= 'z') {
                image = new Image(path);
            } else {
                // absolute path
                image = new Image(new File(path).toURI().toString());
            }
            resourceImage.setImage(image);

        } catch (Exception e) {
            try {
                resourceImage.setImage(new Image("resources/noImage.png"));
            } catch (Exception ex) {
                resourceImage.setImage(null);
            }
        }
    }
}