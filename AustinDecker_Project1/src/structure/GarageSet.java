package structure;

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
        if(!searchNode.equals(tail) && !hasDuplicate(newNode.getCarID()))
        {
                searchNode.addNodeAfter(newNode);
                totalItems++;
        }
        else if(searchNode.equals(tail) && !hasDuplicate(newNode.getCarID()))
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
            totalItems++;
        }
        else
        {
            CarDataNode searchNode = head;

            if(!hasDuplicate(newNode.getCarID()))
            {
                while(searchNode.getNext() != null)
                {
                    searchNode = searchNode.getNext();
                }

                searchNode.addNodeAfter(newNode);
                tail = newNode;
                totalItems++;
            }
        }
    }

    public void checkOut(int index)
    {
        if(totalItems == 0)
            return;
        
        CarDataNode delNode = CarDataNode.getNodeFromIndex(head, index);
        if(delNode == null)
            return;
            
        delNode.checkOut();
        if(delNode.equals(head))
            head = head.getNext();
            
        if (delNode.equals(tail)){
            tail = tail.getPrev();
        }
        exitBag.add(delNode);
        delNode.removeNode();
        totalItems--;

    }

    public void checkOut(String liscenceID)
    {
        if(totalItems == 0)
            return;
        
        CarDataNode delNode = CarDataNode.getNodeFromID(head, liscenceID);
        if(delNode == null)
            return;
            
        delNode.checkOut();
        if(delNode.equals(head))
            head = head.getNext();
            
        if (delNode.equals(tail))
            tail = tail.getPrev();
            
        exitBag.add(delNode);
        delNode.removeNode();
        totalItems--;

    }

    public GarageExitBag getExitBag()
    {
        return this.exitBag;
    }

    public CarDataNode getHead()
    {
        return this.head;
    }
    
    public CarDataNode getTail()
    {
        return this.tail;
    }
    
    public int getTotalItems()
    {
        return this.totalItems;
    }

    public boolean hasDuplicate(String id)
    {
        CarDataNode cursor = head;

        for (; cursor != null; cursor = cursor.getNext()) 
        {
            if(cursor.getCarID().equals(id)){
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