package Application;

import java.util.NoSuchElementException;

public class PriorityQueue{
    final int MAX_PRIORITY = 14;
    int manyItems;
    private LinkedList[] data = new LinkedList[MAX_PRIORITY + 1];

    public PriorityQueue(){       
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList();
        }
    }
    public void add(Process item){
        int priorityIndex = item.getPriority();
        if(priorityIndex > MAX_PRIORITY)
            throw new ArrayIndexOutOfBoundsException("Priority level not supported");
        data[priorityIndex].addToBack(item);
        System.out.printf("%s inserts into queue%n", item.getProcessID());
        manyItems++;
    }
    public void remove() throws NoSuchElementException{
        int priorityIndex = 0;
        boolean removed = false;

        if(manyItems == 0){
            throw new NoSuchElementException("Queue Underflow");
        }
        while(priorityIndex < data.length){
            if(data[priorityIndex].getHead() == null)
                priorityIndex++;
            else{   
                removed = true;
                data[priorityIndex].removeFromFront();
                break;
            }
        }

        if(removed)
            manyItems--;
    }
    public Process getNextProcess(){
        int priorityIndex = 0;
        
        while(priorityIndex < data.length){
            if(data[priorityIndex].getHead() == null)
                priorityIndex++;
            else{
                return data[priorityIndex].getHead().getValue();
            }
        }
        return null;
    }
    
}
