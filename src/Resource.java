/**
 * Class to model a resource.
 */
public abstract class Resource {

    /**
     * The unique ID of a resource.
     */
    private String uniqueID;

    /**
     * The title of each resource.
     */
    private String title;

    /**
     * The year each resource was produced.
     */
    private int year;

    /**
     * The thumbnail image path of the resource.
     */
    private String thumbnailImagePath;

    /**
     * The copy manager of the resource.
     */
    private CopyManager copyManager;

    /**
     * The constructor of a resource.
     *
     * @param uniqueID The unique ID of a resource.
     * @param title The title of each resource.
     * @param year The year each resource was produced.
     * @param thumbnailImagePath The thumbnail image path of the resource.
     */
    public Resource(String uniqueID, String title, int year, String thumbnailImagePath) {
        this.uniqueID = uniqueID;
        this.title = title;
        this.year = year;
        this.thumbnailImagePath = thumbnailImagePath;
        this.copyManager = new CopyManager(this);
    }

    /**
     * Gets the unique ID of a resource.
     * @return uniqueID the unique ID of a resource.
     */
    public String getUniqueID() {
        return this.uniqueID;
    }

    /**
     * Gets the title of the resource.
     * @return title The title of the resource.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the resource.
     * @param title The new title of the resource.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the year the resource was created.
     * @return year The year the resource was created.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Sets the year the resource was produced.
     * @param year The new year the resource was produced.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the thumbnail image path of the resource.
     * @return thumbnailImagePath The thumbnail image path of the resource.
     */
    public String getThumbnailImagePath() {
        return this.thumbnailImagePath;
    }

    /**
     * Sets the thumbnail image path of the resource.
     * @param thumbnailImagePath The new thumbnail image path of the resource.
     */
    public void setThumbnailImagePath(String thumbnailImagePath) {
        this.thumbnailImagePath = thumbnailImagePath;
    }

    /**
     * Gets the maxFineAmount a user can get for a resource overwritten by each resource..
     * @return null.
     */
    public abstract double getMaxFineAmount();

    /**
     * Gets the late return fine per day of the resource.
     * @return null.
     */
    public abstract double getLateReturnFinePerDay();

    /**
     * Gets the copy manager of the resource.
     * @return copyManager The copy manager of the resource.
     */
    public CopyManager getCopyManager(){
        return copyManager;
    }

    /**
     * Sets the copy manager of the resource.
     * @param copyManager The new copy manager of the resource.
     */
    public void setCopyManager(CopyManager copyManager){
        this.copyManager = copyManager;
    }

    /**
     * todo comment this method.
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Resource)) return false;
        Resource o = (Resource) obj;
        return o.getUniqueID().equals(this.getUniqueID());
    }

}
