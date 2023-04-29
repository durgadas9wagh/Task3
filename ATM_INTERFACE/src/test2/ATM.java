package test2;

import java.util.Scanner;

public class ATM 
{
    private static  String USER_ID ="123";
    private static  String USER_PIN="123" ;
    private user user;
    
    public static void main(String[] args) 
    {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for user id and pin
        System.out.print("Enter user id: ");
        String userId = scanner.nextLine();
        System.out.print("Enter user pin: ");
        String userPin = scanner.nextLine();
        
        // Check if user id and pin are valid
        if (userId.equals(USER_ID) && userPin.equals(USER_PIN)) 
        {
            System.out.println("Login successful");
            atm.start(scanner);
        } else {
            System.out.println("Login failed");
        }
    }
    

    
    public void start(Scanner scanner) {
        // Create user object for logged in user
        user = new test2.user("John Doe", "1234567890", 1000.0);
        
        // Main loop for ATM operations
        boolean quit = false;
        while (!quit) 
        {
            System.out.println("Choose an option:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter option number: ");
            
            // Get user input for chosen option
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline character
            
            switch (option) {
                case 1:
                    viewTransactionHistory();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    transfer(scanner);
                    break;
               
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    
    private void viewTransactionHistory() {
        System.out.println("Transaction history:");
        for (Transaction transaction : user.getBankAccount().getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
    
    private void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline character
        
        boolean success = user.getBankAccount().withdraw(amount);
        if (success) {
            System.out.println("Withdrawal successful");
            user.getBankAccount().addTransaction(new Transaction(TransactionType.WITHDRAWAL, amount));
        } else {
            System.out.println("Withdrawal failed: insufficient funds");
        }
    }
    
    private void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline character
        
        user.getBankAccount().deposit(amount);
        System.out.println("Deposit successful");
        user.getBankAccount().addTransaction(new Transaction(TransactionType.DEPOSIT, amount));
    }
    
    private void transfer(Scanner scanner)
    {
        System.out.print("Enter recipient account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline character
        
        BankAccount recipient = BankAccountDatabase.lookup(accountNumber);
        if (recipient != null) 
        {
            boolean success = user.getBankAccount().transfer(recipient, amount);
            if (success) 
            {
                System.out.println("Transfer successful");
                System.out.println("--------------------------------------------");
                user.getBankAccount().addTransaction(new Transaction(TransactionType.TRANSFER, amount, recipient.getAccountNumber()));
                recipient.addTransaction(new Transaction(TransactionType.RECEIVE_TRANSFER, amount, user.getBankAccount().getAccountNumber()));
            } 
            else 
            {
                System.out.println("Transfer failed: insufficient funds");
            }
        } 
        
        else 
        {
            System.out.println("Invalid recipient account number");
        }
        
        
        
        
        
       
    }
    }





