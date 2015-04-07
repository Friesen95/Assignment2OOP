package banking;

/**
 *
 * @author fries_000
 */
public class AccountSupport {
    
    private static int accountNum = 10000;
    
    public static int getAccountNum(){
        return accountNum++;
    }
}
