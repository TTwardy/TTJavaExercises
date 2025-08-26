package Chapter15.fileMatcher;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class TransactionRecords {
    @XmlElement(name="Transaction")
    private List<TransactionRecord> Transactions = new ArrayList<>();
    public List<TransactionRecord> getTransactions(){
        return Transactions;
    }
}
