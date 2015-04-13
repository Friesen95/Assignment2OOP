package OOPAssignment2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fries_000
 */
public class Teller 
{
    // needed to suppress the warning lables because they were bugging me while i was writing my code
    // i used the "continue" line so that if they choose to exit it would leave the if statment but still stay in the loop
    @SuppressWarnings("UnnecessaryContinue")
    public static void main(String[] args) 
    {
        Scanner intHolder = new Scanner(System.in);
        Scanner doubleHolder = new Scanner(System.in);
        Scanner stringHolder = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();
        double accountNum, balance, amount = 0;
        int choice, customerNum = 0, age = 0;
        Customer addRegularCustomer = new regularCustomer("RC","Drew", "James", 29);
        customers.add(addRegularCustomer);
        addRegularCustomer.createAccount(30);
        Customer addSeniorCustomer = new seniorCustomer("SNC","Felix", "Felicis",70);
        customers.add(addSeniorCustomer);
        addSeniorCustomer.createAccount(30);
        Customer addStudentCustomer = new studentCustomer("STC", "Emma", "Hilborn","Georgian",18);
        customers.add(addStudentCustomer);
        addStudentCustomer.createAccount(30);
        Customer addBusinessCustomer = new studentCustomer("BC", "Harry", "Potter","Hogwarts",26);
        customers.add(addBusinessCustomer);
        addBusinessCustomer.createAccount(30);
        //--hasAccount means they have an account and will be able to continue to the private menu that 
        //is only avaliable for customers 
        //--quit will terminate the program and end everything 
        //--insideMenu stands for the menu that will be responsible for changing info about the customer
        //--Primary Menu is the first menu anyone sees if they are a customer or not, it is the point where 
        //they get to choose to be a customer or to leave
        //--multiAccounts meaning they have more then one account under their name
        boolean hasAccount, quit = false, insideMenu = false, primaryMenu, multiAccounts; 
        // input will not be used but is needed to record the fact that the user pressed enter to continue
        //FN = First Name, LN = Last Name
        String FN, LN, school, business, input;

        System.out.println("Hello and welcome to Friesens-JBank");
        //the first menu when someone starts the program
        while (quit == false) 
        {
            // initialize my boolean here so that the values done stay when looking up/creating a different account
            primaryMenu = false;
            hasAccount = false;
            multiAccounts = false; 
            while (primaryMenu == false) 
            {
                System.out.println("\nMenu:");
                System.out.println("--------------------------------------------------------");
                System.out.println("1. New Customer");
                System.out.println("2. Existing Customer");
                System.out.println("3. Customer look-up");
                System.out.println("4. Bank Information");
                System.out.println("5. Quit");
                while (!intHolder.hasNextInt())
                {
                    System.out.println("Not a valid option");
                    intHolder.next();
                }
                choice = intHolder.nextInt();

                if (choice == 1) //will create a new customer, first collect info and then save it 
                {
                    System.out.println("Lets make you a part of our family");
                    System.out.println("We will need some information of yours"
                            + "to open an account.");
                    //Ask what kind of customer
                    System.out.println("What kind of customer would you like "
                            + "to create? Enter 1 for regular, 2 for senior, 3 "
                            + "for student, or 4 for business.");
                    int custType = intHolder.nextInt();
                    //Keep asking 'til they pick 1-4
                    while(custType < 1 || custType > 4)
                    {
                        System.out.printf("\nSorry but %d is not a valid choice."
                                + " Please choose 1, 2, 3, or 4.",custType);
                        custType = intHolder.nextInt();
                    }
                    if(custType == 1) //Regular customer
                    {
                        System.out.println("What is your First Name: ");
                        FN = stringHolder.nextLine();
                        System.out.println("What is your Last Name: ");
                        LN = stringHolder.nextLine();
                        System.out.println("How old are you: ");
                        age = intHolder.nextInt();
                        Customer newCust = new regularCustomer("RC", FN, LN, age);
                        System.out.println("How much would you like to put in your account?: ");
                         //if the entered amount is not a double
                        while (!doubleHolder.hasNextDouble()) 
                        {
                            System.out.println("Not a valid option");
                            doubleHolder.next();
                        }
                        balance = doubleHolder.nextDouble();
                        while(balance <= 0)
                        {
                            System.out.println("You must choose a balance greater"
                                    + "than $0.");
                            while (!doubleHolder.hasNextDouble()) 
                            {
                            System.out.println("Not a valid option");
                            doubleHolder.next();
                            }
                            balance = doubleHolder.nextDouble();
                        }
                        newCust.createAccount(balance);
                        customers.add(newCust);
                        System.out.println("Congradulations you created an account.\n"
                                + "This is your account number, dont forget it.\n"
                                + "Account Number: " + newCust.getAccountNum());
                        hasAccount = true;
                        primaryMenu = true;
                        //we just added an account to our list meaning they will be the latest customer
                        customerNum = customers.lastIndexOf(newCust);
                    }
                    else if(custType == 2) //Senior customer
                    {
                        System.out.println("What is your First Name: ");
                        FN = stringHolder.nextLine();
                        System.out.println("What is your Last Name: ");
                        LN = stringHolder.nextLine();
                        System.out.println("How old are you: ");
                        age = intHolder.nextInt();
                        Customer newCust = new seniorCustomer("SNC", FN, LN, age);
                        System.out.println("How much would you like to put in your account?: ");
                        while (!doubleHolder.hasNextDouble()) 
                        {
                            System.out.println("Not a valid option");
                            doubleHolder.next();
                        }
                        balance = doubleHolder.nextDouble();
                        while(balance <= 0)
                        {
                            System.out.println("You must choose a balance greater"
                                    + "than $0.");
                            while (!doubleHolder.hasNextDouble()) 
                            {
                            System.out.println("Not a valid option");
                            doubleHolder.next();
                            }
                            balance = doubleHolder.nextDouble();
                        }
                        newCust.createAccount(balance);
                        customers.add(newCust);
                        System.out.println("Congradulations you created an account.\n"
                                + "This is your account number, dont forget it.\n"
                                + "Account Number: " + newCust.getAccountNum());
                        hasAccount = true;
                        primaryMenu = true;
                        //we just added an account to our list meaning they will be the latest customer
                        customerNum = customers.lastIndexOf(newCust);
                    }
                    else if(custType == 3) //Student customer
                    {
                        System.out.println("What is your First Name: ");
                        FN = stringHolder.nextLine();
                        System.out.println("What is your Last Name: ");
                        LN = stringHolder.nextLine();
                        System.out.println("What is your school: ");
                        school = stringHolder.nextLine();
                        System.out.println("How old are you: ");
                        age = intHolder.nextInt();
                        Customer newCust = new studentCustomer("STC", FN, LN, school, age);
                        System.out.println("How much would you like to put in your account?: ");
                        while (!doubleHolder.hasNextDouble()) 
                        {
                            System.out.println("Not a valid option");
                            doubleHolder.next();
                        }
                        balance = doubleHolder.nextDouble();
                        while(balance <= 0)
                        {
                            System.out.println("You must choose a balance greater"
                                    + "than $0.");
                            while (!doubleHolder.hasNextDouble()) 
                            {
                            System.out.println("Not a valid option");
                            doubleHolder.next();
                            }
                            balance = doubleHolder.nextDouble();
                        }
                        newCust.createAccount(balance);
                        customers.add(newCust);
                        System.out.println("Congradulations you created an account.\n"
                                + "This is your account number, dont forget it.\n"
                                + "Account Number: " + newCust.getAccountNum());
                        hasAccount = true;
                        primaryMenu = true;
                        //we just added an account to our list meaning they will be the latest customer
                        customerNum = customers.lastIndexOf(newCust);
                    }
                    else //Business cusomter
                    {
                        System.out.println("What is your First Name: ");
                        FN = stringHolder.nextLine();
                        System.out.println("What is your Last Name: ");
                        LN = stringHolder.nextLine();
                        System.out.println("What is your buiness: ");
                        business = stringHolder.nextLine();
                        System.out.println("How old are you: ");
                        age = intHolder.nextInt();
                        Customer newCust = new studentCustomer("BC", FN, LN, business, age);
                        System.out.println("How much would you like to put in your account?: ");
                        //if the entered amount is not a double
                        while (!doubleHolder.hasNextDouble()) 
                        {
                            System.out.println("Not a valid option");
                            doubleHolder.next();
                        }
                        
                         balance = doubleHolder.nextDouble();
                        while(balance <= 0)
                        {
                            System.out.println("You must choose a balance greater"
                                    + "than $0.");
                            while (!doubleHolder.hasNextDouble()) 
                            {
                            System.out.println("Not a valid option");
                            doubleHolder.next();
                            }
                            balance = doubleHolder.nextDouble();
                        }
                        newCust.createAccount(balance);
                        customers.add(newCust);
                        System.out.println("Congradulations you created an account.\n"
                                + "This is your account number, dont forget it.\n"
                                + "Account Number: " + newCust.getAccountNum());
                        hasAccount = true;
                        primaryMenu = true;
                        //we just added an account to our list meaning they will be the latest customer
                        customerNum = customers.lastIndexOf(newCust);
                    }
                } 
                else if (choice == 2) //they have an account, we shall ask for their accountNum and search for it
                {
                    System.out.println("Welcome Customer, may I have your account Number:");
                    accountNum = intHolder.nextInt();
                    for (int x = 0; x < customers.size(); x++) 
                    {
                        if (accountNum == customers.get(x).getAccountNum()) 
                        {   //we let hasAccount = true so that they can access the next step 
                            hasAccount = true;
                            primaryMenu = true;
                            insideMenu = true;
                            // we save their number so that we can find them again once we leave this for loop
                            customerNum = x;
                        }
                    }
                }
                else if (choice == 3) //They want to look up a customer
                {
                    //Get a search name
                    System.out.println("Who would you like to search for?\n");
                    String searchUser = stringHolder.nextLine();
                    int search = 0;
                    boolean searching = true;
                    int customerLocation = -1;
                    //Run a loop looking for the name while the search location
                    //is less than the arraylist size and while the name hasn't
                    //been found yet
                    do
                    {
                        Customer searchCust = customers.get(search);                       
                        FN = searchCust.getFirstName();
                        LN = searchCust.getLastName();   
                        //If the user matches, make sure it's the right customer
                        //(possible duplicate names)
                        if (FN.equalsIgnoreCase(searchUser) || 
                                LN.equalsIgnoreCase(searchUser))
                        {
                            System.out.printf("\nIs %s the customer you "
                                        + "wanted? Enter 'y' or 'n'.\n", 
                                        searchCust.getFullName());
                                String searchCheck = stringHolder.nextLine();
                            //While the user has not chosen either way, keep asking
                            while(!searchCheck.equalsIgnoreCase("y") && 
                                    !searchCheck.equalsIgnoreCase("n"))
                            {
                                System.out.printf("\n%s is not a valid choice! "
                                            + "Enter 'y' or 'n'.\n");
                                searchCheck = stringHolder.nextLine();
                            }
                            if(searchCheck.equalsIgnoreCase("y"))
                            {
                                customerLocation = search;
                                searching = false;
                            }
                            else
                            {
                                System.out.println("Okay, we'll look for the"
                                        + "next customer with that name!\n");
                                searching = true;
                            }
                        }
                    }while(search < customers.size() && searching == true);
                    
                    if(customerLocation == -1)
                    {
                        System.out.println("Sorry, but there isn't a customer "
                                + "with that name!\n");
                        System.out.println("Would you like to display all "
                                + "customers? Enter 'y' or 'n'.\n");
                        String display = stringHolder.nextLine();
                        while(!display.equalsIgnoreCase("y") &&
                                !display.equalsIgnoreCase("n"))
                        {
                            System.out.printf("\nSorry but %s is not a valid "
                                    + "choice! Enter 'y' or 'n'.\n");
                        };
                        if(display.equalsIgnoreCase("y"))
                        {
                            System.out.println("Customer list:");
                            for(int d = 0; d < customers.size(); d++)
                            {
                                System.out.printf("\n%d: %s", d+1,
                                customers.get(d).getFullName());
                            }
                            System.out.println("End of customer list.");
                        }
                        else
                        {
                            System.out.println("Sorry you didn't find who you "
                                    + "were looking for!");
                        }
                        quit = false;
                    }
                    else
                    {
                        Customer custSearchResult = customers.get(search);
                        System.out.printf("\nType: %s. Full name: %s. Age: %d. "
                                + "# of accounts: %d",
                                custSearchResult.getType(),
                                custSearchResult.getFullName(),
                                custSearchResult.getAge(),
                                custSearchResult.numOfAccts());
                        quit = false;
                    }
                }
                else if (choice == 4) //They want bank info
                { 
                    String bankInfo = Bank.bankInfo(customers);
                    System.out.println(bankInfo);
                }
                else if (choice == 5) 
                {
                    System.out.println("\nThank you for trying Error 404's "
                            + "JBank.\n Hope to see you again soon. Good Bye.");
                    // need to shut down the program
                    primaryMenu = true;
                    quit = true;
                } 
                else 
                {
                    System.out.println("\n\nNot a valid option. Try Again");
                }
                
            }

            // have this account menu stay until it is exited out meaning customer left and new one is coming
            while (insideMenu == true) 
            { 
                System.out.println("Welcome " + customers.get(customerNum).getFullName());
                if (hasAccount == true) 
                {
                    System.out.println("\nAccount Menu");
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("1 - Withdraw");
                    System.out.println("2 - Deposit");
                    System.out.println("3 - Create Account");
                    System.out.println("4 - View Account Info");
                    System.out.println("5 - Change Account Info");
                    System.out.println("6 - Exit");
                    // pick a choice and store
                    choice = intHolder.nextInt();
                    //check if customer has multiple accounts 
                    if (customers.get(customerNum).getNumbersOfAcct() > 1) 
                        multiAccounts = true;
                    if (choice == 1) 
                    {
                        System.out.println("\n\nWithdraw");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("Enter the amount you want to withdraw (0 to exit): ");
                        while (!doubleHolder.hasNextDouble()) 
                        {
                            System.out.println("Not a valid option");
                            doubleHolder.next();
                        }
                        amount = doubleHolder.nextDouble();
                        // here is where we will use CustomerNum to let them change info in their account
                        if (customers.get(customerNum).getNumbersOfAcct() > 1) 
                        {
                            do  
                            {
                                System.out.println("Which account would you like to accss 1 or 2");
                                choice = intHolder.nextInt();
                                if (choice == 1) 
                                {
                                    if (customers.get(customerNum).getAccount(0).getBalance()<amount)
                                    {
                                        continue; 
                                    }
                                    customers.get(customerNum).getAccount(0).withdraw(amount);
                                } 
                                else if (choice == 2) 
                                {
                                    if (customers.get(customerNum).getAccount(1).getBalance()<amount)
                                    {
                                        continue; 
                                    }
                                    customers.get(customerNum).getAccount(1).withdraw(amount);
                                } 
                                else 
                                {
                                    System.out.println("Not a valid option");
                                }
                            }while(!(choice == 1 || choice == 2));
                        } 
                        else 
                        {
                            customers.get(customerNum).getAccount(0).withdraw(amount);  
                        }
                        System.out.println("Balance of first account $" + customers.get(customerNum).getAccount(0).getBalance());
                    
                        // if i have time dont forget to add these two functions
                        //have the option of making another transaction/change OR quitting
                        // if quit is picked ask if they wan a reciept 
                    } else if (choice == 2) 
                    {
                        System.out.println("\n\nDeposit");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("Enter the amount you want to deposit ( 0 to exit): ");
                        while (!doubleHolder.hasNextDouble()) 
                        {
                            System.out.println("Not a valid option");
                            doubleHolder.next();
                        }
                        amount = doubleHolder.nextDouble();
                        // here is where we will use CustomerNum to let them change info in their account
                        if (customers.get(customerNum).getNumbersOfAcct() > 1) 
                        {
                            //reset choice to default;
                            choice = 0;
                            while (!(choice == 1 || choice == 2)) 
                            {
                                System.out.println("Which account would you like to accss 1 or 2");
                                choice = intHolder.nextInt();
                                if (choice == 1) 
                                {
                                    customers.get(customerNum).getAccount(0).deposit(amount);
                                }
                                else if (choice == 2) 
                                {
                                    customers.get(customerNum).getAccount(1).deposit(amount);
                                } 
                                else 
                                {
                                    System.out.println("Not a valid option");
                                }
                            }
                        } 
                        else 
                        {
                            customers.get(customerNum).getAccount(0).deposit(amount);
                        }
                    } 
                    else if (choice == 3) 
                    {
                        System.out.println("Create New Account");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("What kind of account do you want to create");
                        System.out.println("1 - Chequing");
                        System.out.println("2 - Credit");
                        System.out.println("3 - Savings");
                        System.out.println("4 - Exit");
                        int newAcctType = intHolder.nextInt();
                        if(newAcctType ==4)
                        {
                            continue;
                        }
                        while(newAcctType < 1 && newAcctType > 4)
                        {
                            System.out.printf("Sorry but %d is not a valid "
                                    + "option. Enter 1, 2, 3, or 4.",newAcctType);
                            newAcctType = intHolder.nextInt();
                        }
                        System.out.println("How much would you like to put in your account?: ");
                        while (!doubleHolder.hasNextDouble()) 
                        {
                            System.out.println("Not a valid option");
                            doubleHolder.next();
                        }
                        balance = doubleHolder.nextDouble();
                        customers.get(customerNum).createAccount(balance);
                    } 
                    else if (choice == 4) 
                    {
                        System.out.println("\nAccount Information");
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("Press enter to Exit");
                        //record choice and displau info
                        System.out.print("\nAccount Holder Name: " + customers.get(customerNum).getFullName());
                        System.out.print("\nAccount Holder # of Transactions: " + customers.get(customerNum).getNumbersOfAcct());
                        System.out.print("\nAccount Holder #: " + customers.get(customerNum).getAccountNum());
                        System.out.print("\nAccount Balance: " + customers.get(customerNum).getAccount(0).getBalance());
                        if(customers.get(customerNum).getNumbersOfAcct() > 1)
                            System.out.print("\nAccount Balance for second account: " + customers.get(customerNum).getAccount(1).getBalance());
                        input = stringHolder.nextLine();
                        continue;
                    } 
                    else if (choice == 5) 
                    {
                        //reset the value of choice so that there wont be any errors with do while 
                        choice = 0;
                        do 
                        {
                            System.out.println("\nWhat Information Would You like to change?");
                            System.out.println("1 - First Name");
                            System.out.println("2 - Last Name");
                            System.out.println("3 - Exit");
                            choice = intHolder.nextInt();
                            if (choice == 1) 
                            {
                                System.out.println("Change First Name");
                                System.out.println("Old First Name: " + customers.get(customerNum).getFirstName());
                                System.out.println("What will be the new First Name? ");
                                customers.get(customerNum).setFirstName(stringHolder.nextLine());
                            } 
                            else if (choice == 2) 
                            {
                                System.out.println("Change Last Name");
                                System.out.println("Old Last Name: " + customers.get(customerNum).getLastName());
                                System.out.println("What will be the new Last Name? ");
                                customers.get(customerNum).setLastName(stringHolder.nextLine());
                            } 
                            else if (choice == 3) 
                            {
                                continue;
                            } 
                            else 
                            {
                                System.out.println("Not a valid option");
                            }
                        } while (choice != 4);
                    } 
                    else if (choice == 6) 
                    {
                        System.out.println("Thank you. Good Bye");
                        insideMenu = false;
                    } 
                    else 
                    {
                        System.out.print("Not a valid option");
                    }
                }
            }
        }
        System.out.print("Good bye and thank you for visiting out JBANK");
    }
}
