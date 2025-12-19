package ma.skypay.banking;
import java.util.UUID;
import ma.skypay.enums.TransactionType;

public class Transaction {

  private final String transactionId = UUID.randomUUID().toString();
  private final String date;
  private final TransactionType type;
  private final int amount;
  private final int balanceAfterTransaction;


  public Transaction(TransactionType type, int amount, int balanceAfterTransaction, String date) {
    this.type = type;
    this.amount = amount;
    this.balanceAfterTransaction = balanceAfterTransaction;
    this.date = date;
  }

  public String getTransactionId() {
    return transactionId;
  }

  public TransactionType getType() {
    return type;
  }

  public int getAmount() {
    return amount;
  }

  public int getBalanceAfterTransaction() {
    return balanceAfterTransaction;
  }

  public String getDate() {
    return date;
  }

  @Override
  public String toString() {
    int signedAmount = type == TransactionType.WITHDRAWAL ? -amount : amount;
    return date + " | " + signedAmount + "   | " + balanceAfterTransaction;
  }

}
