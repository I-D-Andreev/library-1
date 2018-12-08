public class TableRepresentationMoneyTransaction {
    private String type;
    private String date;
    private Double amount;
    private String itemID;
    private Integer daysOverdue;

    public TableRepresentationMoneyTransaction(String type, String date, Double amount) {
        this.type = type;
        this.date = date;
        this.amount = amount;
    }

    public TableRepresentationMoneyTransaction(String type, String date, Double amount, String itemID, Integer daysOverdue) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.itemID = itemID;
        this.daysOverdue = daysOverdue;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getItemID() {
        return itemID;
    }

    public Integer getDaysOverdue() {
        return daysOverdue;
    }
}
