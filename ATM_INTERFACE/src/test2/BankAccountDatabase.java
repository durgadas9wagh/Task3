package test2;


import java.util.HashMap;
import java.util.Map;

public class BankAccountDatabase {
    private static Map<String, BankAccount> database = new HashMap<>();
    
    public static void add(BankAccount bankAccount) {
        database.put(bankAccount.getAccountNumber(), bankAccount);
    }
    
    public static BankAccount lookup(String accountNumber) {
        return database.get(accountNumber);
    }
}
