import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/***
 * Helper class used for writing serializable objects to a file.
 */
public class ObjectWriterHelper {
    
    private static File file;
    private static FileOutputStream fOutputStream;
    private static ObjectOutputStream objectOutputStream;

    public static <T> boolean writeObject(String fileName, T object){

        try{
            file = new File(fileName);
            createNewFile(file);

            fOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fOutputStream);

            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fOutputStream.close();
            return true;
        }
        catch(NullPointerException e){
            e.printStackTrace();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    private static void createNewFile(File filepath){
        if(!filepath.exists()){
            try {
                filepath.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
