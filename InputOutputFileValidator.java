public class InputOutputFileValidator{

    public static String getFileExtension(String fileName){

        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
            return fileName.substring(fileName.lastIndexOf(".")+1);
        } 
        else return "";
    }

    public static Boolean validateFileFormat(String inputFileName,String outputFileName){
        String inputFileExtension = getFileExtension(inputFileName);
        String outputFileExtension = getFileExtension(outputFileName);

        if (inputFileExtension != null){
            if(outputFileExtension != null) if (inputFileExtension.equals(outputFileExtension)) {
                return true;
            } else {
                return false;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
        
    }
}