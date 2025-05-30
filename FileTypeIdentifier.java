public class FileTypeIdentifier
{
    public static FileProcessor IdentifyFile(String inputFileName, String outputFileName){
		InputFileProcessor inputFileProcessor = null;

		if(inputFileName.contains(".csv")) {
			inputFileProcessor = new InputFileProcessor(new CSVInputFileParser(inputFileName, outputFileName));
		}
			
		else if(inputFileName.contains(".xml")) {
			inputFileProcessor = new InputFileProcessor(new XMLInputFileParser(inputFileName, outputFileName));
		}

		else if(inputFileName.contains(".json")) {
			inputFileProcessor = new InputFileProcessor(new JSONInputFileParser(inputFileName, outputFileName));
		}

		else{
			System.exit(0);
		}

		return inputFileProcessor;
    }
}
