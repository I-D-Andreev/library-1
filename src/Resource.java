//TODO: Javadoc comments
public abstract class Resource {

    private String uniqueID;
    private String title;
    private int year;
    private String thumbnailImagePath;
    //private CopyManager copyManager;

    public Resource(String uniqueID, String title, int year, String thumbnailImagePath) {
        this.uniqueID = uniqueID;
        this.title = title;
        this.year = year;
        this.thumbnailImagePath = thumbnailImagePath;

        // copyManager = new CopyManager(this?);
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getThumbnailImagePath() {
        return thumbnailImagePath;
    }

    public void setThumbnailImagePath(String thumbnailImagePath) {
        this.thumbnailImagePath = thumbnailImagePath;
    }

    public abstract double getMaxFineAmount();

    public abstract double getLateReturnFinePerDay();
    /*
    public CopyManager getCopyManager(){
        return copyManager;
    }

    public void setCopyManager(Copymanager copymanager){
        this.copymanager=copymanager;
    }
     */
}
