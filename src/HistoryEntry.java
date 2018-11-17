import java.util.Date;

/**
 * Models a single history entry.
 * The most basic type of entry.
 * @author Ivan Andreev
 */
public class HistoryEntry {
    /**
     * The entry's date.
     */
    private Date date;

    /**
     * Creates a simple history entry.
     *
     * @param date the date of the entry
     */
    public HistoryEntry(Date date) {
        this.date = date;
    }

    /**
     * Gets the date of the entry.
     *
     * @return date The date of the entry.
     */
    public Date getDate() {
        return date;
    }

}
