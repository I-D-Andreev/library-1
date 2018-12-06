import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * Controller class for the Create/Edit screen for the Librarian.
 * Handles what happens when the user interacts with the UI.
 *
 * @author Chris McAuley.
 */

public class CreateEditController extends Controller {

    // Create Book Tab
    @FXML
    private TextField titleBookTextField;

    @FXML
    private TextField yearBookTextField;

    @FXML
    private TextField imagePathBookTextField;

    @FXML
    private TextField authorBookTextField;

    @FXML
    private TextField publisherBookTextField;

    @FXML
    private TextField genreBookTextField;

    @FXML
    private TextField isbnBookTextField;

    @FXML
    private TextField languageBookTextField;

    @FXML
    private Button createBookButton;


    // Create DVD tab
    @FXML
    private TextField titleDVDTextField;

    @FXML
    private TextField yearDVDTextField;

    @FXML
    private TextField imagePathDVDTextField;

    @FXML
    private TextField directorDVDTextField;

    @FXML
    private TextField runtimeDVDTextField;

    @FXML
    private TextField languageDVDTextField;

    @FXML
    private TextField languageSubtitlesDVDTextField;

    @FXML
    private Button createDVDButton;

    // Create laptop tab.
    @FXML
    private TextField titleLaptopTextField;

    @FXML
    private TextField yearLaptopTextField;

    @FXML
    private TextField imagePathLaptopTextField;

    @FXML
    private TextField manufacturerLaptopTextField;

    @FXML
    private TextField modelLaptopTextField;

    @FXML
    private TextField operatingSystemLaptopTextField;

    @FXML
    private Button createLaptopButton;

    // Edit book tab.
    @FXML
    private TextField uniqueIDSearchEditBookTextField;

    @FXML
    private TextField titleEditBookTextField;

    @FXML
    private TextField yearEditBookTextField;

    @FXML
    private TextField authorEditBookTextField;

    @FXML
    private TextField imagePathEditBook;

    @FXML
    private TextField publisherEditBookTextField;

    @FXML
    private TextField genreEditBookTextField;

    @FXML
    private TextField isbnEditBookTextField;

    @FXML
    private TextField languageEditBookTextField;

    @FXML
    private Button editBookButton;

    @FXML
    private Button editBookSearchButton;

    // Edit DVD tab.
    @FXML
    private TextField uniqueIDSearchEditDVDTextField;

    @FXML
    private TextField titleEditDVDTextField;

    @FXML
    private TextField yearEditDVDTextField;

    @FXML
    private TextField imagePathEditDVD;

    @FXML
    private TextField directorEditDVDTextField;

    @FXML
    private TextField runtimeEditDVDTextField;

    @FXML
    private TextField languageEditDVDTextField;

    @FXML
    private TextField languageSubtitlesEditDVD1TextField;

    @FXML
    private Button editDVDButton;

    @FXML
    private Button editDVDSearchButton;

    @FXML
    private Tab editLaptopTab;

    @FXML
    private TextField uniqueIDSearchEditLaptopTextField;

    @FXML
    private TextField titleEditLaptopTextField;

    @FXML
    private TextField yearEditLaptopTextField;

    @FXML
    private TextField manufacturerEditLaptopTextField;

    @FXML
    private TextField modelEditLaptopTextField;

    @FXML
    private TextField operatingSystemEditLaptopTextField;

    @FXML
    private Button editLaptopButton;

    @FXML
    private Button editLaptopSearchButton;

    @FXML
    private TextField imagePathEditLaptop;

    @FXML
    private Button backButton;
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
    public void createBookButtonClicked(ActionEvent event) {
        // mandatory information- title, year, thumbnail, author, publisher
        // optional information- genre, isbn, language

        if (titleBookTextField.getText().isEmpty() || yearBookTextField.getText().isEmpty()
                || imagePathBookTextField.getText().isEmpty() || publisherBookTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all the required fields.",
                    ButtonType.OK);
            alert.show();
        } else if (!isStringNumber(yearBookTextField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The year text field must be a number.",
                    ButtonType.OK);
            alert.show();
        } else {
            // gather the information
            String title = titleBookTextField.getText();
            int year = Integer.parseInt(yearBookTextField.getText());
            String thumbnail = imagePathBookTextField.getText();
            String author = authorBookTextField.getText();
            String publisher = publisherBookTextField.getText();
            String genre = genreBookTextField.getText();
            String isbn = isbnBookTextField.getText();
            String language = languageBookTextField.getText();

            // create a Book and add it
            getLibrary().getResourceManager().addResource(new Book(title, year, thumbnail, author, publisher,
                    genre, isbn, language));

            // notify the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book resource created successfully.",
                    ButtonType.OK);
            alert.show();

            // clear all the fields
            this.clearAllCreateBookFields();
        }
    }

    @FXML
    public void createDVDButtonClicked(ActionEvent event) {
        // mandatory information- title, year, thumbnail, director, runtime
        // optional information- language, listOfSubtitleLanguages
        if (titleDVDTextField.getText().isEmpty() || yearDVDTextField.getText().isEmpty()
                || imagePathDVDTextField.getText().isEmpty() || directorDVDTextField.getText().isEmpty()
                || runtimeDVDTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all the required fields.",
                    ButtonType.OK);
            alert.show();
        } else if (!isStringNumber(yearDVDTextField.getText()) || !isStringNumber(runtimeDVDTextField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The year and runtime text fields must be a number.",
                    ButtonType.OK);
            alert.show();
        } else {
            // gather the information
            String title = titleDVDTextField.getText();
            int year = Integer.parseInt(yearDVDTextField.getText());
            String thumbnail = imagePathDVDTextField.getText();
            String director = directorDVDTextField.getText();
            int runtime = Integer.parseInt(runtimeDVDTextField.getText());
            String language = languageDVDTextField.getText();

            // get a string containing the languages comma separated
            String subtitleLanguages = languageSubtitlesDVDTextField.getText();

            // split the string into smaller strings on new line, comma or space
            String[] arrayOfSubtitleLanguages = subtitleLanguages.split("\\r?\\n|,| ");

            // convert that array into array list
            ArrayList<String> listOfSubtitleLanguages = new ArrayList<>(Arrays.asList(arrayOfSubtitleLanguages));

            // create a DVD and add it
            getLibrary().getResourceManager().addResource(new DVD(title, year, thumbnail, director,
                    runtime, language, listOfSubtitleLanguages));

            // notify the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "DVD resource created successfully.",
                    ButtonType.OK);
            alert.show();

            // clear all the fields
            this.clearAllCreateDVDFields();
        }
    }

    @FXML
    public void createLaptopButtonClicked(ActionEvent event) {
        // mandatory information - title, year, thumbnail, manufacturer, model, installedOS
        if (titleLaptopTextField.getText().isEmpty() || yearLaptopTextField.getText().isEmpty()
                || imagePathLaptopTextField.getText().isEmpty() || manufacturerLaptopTextField.getText().isEmpty()
                || modelLaptopTextField.getText().isEmpty() || operatingSystemLaptopTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all the required fields.",
                    ButtonType.OK);
            alert.show();
        } else if (!isStringNumber(yearLaptopTextField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The year text field must be a number.",
                    ButtonType.OK);
            alert.show();
        } else {
            // gather the information
            String title = titleLaptopTextField.getText();
            int year = Integer.parseInt(yearLaptopTextField.getText());
            String thumbnail = imagePathLaptopTextField.getText();
            String manufacturer = manufacturerLaptopTextField.getText();
            String model = modelLaptopTextField.getText();
            String installedOS = operatingSystemLaptopTextField.getText();

            // create a Laptop object and add it
            getLibrary().getResourceManager().addResource(new Laptop(title, year, thumbnail, manufacturer,
                    model, installedOS));

            // notify the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Laptop resource created successfully.",
                    ButtonType.OK);
            alert.show();

            // clear all the fields
            this.clearAllCreateLaptopFields();
        }
    }

    @FXML
    public void editBookSearchButtonClicked(ActionEvent event) {
        String bookID = uniqueIDSearchEditBookTextField.getText();
        Resource resource = getLibrary().getResourceManager().getResourceById(bookID);

        if (resource == null || !resource.getType().equals("Book")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't find a book with such ID.",
                    ButtonType.OK);
            alert.show();
        } else {
            // Book is successfully found.
            Book book = (Book) resource;

            // fill the fields with data
            titleEditBookTextField.setText(book.getTitle());
            yearEditBookTextField.setText(String.valueOf(book.getYear()));
            authorEditBookTextField.setText(book.getAuthor());
            imagePathEditBook.setText(book.getThumbnailImagePath());
            publisherEditBookTextField.setText(book.getPublisher());
            genreEditBookTextField.setText(book.getGenre());
            isbnEditBookTextField.setText(book.getISBN());
            languageEditBookTextField.setText(book.getLanguage());

            // lock the id field
            uniqueIDSearchEditBookTextField.setDisable(true);
        }
    }

    @FXML
    public void editBookButtonClicked(ActionEvent event) {
        // mandatory information- title, year, thumbnail, author, publisher
        // optional information- genre, isbn, language

        if (titleEditBookTextField.getText().isEmpty() || yearEditBookTextField.getText().isEmpty()
                || imagePathEditBook.getText().isEmpty() || publisherEditBookTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all the required fields.",
                    ButtonType.OK);
            alert.show();
        } else if (!isStringNumber(yearEditBookTextField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The year text field must be a number.",
                    ButtonType.OK);
            alert.show();
        } else {
            // gather the information
            String title = titleEditBookTextField.getText();
            int year = Integer.parseInt(yearEditBookTextField.getText());
            String thumbnail = imagePathEditBook.getText();
            String author = authorEditBookTextField.getText();
            String publisher = publisherEditBookTextField.getText();
            String genre = genreEditBookTextField.getText();
            String isbn = isbnEditBookTextField.getText();
            String language = languageEditBookTextField.getText();

            // get the book
            Book book = (Book) getLibrary().getResourceManager().
                    getResourceById(uniqueIDSearchEditBookTextField.getText());
            // edit the book
            getLibrary().getResourceManager().editBook(book, title, year, thumbnail, author, publisher,
                    genre, isbn, language);

            // notify the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book resource edited successfully.",
                    ButtonType.OK);
            alert.show();

            // enable the search ID again and clear all the fields
            uniqueIDSearchEditBookTextField.setDisable(false);
            this.clearAllEditBookFields();
        }
    }

    @FXML
    void editDVDSearchButtonClicked(ActionEvent event) {

    }


    @FXML
    public void editDVDButtonClicked(ActionEvent event) {

    }


    @FXML
    void editLaptopSearchButtonClicked(ActionEvent event) {
        String laptopId = uniqueIDSearchEditLaptopTextField.getText();
        Resource resource = getLibrary().getResourceManager().getResourceById(laptopId);

        if (resource == null || !resource.getType().equals("Laptop")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't find a laptop with such ID.",
                    ButtonType.OK);
            alert.show();
        } else {
            // Laptop is successfully found.
            Laptop laptop = (Laptop) resource;

            // fill the fields with data
            titleEditLaptopTextField.setText(laptop.getTitle());
            yearEditLaptopTextField.setText(String.valueOf(laptop.getYear()));
            imagePathEditLaptop.setText(laptop.getThumbnailImagePath());
            manufacturerEditLaptopTextField.setText(laptop.getManufacturer());
            modelEditLaptopTextField.setText(laptop.getModel());
            operatingSystemEditLaptopTextField.setText(laptop.getInstalledOS());

            // lock the id field
            uniqueIDSearchEditLaptopTextField.setDisable(true);
        }
    }

    @FXML
    public void editLaptopButtonClicked(ActionEvent event) {
        // mandatory information - title, year, thumbnail, manufacturer, model, installedOS
        if (titleEditLaptopTextField.getText().isEmpty() || yearEditLaptopTextField.getText().isEmpty()
                || imagePathEditLaptop.getText().isEmpty() || manufacturerEditLaptopTextField.getText().isEmpty()
                || modelEditLaptopTextField.getText().isEmpty() || operatingSystemEditLaptopTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all the required fields.",
                    ButtonType.OK);
            alert.show();
        } else if (!isStringNumber(yearEditLaptopTextField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The year text field must be a number.",
                    ButtonType.OK);
            alert.show();
        } else {
            // gather the information
            String title = titleEditLaptopTextField.getText();
            int year = Integer.parseInt(yearEditLaptopTextField.getText());
            String imagePath = imagePathEditLaptop.getText();
            String manufacturer = manufacturerEditLaptopTextField.getText();
            String model = modelEditLaptopTextField.getText();
            String installedOS = operatingSystemEditLaptopTextField.getText();

            // Find the laptop.
            Laptop laptop = (Laptop) getLibrary().getResourceManager().
                    getResourceById(uniqueIDSearchEditLaptopTextField.getText());

            // Change the laptop
            getLibrary().getResourceManager().editLaptop(laptop, title, year, imagePath,
                    manufacturer, model, installedOS);

            // notify the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Laptop resource edited successfully.",
                    ButtonType.OK);
            alert.show();

            // enable the search bar and clear all the fields
            uniqueIDSearchEditLaptopTextField.setDisable(false);
            this.clearAllEditLaptopFields();
        }
    }

    /**
     * Check if a certain string contains numbers only.
     *
     * @param s The string.
     * @return True if the string contains only numbers, false otherwise.
     */
    private boolean isStringNumber(String s) {
        // regular expression
        // \\d+ means 1 or more digits
        return s.matches("\\d+");
    }



    private void clearAllCreateBookFields(){
        titleBookTextField.setText("");
        authorBookTextField.setText("");
        imagePathBookTextField.setText("");
        authorBookTextField.setText("");
        publisherBookTextField.setText("");
        genreBookTextField.setText("");
        isbnBookTextField.setText("");
        languageBookTextField.setText("");
        yearBookTextField.setText("");
    }

    private void clearAllCreateLaptopFields(){
        titleLaptopTextField.setText("");
        yearLaptopTextField.setText("");
        imagePathLaptopTextField.setText("");
        manufacturerLaptopTextField.setText("");
        modelLaptopTextField.setText("");
        operatingSystemLaptopTextField.setText("");
    }

    private void clearAllCreateDVDFields(){
        titleDVDTextField.setText("");
        yearDVDTextField.setText("");
        imagePathDVDTextField.setText("");
        directorDVDTextField.setText("");
        runtimeDVDTextField.setText("");
        languageDVDTextField.setText("");
        languageSubtitlesDVDTextField.setText("");
    }

    private void clearAllEditBookFields(){
        uniqueIDSearchEditBookTextField.setText("");
        titleEditBookTextField.setText("");
        yearEditBookTextField.setText("");
        authorEditBookTextField.setText("");
        imagePathEditBook.setText("");
        publisherEditBookTextField.setText("");
        genreEditBookTextField.setText("");
        isbnEditBookTextField.setText("");
        languageEditBookTextField.setText("");
    }

    private void clearAllEditLaptopFields(){
        uniqueIDSearchEditLaptopTextField.setText("");
        titleEditLaptopTextField.setText("");
        yearEditLaptopTextField.setText("");
        imagePathEditLaptop.setText("");
        manufacturerEditLaptopTextField.setText("");
        modelEditLaptopTextField.setText("");
        operatingSystemEditLaptopTextField.setText("");
    }
}

