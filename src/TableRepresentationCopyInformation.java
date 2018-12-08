public class TableRepresentationCopyInformation {

    private String copyID;
    private String resourceName;
    private String resourceType;
    private String borrowDate;
    private String dueDate;

    public TableRepresentationCopyInformation(String copyID, String resourceName, String resourceType) {
        this.copyID = copyID;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
    }

    public TableRepresentationCopyInformation(String copyID, String resourceName,
                                              String resourceType, String borrowDate, String dueDate) {
       this(copyID, resourceName, resourceType);
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public String getCopyID() {
        return copyID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }
}
