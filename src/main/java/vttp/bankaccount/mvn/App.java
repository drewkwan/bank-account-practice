package vttp.bankaccount.mvn;

import vttp.bankaccount.mvn.accounts.BankAccount;
import vttp.bankaccount.mvn.accounts.FixedDepositAccount;

/**
 * Hello world!
 * 
 */

 // Main method will be in the app class, so start function will be here.

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("My ATM Machine - RHB Bank");
        BankAccount bkAcct = new BankAccount("Andrew's bank account");
        bkAcct.deposit("1000");
        System.out.println("My new bank account balance: " + bkAcct.getBalance());
        bkAcct.withdraw("500");
        System.out.println("My new bank account balance: " + bkAcct.getBalance());
        
        //Fixed Deposit
        FixedDepositAccount fdAcc = new FixedDepositAccount("Andrew FD", 100000f);
        System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());

        fdAcc.setDurationAndInterest(4, 12);
        System.out.println("[UPDATED] Fixed Deposit Acc balance > " + fdAcc.getBalance());
        //test out setting a new duration

    }
        

}
