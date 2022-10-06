package structures;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class GarageExitBag
{
    private CarDataNode head;
    private int totalItems;

    public GarageExitBag()
    {
        totalItems = 0;
        head = null;

    }

    public void add(CarDataNode node)
    {
        CarDataNode newNode = new CarDataNode(node.getCarID(), null, null);

        if(this.head == null)
        {
            head = newNode;
        }
        else
        {
            CarDataNode cursor = head;

            while(cursor.getNext() != null){
                cursor = cursor.getNext();
            }
            cursor.addNodeAfter(newNode);

        }
        totalItems++;
    }

    public int getSize()
    {
        return this.totalItems;
    }

    public CarDataNode getHead(){
        return this.head;
    }

    public void dumpOutputData()
    {
        LocalDate currentDate = LocalDate.now();
        File file = new File("output/" + currentDate.toString() + ".txt");
        
        try 
        {
            FileWriter fWriter = new FileWriter(file);
            CarDataNode cursor = head;

            while(cursor != null)
            {
                fWriter.append(cursor.toString() + "\n");
                cursor = cursor.getNext();
            }
            fWriter.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
    }
}