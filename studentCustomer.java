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
public class studentCustomer extends Customer {
    // students have a limit of taking out 500$
    // have a variable for school name and city
    private String school="";
    
    
    public studentCustomer(String customerType,String FirstName, String LastName, String School, int Age) 
    {
        super(customerType, FirstName, LastName, Age);
        this.school = School;         
    }
    
    public void setSchool(String schoolName)
    {
        this.school = schoolName;
    }
    public String getSchool()
    {
     return this.school;   
    }
}
