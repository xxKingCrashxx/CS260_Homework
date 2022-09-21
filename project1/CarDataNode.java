package project1;
import java.time.LocalDateTime;


public class CarDataNode 
{
    CarDataNode next;
    CarDataNode prev;

    String liscenceNum;

    LocalDateTime checkIn;
    LocalDateTime checkout;

    public CarDataNode(String liscenceNum, CarDataNode next, CarDataNode prev)
    {
        this.liscenceNum = liscenceNum;
        this.next = next;
        this.prev = prev;

    }

    public void addNodeAfter()
    {

    }

    public String toString()
    {
        return "";
    }

    public void removeNode()
    {


    }

    public void checkIn()
    {
       checkIn = LocalDateTime.now();
    }

    public void checkOut()
    {
        checkout = LocalDateTime.now();
    }

    public boolean equals(CarDataNode node)
    {
        return false;
    }

    public static CarDataNode getNodeFromID(CarDataNode head, String liscenceNum)
    {
        return null;
    }

    public static CarDataNode getNodeFromIndex(CarDataNode head, int index)
    {
        return null;
    }

}