package vttp.bankaccount.mvn.accounts;


/* Task 2: Write fixed deposit class.
 * Extend bank account, add members interest (float), duration in months (int), default is 3 and 6. 
 * Changed only once, any subsequent change, throw illegal argument exception. Once balance is set, it cannot change.
 * Withdraw and deposit will not update the acounts balance. 
 * getBalance should reutrn balance plus interest. 
 */
public class FixedDepositAccount extends BankAccount {
    private float interest = 3;
    private int duration = 6;
    private int durationInterestCounter = 0;

    //Overload the bankaccount constructors

    public FixedDepositAccount (String acctName, Float initialBal) {
        super(acctName, initialBal);
        this.durationInterestCounter = 0;
    }

    public FixedDepositAccount (String acctName, Float initialBal, Float interest) {
        super(acctName, initialBal);
        this.interest = interest;
        this.durationInterestCounter = 0;
    }

    public FixedDepositAccount (String acctName, Float initialBal, Float interest, Integer duration) {
        super(acctName, initialBal);
        this.interest = interest;
        this.duration = duration;
        this.durationInterestCounter = 0;
    }
    
}