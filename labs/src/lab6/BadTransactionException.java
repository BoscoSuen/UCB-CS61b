package lab6;
/**
 *  Implements an exception that should be thrown for invalid amount.
 **/
public class BadTransactionException extends Exception {
	public int amount;
	
	public BadTransactionException(int BadAmount) {
	  super("Invalid Amount: " + BadAmount);
	  
	  amount = BadAmount;
	}
}
