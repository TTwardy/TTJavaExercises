package Chapter15.fileMatcher;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Transaction")
public class TransactionRecord {
    private int accountNumber;
    private double transactionAmount;

    public TransactionRecord(){}

    public TransactionRecord(int accountNumber, double transactionAmount){
        this.accountNumber=accountNumber;
        this.transactionAmount=transactionAmount;
    }
    @XmlElement(name = "AccountNumber")
    public int getAccountNumber() {
        return accountNumber;
    }
    @XmlElement(name = "TransactionAmount")
    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
