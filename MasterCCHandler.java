import java.util.Date;

public class MasterCCHandler implements Handler {

	private Handler nextHandler;

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;

	}

	public CreditCard validateCreditCardNumber(String creditCardNo, Date expDate, String name) {
		String creditCardNumber = creditCardNo;

		int len = creditCardNo.length();
		boolean rightMostDigitCheck = Character.isDigit(creditCardNumber.charAt(len - 1));
		if (len <=19 && rightMostDigitCheck) {
			if ((creditCardNumber.charAt(0) == '5') && ((Character.getNumericValue(creditCardNumber.charAt(1)) >= 1) && (Character.getNumericValue(creditCardNumber.charAt(1)) <= 5) && len == 16)) {
				MasterCC master = new MasterCC(creditCardNo, expDate, name, "MasterCard", true);
				return master;
			} else {
				return (nextHandler.validateCreditCardNumber(creditCardNo, expDate, name));
			}
		}
		else {
			return(nextHandler.validateCreditCardNumber(creditCardNo, expDate, name));
		}


	}

}
