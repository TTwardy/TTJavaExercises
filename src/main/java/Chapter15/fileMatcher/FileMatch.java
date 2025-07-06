package Chapter15.fileMatcher;

import Chapter15.Account;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class FileMatch {
    static Scanner oldMastScanner;
    static Scanner transactionsScanner;
    static boolean isMultipleTransactions;

    protected static void compareTransactionsToOldMast() throws IOException {
        double transactionBalance = 0;
        initializeScanners();
        Account currentAccount=readNextAccount(oldMastScanner);
        TransactionRecord currentTransaction;
        try (
                Formatter newMastWriter = new Formatter("newMast.txt");
                Formatter logWriter = new Formatter("log.txt");
        ) {
            while (oldMastScanner.hasNext() || transactionsScanner.hasNext()) {
                currentTransaction = readNextTransaction(transactionsScanner);
                if (currentTransaction.getAccountNumber()==currentAccount.getAccountNumber()){
                    transactionBalance += currentTransaction.getTransactionAmount();
                    isMultipleTransactions=true;
                    continue;
                }

                if(isMultipleTransactions){
                    newMastWriter.format("%d %s %s %.2f\n", currentAccount.getAccountNumber(), currentAccount.getFirstName(), currentAccount.getLastName(),
                            currentAccount.getBalance()+transactionBalance);
                    isMultipleTransactions=false;
                    transactionBalance = 0;
                }
                currentAccount = readNextAccount(oldMastScanner);
                if (currentAccount == null) {
                    logWriter.format("%s %d %.2f\n", "Unmatched transaction for account:", currentTransaction.getAccountNumber(), currentTransaction.getTransactionAmount());
                } else if (currentTransaction == null) {
                    writeAccount(newMastWriter, currentAccount);
                } else if (currentAccount.getAccountNumber() == currentTransaction.getAccountNumber()) {
                    writeAccount(newMastWriter, currentAccount, currentTransaction.getTransactionAmount());
                } else if (currentAccount.getAccountNumber() < currentTransaction.getAccountNumber()) {
                    writeAccount(newMastWriter, currentAccount);
                } else {
                    logWriter.format("%s %d %.2f\n", "Unmatched transaction for account:", currentTransaction.getAccountNumber(), currentTransaction.getTransactionAmount());
                    writeAccount(newMastWriter, currentAccount);
                }
            }
        }
    }

    private static void writeAccount(Formatter writer, Account account, double delta) {
        writer.format("%d %s %s %.2f\n", account.getAccountNumber(), account.getFirstName(), account.getLastName(),
                account.getBalance() + delta);
    }

    private static void writeAccount(Formatter writer, Account account) {
        writeAccount(writer, account, 0);
    }
    protected static void initializeScanners() throws IOException {
        oldMastScanner = new Scanner(Paths.get("oldMast.txt"));
        transactionsScanner = new Scanner(Paths.get("transactions.txt"));
    }

    protected static Account readNextAccount(Scanner oldMastScanner) {
        if (oldMastScanner.hasNext()) {
            return new Account(oldMastScanner.nextInt(), oldMastScanner.next(), oldMastScanner.next(), oldMastScanner.nextDouble());
        } else {
            return null;
        }
    }

    protected static TransactionRecord readNextTransaction(Scanner transactionsScanner) {
        if (transactionsScanner.hasNext()) {
            return new TransactionRecord(transactionsScanner.nextInt(), transactionsScanner.nextDouble());
        } else {
            return null;
        }
    }

}