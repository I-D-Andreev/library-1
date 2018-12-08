/**
 * Class that models the representation of a copy in a table.
 */
public class TableRepresentationCopyInformation {

    private String copyID;
    private String borrowedBy;
    private String resourceName;
    private String resourceType;
    private String borrowDate;
    private String dueDate;
    private Integer daysOverdue;

    /**
     * Constructor for a copy representation in a table.
     *
     * @param copyID       The unique copy ID.
     * @param resourceName The resource name this copy is a copy of.
     * @param resourceType The type of resource this copy is a copy of.
     */
    public TableRepresentationCopyInformation(String copyID, String resourceName, String resourceType) {
        this.copyID = copyID;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
    }

    /**
     * Constructor for a copy representation in a table.
     *
     * @param copyID       The unique copy ID.
     * @param resourceName The resource name this copy is a copy of.
     * @param resourceType The type of resource this copy is a copy of.
     * @param borrowDate   The date the copy was borrowed.
     * @param dueDate      The date the copy is due.
     */
    public TableRepresentationCopyInformation(String copyID, String resourceName,
                                              String resourceType, String borrowDate, String dueDate) {
        this(copyID, resourceName, resourceType);
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    /**
     * Constructor for a copy representation in a table.
     *
     * @param copyID      The unique copy ID.
     * @param borrowDate  The date the copy was borrowed.
     * @param dueDate     The date the copy is due.
     * @param daysOverdue The days overdue the copy is.
     * @param borrowedBy  The user that borrowed the copy.
     */
    public TableRepresentationCopyInformation(String copyID, String borrowDate,
                                              String dueDate, Integer daysOverdue, String borrowedBy) {
        this.copyID = copyID;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.daysOverdue = daysOverdue;
        this.borrowedBy = borrowedBy;
    }

    /**
     * Gets the copy unique ID.
     *
     * @return The unique copy ID.
     */
    public String getCopyID() {
        return copyID;
    }

    /**
     * Gets the resource name this copy is a copy of.
     *
     * @return The resource name this copy is a copy of.
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * Gets the resource type this copy is a copy of.
     *
     * @return The resource type this copy is a copy of.
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * Gets the date this copy was borrowed.
     *
     * @return The date this copy was borrowed.
     */
    public String getBorrowDate() {
        return borrowDate;
    }

    /**
     * Gets the date this copy is due.
     *
     * @return The date this copy is due.
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Gets how many days overdue the copy is.
     *
     * @return The days the copy is overdue.
     */
    public Integer getDaysOverdue() {
        return daysOverdue;
    }

    /**
     * Gets the user that borrowed the copy.
     *
     * @return The user that borrowed the copy.
     */
    public String getBorrowedBy() {
        return borrowedBy;
    }
}
