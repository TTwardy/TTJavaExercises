package Chapter15;

import Chapter15.fileMatcher.TransactionRecord;

// Fig. 15.9: Account.java
// Account class for storing records as objects.
public class Account {
    private int accountNumber;
    private String firstName;
    private String lastName;
    private double balance;

    public Account() {this(0, "", "", 0.0);}

    public Account(int accountNumber, String firstName,
                   String lastName, double balance) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }
    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    protected void combine(TransactionRecord transactionRecord){
        this.balance =+ transactionRecord.getTransactionAmount();
    }
    public int getAccountNumber() {return accountNumber;}

    public void setAccountNumber(int accountNumber)
    {this.accountNumber = accountNumber;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName)
    {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public double getBalance() {return balance;}

    public void setBalance(double balance) {this.balance = balance;}
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