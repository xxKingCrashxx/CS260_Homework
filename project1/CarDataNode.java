
import java.time.LocalDateTime;


public class CarDataNode 
{
    private CarDataNode next;
    private CarDataNode prev;

    private String liscenceNum;

    private LocalDateTime checkIn;
    private LocalDateTime checkout;

    public CarDataNode(String liscenceNum, CarDataNode next, CarDataNode prev)
    {
        this.liscenceNum = liscenceNum;
        this.next = next;
        this.prev = prev;

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

    public String getCheckInTime(){
        return checkIn.toString();
    }
    public String getCheckOutTime(){
        return checkout.toString();
    }

    public boolean addNodeAfter()
    {
        return false;
    }

    public String toString()
    {
        return "";
    }

    public boolean removeNode()
    {
        return false;

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