package banking;
/**
 *
 * @author fries_000
 * All code commented out is meant for future purposes s
 */
public class Account 
{
    private double acctBalance;
    private int acctNum;
    private final double MAXWITHDRAWAL = 1000; 
    private int transactioncount=0;
    public Account()
    {}
    
    /*The Constructor for account, will create an account and add a balance to it
    *
    *@param acctBalance the amount you want to start off with in your account
    */
    public Account(double acctBalance)
    {
        this.acctBalance = acctBalance;
        this.acctNum = AccountSupport.getAccountNum();
    }

    /*
    *This method will deposite money from your account
    *
    *@param amount the amount you want to take out of your account
    *@return will return a boolean if transaction is possible
    */
    public boolean deposite(double amount)
    {
        if(amount<=0)
        {
          return false;  
        }
        else
        {
        this.updateBalance("D", amount);
        transactioncount++;
        return true;
        }
    }
    
    public boolean withdraw(double amount)
    { 
        if(acctBalance<amount)
        {
            System.out.println("You do not have $" + amount +" in your account");
            return false;
        }
        else if(amount>MAXWITHDRAWAL)
        {
            System.out.println("This amount is over the max withdrawal allowed.");
            return false;
        }
        else{
        this.updateBalance("W", amount);
        transactioncount++;
        return true;
        }
    }
    
    public double getBalance()
    {
        return this.acctBalance;
    }
    
    public int getAcctNum()
    {
        return this.acctNum;
    }
    
    public boolean updateBalance(String typeOfChange, double amount)
    {
        if(typeOfChange.equals("W"))
        {
            this.acctBalance = this.acctBalance - amount;
            return true;
        }
        else if(typeOfChange.equals("D"))
        {
            this.acctBalance = this.acctBalance + amount;
            return true;
        }
        else 
            return false;
        
    }
    public int getNumberofTransaction()
    {
        return this.transactioncount;
    }
    public void setATransaction()
    {
        this.transactioncount++;
    }
    
}
