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
 * Controller for the User Resource Window.
 * Handles user interaction with the UI.
 *
 * @author Sian Pike
 */
public class UserResourceController extends Controller {

    @FXML // fx:id="resourceImage"
    private ImageView resourceImage; // Value injected by FXMLLoader

    @FXML // fx:id="copyIdLabel"
    private Label copyIdLabel; // Value injected by FXMLLoader

    @FXML // fx:id="isAvailableLabel"
    private Label isAvailableLabel; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML
    private static Resource clickedResource;

    @FXML
    private TableView<TableRepresentationCopyAvailable> tableView;

    @FXML
    private TableColumn<TableRepresentationCopyAvailable, String> uniqueIDColumn;

    @FXML
    private TableColumn<TableRepresentationCopyAvailable, String> isAvailableColumn;


    @FXML
    private ObservableList<TableRepresentationCopyAvailable> data;

    /**
     * Takes the user to the browse resource tab after the button is clicked.
     * @param event The button is clicked.
     */
    @FXML
    public void okButtonClicked(ActionEvent event) {
        clickedResource = null;
        new NewWindow("resources/BrowseResources.fxml", event,
                "Browse Resources - TaweLib", getLibrary());
    }

    public static void setClickedResource(Resource resource) {
        clickedResource = resource;
    }

    /**
     * Initializes the tab for the user.
     */
    @Override
    public void onStart() {
        data = FXCollections.observableArrayList();
        uniqueIDColumn.setCellValueFactory(new PropertyValueFactory<TableRepresentationCopyAvailable, String>("uniqueCopyID"));
        isAvailableColumn.setCellValueFactory(new PropertyValueFactory<TableRepresentationCopyAvailable, String>("isAvailable"));

        for (Copy copy : clickedResource.getCopyManager().getListOfAllCopies()) {
            data.add(new TableRepresentationCopyAvailable(copy.getUniqueCopyID(),
                    (copy.isAvailable()) ? "available" : "not available"));
        }

        tableView.getItems().addAll(data);

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