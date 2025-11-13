package Chapter16.SortingAccounts;


import javax.xml.bind.JAXB;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingAccountsMain {
    public static void main(String[] args) throws IOException {
        BufferedReader oldMastReader = Files.newBufferedReader(Paths.get("oldMast.xml"));
        Accounts accounts = JAXB.unmarshal(oldMastReader, Accounts.class);
        List<Account> accountList= new ArrayList<>();

        for (int i = 0; i< accounts.getAccounts().size();i++){
            Account account = accounts.getAccounts().get(i);
            accountList.add(account);
        }
        Collections.sort(accountList, new AccountComparator());
        System.out.print(accountList);
    }
}
