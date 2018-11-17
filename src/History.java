import java.util.ArrayList;

/**
 * Models a History class that contains entries with information about events.
 * @author Ivan Andreev
 */
public class History {
    private ArrayList<HistoryEntry> history;

    public History() {
        history = new ArrayList<>();
    }

    public ArrayList<HistoryEntry> getHistory() {
        return history;
    }

    public void addEntry(HistoryEntry historyEntry) {
        this.history.add(historyEntry);
    }
}
