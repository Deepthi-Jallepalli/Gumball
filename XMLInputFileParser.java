import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class XMLInputFileParser implements InputFileParser{
	private String inputFileName_; 
	private String outputFileName_;
	
	public XMLInputFileParser(String inputFileName,String outputFileName){
		inputFileName_ = inputFileName;
		outputFileName_ = outputFileName;
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
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		try {

			File xmlFile = new File(inputFileName_);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);

			doc.getDocumentElement();
			Date expDate = new Date();

			NodeList nList = doc.getElementsByTagName("row");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					String cardNumber = String.format("%.0f", Double.parseDouble(eElement.getElementsByTagName("CardNumber").item(0).getTextContent()));

					try {
						expDate = formatter.parse(eElement.getElementsByTagName("ExpirationDate").item(0).getTextContent());
						String strExpDate = formatter.format(expDate);
					}
					catch(Exception e) {
						System.out.println("Incorrect Date" + expDate);
					}

					String name = eElement.getElementsByTagName("NameOfCardholder").item(0).getTextContent();

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

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			Element rootElement = doc.createElementNS("", "root");
			doc.appendChild(rootElement);
			for (int i = 0; i < Cards.size(); i++) {
				Element rowElement = doc.createElement("row");
				CreditCard cc = Cards.get(i);


				Element nodeCardNumber = doc.createElement("CardNumber");
				nodeCardNumber.appendChild(doc.createTextNode(cc.getCreditCardNo()));
				rowElement.appendChild(nodeCardNumber);

				Element nodeCardType = doc.createElement("CardType");
				nodeCardType.appendChild(doc.createTextNode(cc.getCardType()));
				rowElement.appendChild(nodeCardType);


				Element Error = doc.createElement("Error");
				if(cc.getIsValid()) {
					Error.appendChild(doc.createTextNode("None"));
					rowElement.appendChild(Error);
				}
				else {
					Error.appendChild(doc.createTextNode("InvalidCardNumber"));
					rowElement.appendChild(Error);
				}

				rootElement.appendChild(rowElement);

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(doc);

			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(new File(outputFileName_));

			transformer.transform(source, console);
			transformer.transform(source, file);


		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
