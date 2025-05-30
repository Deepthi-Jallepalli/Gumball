import java.util.Date;

public class AmExCCHandler implements Handler {

	private Handler nextHandler;

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;

	}

	public CreditCard validateCreditCardNumber(String creditCardNo, Date expDate, String name) {
		String creditCardNumber = creditCardNo;
		int len = creditCardNo.length();
		boolean rightMostDigitCheck = Character.isDigit(creditCardNumber.charAt(len - 1));

		if (len <=19 && rightMostDigitCheck) {
			if ((creditCardNumber.charAt(0) == '3') && ((creditCardNumber.charAt(1) == '4') || (creditCardNumber.charAt(1) == '7') && len == 15)) {
				AmExCC amex = new AmExCC(creditCardNo, expDate, name, "AmericanExpress", true);
				return amex;
			} else {
				return (nextHandler.validateCreditCardNumber(creditCardNo, expDate, name));
			}
		}
		else {
			return(nextHandler.validateCreditCardNumber(creditCardNo, expDate, name));
		}
	}

}
