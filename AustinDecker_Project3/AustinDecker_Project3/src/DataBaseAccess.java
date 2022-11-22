
import java.util.ArrayList;

import structures.AVLTree;
import structures.Node;
import utils.ObjectReaderHelper;
import utils.ObjectWriterHelper;

/**
 * Class used to access the AVLTree<VideoGame> database.
 * @author Austin Decker
 * @version 1.0
 */
public class DataBaseAccess {
    AVLTree<VideoGame> database = new AVLTree<>();

    
    /** 
     * Adds the VideoGame object to the database.
     * @param game
     */
    public void addEntry(VideoGame game){
        System.out.printf("\n");
        if(game == null)
            throw new NullPointerException("Cannot add a null value to the database.");

        database.addNode(new Node<VideoGame>(game, null, null));
        database.printTreeDiagram();
        System.out.println(database.toString());
        System.out.printf("\n");
    }
    
    /**
     * Removes the video game from the database if the game to be removed is in the database. 
     * @param game
     */
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
    
    /**
     * Does a binary search of the VideoGame object and returns the object if found and returns null if the object was not found in the database. 
     * @param game
     * @return VideoGame
     */
    public VideoGame findEntry(VideoGame game){
        Node<VideoGame> foundNode = database.findNodeWithData(game);
        return foundNode == null ? null : foundNode.getData();
    }
    
    /**
     * loads in the database from a file if there is a file to read. 
     * @param dataBaseAccess
     */
    public static void loadDataBaseFromFile(DataBaseAccess dataBaseAccess){

        ArrayList<AVLTree<VideoGame>> avlTreeWrapper = new ArrayList<>();
        avlTreeWrapper.add(dataBaseAccess.database);
        
        boolean result = ObjectReaderHelper.readObject("src\\db_save.txt", avlTreeWrapper);

        if(result){
            dataBaseAccess.database = avlTreeWrapper.get(0);
            System.out.println("\n\ndatabase was loaded successfully.");
        } else{
            System.out.println("\n\ndatabase was not loaded successfully.  File not found or data is invalid.");
        }
    }

    /**
     * Saves the contents of the database to a file. 
     * @param dataBaseAccess
     */
    public static void saveDataBaseToFile(DataBaseAccess dataBaseAccess){
        boolean result = ObjectWriterHelper.writeObject("src\\db_save.txt", dataBaseAccess.database);
        if(result){
            System.out.println("\n\nDatabase was written to the file successfully.");
        } else{
            System.out.println("\n\nDatabase could not be written to a file.");
        }
    }
}
