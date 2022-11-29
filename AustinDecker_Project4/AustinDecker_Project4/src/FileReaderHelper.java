import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Helper class for reading lines of data from a specified text file
 * @author Austin Decker
 * @version 1.0
 * 
 */
public class FileReaderHelper {
    /**
     * method which reads a specified file and saves each line into an arraylist for later access.
     * Method returns true if the reading was successful and false if file was not found or reading was unsuccessful.
     * @throws NullPointerException
     * @param filepath String
     * @param lines ArrayList<String>
     * @return boolean
     */
    public static boolean readFile(String filepath, ArrayList<String> lines){

        if(lines == null)
            throw new NullPointerException("provided arraylist should not be null");

        try {
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }
            
            scanner.close();
            return true;
        } 
        catch (FileNotFoundException e) {
            System.out.println("file does not exist");
        }
        catch (NullPointerException e){
            System.out.println("file directory cannot be null");
        }
        return false;

    }
    
}
