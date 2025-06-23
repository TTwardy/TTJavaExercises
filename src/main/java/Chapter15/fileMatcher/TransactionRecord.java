package Chapter15.fileMatcher;

public class TransactionRecord {
    int accountNumber;
    double transactionAmount;

    public TransactionRecord(int accountNumber, double transactionAmount){
        this.accountNumber=accountNumber;
        this.transactionAmount=transactionAmount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
