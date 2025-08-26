package Chapter15.fileMatcher;

import Chapter15.Account;
import Chapter15.Accounts;

import javax.xml.bind.JAXB;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import static Chapter15.fileMatcher.FileMatch.compareTransactionsToOldMast;

public class FileMatcherMain {
    public static void main(String[] args) throws IOException {
        createOldMasterTransactions();
        createTransactions();
        compareTransactionsToOldMast();
    }

    private static void createOldMasterTransactions() {
        Accounts oldMastAccounts = new Accounts();
        oldMastAccounts.getAccounts().add(new Account(1000, "John", "Water", 22.33));
        oldMastAccounts.getAccounts().add(new Account(2000, "David", "Fire", 2122.33));
        oldMastAccounts.getAccounts().add(new Account(3000, "Anna", "Smith", 100));

        try (BufferedWriter oldMastWriter = Files.newBufferedWriter(Paths.get("oldMast.xml"));) {
            JAXB.marshal(oldMastAccounts, oldMastWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createTransactions() {
        TransactionRecords transactionRecords = new TransactionRecords();
        transactionRecords.getTransactions().add(new TransactionRecord(1000, 300));
        transactionRecords.getTransactions().add(new TransactionRecord(1000, 50));
        transactionRecords.getTransactions().add(new TransactionRecord(1000, -150));
        transactionRecords.getTransactions().add(new TransactionRecord(2000, -500));
        transactionRecords.getTransactions().add(new TransactionRecord(2000, 5500));
        transactionRecords.getTransactions().add(new TransactionRecord(2222, 999));
        transactionRecords.getTransactions().add(new TransactionRecord(2333, 99));

        try (BufferedWriter transactionWriter = Files.newBufferedWriter(Paths.get("transactions.xml"));) {
            JAXB.marshal(transactionRecords, transactionWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
