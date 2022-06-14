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

    //setters and getters

     public float getInterest() {
        return interest;
    }

    private void setInterest(float interest) {
        if(interest <0) {
            throw new IllegalArgumentException("Unsupported interest");
        }

        this.interest = interest;
        //set back to default if invalid amount entered
    }

    public int getDuration() {
        return duration;
        
    }

    public void setDuration(int duration) {
        if (duration<0) {
            throw new IllegalArgumentException("Unsupported duration");
        }
        this.duration = duration;
    }

    public int getDurationInterestCounter() {
        return durationInterestCounter;
    }

    public void setDurationAndInterest(float interest, int duration) {
        if (durationInterestCounter == 1) {
            throw new IllegalArgumentException("Duration and Interest can only be changed once.");
        }
        setInterest(interest);
        setDuration(duration);
        durationInterestCounter++;
    }

    @Override
    public float withdraw (String withdrawAmt) {
        //NOP
        return 0;
    }

    @Override
    public Float deposit (String depositAmt) {
        return 0f;
    }

    @Override
    public float getBalance() {
        return super.getBalance() +interest;
    }

}