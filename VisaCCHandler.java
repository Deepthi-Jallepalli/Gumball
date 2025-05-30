import java.util.Date;

public class VisaCCHandler implements Handler {

	private Handler nextHandler;

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	public CreditCard validateCreditCardNumber(String creditCardNo, Date expDate, String name) {
		String creditCardNumber = creditCardNo;
		int len = creditCardNo.length();
		boolean rightMostDigitCheck = Character.isDigit(creditCardNumber.charAt(len - 1));
		if (len <=19 && rightMostDigitCheck) {
			if ((creditCardNumber.charAt(0) == '4') && ((len == 16) || len == 13)) {
				VisaCC visa = new VisaCC(creditCardNo, expDate, name, "Visa", true);
				return visa;
			}
			else{
				return(nextHandler.validateCreditCardNumber(creditCardNo, expDate, name));
			}
		}
		else {
			return(nextHandler.validateCreditCardNumber(creditCardNo, expDate, name));
		}

	}

}
