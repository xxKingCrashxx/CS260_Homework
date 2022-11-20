import structures.AVLTree;
import structures.Node;

public class DataBaseAccess {
    AVLTree<VideoGame> database = new AVLTree<>();

    public void addEntry(VideoGame game){
        //TODO
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
        //TODO
        Node<VideoGame> foundNode = database.findNodeWithData(game);
        return foundNode == null ? null : foundNode.getData();
    }

    public static void loadDataBaseFromFile(){
        //TODO
    }

    public static void saveDataBaseToFile(){
        //TODO
    }
}
