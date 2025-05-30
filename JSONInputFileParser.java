import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class JSONInputFileParser implements InputFileParser {
	private String inputFileName_; 
	private String outputFileName_;

	public JSONInputFileParser(String inputFileName,String outputFileName){
		inputFileName_ = inputFileName;
		outputFileName_ = outputFileName;
    }

	public static String formatJsonContent(String line) {
			String[] row = line.split(":");
			row[1] = row[1].replace("\"", "");
			row[1] = row[1].replace(",", "");
			row[1] = row[1].replace(" ", "");
			return row[1];
		}

	public ArrayList<CreditCard> ParseInputFile(String inputFileName_) {
		VisaCCHandler handler1 = new VisaCCHandler();
		MasterCCHandler handler2 = new MasterCCHandler();
		AmExCCHandler handler3 = new AmExCCHandler();
		DiscoverCCHandler handler4 = new DiscoverCCHandler();

		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		handler3.setNextHandler(handler4);

    ArrayList<CreditCard> Cards = new ArrayList<CreditCard>();
		BufferedReader br = null;
		String line = "";
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		try {
			br = new BufferedReader(new FileReader(inputFileName_));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String cardNumber = "";
				Date expDate = new Date();
				String name = "";
				String strExpDate = "";

				if (line.contains("CardNumber")) {
					String cleanedString = formatJsonContent(line);
					cardNumber = String.format("%.0f", Double.parseDouble(cleanedString));
					line = br.readLine();
				}
				if (line.contains("ExpirationDate")) {
					try {
						String cleanedString = formatJsonContent(line);
						expDate = formatter.parse(cleanedString);
						strExpDate = formatter.format(expDate);
						line = br.readLine();
					}
					catch(Exception e) {
						System.out.println("Incorrect Date" + expDate);
						line = br.readLine();
					}

				}
				if (line.contains("NameOfCardholder")) {
					String cleanedString = formatJsonContent(line);
					name = cleanedString;
				}

				if(cardNumber != "" && name != "") {
					Cards.add(handler1.validateCreditCardNumber(cardNumber, expDate, name));
				}


			}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return Cards;
  }

  public boolean WriteOutputFile(ArrayList<CreditCard> Cards, String outputFileName_) {
  		try {
  			FileWriter myWriter = new FileWriter(outputFileName_);
  			myWriter.write("[");
  			myWriter.write('\n');
  			for (int i = 0; i < Cards.size(); i++) {
  				CreditCard cc = Cards.get(i);
  				myWriter.write("{");
  				myWriter.write('\n');
  				myWriter.write("\"CardNumber\": "+ cc.getCreditCardNo() + ",");
  				myWriter.write('\n');
  				myWriter.write("\"CardType\": " + "\"" + cc.getCardType() + "\"" + " ,");
  				myWriter.write('\n');

  				if(cc.getIsValid()) {
  					myWriter.write("\"Error\": \"None\"");
  					myWriter.write('\n');
  				}
  				else {
  					myWriter.write("\"Error\": \"InvalidCardNumber\"");
  					myWriter.write('\n');
  				}
  				if(i == Cards.size() - 1) {
  					myWriter.write("}");
  				}
  				else {
  					myWriter.write("},");
  				}
  				myWriter.write('\n');
  			}
  			myWriter.write("]");
  			myWriter.close();
  		}
  		catch (IOException e) {
  			e.printStackTrace();
  		}


  		return true;
  	}

}
