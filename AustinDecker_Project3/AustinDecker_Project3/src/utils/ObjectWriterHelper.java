package utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Helper class for writing serializable objects to a file.
 * @author Austin Decker
 * @version 1.0
 */
public class ObjectWriterHelper {
    
    private static File file;
    private static FileOutputStream fOutputStream;
    private static ObjectOutputStream objectOutputStream;

    /**
     * 
     * @param <T> T Object
     * @param fileName
     * @param <T> object
     * @return boolean
     */
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
