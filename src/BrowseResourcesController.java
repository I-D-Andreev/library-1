import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * Controller class for the Browse Resources Page for Lirarian/User.
 * Handles what happens when the user interacts with the UI.
 * @author Chris McAuley.
 */

public class PleaseProvideControllerClassName {

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
    private TableView<?> displayTable;// Value injected by FXMLLoader

    @FXML// fx:id="uniqueIDColumn"
    private TableColumn<?, ?> uniqueIDColumn;// Value injected by FXMLLoader

    @FXML// fx:id="titleColumn"
    private TableColumn<?, ?> titleColumn;// Value injected by FXMLLoader

    @FXML// fx:id="yearColumn"
    private TableColumn<?, ?> yearColumn;// Value injected by FXMLLoader

    @FXML// fx:id="typeColumn"
    private TableColumn<?, ?> typeColumn;// Value injected by FXMLLoader

}

