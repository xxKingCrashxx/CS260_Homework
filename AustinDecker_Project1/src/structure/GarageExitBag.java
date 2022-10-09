package structure;

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
        CarDataNode newNode = node.clone();

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
        File file = new File(currentDate.toString() + ".txt");
        
        try 
        {
            if(!file.exists())
            {
                file.createNewFile();
            }

            FileWriter fWriter = new FileWriter(file, true);
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
            System.out.println("Could not create file for an unknown reason.");
        }
        catch(SecurityException se)
        {
            se.printStackTrace();
            System.out.println("A security error occured while trying to create the file.");
        }
        
    }
    public CarDataNode getLastNode(){
        CarDataNode cursor = this.head;

        while(cursor.getNext() != null){
            cursor = cursor.getNext();
        }
        return cursor;
    }
    
    public String[] toArray(){
        int arraySize = totalItems;
        String contentArray[] = new String[arraySize];

        CarDataNode cursor = head;
        for (int i = 0; i < contentArray.length; i++, cursor = cursor.getNext()) {
            contentArray[i] = cursor.toString();
        }
        return contentArray;
    }

}