/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banking;

import java.util.ArrayList;

/**
 *
 * @author Emma
 */
public class Bank {
    
    //# of Customers
    public String bankInfo(ArrayList customers){
        int numOfCusts = customers.size();
        int numOfAccts = 0;
        
        for(int i = 0; i < customers.size(); i++)
        {
            Customer acctCheck = customers.get(i);
            numOfAccts += acctCheck.numOfAccts();
        }
        
        String bankInfo = ("The bank has " + numOfCusts + " customers and " + 
                numOfAccts + "accounts");
        
        return bankInfo;
    };
    
}
