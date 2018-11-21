import java.util.ArrayList;

public class DVD extends Resource {

    private String director;
    private int runtime;
    private String language;
    private ArrayList<String> listOfSubtitleLanguages;
    private final double lateReturnFinePerDay;
    private final double maxFineAmount;

    public DVD(String uniqueID, String title, int year, String thumbnail, String director, int runtime) {
        super(uniqueID, title, year, thumbnail);
        this.director = director;
        this.runtime = runtime;

        this.lateReturnFinePerDay = 2.00;
        this.maxFineAmount = 25.00;
        this.listOfSubtitleLanguages = new ArrayList<>();
    }

    public DVD(String uniqueID, String title, int year, String thumbnail, String director, int runtime,
               String language, ArrayList<String> listOfSubtitleLanguages) {
        // call the "smaller" DVD constructor
        this(uniqueID, title, year, thumbnail, director, runtime);
        this.language = language;
        this.listOfSubtitleLanguages = getListOfSubtitleLanguages();
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return this.director;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setListOfSubtitleLanguages(ArrayList<String> listOfSubtitleLanguages) {
        this.listOfSubtitleLanguages = listOfSubtitleLanguages;
    }

    public ArrayList<String> getListOfSubtitleLanguages() {
        return this.listOfSubtitleLanguages;
    }

    public void addSubtitleLanguage(String language) {
        // add language only if it doesn't already exist
        if(this.listOfSubtitleLanguages.indexOf(language) != -1) {
            this.listOfSubtitleLanguages.add(language);
        }
    }

    public void removeSubtitleLanguage(String language) {
        this.listOfSubtitleLanguages.remove(language);
    }

    public double getLateReturnFinePerDay() {
        return this.lateReturnFinePerDay;
    }

    public double getMaxFineAmount() {
        return this.maxFineAmount;
    }
}
