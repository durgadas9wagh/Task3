package test2;




import java.time.LocalDateTime;

public class Transaction {
    private TransactionType type;
    private LocalDateTime dateTime;
    private double amount;
    private String otherAccountNumber;
    
    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }
    
    public Transaction(TransactionType type, double amount, String otherAccountNumber) {
        this.type = type;
        this.amount = amount;
        this.otherAccountNumber = otherAccountNumber;
        this.dateTime = LocalDateTime.now();
    }
    
    public TransactionType getType() {
        return type;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String getOtherAccountNumber() {
        return otherAccountNumber;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dateTime).append(" | ");
        sb.append(type).append(" | ");
        sb.append(amount);
        if (otherAccountNumber != null) {
            sb.append(" | ").append(otherAccountNumber);
        }
        return sb.toString();
    }
}
