package ma.skypay.banking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import ma.skypay.enums.TransactionType;

public class Account implements AccountService {

  private String accountId = "ACC-" + UUID.randomUUID().toString();
  private String name;
  private String createdAt = LocalDate.now().toString();

  private int balance = 0;
  private ArrayList<Transaction> transactions = new ArrayList<>();

  public Account(String name) {
    this.name = name.stripLeading().stripTrailing();
  }

  @Override
  public void deposit(int amount) {
    deposit(amount, LocalDate.now().toString());
  }

  public void deposit(int amount, String date) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Deposit amount must be positive");
    }
    balance += amount;
    transactions.add(new Transaction(TransactionType.DEPOSIT, amount, balance, date));
  }

  @Override
  public void withdraw(int amount) {
    withdraw(amount, LocalDate.now().toString());
  }

  public void withdraw(int amount, String date) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Withdrawal amount must be positive");
    }
    if (amount > balance) {
      throw new IllegalArgumentException("Insufficient funds for withdrawal");
    }
    balance -= amount;
    transactions.add(new Transaction(TransactionType.WITHDRAWAL, amount, balance, date));
  }

  @Override
  public void printStatement() {
    System.out.println("Date       | Amount | Balance");
    System.out.println("-----------------------------");
    // reverse transactions
    for (int i = transactions.size() - 1; i >= 0; i--) {
      System.out.println(transactions.get(i));
    }
  }

  public void getAccount() {
    System.out.println("Account ID: " + accountId);
    System.out.println("Name: " + name);
    System.out.println("Created At: " + createdAt);
    System.out.println("Balance: " + balance);
    System.out.println("Number of Transactions: " + transactions.size());
  }
}
