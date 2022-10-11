package structure;

import java.time.LocalDateTime;
/**
 * CarDataNode class which uses the doubly linked list data structure.
 */
public class CarDataNode implements Cloneable
{
    private CarDataNode next;
    private CarDataNode prev;

    private String liscenceNum;

    private String checkIn;
    private String checkout;

    /**
     * Constructor for the CarDataNode Object.
     * Takes 3 parameters requiring to make Object.
     * @param liscenceNum id of the car
     * @param next next Object in the linkedlist
     * @param prev previous Object in the linkedlist
     */
    public CarDataNode(String liscenceNum, CarDataNode next, CarDataNode prev)
    {
        this.liscenceNum = liscenceNum;
        this.next = next;
        this.prev = prev;

    }

    /**
     * Constructor of the CarDataNode Object.
     * Takes 5 parameters requiring to make object.
     * @param liscenceNum id of the car.
     * @param next next Object in the linkedlist
     * @param prev previous Object in the linkedlist.
     * @param checkIn check-in date/time of the car. 
     * @param checkout check-out date/time of the car.
     * 
     */
    public CarDataNode(String liscenceNum, CarDataNode next, CarDataNode prev, String checkIn, String checkout)
    {
        this.liscenceNum = liscenceNum;
        this.next = next;
        this.prev = prev;

        this.checkIn = checkIn;
        this.checkout = checkout;
    }

    /**
     * Gets the next CarDataNode Object in the linkedlist
     * @return CarDataNode
     */
    public CarDataNode getNext()
    {
        return this.next;
    }

    /**
     * sets the next CarDataNode Object in the linkedlist
     * @param next CarDataNode Object
     * @return void
     */
    public void setNext(CarDataNode next)
    {
        this.next = next;
    }

    /**
     * Gets the prevous CarDataNode Object in the linkedlist
     * @return CarDataNode
     */
    public CarDataNode getPrev()
    {
        return this.prev;
    }

    /**
     * Sets the previous CarDataNode Object in the linkedlist
     * @param prev CarDataNode Object
     * @return void
     */
    public void setPrev(CarDataNode prev)
    {
        this.prev = prev;
    }

     /**
     * gets the CarDataNode Object ID
     * @return String
     */
    public String getCarID()
    {
        return this.liscenceNum;
    }

    /**
     * sets the CarDataNode Object ID
     * @param liscenseNum String
     * @return void
     */
    public void setCarID(String liscenseNum)
    {
        this.liscenceNum = liscenseNum;
    }

    /**
     * gets the CarDataNode Object check in time
     * @return String of LocalDataTime.now();
     */
    public String getCheckInTime()
    {
        return checkIn;
    }
    
    /**
     * gets the CarDataNode Object check out time
     * @return String of LocalDataTime.now();
     */
    public String getCheckOutTime()
    {
        return checkout;
    }
    /**
     * A method that takes in a CarDataNode Object and adds the node after the currently called CarDataNode Object.
     * @param newNode
     */
    public void addNodeAfter(CarDataNode newNode)
    {
        if(this.next != null)
        {
            this.next.prev = newNode;
            newNode.next = this.next;
            this.next = newNode;
            newNode.prev = this;

        }
        else
        {
            this.next = newNode;
            newNode.prev = this;
            newNode.next = null;
        }
    }

    /**
     * returns the CarDataNode's Data as a String
     */
    @Override
    public String toString()
    {
        return String.format("Liscence Number: %s\tClock In: %s\tClock Out: %s", this.liscenceNum, this.checkIn, this.checkout);
    }

    /**
     * removes the currently called Node from the linkedList
     */
    public void removeNode()
    {
        
        if (this.next != null) {
            this.next.prev = this.prev;
        }
 
        if (this.prev != null) {
            this.prev.next = this.next;
        }

    }

    /**
     * Assigns the called CarDataNode Object's checkIn variable to the current date and time.
     */
    public void checkIn()
    {
       checkIn = LocalDateTime.now().toString();
    }

    /**
     * Assigns the called CarDataNode Object's checkOut variable to the current date and time.
     */
    public void checkOut()
    {
        checkout = LocalDateTime.now().toString();
    }

    /**
     * compares the called CarDataNode object to another CarDataNode object specified in the peremeters as node.  The method compares the liscenseID of both objects and returns true if the liscenseID matches.
     * @param node
     * @return boolean
     */
    public boolean equals(CarDataNode node)
    {
        return this.liscenceNum.equals(node.liscenceNum);
    }
    /**
     * static method that searches through the head of the CarDataNode object until it finds a CarDataNode object with the matching liscenseID.
     * @param head CarDataNode Object.
     * @param liscenceNum ID of CarDataNode to find.
     * @return CarDataNode
     * 
     */
    public static CarDataNode getNodeFromID(CarDataNode head, String liscenceNum)
    {
        CarDataNode cursor = head;
        while(cursor != null)
        {
            if(cursor.liscenceNum.equals(liscenceNum))
            {
                return cursor;
            }
            cursor = cursor.next;
        }
        return null;
    }

    /**
     * static method that searches through the head of the CarDataNode object until it finds a CarDataNode object in the specified index position
     * @param head CarDataNode Object.
     * @param index integer 
     * @return CarDataNode
     * 
     */
    public static CarDataNode getNodeFromIndex(CarDataNode head, int index)
    {
        CarDataNode cursor = head;
        int nodeCount = 0;

        while(cursor != null)
        {
            if(nodeCount == index)
                return cursor;
            cursor = cursor.next;
            nodeCount++;
        }
        return null;
    }
    @Override
    public CarDataNode clone()
    {
        CarDataNode copiedNode = null;
        try 
        {
            copiedNode = (CarDataNode)super.clone();
            copiedNode.next = null;
            copiedNode.prev = null;
        } 
        catch (CloneNotSupportedException e) 
        {
            e.printStackTrace();
        }
        return copiedNode;
    }
}