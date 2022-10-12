package structure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * GarageSet class which stores and manipulates a CarDataNode linkedlist structure.
 */
public class GarageSet
{
    private CarDataNode head;
    private CarDataNode tail;
    private int totalItems;

    /**
     * Constructor for the GarageSet
     */
    public GarageSet()
    {
        head = null;
        tail = null;
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
            if(!hasDuplicate(newNode.getCarID()))
            {
                tail.addNodeAfter(newNode);
                tail = tail.getNext();
                totalItems++;
            }
        }
    }
    /**
     * Method that checks out and removes the CarDataNode object found at the specified index.  Removed Node is added to the GarageExitBag.
     * @param index
     * @param exitBag
     */
    public void checkOut(int index, GarageExitBag exitBag)
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
     * Method that checks out the node with the specified liscenseID and sends the node into the exitBag object.
     * @param liscenceID
     * @param exitBag
     */
    public void checkOut(String liscenceID, GarageExitBag exitBag)
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
     * Method that searches through the GarageSet and returns 
     * true or false whether the GarageSet contains a node with a matching liscenseID.
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
     * private method which loads in nodes directly into the GarageSet.
     * The data is assumed to have come from the application and no changes were made to the data.
     * @param savedNode
     */
    private void loadSavedNodes(CarDataNode savedNode)
    {
        if(this.head == null)
        {
            head = savedNode;
        }
        else
        {
            CarDataNode searchNode = head;

            while(searchNode.getNext() != null)
            {
                searchNode = searchNode.getNext();
            }

            searchNode.addNodeAfter(savedNode);
        }
        tail = savedNode;
        totalItems++;
    }

    /**
     * Static method that reads in data from a file and fills up the GarageSet Object.
     */
    public static void loadGSData(GarageSet garageSet)
    {
        File loadData = new File("saveData.txt");

        if(!loadData.exists())
            return;
        try 
        {
            Scanner scanner = new Scanner(loadData);

            while(scanner.hasNextLine()){
                String[] data = scanner.nextLine().split("\t");
                garageSet.loadSavedNodes(new CarDataNode(data[0], null, null, data[1], null));
            }
            scanner.close(); 
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        catch(IOException ioe){
            System.out.println("saveData.txt could not be created for some reason.");
        }
        catch(SecurityException se)
        {
            se.printStackTrace();
            System.out.println("A SecurityException occured while trying to access the filepath");
        }
    }
    /**
     * Static method that writes the string representation of all the CarDataNodes in the GarageSet in a format which will be used to load in the GarageSet Object later.
     */
    public static void saveGSData(GarageSet garageSet)
    {
        File saveData = new File("saveData.txt");
        try 
        {
            if(!saveData.exists())
            {
                saveData.createNewFile();
            }

            FileWriter fWriter = new FileWriter(saveData);
            fWriter.write(garageSet.toString());
            fWriter.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            System.out.println("An IO exception occured while trying to write/create the file.");
        }
        catch(SecurityException se)
        {
            se.printStackTrace();
            System.out.println("A SecurityException occured while trying to access the filepath");
        }
    }

}