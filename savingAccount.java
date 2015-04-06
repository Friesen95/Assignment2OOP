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
public class savingAccount extends Account {
    // can only take out money limited amont of times
    public savingAccount(double balance)
    {
        super(balance);
    }
    
    @Override
    public boolean withdraw(double amount)
    {
        System.out.println("This is a savings account");
        return false;
    }
}
