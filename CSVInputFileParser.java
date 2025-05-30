import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class CSVInputFileParser implements InputFileParser
{    
	private String inputFileName_; 
	private String outputFileName_;

    public CSVInputFileParser(String inputFileName,String outputFileName){
		inputFileName_ = inputFileName;
		outputFileName_ = outputFileName;
    }
    public ArrayList<CreditCard> ParseInputFile(String inputFileName_)
    {
		VisaCCHandler handler1 = new VisaCCHandler();
		MasterCCHandler handler2 = new MasterCCHandler();
		AmExCCHandler handler3 = new AmExCCHandler();
		DiscoverCCHandler handler4 = new DiscoverCCHandler();

		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		handler3.setNextHandler(handler4);

		ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>();
		BufferedReader br = null;
		String line = "";
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date expDate = new Date();
		String strExpDate = "";

		try {
			br = new BufferedReader(new FileReader(inputFileName_));
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				String cardNumber = String.format("%.0f", Double.parseDouble(row[0]));
				try {
					expDate = formatter.parse(row[1]);
					strExpDate = formatter.format(expDate);
				}
				catch(Exception e) {
				}
				String name = row[2];

                creditCards.add(handler1.validateCreditCardNumber(cardNumber, expDate, name));
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return creditCards;

    }
    public boolean WriteOutputFile(ArrayList<CreditCard> Cards, String outputFileName_) {

		try (PrintWriter writer = new PrintWriter(new File(outputFileName_))) {

		      StringBuilder sb = new StringBuilder();
		      sb.append("CardNumber");
		      sb.append(',');
		      sb.append("CardType");
		      sb.append(",");
		      sb.append("Error");
		      sb.append('\n');

		      for (int i = 0; i < Cards.size(); i++) {
					CreditCard cc = Cards.get(i);
					sb.append(cc.getCreditCardNo());
					sb.append(',');
					sb.append(cc.getCardType());
					sb.append(',');
					if(cc.getIsValid()) {
						sb.append("None");
					}
					else {
						sb.append("InvalidCardNumber");
					}
					sb.append('\n');
		      }

		      writer.write(sb.toString());

		    }
			catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
		    }

		return true;
	} 
}




