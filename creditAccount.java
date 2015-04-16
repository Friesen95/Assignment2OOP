

package OOPAssignment2;

/**
 *
 * @author fries_000, co-written by Marco Duarte (macraven)
 */
public class creditAccount extends Account
{
    private double creditLimit;
    protected double existingFee;
    
    /**
    * Credit Account constructor create a an account for a regular customer on 
    * default, with a credit balance of $5000 & a withdrawal limit of $1000
    */
    public creditAccount(double acctBalance)
    {
        super(acctBalance);
        
        this.creditLimit = 5000;
        acctBalance = 5000;
        this.setMAXWITHDRAWAL(1000);
        /**
        * if a student customer, then the credit balance and max withdrawal
        * are changed to $1000 balance & %200 withdrawal limit
        */
        if(Customer.class.getClass().getSimpleName().equals("studentCustomer"))
        {
            this.creditLimit = 1000.00;
            acctBalance = 1000.00;
            this.setMAXWITHDRAWAL(200.00);
            
        }
        /**
        * if a senior customer, then the credit balance and max withdrawal
        * are changed to $3000 balance & %500 withdrawal limit
        */
        if(Customer.class.getClass().getSimpleName().equals("seniorCustomer"))
        {
            this.creditLimit = 3000.00;
            acctBalance = 3000;
            this.setMAXWITHDRAWAL(500.00);
            
        }
        /**
        * if a business customer, then the credit balance and max withdrawal
        * are changed to $10000 & $3000 max withdrawal limit
        */
        else if(Customer.class.getClass().getSimpleName() == "businessCustomer")
        {
            this.creditLimit = 10000.00;
            acctBalance = 10000.00;
            this.setMAXWITHDRAWAL(3000.00);
        }
        
    }//end of creditAccount constructor
    
    
    
    //this method will allow a customer to pay thier balance
    public boolean pay(double amount)
    {
        if(super.getBalance() < amount)
        {
            System.out.println("You do not have $" + amount +" in your account");
            return false;
        }
        else
        {
        this.updateBalance("W", amount);
        return true;
        }
    }//end of pay method
    
    //this method will get the existing fee if credit has ben used in the account
    public double getExistingFee(double acctBalance)
    {
        //if credit hads been used and unpaid then calculate the 8% interest
        if(acctBalance < this.creditLimit )
        {
            existingFee = acctBalance * 0.08;
        }
        
        return this.existingFee;
        
    }//end of getExistingFee method
    
    //this method will set the existing fee
    public void setExistingFee(double existingfee)
    {
        this.existingFee = existingfee;
        
    }//end of setExistingFee method
    
/**
--------------------------- Credit Account Fees -------------------------------- 
* - A regular customers credit account has a credit amount of up to $5,000.00 
*   and has a maximum transaction amount of $1,000.00 per day. Interest rate 
*   is 14.95% per month.
* - A student’s credit account has a credit amount of up to $1,000 and has a 
*   maximum transaction amount of $200.00 per day. Interest rate is 12.95% 
*   per month.
* - A senior’s credit account has a credit amount of up to $3,000 and has a 
*   maximum transaction amount of $500.00 per day. Interest rate is 9.95% 
*   per month.
* - A business customer’s account has a credit amount of up to $10,000 and has a 
*   maximum transaction amount of $3,000.00 per day. Interest rate is 19.95% 
*   per month.
* - The monthly fee for this account is $7.00 for regular customers, $5.00 for 
*   seniors and students and $15.00 for business customers.
* - A minimum payment of 8% of the credit balance must be paid at the end of 
*   each month until the credit balance is paid off.
*/

    public double calculateMonthlyFees(String custType, Double existingFee)   
    { 
        Double totalFee = 0.0;
        
        //RC = regular customer
        if(custType.equalsIgnoreCase("RC"))
        {
            totalFee += 7.00;
            totalFee += existingFee * 0.1495;
        }
        
        //BA = business customer
        else if(custType.equalsIgnoreCase("BC"))
        {
            totalFee +=15.00;
            totalFee += existingFee * 0.1995;
        }
        
        // SN = senior customer
        else if (custType.equalsIgnoreCase("SNC"))
        {
            return totalFee += 5.00 + existingFee * 0.0995;
        }
        
        //ST = student customer
        else if (custType.equalsIgnoreCase("STC"))
        {
            return totalFee += 5.00 + existingFee * 0.1295;
        }
        
        else
        {       
            System.out.print("Not a valid customer");
            return totalFee = -1.0; 
        }
        
    return totalFee;  
    
    }//end of calculateMonthlyFees method

}//end of credit account class