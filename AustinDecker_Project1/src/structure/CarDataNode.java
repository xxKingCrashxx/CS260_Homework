package structure;

import java.lang.annotation.Documented;
import java.time.LocalDateTime;
import java.time.ZoneId;


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
     * @return void
     */
    public void setPrev(CarDataNode prev)
    {
        this.prev = prev;
    }

    public String getCarID()
    {
        return this.liscenceNum;
    }

    public void setCarID(String liscenseNum)
    {
        this.liscenceNum = liscenseNum;
    }

    public String getCheckInTime()
    {
        return checkIn;
    }
    public String getCheckOutTime()
    {
        return checkout;
    }

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

    @Override
    public String toString()
    {
        return String.format("Liscence Number: %s\tClock In: %s\tClock Out: %s", this.liscenceNum, this.checkIn, this.checkout);
    }

    public void removeNode()
    {
        
        if (this.next != null) {
            this.next.prev = this.prev;
        }
 
        if (this.prev != null) {
            this.prev.next = this.next;
        }

    }

    public void checkIn()
    {
       checkIn = LocalDateTime.now().toString();
    }

    public void checkOut()
    {
        checkout = LocalDateTime.now().toString();
    }

    public boolean equals(CarDataNode node)
    {
        if(!this.liscenceNum.equals(node.liscenceNum))
        {
            return false;
        }
        return true;
    }

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