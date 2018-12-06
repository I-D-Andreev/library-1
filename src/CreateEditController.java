import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Controller class for the Create/Edit screen for the Librarian.
 * Handles what happens when the user interacts with the UI.
 * @author Chris McAuley.
 */

public class CreateEditController extends Controller {

    @FXML// fx:id="createBookTab"
    private Tab createBookTab;// Value injected by FXMLLoader

    @FXML// fx:id="yearBookTextField"
    private TextField yearBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="titleBookTextField"
    private TextField titleBookTextField;// Value injected by FXMLLoader

    @FXML
    private TextField imagePathBookTextField;

    @FXML// fx:id="authorBookTextField"
    private TextField authorBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="publisherBookTextField"
    private TextField publisherBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="genreBookTextField"
    private TextField genreBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="isbnBookTextField"
    private TextField isbnBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="languageBookTextField"
    private TextField languageBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="createBookButton"
    private Button createBookButton;// Value injected by FXMLLoader

    @FXML// fx:id="createDVDTab"
    private Tab createDVDTab;// Value injected by FXMLLoader

    @FXML// fx:id="yearDVDTextField"
    private TextField yearDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="titleDVDTextField"
    private TextField titleDVDTextField;// Value injected by FXMLLoader

    @FXML
    private TextField imagePathDVDTextField;

    @FXML// fx:id="directorDVDTextField"
    private TextField directorDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="runtimeDVDTextField"
    private TextField runtimeDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="languageDVDTextField"
    private TextField languageDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="languageSubtitlesDVD1TextField"
    private TextField languageSubtitlesDVD1TextField;// Value injected by FXMLLoader

    @FXML// fx:id="languageSubtitlesDVD2TextField"
    private TextField languageSubtitlesDVD2TextField;// Value injected by FXMLLoader

    @FXML// fx:id="createDVDButton"
    private Button createDVDButton;// Value injected by FXMLLoader

    @FXML// fx:id="languageSubtitlesDVD3TextField"
    private TextField languageSubtitlesDVD3TextField;// Value injected by FXMLLoader

    @FXML// fx:id="createLaptopTab"
    private Tab createLaptopTab;// Value injected by FXMLLoader

    @FXML// fx:id="yearLaptopTextField"
    private TextField yearLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="titleLaptopTextField"
    private TextField titleLaptopTextField;// Value injected by FXMLLoader

    @FXML
    private TextField imagePathLaptopTextField;

    @FXML// fx:id="manufacturerLaptopTextField"
    private TextField manufacturerLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="modelLaptopTextField"
    private TextField modelLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="operatingSystemLaptopTextField"
    private TextField operatingSystemLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="createLaptopButton"
    private Button createLaptopButton;// Value injected by FXMLLoader

    @FXML// fx:id="editBookTab"
    private Tab editBookTab;// Value injected by FXMLLoader

    @FXML// fx:id="yearEditBookTextField"
    private TextField yearEditBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="titleEditBookTextField"
    private TextField titleEditBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="authorEditBookTextField"
    private TextField authorEditBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="publisherEditBookTextField"
    private TextField publisherEditBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="genreEditBookTextField"
    private TextField genreEditBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="isbnEditBookTextField"
    private TextField isbnEditBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="languageEditBookTextField"
    private TextField languageEditBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="editBookButton"
    private Button editBookButton;// Value injected by FXMLLoader

    @FXML// fx:id="uniqueIDSearchEditBookTextField"
    private TextField uniqueIDSearchEditBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="editBookSearchButton"
    private Button editBookSearchButton;// Value injected by FXMLLoader

    @FXML// fx:id="editDVDTab"
    private Tab editDVDTab;// Value injected by FXMLLoader

    @FXML// fx:id="uniqueIDEditDVDTextField"
    private TextField uniqueIDEditDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="yearEditDVDTextField"
    private TextField yearEditDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="titleEditDVDTextField"
    private TextField titleEditDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="directorEditDVDTextField"
    private TextField directorEditDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="runtimeEditDVDTextField"
    private TextField runtimeEditDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="languageEditDVDTextField"
    private TextField languageEditDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="languageSubtitlesEditDVD1TextField"
    private TextField languageSubtitlesEditDVD1TextField;// Value injected by FXMLLoader

    @FXML// fx:id="editDVDButton"
    private Button editDVDButton;// Value injected by FXMLLoader

    @FXML// fx:id="uniqueIDSearchEditDVDTextField"
    private TextField uniqueIDSearchEditDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="editDVDSearchButton"
    private Button editDVDSearchButton;// Value injected by FXMLLoader

    @FXML// fx:id="languageSubtitlesEditDVD2TextField"
    private TextField languageSubtitlesEditDVD2TextField;// Value injected by FXMLLoader

    @FXML// fx:id="languageSubtitlesEditDVD3TextField"
    private TextField languageSubtitlesEditDVD3TextField;// Value injected by FXMLLoader

    @FXML// fx:id="editLaptopTab"
    private Tab editLaptopTab;// Value injected by FXMLLoader

    @FXML// fx:id="uniqueIDSearchEditLaptopTextField"
    private TextField uniqueIDEditLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="yearEditLaptopTextField"
    private TextField yearEditLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="titleEditLaptopTextField"
    private TextField titleEditLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="manufacturerEditLaptopTextField"
    private TextField manufacturerEditLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="modelEditLaptopTextField"
    private TextField modelEditLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="operatingSystemEditLaptopTextField"
    private TextField operatingSystemEditLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="editLaptopButton"
    private Button editLaptopButton;// Value injected by FXMLLoader

    @FXML// fx:id="uniqueIDSearchEditLaptopTextField"
    private TextField uniqueIDSearchEditLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="editLaptopSearchButton"
    private Button editLaptopSearchButton;// Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    /**
     * Goes back to the librarian dashboard when clicked.
     *
     * @param event The current event.
     */
    @FXML
    public void backButtonClicked(ActionEvent event) {

        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }


    @FXML
    void createBookButtonClicked(ActionEvent event) {
        // mandatory - title, year, thumbnail, author, publisher
        // optional - genre, isbn, language

        if(titleBookTextField.getText().isEmpty() || yearBookTextField.getText().isEmpty()
        || imagePathBookTextField.getText().isEmpty() || publisherBookTextField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all the fields.",
                    ButtonType.OK);
            alert.show();
        } else {

            String title = titleBookTextField.getText();
            int year = Integer.parseInt(yearBookTextField.getText());
            String thumbnail = imagePathBookTextField.getText();
            String author = authorBookTextField.getText();
            String publisher = publisherBookTextField.getText();
            String genre = genreBookTextField.getText();
            String isbn = isbnBookTextField.getText();
            String language = languageBookTextField.getText();

            getLibrary().getResourceManager().addResource(new Book(title, year, thumbnail, author, publisher,
                    genre, isbn, language));

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book added successfully.",
                    ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void createDVDButtonClicked(ActionEvent event) {

    }

    @FXML
    void createLaptopButtonClicked(ActionEvent event) {

    }

    @FXML
    void editBookButtonClicked(ActionEvent event) {

    }

    @FXML
    void editDVDButtonClicked(ActionEvent event) {

    }

    @FXML
    void editLaptopButtonClicked(ActionEvent event) {

    }
}

