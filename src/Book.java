/**
 *Class to model Book resources.
 * @author Kleanthis Liontis
 */
public class Book extends Resource {

    /**
     * Author of the book.
     */
    private String author;

    /**
     * Publisher of the book.
     */
    private String publisher;

    /**
     * Genre of the book.
     * This is optional.
     */
    private String genre;

    /**
     * The International Standard Book Number.
     * This is optional.
     */
    private String ISBN;

    /**
     * The language of the book.
     * This is optional.
     */
    private String language;

    /**
     * The fine per day the user delays to return the book.
     */
    private final double lateReturnFinePerDay;

    /**
     * The maximum amount you can be fined for a book.
     */
    private final double maxFineAmount;

    /**
     * Constructs a book object.
     *
     * @param uniqueID The unique ID of the book.
     * @param title The title of the book.
     * @param year The year the book was published.
     * @param thumbnail The thumbnail photo of the book.
     * @param author The author of the book.
     * @param publisher The publisher of the book.
     */
    public Book(String uniqueID, String title, int year, String thumbnail, String author, String publisher) {
        super(uniqueID, title, year, thumbnail);
        this.author = author;
        this.publisher = publisher;

        this.lateReturnFinePerDay = 2.00;
        this.maxFineAmount = 25.00;
    }

    /**
     * Construct a book object including ISBN,genre and language.
     *
     * @param uniqueID The unique ID of the book.
     * @param title The title of the book.
     * @param year The year the book was published.
     * @param thumbnail The thumbnail photo of the book.
     * @param author The author of the book.
     * @param publisher The publisher of the book.
     * @param genre The genre of the book.
     * @param ISBN The International Standard Book Number.
     * @param language The language of the book.
     */
    public Book(String uniqueID, String title, int year, String thumbnail, String author, String publisher,
                String genre, String ISBN, String language) {
        // call the "smaller" constructor
        this(uniqueID, title, year, thumbnail, author, publisher);
        this.genre = genre;
        this.ISBN = ISBN;
        this.language = language;
    }

    /**
     * Sets the author of the book.
     * @param author The new author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the author of the book.
     * @return author The author of the book.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Sets the publisher of the book.
     * @param publisher The new publisher of the book
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets the publisher of the book.
     * @return publisher The publisher of the book.
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Sets the International Standard Book Number of the book.
     * @param ISBN The new International Standard Book Number.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Gets the International Standard Book Number of the book.
     * @return ISBN The International Standard Book Number.
     */
    public String getISBN() {
        return this.ISBN;
    }

    /**
     * Sets the new language of the book.
     * @param language The new language of the book.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets the language of the book.
     * @return language The language of the book.
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * Gets the late return fine per day of the book.
     * @return lateReturnFinePerDay The late return fine per day of the book.
     */
    public double getLateReturnFinePerDay() {
        return this.lateReturnFinePerDay;
    }

    /**
     * Gets the maximum fine a book can have.
     * @return maxFineAmount The max fine of the book.
     */
    public double getMaxFineAmount() {
        return this.maxFineAmount;
    }
}
