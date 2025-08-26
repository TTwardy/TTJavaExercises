package Chapter15.fileMatcher;

import Chapter15.Account;
import Chapter15.Accounts;

import javax.xml.bind.JAXB;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class FileMatch {
    static Scanner oldMastScanner;
    static Scanner transactionsScanner;
    static BufferedReader transactionsReader;
    static BufferedReader oldMastReader;
    static boolean isMultipleTransactions;

    protected static void compareTransactionsToOldMast() throws IOException {
        double transactionBalance = 0;
        int transactionCounter = 0;

        initializeXmlReaders();
        Accounts newMastAccounts = new Accounts();
        Accounts accounts = JAXB.unmarshal(oldMastReader, Accounts.class);
        TransactionRecords transactions = JAXB.unmarshal(transactionsReader, TransactionRecords.class);

        try (
                BufferedWriter newMastWriter = Files.newBufferedWriter(Paths.get("newMast.xml"));
                Formatter logWriter = new Formatter("log.txt");) {
            int i = 0;
            while (i < accounts.getAccounts().size()) {
                Account currentAccount = accounts.getAccounts().get(i);

                if (transactionCounter >= transactions.getTransactions().size()) {
                    newMastAccounts.getAccounts().add(getCurrentTransactionAccount(currentAccount, transactionBalance));
                    i++;
                    continue;
                }

                TransactionRecord currentTransaction = transactions.getTransactions().get(transactionCounter);

                if (currentTransaction.getAccountNumber() == currentAccount.getAccountNumber()) {
                    transactionBalance += currentTransaction.getTransactionAmount();
                    isMultipleTransactions = true;
                    transactionCounter++;
                    continue;
                }

                if (isMultipleTransactions) {
                    newMastAccounts.getAccounts().add(getCurrentTransactionAccount(currentAccount, transactionBalance));
                    isMultipleTransactions = false;
                    transactionBalance = 0;
                    i++;
                } else if (currentTransaction.getAccountNumber() < currentAccount.getAccountNumber()) {
                    logWriter.format("%s %d %.2f\n", "Unmatched transaction for account:",
                            currentTransaction.getAccountNumber(), currentTransaction.getTransactionAmount());
                    transactionCounter++;
                } else {
                    newMastAccounts.getAccounts().add(getCurrentTransactionAccount(currentAccount));
                    i++;
                }
            }
            JAXB.marshal(newMastAccounts, newMastWriter);
        }
    }

//    private static boolean succesfullMatchToAccount(Accounts accounts, TransactionRecord currentTransaction) {
//        for (int i = 0; i < accounts.getAccounts().size(); i++) {
//            if (accounts.getAccounts().get(i).getAccountNumber() == currentTransaction.getAccountNumber()){
//                newMastAccounts.getAccounts().add(getCurrentTransactionAccount(accounts.getAccounts().get(i), currentTransaction.getTransactionAmount()));
//                return true;
//            }
//        }
//        return false;
//    }
    private static void writeAccount(Formatter writer, Account account, double delta) {
        writer.format("%d %s %s %.2f\n", account.getAccountNumber(), account.getFirstName(), account.getLastName(),
                account.getBalance() + delta);
    }
    private static Account getCurrentTransactionAccount(Account account, double delta){
        return new Account(account.getAccountNumber(), account.getFirstName(), account.getLastName(),
                account.getBalance() + delta);
    }
    private static Account getCurrentTransactionAccount(Account account){
        return new Account(account.getAccountNumber(), account.getFirstName(), account.getLastName(),
                account.getBalance());
    }

    private static void writeAccount(Formatter writer, Account account) {
        writeAccount(writer, account, 0);
    }

    protected static void initializeScanners() throws IOException {
        oldMastScanner = new Scanner(Paths.get("oldMast.txt"));
        transactionsScanner = new Scanner(Paths.get("transactions.txt"));
    }

    protected static void initializeXmlReaders() throws IOException {
        oldMastReader = Files.newBufferedReader(Paths.get("oldMast.xml"));
        transactionsReader = Files.newBufferedReader(Paths.get("transactions.xml"));
    }


    protected static TransactionRecord readNextTransaction(Scanner transactionsScanner) {
        if (transactionsScanner.hasNext()) {
            return new TransactionRecord(transactionsScanner.nextInt(), transactionsScanner.nextDouble());
        } else {
            return null;
        }
    }

}