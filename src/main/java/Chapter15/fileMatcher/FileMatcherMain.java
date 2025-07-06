package Chapter15.fileMatcher;

import Chapter15.Account;
import Chapter15.Accounts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import static Chapter15.fileMatcher.FileMatch.compareTransactionsToOldMast;

public class FileMatcherMain {
    public static void main(String[] args) throws IOException {
        createOldMasterTransactions();
        createTransactions();
        compareTransactionsToOldMast();
    }

    private static void createOldMasterTransactions(){
        Accounts oldMastAccounts = new Accounts();
        oldMastAccounts.getAccounts().add(new Account(1000, "John", "Water", 22.33));
        oldMastAccounts.getAccounts().add(new Account(2000, "David", "Fire", 2122.33));
        oldMastAccounts.getAccounts().add(new Account(3000, "Anna", "Smith", 100));

        try (Formatter writer = new Formatter("oldMast.txt")) {
            for (Account account : oldMastAccounts.getAccounts()){
                try{
                    writer.format("%d %s %s %.2f\n", account.getAccountNumber(), account.getFirstName(), account.getLastName(), account.getBalance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void createTransactions(){
        List<TransactionRecord> transactionRecords = new ArrayList<>();
        transactionRecords.add(new TransactionRecord(1000, 100));
        transactionRecords.add(new TransactionRecord(1000, 50));
        transactionRecords.add(new TransactionRecord(1000, -150));
        transactionRecords.add(new TransactionRecord(2000, -500));
        transactionRecords.add(new TransactionRecord(2000, 5500));
        transactionRecords.add(new TransactionRecord(2222, 999));
        transactionRecords.add(new TransactionRecord(2333, 99));

        try (Formatter writer = new Formatter("transactions.txt")) {
            for (TransactionRecord transactionRecord : transactionRecords){
                try{
                    writer.format("%d %.2f\n", transactionRecord.getAccountNumber(), transactionRecord.getTransactionAmount());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
