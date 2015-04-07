/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banking;

import java.util.ArrayList;

/**
 *
 * @author fries_000
 */
public class seniorCustomer extends Customer  {
    // senior get 5$ for every 100 transactions and they have a limit of 
    // regular customer gets nothing
    private int age;
    
    
    public seniorCustomer(String FirstName, String LastName, int Age)
    {
            super(FirstName, LastName, Age);  
    }
    @Override
    public void setAge(int Age)
    {
        if (Age >= 60)
            this.age = Age;
        else
            System.out.print("You are not a senior");
    }
    
}
