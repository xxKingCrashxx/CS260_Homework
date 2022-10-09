package structure;
/**
 * GarageSet class which stores and manipulates a CarDataNode linkedlist structure.
 */
public class GarageSet
{
    private CarDataNode head;
    private CarDataNode tail;
    private int totalItems;

    private GarageExitBag exitBag;

    /**
     * Constructor for the GarageSet
     */
    public GarageSet()
    {
        head = null;
        tail = null;
        exitBag = new GarageExitBag();
        totalItems = 0;
    }

    /**
     * method that adds the CarDataNode object into the LinkedListSet in the position after the specified index.  It checks-in the CarDataNode Object and puts it into the linked list only if the object's liscenseID is different from all the other nodes in the linkedlist.
     * @param index
     * @param liscenceID
     */
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
    /**
     * Method that adds and checks in a CarDataNode object with the specified liscenseID.  It only adds the node into the linkedList if there is no other node with the same liscense id.  The node is added at the end of the linkedlist.
     * @param liscenceID
     */
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
    /**
     * Method that checks out and removes the CarDataNode object found at the specified index.  Removed Node is added to the GarageExitBag.
     * @param index
     */
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

    /**
     * Method that checks out and removes the CarDataNode object with the specified liscenseID.  Removed Node is added to the GarageExitBag.
     * @param liscenseID
     */
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
    /**
     * Getter method that gets a refrence to the GarageExitBag object which stores all of the removed nodes in another linked list.
     * @return GarageExitBag
     */
    public GarageExitBag getExitBag()
    {
        return this.exitBag;
    }

    /**
     * Gets the head of the GarageSet linkedlist.
     * @return CarDataNode
     */
    public CarDataNode getHead()
    {
        return this.head;
    }
    
    /**
     * Gets the tail of the GarageSet linkedList
     * @return
     */
    public CarDataNode getTail()
    {
        return this.tail;
    }
    
    /**
     * gets the total number of CarDataNodes in the GarageSet
     * @return int
     */
    public int getTotalItems()
    {
        return this.totalItems;
    }

    /**
     * Method that searches through the GarageSet and returns true or false whether the GarageSet contains a node with a matching liscenseID.
     * @param id 
     * @return boolean
     */
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

    /**
     * Method that returns a String array of all the nodes in their string representation.
     * @return String[]
     */
    public String[] toArray(){
        int arraySize = totalItems;
        String contentArray[] = new String[arraySize];

        CarDataNode cursor = head;
        for (int i = 0; i < contentArray.length; i++, cursor = cursor.getNext()) {
            contentArray[i] = cursor.toString();
        }

        return contentArray;
    }

    /**
     * GarageSet to string method.  Returns a string representation of the GarageSet.
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        CarDataNode cursor = head;

        while(cursor != null){
            builder.append(cursor.getCarID() + "\t" + cursor.getCheckInTime() + "\n");
            cursor = cursor.getNext();
        }
        return builder.toString();
    }

    /**
     * Static method that reads in data from a file and fills up the GarageSet Object.
     */
    public static void loadGSData()
    {

    }
    /**
     * Static method that writes the string representation of all the CarDataNodes in the GarageSet in a format which will be used to load in the GarageSet Object later.
     */
    public static void saveGSData()
    {
        
    }

}