//TODO: Javadoc
public class Book extends Resource {

    private String author;
    private String publisher;
    private String genre;
    private String ISBN;
    private String language;
    private final double lateReturnFinePerDay;
    private final double maxFineAmount;

    public Book(String uniqueID, String title, int year, String thumbnail, String author, String publisher) {
        super(uniqueID, title, year, thumbnail);
        this.author = author;
        this.publisher = publisher;

        this.lateReturnFinePerDay = 2.00;
        this.maxFineAmount = 25.00;
    }

    public Book(String uniqueID, String title, int year, String thumbnail, String author, String publisher,
                String genre, String ISBN, String language) {
        // call the "smaller" constructor
        this(uniqueID, title, year, thumbnail, author, publisher);
        this.genre = genre;
        this.ISBN = ISBN;
        this.language = language;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return this.language;
    }

    public double getLateReturnFinePerDay() {
        return this.lateReturnFinePerDay;
    }

    public double getMaxFineAmount() {
        return this.maxFineAmount;
    }

    public String getType() {
        return "Book";
    }
}
