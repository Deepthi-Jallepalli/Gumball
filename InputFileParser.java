import java.util.ArrayList;
public interface InputFileParser
{
    ArrayList<CreditCard> ParseInputFile(String inputFileName);
    boolean WriteOutputFile(ArrayList<CreditCard> Cards, String outputFileName);
}
