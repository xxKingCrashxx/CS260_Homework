package structures;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class CarDataNode 
{
    private CarDataNode next;
    private CarDataNode prev;

    private String liscenceNum;

    private String checkIn;
    private String checkout;

    public CarDataNode(String liscenceNum, CarDataNode next, CarDataNode prev)
    {
        this.liscenceNum = liscenceNum;
        this.next = next;
        this.prev = prev;

    }

    public CarDataNode(String liscenceNum, CarDataNode next, CarDataNode prev, String checkIn)
    {
        this.liscenceNum = liscenceNum;
        this.next = next;
        this.prev = prev;

        this.checkIn = checkIn;

    }

    public CarDataNode getNext()
    {
        return this.next;
    }

    public void setNext(CarDataNode next)
    {
        this.next = next;
    }

    public CarDataNode getPrev()
    {
        return this.prev;
    }

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
        this.prev.next = this.next;
        this.next.prev = this.prev;

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

}