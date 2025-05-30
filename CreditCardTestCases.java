import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class CreditCardTestCases {

	@Test
	public void test0(){
		String inputFileName="Input.csv";
		String outputFileName="Output.csv";

		boolean isValid = InputOutputFileValidator.validateFileFormat(inputFileName,outputFileName);
		assertTrue(isValid);

	}
	@Test
	public void test1(){
		String inputFileName="Input.json";
		String outputFileName="Output.json";

		boolean isValid = InputOutputFileValidator.validateFileFormat(inputFileName,outputFileName);
		assertTrue(isValid);

	}
	@Test
	public void test2(){
		String inputFileName="Input.xml";
		String outputFileName="Output.xml";

		boolean isValid = InputOutputFileValidator.validateFileFormat(inputFileName,outputFileName);
		assertTrue(isValid);

	}

	@Test
	public void test3(){
		String inputFileName="Input.csv";
		String outputFileName="Output.csv";

		InputFileProcessor csv = new InputFileProcessor(new CSVInputFileParser(inputFileName, outputFileName));
		FileProcessor file = FileTypeIdentifier.IdentifyFile(inputFileName, outputFileName);
		assertEquals(file.getClass(), csv.getClass());

	}
	@Test
	public void test4(){
		String inputFileName="Input.json";
		String outputFileName="Output.json";

		InputFileProcessor json = new InputFileProcessor(new JSONInputFileParser(inputFileName, outputFileName));
		FileProcessor file = FileTypeIdentifier.IdentifyFile(inputFileName, outputFileName);
		assertEquals(file.getClass(), json.getClass());

	}
	@Test
	public void test5(){
		String inputFileName="Input.xml";
		String outputFileName="Output.xml";

		InputFileProcessor xml = new InputFileProcessor(new XMLInputFileParser(inputFileName, outputFileName));
		FileProcessor file = FileTypeIdentifier.IdentifyFile(inputFileName, outputFileName);
		assertEquals(file.getClass(), xml.getClass());

	}

	@Test
	public void test6() {
		String cardNumber = "5410000000000000";
		String name = "Alice";
		Date expDate = new Date();

		VisaCCHandler handler1 = new VisaCCHandler();
		MasterCCHandler handler2 = new MasterCCHandler();
		AmExCCHandler handler3 = new AmExCCHandler();
		DiscoverCCHandler handler4 = new DiscoverCCHandler();

		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		handler3.setNextHandler(handler4);

		CreditCard cc = handler1.validateCreditCardNumber(cardNumber, expDate, name);
		assertTrue(cc.getIsValid());

	}

	@Test
	public void test7() {
		String cardNumber = "341000000000000";
		String name = "Bob";
		Date expDate = new Date();

		VisaCCHandler handler1 = new VisaCCHandler();
		MasterCCHandler handler2 = new MasterCCHandler();
		AmExCCHandler handler3 = new AmExCCHandler();
		DiscoverCCHandler handler4 = new DiscoverCCHandler();

		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		handler3.setNextHandler(handler4);

		CreditCard cc = handler1.validateCreditCardNumber(cardNumber, expDate, name);
		assertTrue(cc.getIsValid());

	}

	@Test
	public void test8() {
		String cardNumber = "4120000000000";
		String name = "Richard";
		Date expDate = new Date();

		VisaCCHandler handler1 = new VisaCCHandler();
		MasterCCHandler handler2 = new MasterCCHandler();
		AmExCCHandler handler3 = new AmExCCHandler();
		DiscoverCCHandler handler4 = new DiscoverCCHandler();

		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		handler3.setNextHandler(handler4);

		CreditCard cc = handler1.validateCreditCardNumber(cardNumber, expDate, name);
		assertTrue(cc.getIsValid());

	}

	@Test
	public void test9() {
		String cardNumber = "6011000000000000";
		String name = "Eve";
		Date expDate = new Date();

		VisaCCHandler handler1 = new VisaCCHandler();
		MasterCCHandler handler2 = new MasterCCHandler();
		AmExCCHandler handler3 = new AmExCCHandler();
		DiscoverCCHandler handler4 = new DiscoverCCHandler();

		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		handler3.setNextHandler(handler4);

		CreditCard cc = handler1.validateCreditCardNumber(cardNumber, expDate, name);
		assertTrue(cc.getIsValid());

	}

	@Test
	public void test10() {
		String cardNumber = "9620052000000";
		String name = "Nirav";
		Date expDate = new Date();

		VisaCCHandler handler1 = new VisaCCHandler();
		MasterCCHandler handler2 = new MasterCCHandler();
		AmExCCHandler handler3 = new AmExCCHandler();
		DiscoverCCHandler handler4 = new DiscoverCCHandler();

		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		handler3.setNextHandler(handler4);

		CreditCard cc = handler1.validateCreditCardNumber(cardNumber, expDate, name);
		assertFalse(cc.getIsValid());

	}

	@Test
	public void test11() {
		String cardNumber = "9590000000000";
		String name = "Sam";
		Date expDate = new Date();

		VisaCCHandler handler1 = new VisaCCHandler();
		MasterCCHandler handler2 = new MasterCCHandler();
		AmExCCHandler handler3 = new AmExCCHandler();
		DiscoverCCHandler handler4 = new DiscoverCCHandler();

		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		handler3.setNextHandler(handler4);

		CreditCard cc = handler1.validateCreditCardNumber(cardNumber, expDate, name);
		assertFalse(cc.getIsValid());

	}

	@Test
	public void test12() {
		String cardNumber = "6780000000000";
		String name = "John";
		Date expDate = new Date();

		VisaCCHandler handler1 = new VisaCCHandler();
		MasterCCHandler handler2 = new MasterCCHandler();
		AmExCCHandler handler3 = new AmExCCHandler();
		DiscoverCCHandler handler4 = new DiscoverCCHandler();

		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		handler3.setNextHandler(handler4);

		CreditCard cc = handler1.validateCreditCardNumber(cardNumber, expDate, name);
		assertFalse(cc.getIsValid());

	}

	@Test
	public void test13() {
		String cardNumber = "9620000000000";
		String name = "Bretty";
		Date expDate = new Date();

		VisaCCHandler handler1 = new VisaCCHandler();
		MasterCCHandler handler2 = new MasterCCHandler();
		AmExCCHandler handler3 = new AmExCCHandler();
		DiscoverCCHandler handler4 = new DiscoverCCHandler();

		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		handler3.setNextHandler(handler4);

		CreditCard cc = handler1.validateCreditCardNumber(cardNumber, expDate, name);
		assertFalse(cc.getIsValid());

	}

	@Test
	public void test14() {
		String cardNumber = "5410000000000000";
		String name = "Kile";
		Date expDate = new Date();

		MasterCCHandler handler = new MasterCCHandler();
		MasterCC master= new MasterCC(cardNumber, expDate, name, "MasterCard", true);

		CreditCard cc = handler.validateCreditCardNumber(cardNumber, expDate, name);
		assertEquals(cc.getClass(), master.getClass());

	}

	@Test
	public void test15() {
		String cardNumber = "341000000000000";
		String name = "Eve";
		Date expDate = new Date();

		AmExCCHandler handler = new AmExCCHandler();
		AmExCC amex = new AmExCC(cardNumber, expDate, name, "AmericanExpress", true);

		CreditCard cc = handler.validateCreditCardNumber(cardNumber, expDate, name);
		assertEquals(cc.getClass(), amex.getClass());

	}

	@Test
	public void test16() {
		String cardNumber = "6011000000000000";
		String name = "Jackson";
		Date expDate = new Date();

		DiscoverCCHandler handler = new DiscoverCCHandler();
		DiscoverCC discover = new DiscoverCC(cardNumber, expDate, name, "Discover", true);

		CreditCard cc = handler.validateCreditCardNumber(cardNumber, expDate, name);
		System.out.println(cc.getIsValid());

		assertEquals(cc.getClass(), discover.getClass());

	}

	@Test
	public void test17() {
		String cardNumber = "4120000000000";
		String name = "Richard";
		Date expDate = new Date();

		VisaCCHandler handler = new VisaCCHandler();
		VisaCC visa = new VisaCC(cardNumber, expDate, name, "Visa", true);

		CreditCard cc = handler.validateCreditCardNumber(cardNumber, expDate, name);
		assertEquals(cc.getClass(), visa.getClass());

	}

}
