import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

/**
 * Controller class for the Create/Edit screen for the Librarian.
 * Handles what happens when the user interacts with the UI.
 * @author Chris McAuley.
 */

public class CreateEditController {

    @FXML// fx:id="createEditCloseButton"
    private Button createEditCloseButton;// Value injected by FXMLLoader

    @FXML// fx:id="createBookTab"
    private Tab createBookTab;// Value injected by FXMLLoader

    @FXML// fx:id="uniqueIDBookTextField"
    private TextField uniqueIDBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="yearBookTextField"
    private TextField yearBookTextField;// Value injected by FXMLLoader

    @FXML// fx:id="titleBookTextField"
    private TextField titleBookTextField;// Value injected by FXMLLoader

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

    @FXML// fx:id="uniqueIDDVDTextField"
    private TextField uniqueIDDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="yearDVDTextField"
    private TextField yearDVDTextField;// Value injected by FXMLLoader

    @FXML// fx:id="titleDVDTextField"
    private TextField titleDVDTextField;// Value injected by FXMLLoader

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

    @FXML// fx:id="uniqueIDLaptopTextField"
    private TextField uniqueIDLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="yearLaptopTextField"
    private TextField yearLaptopTextField;// Value injected by FXMLLoader

    @FXML// fx:id="titleLaptopTextField"
    private TextField titleLaptopTextField;// Value injected by FXMLLoader

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

    @FXML// fx:id="uniqueIDEditBookTextField"
    private TextField uniqueIDEditBookTextField;// Value injected by FXMLLoader

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

}

