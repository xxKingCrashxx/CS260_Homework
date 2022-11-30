import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static HeapTree intHeapTree = new HeapTree(20);
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
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
        intHeapTree.insert(Integer.valueOf(24));
        intHeapTree.insert(Integer.valueOf(17));
        intHeapTree.insert(Integer.valueOf(37));
        intHeapTree.insert(Integer.valueOf(19));
        intHeapTree.insert(Integer.valueOf(33));
        intHeapTree.insert(Integer.valueOf(9));
        intHeapTree.insert(Integer.valueOf(8));
        intHeapTree.insert(Integer.valueOf(69));

        intHeapTree.print();
    }

    private static void heapSort() {
        //TODO
    }

    private static void delete() {
        //TODO
    }

    private static void insert() {
        //TODO
    }

    private static void buildHeap() {
        ArrayList<String> buffer = new ArrayList<>();
        FileReaderHelper.readFile("src\\numbers.txt", buffer);
    }
}
