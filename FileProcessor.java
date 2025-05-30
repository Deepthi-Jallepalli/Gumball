import java.util.ArrayList;
public interface FileProcessor
{ 
    public ArrayList<CreditCard> ParseInputFile(String inputFileName);
    public boolean WriteOutputFile(ArrayList<CreditCard> Cards, String outputFileName);
}