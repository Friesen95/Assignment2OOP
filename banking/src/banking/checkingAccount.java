
package banking;

import java.util.*;

/**
 *  The Checking Account type allows customers to:
 * - deposit & withdraw funds from the account
 * - for an optional overdraft protection of up to $500
 * 
 * @author fries_000, co-written by Marco Duarte (macraven)
 */
public class checkingAccount extends Account 
{
    Scanner input = new Scanner(System.in);
    
    private double overDraftProtectionBalance = 0.0; //default overdraft balance is zero
    private double overDraftProtectionLimit = 0.0; //default overdraft limit is zero
    public boolean getOverDraftProtection = false; //default overdraft decision is false
    private double overDraftFee;
    
    //checkingAccount constructor
    public checkingAccount(double acctBalance)
    {
        super(acctBalance);
        
        //validation if the customer is a student
        if(Account.class.getClass().getSimpleName().equals("studentCustomer"))
        {
            System.out.println("Account type is invalid for Students.");
        }
                
        getOverDraftProtection();//prompts if the customer wants overdraft      
        
    }//end of checkingAccount constructor
    
    //set the max withdrawal for the chequing account to be $2000.00
    @Override
    public void setMAXWITHDRAWAL(double MAXWITHDRAWAL)
    {
        MAXWITHDRAWAL = 2000.00;
    }
    
    /** 
    *   This method will prompt if the customer wishes to include 
    * overdraft protection
    */
    public boolean getOverDraftProtection()
    {
        String choice;
        System.out.println("Do you wish to include Over Draft Protection to"
                + " your Chequing Account?");
        System.out.println("Options: enter y or n ");
        choice = input.next();
        
        if(!choice.equalsIgnoreCase("n")) //if the user wants to add the service
        {
            this.overDraftProtectionBalance = 500;
            this.overDraftProtectionLimit = 500;
           
        }
       
        return false;
    }//end of overdraft protection method
    
    //this method will get an overdraft fee if it exists
    public double getOverDraftFee(double overDraftProtectionBalance)
    {
        //if overdraft has been used and unpaid then calculate the 8% interest
        if(overDraftProtectionBalance < overDraftProtectionLimit)
        {
            this.overDraftFee = overDraftProtectionBalance * 12.95;
        }
        
        return this.overDraftFee;
        
    }//end of getExistingFee method
    
    //this method will set the existing fee
    public void setExistingFee(double existingfee)
    {
        this.overDraftFee = overDraftFee;
        
    }//end of setExistingFee method
    
/**
----------------------- Checking Account Fees ----------------------------------
* - For regular customers, the monthly fee for this account type is $7.99 and
*   that includes 25 free transactions. Subsequent transactions will cost $0.15
* - Students cannot have a checking account.
* - Seniors have no fee for this account type and unlimited transactions.
* - Business customers have unlimited transactions but the monthly fee is $14.99 
*   Business customers have a max withdrawal of $10,000.00 per day.
* - Interest rate calculated on funds in this account is 1.5% per month.
* - Overdraft interest is calculated with a 12.95% interest rate per month.
*/
    public double calculateMonthlyFees(String custType, Double overDraftFee)   
    {
        Double totalFee = 0.0;
        
        //add the fee associated with the total fee if there is overdraft
        totalFee += overDraftFee;
     
        //RC = regular customer
        if(custType.equalsIgnoreCase("RC"))
        {
            totalFee += 7.99;
            
            //25 included transactions, fees calculated after 25 @ 15%
            if(this.getNumberofTransaction() > 25)
            {
                totalFee+= (this.getNumberofTransaction() - 25) * 0.15;
            }
        }
        
        //BA = business account
        else if(custType.equalsIgnoreCase("BC"))
        {
            totalFee +=14.99;
        }
        
        // SN = senior NOTE: no fees in this account
        else if (custType.equalsIgnoreCase("SNC"))
        {
            return totalFee = 0.0;
            
        }
        else
        {
            return totalFee = -1.0; 
            
        }
    //1.5% of our total balance we get every month 
    this.deposit(this.getBalance()*0.015);
    
    return totalFee;   
    }//end of calculateMonthlyFees method
    
}//end of checkig account class