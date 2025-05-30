import java.util.ArrayList;
public class InputFileProcessor implements FileProcessor
{
    private InputFileParser inputFileParserType;

     public InputFileProcessor(InputFileParser fileParser)
     {
         inputFileParserType = fileParser;
     }

     public ArrayList<CreditCard> ParseInputFile(String inputFileName)
     {
         return inputFileParserType.ParseInputFile(inputFileName);
     }
     public boolean WriteOutputFile(ArrayList<CreditCard> Cards, String outputFileName){
         return inputFileParserType.WriteOutputFile(Cards,outputFileName);
     }
}