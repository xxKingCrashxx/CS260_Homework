package Application;

public class Processor {
    private LinkedList processes;
    private int manyItems;

    public Processor(int processAmount)
    {
        processes = new LinkedList();
        manyItems = 0;
    }
    public void addToProcessor(Process process){
        processes.addToBack(process);
        manyItems++;
    }
    public void disposeProcess(){
        
        processes.removeFromFront();
        manyItems--;
    }
}
