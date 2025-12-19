import ma.skypay.banking.Account;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AcceptanceTest {

  private PrintStream originalOut;
  private ByteArrayOutputStream out;


  @BeforeEach
  void setup() {
    originalOut = System.out;
    out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
  }

  @AfterEach
  void teardown() {
    System.setOut(originalOut);
  }

  @Test
  void acceptance_printStatement() {

    Account account = new Account("Achraf Amrane");
    account.deposit(1000, "10-01-2012");
    account.deposit(2000, "13-01-2012");
    account.withdraw(500, "14-01-2012");

    account.printStatement();

    String nl = System.lineSeparator();
    String expected =
        "Date       | Amount | Balance" + nl +
        "-----------------------------" + nl +
        "14-01-2012 | -500   | 2500" + nl +
        "13-01-2012 | 2000   | 3000" + nl +
        "10-01-2012 | 1000   | 1000" + nl;

    assertEquals(expected, out.toString());
  }
}
