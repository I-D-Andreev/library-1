import java.util.ArrayList;

/**
 * Class to model DVD resource
 * @author Kleanthis Liontis, Ivan Andreev
 */
public class DVD extends Resource {

    /**
     * Director of the DVD.
     */
    private String director;

    /**
     * The runtime of the DVD.
     */
    private int runtime;

    /**
     * The language the DVD is in
     */
    private String language;

    /**
     * An arraylist that contains all the subtitle languages of the DVD.
     */
    private ArrayList<String> listOfSubtitleLanguages;

    /**
     * The find the user receives for returning late a DVD.
     */
    private final double lateReturnFinePerDay;

    /**
     * The maximum fine amount given for a DVD.
     */
    private final double maxFineAmount;

    /**
     * The constructor of a DVD.
     *
     * @param uniqueID The unique ID of a DVD.
     * @param title The title of the DVD.
     * @param year The year the DVD came out.
     * @param thumbnail The thumbnail of the DVD.
     * @param director The director of the DVD.
     * @param runtime The runtime of the DVD.
     */
    public DVD(String uniqueID, String title, int year, String thumbnail, String director, int runtime) {
        super(uniqueID, title, year, thumbnail);
        this.director = director;
        this.runtime = runtime;

        this.lateReturnFinePerDay = 2.00;
        this.maxFineAmount = 25.00;
        this.listOfSubtitleLanguages = new ArrayList<>();
    }

    /**
     * The constructor of a DVD including language and list of subtitle languages.
     *
     * @param uniqueID The unique ID of a DVD.
     * @param title The title of the DVD.
     * @param year The year the DVD came out.
     * @param thumbnail The thumbnail of the DVD.
     * @param director The director of the DVD.
     * @param runtime The runtime of the DVD.
     * @param language The language of the DVD.
     * @param listOfSubtitleLanguages The list of the subtitle languages of the DVD.
     */
    public DVD(String uniqueID, String title, int year, String thumbnail, String director, int runtime,
               String language, ArrayList<String> listOfSubtitleLanguages) {
        // call the "smaller" DVD constructor
        this(uniqueID, title, year, thumbnail, director, runtime);
        this.language = language;
        this.listOfSubtitleLanguages = getListOfSubtitleLanguages();
    }

    /**
     * Sets the director of the DVD.
     * @param director The name of the new director.
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets the director of the DVD.
     * @return director The name of the director of the DVD.
     */
    public String getDirector() {
        return this.director;
    }

    /**
     * Sets the runtime of the DVD.
     * @param runtime The new runtime of the DVD.
     */
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    /**
     * Gets the runtime of the DVD.
     * @return runtime The runtime of the DVD.
     */
    public int getRuntime() {
        return this.runtime;
    }

    /**
     * Sets the language of the DVD.
     * @param language The new language of the DVD.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets the language of the DVD.
     * @return language The language of the DVD.
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * Sets the list of subtitle languages of the DVD.
     * @param listOfSubtitleLanguages The new list of subtitle languages.
     */
    public void setListOfSubtitleLanguages(ArrayList<String> listOfSubtitleLanguages) {
        this.listOfSubtitleLanguages = listOfSubtitleLanguages;
    }

    /**
     * Gets the list of subtitle languages of the DVD.
     * @return listOfSubtitleLanguages The list of subtitle languages.
     */
    public ArrayList<String> getListOfSubtitleLanguages() {
        return this.listOfSubtitleLanguages;
    }

    /**
     * Add a language into the list of subtitle languages of the DVD.
     * @param language The new language to be added in the list.
     */
    public void addSubtitleLanguage(String language) {
        // add language only if it doesn't already exist
        if(this.listOfSubtitleLanguages.indexOf(language) != -1) {
            this.listOfSubtitleLanguages.add(language);
        }
    }

    /**
     * Removes a language from the list of subtitle languages of the DVD.
     * @param language The language to be removed from the list.
     */
    public void removeSubtitleLanguage(String language) {
        this.listOfSubtitleLanguages.remove(language);
    }

    /**
     * Gets the late return fine given to a user per day DVD is late.
     * @return lateReturnFinePerDay The late return fine given to user per day.
     */
    public double getLateReturnFinePerDay() {
        return this.lateReturnFinePerDay;
    }

    /**
     * Gets the maximum fine imposed to a user for returning a DVD late.
     * @return maxFineAmount The maximum fine imposed to a user.
     */
    public double getMaxFineAmount() {
        return this.maxFineAmount;
    }
}
