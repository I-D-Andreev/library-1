public class TableRepresentationCopy {
    private String uniqueCopyID;
    private String isAvailable;
    private String borrowedBy;
    private String reservedFor;

    public TableRepresentationCopy(String uniqueCopyID, String isAvailable){
        this.uniqueCopyID = uniqueCopyID;
        this.isAvailable = isAvailable;
    }

    public TableRepresentationCopy(String uniqueCopyID, String isAvailable, String borrowedBy, String reservedFor){
        this(uniqueCopyID, isAvailable);
        this.borrowedBy = borrowedBy;
        this.reservedFor = reservedFor;
    }

    public String getUniqueCopyID() {
        return uniqueCopyID;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public String getReservedFor() {
        return reservedFor;
    }
}
