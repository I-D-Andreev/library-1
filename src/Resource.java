//TODO: Javadoc comments
import java.io.*;
public abstract class Resource implements Serializable {
    private static int nextID=0;

    private String uniqueID;
    private String title;
    private int year;
    private String thumbnailImagePath;
    private CopyManager copyManager;



    public Resource(String title, int year, String thumbnailImagePath) {
        this.uniqueID = uniqueID;
        this.title = title;
        this.year = year;
        this.thumbnailImagePath = thumbnailImagePath;
        this.copyManager = new CopyManager(this);
        this.setUniqueID();
    }

    public String getUniqueID() {
        return this.uniqueID;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getThumbnailImagePath() {
        return this.thumbnailImagePath;
    }

    public void setThumbnailImagePath(String thumbnailImagePath) {
        this.thumbnailImagePath = thumbnailImagePath;
    }

    public abstract double getMaxFineAmount();

    public abstract double getLateReturnFinePerDay();

    public abstract String getType();


    public CopyManager getCopyManager(){
        return copyManager;
    }

    public void setCopyManager(CopyManager copyManager){
        this.copyManager = copyManager;
    }

    private void setUniqueID() {
        this.uniqueID = this.title.charAt(0) + "-" + nextID;
        nextID++;
    }


    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Resource)) return false;
        Resource o = (Resource) obj;
        return o.getUniqueID().equals(this.getUniqueID());
    }

}
