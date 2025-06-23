package Chapter15.fileMatcher;

import Chapter15.Account;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class FileMatch {
    static Scanner oldMastScanner;
    static Scanner transactionsScanner;

    protected static void compareTransactionsToOldMast() throws IOException {
        initializeScanners();
        try (
                Formatter newMastWriter = new Formatter("newMast.txt");
                Formatter logWriter = new Formatter("log.txt");
        ) {
            while (oldMastScanner.hasNext() || transactionsScanner.hasNext()) {
                Account currentAccount = new Account(oldMastScanner.nextInt(), oldMastScanner.next(), oldMastScanner.next(), oldMastScanner.nextDouble());

                if (transactionsScanner.hasNext()) {
                    TransactionRecord currentTransaction = new TransactionRecord(transactionsScanner.nextInt(), transactionsScanner.nextDouble());
                    if (currentAccount.getAccountNumber() == currentTransaction.getAccountNumber()) {
                        newMastWriter.format("%d %s %s %.2f\n", currentAccount.getAccountNumber(), currentAccount.getFirstName(), currentAccount.getLastName(),
                                currentAccount.getBalance() + currentTransaction.getTransactionAmount());
                    } else {
                        logWriter.format("%s %d %s %s %.2f\n", "Unmatched transaction for account:",currentAccount.getAccountNumber(), currentAccount.getFirstName(), currentAccount.getLastName(),
                                currentAccount.getBalance() + currentAccount.getBalance());
                    }
                } else {
                    newMastWriter.format("%d %s %s %.2f\n", currentAccount.getAccountNumber(), currentAccount.getFirstName(), currentAccount.getLastName(),
                            currentAccount.getBalance());
                }
            }
        }
    }

    protected static void initializeScanners() throws IOException {
        oldMastScanner = new Scanner(Paths.get("oldMast.txt"));
        transactionsScanner = new Scanner(Paths.get("transactions.txt"));
    }

}
//    protected static void updateRecords(int accountNumber, double balanceChange) {
//        try (Formatter writer = new Formatter("newMast.txt")) {
//            for (Account account : accounts.getAccounts()) {
//                try {
//                    writer.format("%d %s %s %.2f\n", account.getAccountNumber(), account.getFirstName(), account.getLastName(), account.getBalance());
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

