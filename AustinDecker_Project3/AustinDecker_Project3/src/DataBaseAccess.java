import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import structures.AVLTree;
import structures.Node;

public class DataBaseAccess {
    AVLTree<VideoGame> database = new AVLTree<>();

    public void addEntry(VideoGame game){
        if(game == null)
            throw new NullPointerException("Cannot add a null value to the database.");

        database.addNode(new Node<VideoGame>(game, null, null));
        database.printTreeDiagram();
        System.out.println(database.toString());
    }

    public void removeEntry(VideoGame game){
        System.out.printf("\n");
        if(database.isEmpty() || findEntry(game) == null)
            System.out.println("Video game was not found in the database.");
        else{
            database.removeNodeWithData(game);
            System.out.println("Video game was removed from the database");
        }
        database.printTreeDiagram();
        System.out.println(database.toString());
        System.out.printf("\n");
    }

    public VideoGame findEntry(VideoGame game){
        Node<VideoGame> foundNode = database.findNodeWithData(game);
        return foundNode == null ? null : foundNode.getData();
    }

    public static void loadDataBaseFromFile(DataBaseAccess dataBaseAccess){
        FileInputStream fInputStream;
        ObjectInputStream objectInputStream;
        File file = new File("src\\db_save.txt");

        System.out.printf("\n");
        if(dataBaseAccess == null){
            System.out.println("DataBaseAcess object is null.");
            return;
        }

        try {

            if(file.exists()){
                fInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fInputStream);

                dataBaseAccess.database = (AVLTree<VideoGame>)objectInputStream.readObject();
                objectInputStream.close();
                fInputStream.close();

                System.out.println("database loaded successfully.");
            }else{
                System.out.println("No database has been previously saved.");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.printf("\n");
    }

    public static void saveDataBaseToFile(DataBaseAccess dataBaseAcess){
        FileOutputStream fOutputStream;
        ObjectOutputStream objectOutputStream;
        File file = new File("src//db_save.txt");

        System.out.printf("\n");
        try {

            if(!file.exists())
                file.createNewFile();

            fOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fOutputStream);
            objectOutputStream.writeObject(dataBaseAcess.database);

            objectOutputStream.close();
            fOutputStream.close();

            System.out.println("database saved successfully.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("\n");
    }
}
