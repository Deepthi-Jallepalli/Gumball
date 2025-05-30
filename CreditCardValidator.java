import java.io.File;
public class CreditCardValidator {

	public static void main(String[] args) {
		if (args.length > 0) {
			String input = args[0];
			String output = args[1];
			File inputFile = new File(input);
			File outputFile = new File(output);

			String inputFileName = inputFile.getName();
			String outputFileName = outputFile.getName();
			Boolean isValid = InputOutputFileValidator.validateFileFormat(inputFileName, outputFileName);
			if (isValid) {
				var fileType = FileTypeIdentifier.IdentifyFile(inputFileName, outputFileName);
				var validatedCreditCardsDetails = fileType.ParseInputFile(inputFileName);
				boolean isSuccess = fileType.WriteOutputFile(validatedCreditCardsDetails, outputFileName);
			}

		}
	}
}
