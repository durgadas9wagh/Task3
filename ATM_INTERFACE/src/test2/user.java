package test2;

public class user 
{
    private String name;
    private String userId;
    private BankAccount bankAccount;
    
    public user(String name, String accountNumber, double balance) 
    {
        this.name = name;
        this.userId = accountNumber;
        this.bankAccount = new BankAccount(accountNumber, balance);
    }
    
    public String getName() {
        return name;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
