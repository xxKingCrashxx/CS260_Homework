package Application;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Main {
    static final String FILE_PATH = "/resources/test.txt";
    public static void main(String[] args) {
        Processor processor;
        PriorityQueue priorityQueue = new PriorityQueue();
        int time = 0;

        try {
            Scanner reader = new Scanner(new File(FILE_PATH));
            processor = new Processor(reader.nextInt());

            while(reader.hasNextLine()){
                
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("could not find file specified");
            e.printStackTrace();
        }
    }
}
