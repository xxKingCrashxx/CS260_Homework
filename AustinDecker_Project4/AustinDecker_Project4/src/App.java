import java.util.Scanner;

public class App {
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
        } while(running);

        scanner.close();
        System.out.println("closing program.");
    }

    private static void print() {

    }

    private static void heapSort() {

    }

    private static void delete() {

    }

    private static void insert() {

    }

    private static void buildHeap() {

    }
}
