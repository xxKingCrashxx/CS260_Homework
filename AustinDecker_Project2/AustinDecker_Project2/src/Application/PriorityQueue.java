package Application;

public class PriorityQueue{
    private int manyItems;
    private LinkedList[] data = new LinkedList[15];

    public PriorityQueue(){
        manyItems = 0;
        
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList();
        }
    }
    public void add(Process item, int priority){

    }
    public void remove(){

    }
    
    
}
