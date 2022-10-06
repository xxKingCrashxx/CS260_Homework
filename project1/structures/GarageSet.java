package structures;

import javax.lang.model.util.ElementScanner14;

public class GarageSet
{
    private CarDataNode head;
    private CarDataNode tail;
    private int totalItems;

    private GarageExitBag exitBag;

    public GarageSet()
    {
        head = null;
        tail = null;
        exitBag = new GarageExitBag();
        totalItems = 0;
    }

    public void checkIn(int index, String liscenceID)
    {
        CarDataNode newNode = new CarDataNode(liscenceID, null, null);;
        newNode.checkIn();

        if(this.head == null)
        {
            head = newNode;
            tail = newNode;
            totalItems++;
            return;
        }
        
        CarDataNode searchNode = CarDataNode.getNodeFromIndex(head, index);   
        if(!searchNode.equals(tail) && !hasDuplicate(newNode))
        {
                searchNode.addNodeAfter(newNode);
                totalItems++;
        }
        else if(searchNode.equals(tail) && !hasDuplicate(newNode))
        {
            searchNode.addNodeAfter(newNode);
            tail = tail.getNext();
            totalItems++;
        }  
    }
    public void checkIn(String liscenceID)
    {
        CarDataNode newNode = new CarDataNode(liscenceID, null, null);
        newNode.checkIn();

        if(this.head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            CarDataNode searchNode = head;

            if(!hasDuplicate(newNode))
            {
                while(searchNode.getNext() != null){
                    searchNode = searchNode.getNext();
                }
                searchNode.addNodeAfter(newNode);
                tail = newNode;
            }

        }
        totalItems++;

    }

    public void checkOut(int index)
    {
        CarDataNode removeNode = CarDataNode.getNodeFromIndex(head, index);
        removeNode.checkOut();
        
        if(removeNode.equals(head))
            head = head.getNext();
        else if(removeNode.equals(tail))
            tail = tail.getPrev();
        else
            removeNode.removeNode();
        
        exitBag.add(removeNode);
        removeNode = null;

    }

    public void checkOut(String liscenceID)
    {
        CarDataNode removeNode = CarDataNode.getNodeFromID(head, liscenceID);
        removeNode.checkOut();

        if(removeNode.equals(head))
            head = head.getNext();
        else if(removeNode.equals(tail))
            tail = tail.getPrev();
        else
            removeNode.removeNode();
        
        exitBag.add(removeNode);
        removeNode = null;

    }

    public GarageExitBag getExitBag()
    {
        return this.exitBag;
    }

    private boolean hasDuplicate(CarDataNode node)
    {
        CarDataNode cursor = head;

        for (; cursor != null; cursor = cursor.getNext()) 
        {
            if(cursor.getCarID().equals(node.getCarID())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        CarDataNode cursor = head;

        while(cursor != null){
            builder.append(cursor.toString() + "\n");
            cursor = cursor.getNext();
        }
        return builder.toString();
    }

    public static void loadGSData()
    {

    }

    public static void saveGSData()
    {
        
    }

}