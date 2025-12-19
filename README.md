## Other projects

- Java SOAP API (Jakarta / Maven): [java_soap_api](https://github.com/AmraneAchraf1/java_soap_api)
- React client for SOAP API: [reactjs_soap_api](https://github.com/AmraneAchraf1/reactjs_soap_api)


# test-one 🔧

**Lightweight demo project** for a simple banking model implemented in Java .

## Quick facts

- **Language:** Java
- **Build:** Maven (`pom.xml`)  
- **Tests:** JUnit 5

## Getting started 🚀

### Build

```bash
# Compile
mvn  compile

# Run tests
mvn  test

# folder structure
src
 ├── main
 │   └── java
 │       └── ma
 │           └── skypay
 │               └── banking
 │                   ├── Account.java
 │                   ├── Transaction.java
 │               └── enums
 │                   └── TransactionType.java
 └── test
     └── java
         └── AccountTest.java
```

## Project structure 📁

- `Account.java`: Represents a bank account that can perform deposits, withdrawals, and print statements.
- `Transaction.java`: Represents a financial transaction (deposit or withdrawal) with details like date, amount, and balance after the transaction.
- `TransactionType.java`: Enum defining the types of transactions (DEPOSIT, WITHDRAWAL).
- `AccountTest.java`: Contains unit tests to verify the functionality of the `Account` class.

## Usage example 📝

```java
Account account = new Account("Achraf Amrane");
account.deposit(1000, "10-01-2012");
account.deposit(2000, "13-01-2012");
account.withdraw(500, "14-01-2012");
account.printStatement();
```

This will output:

```Date       | Amount | Balance
-----------------------------
14-01-2012 | -500   | 2500
13-01-2012 | 2000   | 3000
10-01-2012 | 1000   | 1000
```
