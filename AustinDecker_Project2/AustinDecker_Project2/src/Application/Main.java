package Application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final String FILE_PATH = "AustinDecker_Project2\\src\\Application\\test.txt";
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        Process[] sortedProcesses = sortProcesses(FILE_PATH);
        Processor processor = new Processor();

        int index = 0;
        int time = 0;
        while(index < sortedProcesses.length){
            
            if(sortedProcesses[index].getStartTime() == time){
                System.out.printf("T=%d\n", time);
                while(sortedProcesses[index].getStartTime() == time){
                    if(index >= sortedProcesses.length)
                        break; 
                    priorityQueue.add(sortedProcesses[index]);
                    index++;
                }
            }

            if(!processor.hasProcess()){
                processor.addToProcessor(priorityQueue.getNextProcess());
            }
            if(processor.hasProcess()){
                if(processor.getFirstProcess().getFinishTime() == time){
                    System.out.printf("T=%d\n", time);
                    priorityQueue.remove();
    
                    if(priorityQueue.getNextProcess() != null)
                        priorityQueue.getNextProcess().setFinishTime(time);
                    processor.disposeProcess();
                    //processor.addToProcessor(priorityQueue.getNextProcess());
                }
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
            processAmount = Integer.parseInt(reader.nextLine());
            sortedProcesses = new Process[processAmount];

            int index = 0;
            while(reader.hasNextLine()){
                String[] data = reader.nextLine().split(" ");
                System.out.println(data[0]);
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
