/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OOPAssignment2;

/**
 *
 * @author fries_000
 */
public class businessCustomer extends Customer{
    private String businessName ="";
    
    public businessCustomer(String customerType, String FirstName, String LastName, String City,String businessName, int Age)
    {
        super(customerType, FirstName, LastName, Age);
        this.businessName = businessName;
    }
    
    public void setBusinessName(String Name)
    {
       this.businessName = Name; 
    }
    
    public String getBusinessName()
    {
        return this.businessName;
    }
    
}
