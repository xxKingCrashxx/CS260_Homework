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
        switch (item.getPriority()) {
            case 0:
                data[0].addToBack(item);
                break;
            case 1:
                data[1].addToBack(item);
                break;
            case 2:
                data[2].addToBack(item);
                break;
            case 3:
                data[3].addToBack(item);
                break;
            case 4:
                data[4].addToBack(item);
                break;
            case 5:
                data[5].addToBack(item);
                break;
            case 6:
                data[6].addToBack(item);
                break;
            case 7:
                data[7].addToBack(item);
                break;
            case 8:
                data[8].addToBack(item);
                break;
            case 9:
                data[9].addToBack(item);
                break;
            case 10:
                data[10].addToBack(item);
                break;
            case 11:
                data[11].addToBack(item);
                break;
            case 12:
                data[12].addToBack(item);
                break;
            case 13:
                data[13].addToBack(item);
                break;
            case 14:
                data[14].addToBack(item);
                break;
            case 15:
                data[15].addToBack(item);
                break;
            default:
                break;
        }
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
