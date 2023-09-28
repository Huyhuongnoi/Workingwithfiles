import java.io.Serializable;

public class Card extends User implements Serializable {
    private String accountNumber;
    private String pass;
    private double accountBalance;

    public Card(String name, String accountNumber, String pass, double accountBalance) {
        super(name, 0, null, null);
        this.accountNumber = accountNumber;
        this.pass = pass;
        this.accountBalance = accountBalance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String dataCard() {
        return "\n" + getAccountNumber() + "\n" + String.valueOf(getAccountBalance());
    }
}
