/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banking;

/**
 *
 * @author fries_000
 */
public class businessAccount extends Account {
    private final int MAXWITHDRAWAL = 10000;
    public businessAccount(double amount)
    {
        super(amount);
    }
    
    @Override
    public boolean withdraw(double amount)
    { 
        if(super.getBalance()<amount)
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
        super.setATransaction();
        return true;
        }
    
    }
}
