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
public class creditAccount extends Account{
    //cant withdraw any money
    public creditAccount(double balance)
    {
        super(balance);
    }
    @Override
    public boolean withdraw(double amount)
    {
        System.out.println("This is a credit account you cant deposite any money");
        return false;
    }
    @Override
    public boolean deposite(double amount)
    {
        System.out.println("This is a credit account you cant deposite any money");
        return false;
    }
    
    public boolean pay(double amount)
    {
        if(super.getBalance()<amount)
        {
            System.out.println("You do not have $" + amount +" in your account");
            return false;
        }
        else
        {
        this.updateBalance("W", amount);
        return true;
        }
    }
}
