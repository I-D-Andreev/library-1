import java.util.Date;

public class HistoryEntryMoneyTransaction extends HistoryEntry {

    private double amount;

    public HistoryEntryMoneyTransaction(Date date, Double amount){
        super(date);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
