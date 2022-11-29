import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReaderHelper {
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
