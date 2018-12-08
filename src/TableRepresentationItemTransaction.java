public class TableRepresentationItemTransaction {
    private String borrowedOrReturned;
    private String username;
    private String date;

    public TableRepresentationItemTransaction(String borrowedOrReturned, String username, String date) {
        this.borrowedOrReturned = borrowedOrReturned;
        this.username = username;
        this.date = date;
    }


    public String getBorrowedOrReturned() {
        return borrowedOrReturned;
    }

    public String getUsername() {
        return username;
    }

    public String getDate() {
        return date;
    }
}
