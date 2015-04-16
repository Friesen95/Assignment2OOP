package OOPAssignment2;
/**
 *
 * @author fries_000
 * 
 */
public class Account 
{
    private double acctBalance;
    private int acctNum;
    private double MAXWITHDRAWAL = 1000; 
    private int transactioncount = 0;
    private int transactionlLimit;
    protected double transferFunds;
    
    //default constructor
    public Account()
    {}
    
    /**
    *   The Account Constructor will create an account and add a balance to it
    *
    * @param acctBalance the amount you want to start off with in your account
    */
    public Account(double acctBalance)
    {
        this.acctBalance = acctBalance;
        this.acctNum = AccountSupport.getAccountNum();
    }

    /*
    *This method will validate if the customer can deposit money into their account
    *
    *@param amount the amount you want to take out of your account
    *@return will return a boolean if transaction is possible
    */
    public boolean deposit(double amount)
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
    
    //this method will validate if the customr can withdraw from thier account
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
        else
        {
            this.updateBalance("W", amount);
            transactioncount++;
            return true;
        }
    }
    
    //this method will get the balance
    public double getBalance()
    {
        return this.acctBalance;
    }
    
    //this method will get the account number
    public int getAcctNum()
    {
        return this.acctNum;
    }
    
    //this method will update the balance
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
        //TT = transfer to; TF = transfer from
        else if (typeOfChange.equals("TT"))
        {
            this.acctBalance = this.acctBalance + this.transferFunds;
        }
        else if(typeOfChange.equals("TF"))
        {
            this.acctBalance = this.acctBalance - this.transferFunds;
        }
         
        return false;
        
    }
    
    //this method will get the number of transctions in an account
    public int getNumberofTransaction()
    {
        return this.transactioncount;
    }
    
    //this method will increment a transaction by one
    public void setATransaction()
    {
        this.transactioncount++;
    }
    
    //this method will get the transaction limit
    public int getTransactionlLimit()
    {
        return this.transactionlLimit;
        
    }
    
    //this method will set the transaction limit
    public void setTransactionlLimit(int transactionlLimit)
    {
        this.transactionlLimit = transactionlLimit;
        
    }
   
    //this method will get the max withdrawal from an account
    public double getMAXWITHDRAWAL()
    {
        return this.MAXWITHDRAWAL;
    }
    
    //this method will set the max withdrawal
    public void setMAXWITHDRAWAL(double MAXWITHDRAWAL)
    {
        this.MAXWITHDRAWAL = MAXWITHDRAWAL;
    }
    
    public double getTransferFunds(double amount)
    {
        //will only transfer if there is a valid amount entered and account balance has funds to transfer
        if(amount < 0 || amount > acctBalance)
        {
            System.out.println("Amount entered is invalid");
        }
        
        this.transferFunds = amount;
        this.updateBalance("TF", amount);
        this.updateBalance("TT", amount);
        
        return transferFunds;
        
    }
    
}//end of account class