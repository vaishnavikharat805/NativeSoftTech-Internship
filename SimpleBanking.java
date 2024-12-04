import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a bank account
class Account {
    private String accountName;
    private double balance;
  
    // Constructor to create an account with an initial balance of 0.0
    public Account(String accountName) {
        this.accountName = accountName;
        this.balance = 0.0;
    }

    // Getter for account name
    public String getAccountName() {
        return accountName;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {  
            balance += amount;  
            System.out.println("Successfully deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) { 
            balance -= amount;  
            System.out.println("Successfully withdrew " + amount + ". New balance: " + balance);
        } else if (amount > balance) {  
            System.out.println("Error: Insufficient balance.");
        } else {
            System.out.println("Withdraw amount must be positive.");
        }
    }
}

// Main class for the banking application
public class SimpleBanking {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;  

        System.out.println("===== Welcome to the Simple Banking Application =====");

        do {
            showMenu();  // Show the menu of options
            choice = getValidInt("Enter your choice (1-5):"); 
            // Switch case to handle the user's menu choice
            switch (choice) {
                case 1:
                    createAccount();  
                    break;
                case 2:
                    depositMoney();  
                    break;
                case 3:
                    withdrawMoney();  
                    break;
                case 4:
                    checkBalance();  
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");  
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");  
            }
        } while (choice != 5);  

        sc.close(); 
    }

    // Method to display the menu of options
    private static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
    }

    // Method to create a new account
    private static void createAccount() {
        System.out.print("Enter account name: ");  
        String accountName = sc.next();  
        accounts.add(new Account(accountName));  
        System.out.println("Account created successfully for " + accountName); 
    }

    // Method to deposit money into an existing account
    private static void depositMoney() {
        Account account = findAccount();  
        if (account != null) { 
            double amount = getValidDouble("Enter amount to deposit:"); 
            account.deposit(amount);  
        }
    }

    // Method to withdraw money from an existing account
    private static void withdrawMoney() {
        Account account = findAccount();  
        if (account != null) { 
            double amount = getValidDouble("Enter amount to withdraw:");  
            account.withdraw(amount); 
        }
    }

    // Method to check the balance of an existing account
    private static void checkBalance() {
        Account account = findAccount();  
        if (account != null) {  
            System.out.println("Current balance for " + account.getAccountName() + ": " + account.getBalance());
           
        }
    }

    // Method to find an account by its name
    private static Account findAccount() {
        System.out.print("Enter account name: "); 
        String accountName = sc.next();  
        for (Account acc : accounts) {  
            if (acc.getAccountName().equalsIgnoreCase(accountName)) {  
                return acc;  
            }
        }
        System.out.println("Account not found."); 
        return null;  
    }

    // Method to get a valid double input 
    private static double getValidDouble(String prompt) {
        System.out.println(prompt);  
        while (!sc.hasNextDouble()) { 
            System.out.println("Invalid input! Please enter a valid number:");  
            sc.next();  
        }
        return sc.nextDouble();  
    }

    // Method to get a valid integer input 
    private static int getValidInt(String prompt) {
        System.out.println(prompt);  
        while (!sc.hasNextInt()) {  
            System.out.println("Invalid input! Please enter a valid number:");  
            sc.next();  
        }
        return sc.nextInt();  
    }
}
