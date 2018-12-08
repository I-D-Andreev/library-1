public class TableRepresentationCopy {
    private String uniqueCopyID;
    private String isAvailable;
    private String borrowedBy;

    public TableRepresentationCopy(String uniqueCopyID, String isAvailable){
        this.uniqueCopyID = uniqueCopyID;
        this.isAvailable = isAvailable;
    }

    public TableRepresentationCopy(String uniqueCopyID, String isAvailable, String borrowedBy){
        this(uniqueCopyID, isAvailable);
        this.borrowedBy = borrowedBy;
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
}
