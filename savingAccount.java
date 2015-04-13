/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OOPAssignment2;

import java.util.Scanner;

/**
 *
 * @author matt bauer
 */
public class savingAccount extends Account {
        Scanner input = new Scanner(System.in);
    
    private double overDraftProtectionBalance = 0.0; //default overdraft balance is zero
    private double overDraftProtectionLimit = 0.0; //default overdraft limit is zero
    public boolean getOverDraftProtection = false; //default overdraft decision is false
    private double overDraftFee;
    
    //checkingAccount constructor
    public savingAccount(double acctBalance)
    {
        super(acctBalance);
        
        //validation if the customer has a business account
        if(Account.class.getClass().getSimpleName().equals("businessCustomer"))
        {
            System.out.println("Account type is invalid for Business Accounts.");
        }
                     
        
    }//end of savingAccount constructor
    
    //set the withdrawal limit for the saving account to be $1000.00
    @Override
    public void setMAXWITHDRAWAL(double MAXWITHDRAWAL)
    {
        MAXWITHDRAWAL = 1000.00;
    }
    
/**
    Saving Account Fees 
 This is a type of Account that allows customers to deposit and withdraw funds from the account. Customers will have a max withdrawal
 * limit of $1,000.00 per day.
o   The monthly fee for a saving account is $4.99 and is deducted from the balance of the account (no need to simulate time passing).
o   Regular customers have 10 free transactions per month, and after that each subsequent transaction will cost $0.25.
o   Students and seniors have no fee for this account and unlimited transactions.
o   Business customers do not have access to a savings account. 
o   Interest rate calculated on funds in this account is 4% per month.

*/
    public double calculateMonthlyFees(String custType, Double overDraftFee)   
    {
        Double totalFee = 0.0;
        
        //RC = regular customer
        if(custType.equalsIgnoreCase("RC"))
        {
            totalFee += 4.99;
            
            //10 included transactions, fees calculated after 10 @ .25$
            if(this.getNumberofTransaction() > 10)
            {
                totalFee+= (this.getNumberofTransaction() - 10) * 0.25;
            }
        }
        
        //STC = Student account NOTE: no fees in this account
        else if(custType.equalsIgnoreCase("STC"))
        {
            totalFee += 0.0;
        }
        
        // SN = Senior account NOTE: no fees in this account
        else if (custType.equalsIgnoreCase("SNC"))
        {
            return totalFee = 0.0;
            
        }
        else
        {
            return totalFee = -1.0; 
            
        }
    //4% of our total balance we get every month in intrest
    this.deposit(this.getBalance()*0.04);
    
    return totalFee;   
    }//end of calculateMonthlyFees method
    
}

