import java.util.Date;

public class DiscoverCCHandler implements Handler {

	private Handler nextHandler;

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;

	}

	public CreditCard validateCreditCardNumber(String creditCardNo, Date expDate, String name) {
		String creditCardNumber = creditCardNo;
		int len = creditCardNo.length();
		boolean rightMostDigitCheck = Character.isDigit(creditCardNumber.charAt(len - 1));

		if (len <=19 && rightMostDigitCheck) {
			if ((creditCardNumber.substring(0, 4).equals("6011")) && len == 16) {
				DiscoverCC discover = new DiscoverCC(creditCardNo, expDate, name, "Discover", true);
				return discover;
			} else {
				CreditCard cc = new CreditCard(creditCardNo, expDate, name, "Invalid", false);
				return cc;
			}
		}
		else {
			CreditCard cc = new CreditCard(creditCardNo, expDate, name, "Invalid", false);
			return cc;
		}

	}

}
