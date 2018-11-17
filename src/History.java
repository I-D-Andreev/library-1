import java.util.ArrayList;

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
