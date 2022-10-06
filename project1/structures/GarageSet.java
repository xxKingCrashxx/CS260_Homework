package structures;



public class GarageSet
{
    private CarDataNode head;
    private CarDataNode tail;
    private int totalItems;

    
    public GarageSet()
    {
        head = null;
        tail = null;
        totalItems = 0;
    }

    public void checkIn(int index)
    {

    }
    public void checkIn(String liscenceID)
    {
        CarDataNode newNode = new CarDataNode(liscenceID, null, null);
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

    }
    public void checkOut(String liscenceID)
    {

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
        return "";
    }

    public static void loadGSData()
    {

    }

    public static void saveGSData()
    {
        
    }

    

}