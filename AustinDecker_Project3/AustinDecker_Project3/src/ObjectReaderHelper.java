import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectReaderHelper {
    private static File file;
    private static FileInputStream fInputStream;
    private static ObjectInputStream objectInputStream;

    public static <T> boolean readObject(String fileName, ArrayList<T> obj){

        try {
            file = new File(fileName);
            fInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fInputStream);
            obj.set(0, (T)objectInputStream.readObject());

            objectInputStream.close();
            fInputStream.close();
            return true;

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }
}
