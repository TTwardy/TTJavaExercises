package Chapter15;

// Fig. 15.11: CreateSequentialFile.java
// Writing objects to a file with JAXB and BufferedWriter.

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class CreateSequentialFile {
    public static void main(String[] args) throws IOException {
        // open clients.xml, write objects to it then close file
//        try(BufferedWriter output =
//                    Files.newBufferedWriter(Paths.get("clients.xml"))) {
//
//            Scanner input = new Scanner(System.in);
//
//            // stores the Accounts before XML serialization
//            Accounts accounts = new Accounts();
//
//            System.out.printf("%s%n%s%n? ",
//                    "Enter account number, first name, last name and balance.");
//
//            int counter = 4;
//
//            while (counter>0) { // loop until end-of-file indicator
//                counter--;
//                try {
//                    // create new record
//                    Account record = new Account(input.nextInt(),
//                            input.next(), input.next(), input.nextDouble());
//
//                    // add to AccountList
//                    accounts.getAccounts().add(record);
//                }
//                catch (NoSuchElementException elementException) {
//                    System.err.println("Invalid input. Please try again.");
//                    input.nextLine(); // discard input so user can try again
//                }
//
//                System.out.print("? ");
//            }
//
//            // write AccountList's XML to output
//            JAXB.marshal(accounts, output);
//        }
//        catch (IOException ioException) {
//            System.err.println("Error opening file. Terminating.");
//        }
//        Scanner inOldMaster = new Scanner(Paths.get("oldMast.txt"));
//        //System.out.printf("%d %s %s %.2f",inOldMaster.nextInt(), inOldMaster.next(), inOldMaster.next(), inOldMaster.nextDouble());
//        Account account = new Account(inOldMaster.nextInt(), inOldMaster.next(), inOldMaster.next(), inOldMaster.nextDouble());
//        System.out.println(account.getFirstName() + account.getLastName() + account.getBalance() + account.getAccountNumber());


    }
}

/*************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/