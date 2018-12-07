import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Controller class for the Create/Edit screen for the Librarian.
 * Handles what happens when the user interacts with the UI.
 *
 * @author Chris McAuley.
 */

public class CreateEditController extends Controller {

    /**
     * The book's title field.
     */
    @FXML
    private TextField titleBookTextField;

    /**
     * The book's year field.
     */
    @FXML
    private TextField yearBookTextField;

    /**
     * The book's thumbnail image path field.
     */
    @FXML
    private TextField imagePathBookTextField;

    /**
     * The book's author field.
     */
    @FXML
    private TextField authorBookTextField;

    /**
     * The book's publisher field.
     */
    @FXML
    private TextField publisherBookTextField;

    /**
     * The book's genre field.
     */
    @FXML
    private TextField genreBookTextField;

    /**
     * The book's ISBN field.
     */
    @FXML
    private TextField isbnBookTextField;

    /**
     * The book's language field.
     */
    @FXML
    private TextField languageBookTextField;

    /**
     * The button that creates book resources.
     */
    @FXML
    private Button createBookButton;

    /**
     * The DVD's title field.
     */
    @FXML
    private TextField titleDVDTextField;

    /**
     * The DVD's year field.
     */
    @FXML
    private TextField yearDVDTextField;

    /**
     * The DVD's thumbnail image path field.
     */
    @FXML
    private TextField imagePathDVDTextField;

    /**
     * The DVD's director field.
     */
    @FXML
    private TextField directorDVDTextField;

    /**
     * The DVD's runtime field.
     */
    @FXML
    private TextField runtimeDVDTextField;

    /**
     * The DVD's language field.
     */
    @FXML
    private TextField languageDVDTextField;

    /**
     * The DVD's language of subtitles field.
     */
    @FXML
    private TextField languageSubtitlesDVDTextField;

    /**
     * The button that creates a DVD resource.
     */
    @FXML
    private Button createDVDButton;

    /**
     * The laptop's title field.
     */
    @FXML
    private TextField titleLaptopTextField;

    /**
     * The laptop's year field.
     */
    @FXML
    private TextField yearLaptopTextField;

    /**
     * The laptop's thumbnail image path field.
     */
    @FXML
    private TextField imagePathLaptopTextField;

    /**
     * The laptop's manufacturer field.
     */
    @FXML
    private TextField manufacturerLaptopTextField;

    /**
     * The laptop's model field.
     */
    @FXML
    private TextField modelLaptopTextField;

    /**
     * The laptops operating system field.
     */
    @FXML
    private TextField operatingSystemLaptopTextField;

    /**
     * The button that creates laptop resources.
     */
    @FXML
    private Button createLaptopButton;

    /**
     * The book's field where we edit the unique ID.
     */
    @FXML
    private TextField uniqueIDSearchEditBookTextField;

    /**
     * The book's field where we edit the title.
     */
    @FXML
    private TextField titleEditBookTextField;

    /**
     * The book's field where we edit the year.
     */
    @FXML
    private TextField yearEditBookTextField;

    /**
     * The book's field where we edit the author.
     */
    @FXML
    private TextField authorEditBookTextField;

    /**
     * The book's field where we edit the thumbnail image path.
     */
    @FXML
    private TextField imagePathEditBook;

    /**
     * The book's field where we edit the publisher.
     */
    @FXML
    private TextField publisherEditBookTextField;

    /**
     * The book's field where we edit the genre.
     */
    @FXML
    private TextField genreEditBookTextField;

    /**
     * The book's field where we edit the ISBN.
     */
    @FXML
    private TextField isbnEditBookTextField;

    /**
     * The book's field where we edit the language.
     */
    @FXML
    private TextField languageEditBookTextField;

    /**
     * The button that allows us to edit a book.
     */
    @FXML
    private Button editBookButton;

    /**
     * The book's edit search button.
     */
    @FXML
    private Button editBookSearchButton;

    /**
     * The DVD's edit search field by unique ID.
     */
    @FXML
    private TextField uniqueIDSearchEditDVDTextField;

    /**
     * The DVD's field where we edit the title.
     */
    @FXML
    private TextField titleEditDVDTextField;

    /**
     * The DVD's field where we edit the year.
     */
    @FXML
    private TextField yearEditDVDTextField;

    /**
     * The DVD's field where we edit the thumbnail image path.
     */
    @FXML
    private TextField imagePathEditDVD;

    /**
     * The DVD's field where we edit the director.
     */
    @FXML
    private TextField directorEditDVDTextField;

    /**
     * The DVD's field where we edit the runtime.
     */
    @FXML
    private TextField runtimeEditDVDTextField;

    /**
     * The DVD's field where we edit the language.
     */
    @FXML
    private TextField languageEditDVDTextField;

    /**
     * The DVD's field where we edit the subtitle languages of the dvd.
     */
    @FXML
    private TextField languageSubtitlesEditDVDTextField;

    /**
     * The edit button of the DVDs.
     */
    @FXML
    private Button editDVDButton;

    /**
     * The DVD's button that allows us to search for a dvd to edit.
     */
    @FXML
    private Button editDVDSearchButton;

    /**
     * The tab where we edit a laptop.
     */
    @FXML
    private Tab editLaptopTab;

    /**
     * The laptop's field where we search for a laptop to edit by unique ID.
     */
    @FXML

    private TextField uniqueIDSearchEditLaptopTextField;

    /**
     * The laptop's field where we edit the title.
     */
    @FXML
    private TextField titleEditLaptopTextField;

    /**
     * The laptop's field where we edit the year.
     */
    @FXML
    private TextField yearEditLaptopTextField;

    /**
     * The laptop's field where we edit the manufacturer.
     */
    @FXML
    private TextField manufacturerEditLaptopTextField;

    /**
     * The laptop's field where we edit the model.
     */
    @FXML
    private TextField modelEditLaptopTextField;

    /**
     * The laptop's field where we edit the OS.
     */
    @FXML
    private TextField operatingSystemEditLaptopTextField;

    /**
     * The button that allows us to edit a laptop.
     */
    @FXML
    private Button editLaptopButton;

    /**
     * The button that allows us to search for laptop to edit.
     */
    @FXML
    private Button editLaptopSearchButton;

    /**
     * The laptop's field where we edit the thumbnail image path.
     */
    @FXML
    private TextField imagePathEditLaptop;

    /**
     * The back button.
     */
    @FXML
    private Button backButton;

    /**
     * Button for laptop deletion.
     */
    @FXML // fx:id="laptopDeleteButton"
    private Button laptopDeleteButton; // Value injected by FXMLLoader

    /**
     * Button for DVD deletion.
     */
    @FXML // fx:id="dvdDeleteButton"
    private Button dvdDeleteButton; // Value injected by FXMLLoader

    /**
     * Button for book deletion.
     */
    @FXML // fx:id="bookDeleteButton"
    private Button bookDeleteButton; // Value injected by FXMLLoader

    /**
     * The resources field for unique ID.
     */
    @FXML // fx:id="resourceUniqueIDtextField"
    private TextField resourceUniqueIDtextField; // Value injected by FXMLLoader

    /**
     * The resources search button.
     */
    @FXML // fx:id="copySearchButton"
    private Button resourceSearchButton; // Value injected by FXMLLoader

    /**
     * The copy's loan duration field.
     */
    @FXML // fx:id="copyLoanDurationTextField"
    private TextField copyLoanDurationTextField; // Value injected by FXMLLoader

    /**
     * The button that creates a copy.
     */
    @FXML // fx:id="copyCreateButton"
    private Button copyCreateButton; // Value injected by FXMLLoader

    /**
     * The button that creates a book image.
     */
    @FXML // fx:id="createBookFindImageButton"
    private Button createBookFindImageButton; // Value injected by FXMLLoader

    /**
     * The button that creates a dvd image.
     */
    @FXML // fx:id="createDvdFindImageButton"
    private Button createDvdFindImageButton; // Value injected by FXMLLoader

    /**
     * The button that creates a laptop image.
     */
    @FXML // fx:id="createLaptopFindImageButton"
    private Button createLaptopFindImageButton; // Value injected by FXMLLoader

    /**
     * The button that creates a book image.
     */
    @FXML // fx:id="editBookFindImageButton"
    private Button editBookFindImageButton; // Value injected by FXMLLoader

    /**
     * The edit dvd image button.
     */
    @FXML // fx:id="editDvdFindImageButton"
    private Button editDvdFindImageButton; // Value injected by FXMLLoader

    /**
     * The edit laptop image button.
     */
    @FXML // fx:id="editLaptopFindImageButton"
    private Button editLaptopFindImageButton; // Value injected by FXMLLoader

    /**
     * Field for the edit of the search ID of the copy.
     */
    @FXML
    private TextField editCopyIdSearchTextField;

    /**
     * Field for the edit of the loan duration of the copy.
     */
    @FXML
    private TextField editCopyLoanDurationTextField;

    /**
     * The button to search for a copy.
     */
    @FXML
    private Button copySearchButton;

    /**
     * The button to edit a copy.
     */
    @FXML
    private Button editCopyButton;

    /**
     * The button to delete a copy.
     */
    @FXML
    private Button deleteCopyButton;


    /**
     * Goes back to the librarian dashboard when clicked.
     *
     * @param event When the back button is clicked.
     */
    @FXML
    public void backButtonClicked(ActionEvent event) {

        new NewWindow("resources/LibrarianDashboard.fxml", event, "Dashboard - TaweLib", getLibrary());
    }

    /**
     * Creates a book when the button is clicked.
     * @param event When the button is clicked.
     */
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

            // convert a comma separated string into an array list
            ArrayList<String> listOfSubtitleLanguages =
                    stringToArrayListOfStrings(languageSubtitlesDVDTextField.getText());

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

    private ArrayList<String> stringToArrayListOfStrings(String subtitleLanguages) {
        // split the string into smaller strings on new comma or space
        String[] arrayOfSubtitleLanguages = subtitleLanguages.split(",| ");

        // convert that array into array list
        ArrayList<String> listOfSubtitleLanguages = new ArrayList<>(Arrays.asList(arrayOfSubtitleLanguages));

        // remove empty strings
        for (int i = 0; i < listOfSubtitleLanguages.size(); i++) {
            if (listOfSubtitleLanguages.get(i).equals("")) {
                listOfSubtitleLanguages.remove(i);
            }
        }
        return listOfSubtitleLanguages;
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
        String dvdId = uniqueIDSearchEditDVDTextField.getText();
        Resource resource = getLibrary().getResourceManager().getResourceById(dvdId);

        if (resource == null || !resource.getType().equals("DVD")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't find a DVD with such ID.",
                    ButtonType.OK);
            alert.show();
        } else {
            // DVD is successfully found.
            DVD dvd = (DVD) resource;

            // fill the fields with data
            titleEditDVDTextField.setText(dvd.getTitle());
            yearEditDVDTextField.setText(String.valueOf(dvd.getYear()));
            imagePathEditDVD.setText(dvd.getThumbnailImagePath());
            directorEditDVDTextField.setText(dvd.getDirector());
            runtimeEditDVDTextField.setText(String.valueOf(dvd.getRuntime()));
            languageEditDVDTextField.setText(dvd.getLanguage());


            // convert the array list into comma separated string
            String subtitleLanguages = toCommaSeparatedString(dvd.getListOfSubtitleLanguages());

            languageSubtitlesEditDVDTextField.setText(subtitleLanguages);

            // lock the id field
            uniqueIDSearchEditDVDTextField.setDisable(true);
        }
    }

    private String toCommaSeparatedString(ArrayList<String> listOfSubtitleLanguages) {
        String subtitleLanguages = "";
        for (String language : listOfSubtitleLanguages) {
            subtitleLanguages = subtitleLanguages + language + ',';
        }

        // remove the last comma, if the subtitle language is not empty
        if (!subtitleLanguages.isEmpty()) {
            subtitleLanguages = subtitleLanguages.substring(0, subtitleLanguages.length() - 1);
        }
        return subtitleLanguages;
    }


    @FXML
    public void editDVDButtonClicked(ActionEvent event) {
        // mandatory information- title, year, thumbnail, director, runtime
        // optional information- language, listOfSubtitleLanguages
        if (titleEditDVDTextField.getText().isEmpty() || yearEditDVDTextField.getText().isEmpty()
                || imagePathEditDVD.getText().isEmpty() || directorEditDVDTextField.getText().isEmpty()
                || runtimeEditDVDTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all the required fields.",
                    ButtonType.OK);
            alert.show();
        } else if (!isStringNumber(yearEditDVDTextField.getText()) ||
                !isStringNumber(runtimeEditDVDTextField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The year and runtime text fields must be a number.",
                    ButtonType.OK);
            alert.show();
        } else {
            // gather the information
            String title = titleEditDVDTextField.getText();
            int year = Integer.parseInt(yearEditDVDTextField.getText());
            String imagePath = imagePathEditDVD.getText();
            String director = directorEditDVDTextField.getText();
            int runtime = Integer.parseInt(runtimeEditDVDTextField.getText());
            String language = languageEditDVDTextField.getText();

            // convert a comma separated string into an array list
            ArrayList<String> listOfSubtitleLanguages =
                    stringToArrayListOfStrings(languageSubtitlesEditDVDTextField.getText());

            // find the DVD
            DVD dvd = (DVD) getLibrary().getResourceManager().
                    getResourceById(uniqueIDSearchEditDVDTextField.getText());

            getLibrary().getResourceManager().editDVD(dvd, title, year, imagePath,
                    director, runtime, language, listOfSubtitleLanguages);

            // notify the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "DVD resource edited successfully.",
                    ButtonType.OK);
            alert.show();

            // enable the ID text field
            uniqueIDSearchEditDVDTextField.setDisable(false);
            // clear all the fields
            this.clearAllEditDVDFields();
        }
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
     * Deletes a laptop resource.
     *
     * @param event The current event.
     */
    @FXML
    void laptopDeleteButtonClicked(ActionEvent event) {

        getLibrary().getResourceManager().removeResource(uniqueIDSearchEditLaptopTextField.getText());
        this.clearAllEditLaptopFields();
        uniqueIDSearchEditLaptopTextField.setDisable(false);

        // notify the user
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Laptop deleted successfully.",
                ButtonType.OK);
        alert.show();
    }

    /**
     * Deletes a DVD resource.
     *
     * @param event The current event.
     */
    @FXML
    void dvdDeleteButtonClicked(ActionEvent event) {

        getLibrary().getResourceManager().removeResource(uniqueIDSearchEditDVDTextField.getText());
        this.clearAllEditDVDFields();
        uniqueIDSearchEditDVDTextField.setDisable(false);

        // notify the user
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "DVD deleted successfully.",
                ButtonType.OK);
        alert.show();
    }

    /**
     * Deletes a book resource.
     *
     * @param event The current event.
     */
    @FXML
    void bookDeleteButtonClicked(ActionEvent event) {

        getLibrary().getResourceManager().removeResource(uniqueIDSearchEditBookTextField.getText());
        this.clearAllEditBookFields();
        uniqueIDSearchEditBookTextField.setDisable(false);

        // notify the user
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book deleted successfully.",
                ButtonType.OK);
        alert.show();
    }

    /**
     * Creates a copy of the chosen resource.
     *
     * @param event The current event.
     */
    @FXML
    void copyCreateButtonClicked(ActionEvent event) {

        // mandatory information - loan duration
        if (copyLoanDurationTextField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all the required fields.",
                    ButtonType.OK);

            alert.show();

        } else if (!isStringNumber(copyLoanDurationTextField.getText())) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "The text field must be a number.",
                    ButtonType.OK);

            alert.show();

        } else {

            // gather the information
            int loanDuration = Integer.parseInt(copyLoanDurationTextField.getText());

            // Find the resource.
            Resource resource = getLibrary().getResourceManager().getResourceById(resourceUniqueIDtextField.getText());

            // Change the resource.
            getLibrary().getResourceManager().addCopyOfResource(loanDuration, resource);

            // notify the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Resource copy added successfully.",
                    ButtonType.OK);

            alert.show();

            // enable the search bar and clear all the fields
            resourceUniqueIDtextField.setDisable(false);

            //Clear fields
            copyLoanDurationTextField.setText("");
            resourceUniqueIDtextField.setText("");
        }
    }

    @FXML
    /**
     * Searches for the resource ID.
     */
    void resourceSearchButtonClicked(ActionEvent event) {

        Resource resource = getLibrary().getResourceManager().getResourceById(resourceUniqueIDtextField.getText());

        if (resource == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't find a resource with such ID.",
                    ButtonType.OK);

            alert.show();

        } else {

            // lock the id field
            resourceUniqueIDtextField.setDisable(true);

            // notify the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Resource found.",
                    ButtonType.OK);

            alert.show();
        }
    }

    @FXML
    public void copySearchButtonClicked(ActionEvent event) {
        Copy copy = getLibrary().getResourceManager().getCopyById(editCopyIdSearchTextField.getText());

        if (copy == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Couldn't find a copy with such ID.",
                    ButtonType.OK);

            alert.show();

        } else {
            // lock the id field
            editCopyIdSearchTextField.setDisable(true);

            // fill in the data
            editCopyLoanDurationTextField.setText(String.valueOf(copy.getLoanDurationInDays()));
        }
    }

    @FXML
    public void editCopyButtonClicked(ActionEvent event) {
        // mandatory - loan duration
        if (editCopyLoanDurationTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in the required text fields.",
                    ButtonType.OK);

            alert.show();
        } else if (!isStringNumber(editCopyLoanDurationTextField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The loan duration must be a number.",
                    ButtonType.OK);

            alert.show();
        } else {
            // get information
            String copyId = editCopyIdSearchTextField.getText();
            int loanDuration = Integer.parseInt(editCopyLoanDurationTextField.getText());

            // edit the copy
            getLibrary().getResourceManager().getCopyById(copyId).setLoanDurationInDays(loanDuration);


            // notify the user
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Copy successfully changed.",
                    ButtonType.OK);

            alert.show();

            // unlock the search id
            editCopyIdSearchTextField.setDisable(false);

            // clear the text fields
            editCopyIdSearchTextField.setText("");
            editCopyLoanDurationTextField.setText("");
        }
    }

    @FXML
    public void deleteCopyButtonClicked(ActionEvent event) {
        // delete copy
        getLibrary().getResourceManager().removeCopy(editCopyIdSearchTextField.getText());

        // notify the user
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Copy successfully deleted.",
                ButtonType.OK);

        alert.show();

    }

    /**
     * Opens file explorer so that an image can be chosen.
     *
     * @param event The current event.
     */
    @FXML
    void createBookFindImageButtonClicked(ActionEvent event) {

        selectFile(imagePathBookTextField);
    }

    /**
     * Opens file explorer so that an image can be chosen.
     *
     * @param event The current event.
     */
    @FXML
    void createDvdFindImageButtonClicked(ActionEvent event) {

        selectFile(imagePathDVDTextField);
    }

    /**
     * Opens file explorer so that an image can be chosen.
     *
     * @param event The current event.
     */
    @FXML
    void createLaptopFindImageButtonClicked(ActionEvent event) {

        selectFile(imagePathLaptopTextField);
    }

    /**
     * Opens file explorer so that an image can be chosen.
     *
     * @param event The current event.
     */
    @FXML
    void editBookFindImageButtonClicked(ActionEvent event) {

        selectFile(imagePathEditBook);
    }

    /**
     * Opens file explorer so that an image can be chosen.
     *
     * @param event The current event.
     */
    @FXML
    void editDvdFindImageButtonClicked(ActionEvent event) {

        selectFile(imagePathEditDVD);
    }

    /**
     * Opens file explorer so that an image can be chosen.
     *
     * @param event The current event.
     */
    @FXML
    void editLaptopFindImageButtonClicked(ActionEvent event) {

        selectFile(imagePathEditLaptop);
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

    /**
     * Opens file explorer and adds the file path to the specified text field when an image is chosen.
     *
     * @param imageTextField The specified text field that contains the file path.
     */
    private void selectFile(TextField imageTextField) {

        Stage currentStage = (Stage) languageBookTextField.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPEG Files", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG Files", "*.png"));

        File selectedFile = fileChooser.showOpenDialog(currentStage);

        imageTextField.setText(selectedFile.toString());
    }

    private void clearAllCreateBookFields() {
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

    private void clearAllCreateLaptopFields() {
        titleLaptopTextField.setText("");
        yearLaptopTextField.setText("");
        imagePathLaptopTextField.setText("");
        manufacturerLaptopTextField.setText("");
        modelLaptopTextField.setText("");
        operatingSystemLaptopTextField.setText("");
    }

    private void clearAllCreateDVDFields() {
        titleDVDTextField.setText("");
        yearDVDTextField.setText("");
        imagePathDVDTextField.setText("");
        directorDVDTextField.setText("");
        runtimeDVDTextField.setText("");
        languageDVDTextField.setText("");
        languageSubtitlesDVDTextField.setText("");
    }

    private void clearAllEditBookFields() {
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

    private void clearAllEditLaptopFields() {
        uniqueIDSearchEditLaptopTextField.setText("");
        titleEditLaptopTextField.setText("");
        yearEditLaptopTextField.setText("");
        imagePathEditLaptop.setText("");
        manufacturerEditLaptopTextField.setText("");
        modelEditLaptopTextField.setText("");
        operatingSystemEditLaptopTextField.setText("");
    }

    private void clearAllEditDVDFields() {
        uniqueIDSearchEditDVDTextField.setText("");
        titleEditDVDTextField.setText("");
        yearEditDVDTextField.setText("");
        imagePathEditDVD.setText("");
        directorEditDVDTextField.setText("");
        runtimeEditDVDTextField.setText("");
        languageEditDVDTextField.setText("");
        languageSubtitlesEditDVDTextField.setText("");
    }
}

