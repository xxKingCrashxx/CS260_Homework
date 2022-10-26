package Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final String FILE_PATH = "/resources/test.txt";
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        Process[] sortedProcesses = sortProcesses(FILE_PATH);
        int processAmount = 0;

        try {
            Scanner reader = new Scanner(new File(FILE_PATH));
            processAmount = reader.nextInt();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
            e.printStackTrace();    
        }
        Processor processor = new Processor(processAmount);

        int index = 0;
        int time = 0;
        while(index < sortedProcesses.length){
            System.out.printf("T=%d\n", time);
            if(sortedProcesses[index].getStartTime() == time){
                while(sortedProcesses[index].getStartTime() == time){
                    priorityQueue.add(sortedProcesses[index]);
                    index++;
                }
                
                if(!processor.hasProcess())
                    processor.addToProcessor(priorityQueue.getNextProcess());
            }

            if(processor.getFirstProcess().getFinishTime() == time){
                priorityQueue.remove();
                processor.disposeProcess();
                processor.addToProcessor(priorityQueue.getNextProcess());
            }
            time++;
        }

    }
    public static Process[] sortProcesses(String fileLocation)
    {
        int processAmount;
        Process[] sortedProcesses = null;
        Scanner reader = null;

        try {
            reader = new Scanner(new File(fileLocation)); 
            processAmount = reader.nextInt();
            sortedProcesses = new Process[processAmount];

            int index = 0;
            while(reader.hasNextLine()){
                String[] data = reader.nextLine().split("\t");
                sortedProcesses[index] = new Process(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                index++;
            }
            Arrays.sort(sortedProcesses);
        } 
        catch (FileNotFoundException e) {
            System.out.println("could not find file specified");
            e.printStackTrace();
        }
        finally{
            reader.close();
        }
        return sortedProcesses;

    }
}
