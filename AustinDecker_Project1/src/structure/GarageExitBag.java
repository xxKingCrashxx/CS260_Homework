package structure;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * GarageBag class which stores and writes out the data of the linkedlist.
 */
public class GarageExitBag
{
    private CarDataNode head;
    private int totalItems;

    /**
     * default constructor for the GarageExitBag
     */
    public GarageExitBag()
    {
        totalItems = 0;
        head = null;

    }
    /**
     * Method that copies the CarDataNode object and then adds the copied object to the back of the linkedlist.
     * @param node
     */
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
    /**
     * returns the number of CarDataNode objects in the GarageExitBag's linkedList
     * @return int
     */
    public int getSize()
    {
        return this.totalItems;
    }

    /**
     * returns a CarDataNode object that represents the head of the linkedList
     * @return CarDataNode
     */
    public CarDataNode getHead(){
        return this.head;
    }

    /**
     * Method that dumps the contents of the GarageExitBag into a file and saves it as the current date.
     */
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
    /**
     * returns a CarDataNode Object that is at the end of the linked list
     * @return
     */
    public CarDataNode getLastNode(){
        CarDataNode cursor = this.head;

        while(cursor.getNext() != null){
            cursor = cursor.getNext();
        }
        return cursor;
    }
    /**
     * Method that returns a String array of all the nodes stored in the GarageBag in their string representation.
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

}