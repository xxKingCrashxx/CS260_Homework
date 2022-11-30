import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static HeapTree intHeapTree = new HeapTree(20);
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        
        boolean running = true;

        do{
            System.out.println("==================================================================");
            System.out.println("Options:\n"
                    + "\t0:\tExit\n"
                    + "\t1:\tBuild Heap\n"
                    + "\t2:\tInsert\n"
                    + "\t3:\tDelete\n"
                    + "\t4:\tHeap sort\n"
                    + "\t5:\tPrint\n");
            System.out.println("==================================================================");

            String usrInput = scanner.nextLine();
            switch (usrInput){
                case "0":
                    running = false;
                    break;
                case "1":
                    buildHeap();
                    break;
                case "2":
                    insert();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    heapSort();
                    break;
                case "5":
                    print();
                    break;
                default:
                    System.out.println("Not a valid input.");
            }
            System.out.println(intHeapTree.getCurrentIndex());
        } while(running);

        scanner.close();
        System.out.println("closing program.");
    }

    private static void print() {
        //TODO
    }

    private static void heapSort() {
        //TODO
    }

    private static void delete() {
        //TODO
    }

    private static void insert() {
        while(true){
            System.out.println("Please enter a number:>");
            int userNum = scanner.nextInt();

            intHeapTree.insert(userNum);
            intHeapTree.print();

            System.out.println("add another number?");
            String ans = scanner.nextLine();

            if(!ans.toUpperCase().equals("Y"))
                break;
        }
    }

    private static void buildHeap() {
        ArrayList<String> buffer = new ArrayList<>();
        int[] numbers = new int[buffer.size()];

        FileReaderHelper.readFile("src\\numbers.txt", buffer);

        int index = 0;
        for (String str : buffer) {
            numbers[index] = Integer.parseInt(str);
            index++;
        }

        intHeapTree.heapSort(numbers);
    }
}
