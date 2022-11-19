import structures.AVLTree;
import structures.Node;

public class DataBaseAccess {
    AVLTree<VideoGame> database = new AVLTree<>();

    public void addEntry(VideoGame game){
        //TODO
        database.addNode(new Node<VideoGame>(game, null, null));
        //System.out.println(database.toString());
    }

    public void removeEntry(VideoGame game){
        //TODO
    }

    public VideoGame findEntry(VideoGame game){
        //TODO
        Node<VideoGame> foundNode = database.findNodeWithData(game);

        if(foundNode == null){
            return null;
        }
        else{
            return foundNode.getData();
        }
        

    }

    public static void loadDataBaseFromFile(){
        //TODO
    }

    public static void saveDataBaseToFile(){
        //TODO
    }
}
