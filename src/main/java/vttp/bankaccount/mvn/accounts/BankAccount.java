package vttp.bankaccount.mvn.accounts;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BankAccount {
    /*
     * Members: account holders name(final), account number: 8 digits (substring) randomly generated string (toString), 
     * balance (float), Transactions - list (str), ifClosed - boolean, account cration date, account closing date 
     */
    
    private final String acctName;
    private final String acctID = UUID.randomUUID().toString().substring(0, 8);
    private float balance = 0f;
  
    private List<String> transaction = new LinkedList<>(); //revise strings
    private boolean isClosed = false;

    private LocalDateTime acctOpening;
    private LocalDateTime acctClosing;
    
    //constructors
    //1st constructor just acctName, set balance to 0
    public BankAccount(String acctName) {
        this.acctName = acctName;
        this.balance = 0;
    }
    //2nd constructor acctName and initial Balance, set balance to initialBal
    public BankAccount(String acctName, int initialBal) {
        this.acctName = acctName;
        this.balance = initialBal;
    } 

    
    //getters and setters
    
    public String getAcctName() {
        return acctName;
    }
    public String getAcctID() {
        return acctID;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public List<String> getTransaction() {
        return transaction;
    }
    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }
    public boolean isClosed() {
        return isClosed;
    }
    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }
    public LocalDateTime getAcctOpening() {
        return acctOpening;
    }
    public void setAcctOpening(LocalDateTime acctOpening) {
        this.acctOpening = acctOpening;
    }
    public LocalDateTime getAcctClosing() {
        return acctClosing;
    }
    public void setAcctClosing(LocalDateTime acctClosing) {
        this.acctClosing = acctClosing;
    }

    //Withdraw method: Added to transactions list, deposit only +ve amounts, add the statement to list. If incorrect amount, throw illegal argument exception
    //this indicates the use of a try block 
    public float withdraw (String withdrawAmt) {
        Float withdrawAmtF;
        try {
            withdrawAmtF = Float.parseFloat(withdrawAmt);
            if  (withdrawAmtF.floatValue() <= 0) {
                throw new IllegalArgumentException("Withdrawal amount cannot be 0 or less");
            }

            if (this.isClosed()) {
                throw new IllegalArgumentException("The account is closed.");
            }
            
            if (withdrawAmtF > this.balance) {
                throw new IllegalArgumentException("Account value is too low.");
            }

            this.balance = this.balance - withdrawAmtF.floatValue();
            //Construct history logline using string builder
            
            StringBuilder txnStrBuilder = new StringBuilder();
            txnStrBuilder.append("Withdraw S");
            txnStrBuilder.append(withdrawAmtF.floatValue());
            txnStrBuilder.append(" at ");
            txnStrBuilder.append(LocalDateTime.now());
            System.out.println(txnStrBuilder.toString());
            transaction.add(txnStrBuilder.toString());
        
    }   catch(NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }

    return this.balance;
    
    }
    
}
