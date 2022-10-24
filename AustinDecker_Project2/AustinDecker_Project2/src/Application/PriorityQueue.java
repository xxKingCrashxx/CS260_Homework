package Application;

import java.util.NoSuchElementException;

public class PriorityQueue{
    private int manyItems;
    final int MAX_PRIORITY = 15;
    private LinkedList[] data = new LinkedList[MAX_PRIORITY];

    public PriorityQueue(){
        manyItems = 0;
        
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList();
        }
    }
    public void add(Process item){
        int priorityIndex = item.getPriority();
        if(priorityIndex > MAX_PRIORITY)
            throw new ArrayIndexOutOfBoundsException("Priority level not supported");
        data[priorityIndex].addToBack(item);
        manyItems++;
    }
    public void remove() throws NoSuchElementException{
        int priorityIndex = 0;
        while(priorityIndex < data.length){
            if(data[priorityIndex] == null)
                priorityIndex++;
            else{
                data[priorityIndex].removeFromFront();
                break;
            }
        }

        if(priorityIndex == MAX_PRIORITY)
            throw new NoSuchElementException("Queue underflow");

    }
    
    
}
