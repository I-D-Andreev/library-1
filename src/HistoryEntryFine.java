import java.util.Date;

/**
 * Models a fine type of history entry.
 */
public class HistoryEntryFine extends HistoryEntryMoneyTransaction {

    /**
     * The item that is overdue and caused the fine.
     */
    private String item; // should be Copy type

    /**
     * The number of days the item was overdue.
     */
    private int daysOverdue;

    /**
     * Creates a fine type of history entry.
     *
     * @param date        The date of the fine.
     * @param amount      The amount due.
     * @param daysOverdue The number of days the item is overdue.
     * @param item        The item that was not returned on time.
     */
    public HistoryEntryFine(Date date, double amount, int daysOverdue, String item) {
        super(date, amount);
        this.daysOverdue = daysOverdue;
        this.item = item;
    }

    /**
     * Get the number of days an item is overdue.
     *
     * @return daysOverdue The number of days.
     */
    public int getDaysOverdue() {
        return daysOverdue;
    }

//    public Copy getCopy() {
//        return item;
//    }
}