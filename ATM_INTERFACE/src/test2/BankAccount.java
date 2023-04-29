package test2;


import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;
    
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
    
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public boolean transfer(BankAccount recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            return true;
        } else {
            return false;
        }
    }
    
    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }
    
}