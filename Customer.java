/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OOPAssignment2;

import java.util.ArrayList;

/**
 *
 * @author fries_000
 * All the information/code that is commented out is left for future purposes so that i 
 * don't forget the code i want to add in when working on this project by myself
 */
public class Customer {
    //all the information one needs to fill in, in order to be a customer
    private String firstName="";
    private String lastName="";
    private String customerType="";
    //private String address="";
    //private String city="";
    private int age;
   // private String country="";
    //private String postalcode="";
    //private String email="";
    private int accountNum=0;
    private int numbersOfAcct=0;
    private Account tempAcct; 
    private ArrayList<Account> accountHolder = new ArrayList<Account>();
    
//default constructor
public Customer()
{
    
}
//Constructor that will creat a cutomer if all fields are filled out 
public Customer(String customerType, String FirstName, String LastName, int Age)
{
    this.customerType = customerType;
    this.firstName = FirstName;
    this.lastName = LastName;
    //this.address= Address;
    //this.city = City;
    //this.country= Country;
    //this.postalcode = PostalCode;
    //this.email= Email;
    this.age = Age;
    this.accountNum = AccountSupport.getAccountNum();
    
}
// accessor and mutators for customers name
public String getFirstName() 
{
    return this.firstName;
}
public void setFirstName(String newFN)
{
    this.firstName =newFN;
}

public String getLastName()
{
    return this.lastName;
}
public void setLastName(String newLN)
{
    this.lastName = newLN;
}

public String getFullName()
{
    return this.getFirstName() + " " + this.getLastName();
}

public int numOfAccts()
{
    return this.accountHolder.size();
}

public String getType()
{
    return this.customerType;
}

//accessors and mutators for the full address of customer
/*public String getAddress()
{
    return this.address.toUpperCase();
}
public void setAddress(String newAddress)
{
    this.address = newAddress;
}

public String getCity()
{
    return this.city.toUpperCase();
}
public void setCity(String newCity)
{
    this.city = newCity;
}
*/
/*public String getPostalCode()
{
    return this.postalcode;
}
public void setPostalCode(String newPC)
{
    this.postalcode = newPC;
}

public String getCountry()
{
    return this.country.toUpperCase();
}
public void setCountry(String newC)
{
    this.country = newC;
}

public String getFullAddress()
{
    return this.getAddress() + ", " + this.getCity() 
            + ", " + this.getPostalCode() + ", " + this.getCountry();
}

// accessor and mutator for customers email
public String getEmail()
{
    return this.email;
}
public void setEmail(String newEmail)
{
    this.email = newEmail;
}*/

public void setAge(int Age)
{       
    this.age = Age;    
}
public int getAge()
{
    return this.age;
}

//accessors for customers account
public int getAccountNum()
{
    return this.accountNum;
}
public int getNumbersOfAcct()
{
    return this.numbersOfAcct;
}

//creating another account
public Account getAccount(int choice)
{
    return accountHolder.get(choice);
}

public void createAccount(double balance){
    if(this.getNumbersOfAcct()<2){
    tempAcct = new Account(balance);
    this.numbersOfAcct++;
    accountHolder.add(tempAcct);
    }
    else 
        System.out.println("You are only allowed to have 2 accounts");
    
}


}
