import java.util.Date;

public interface Handler {

	public void setNextHandler(Handler nextHandler);

	public CreditCard validateCreditCardNumber(String creditCardNo, Date expDate, String name);

}
