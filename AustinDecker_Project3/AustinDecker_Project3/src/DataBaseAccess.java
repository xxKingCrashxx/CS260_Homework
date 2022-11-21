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
        database.printTreeDiagram();
        System.out.println(database.toString());

        if(database.isEmpty() || findEntry(game) == null)
            System.out.println("Video game was not found in the database.");
        else{
            database.removeNodeWithData(game);
            System.out.println("Video game was removed from the database");
        }
    }

    public VideoGame findEntry(VideoGame game){
        Node<VideoGame> foundNode = database.findNodeWithData(game);
        return foundNode == null ? null : foundNode.getData();
    }

    public static void loadDataBaseFromFile(DataBaseAccess dataBaseAccess){
        FileInputStream fInputStream;
        ObjectInputStream objectInputStream;

        try {
            fInputStream = new FileInputStream("db_save.txt");
            objectInputStream = new ObjectInputStream(fInputStream);

            dataBaseAccess = (DataBaseAccess)objectInputStream.readObject();

        } catch (FileNotFoundException fnfe) {
            // TODO: handle exception
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void saveDataBaseToFile(DataBaseAccess dataBaseAcess){
        //TODO
        FileOutputStream fOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fOutputStream = new FileOutputStream("db_save.txt");
            objectOutputStream = new ObjectOutputStream(fOutputStream);
            objectOutputStream.writeObject(dataBaseAcess.database);

            objectOutputStream.close();


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
