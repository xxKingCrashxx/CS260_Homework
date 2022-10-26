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
        System.out.printf("%s started executing", process.getProcessID());
        processes.addToBack(process);
        manyItems++;
    }
    public void disposeProcess(){
        Process finishedProcess = processes.getHead().getValue();
        System.out.printf("%s finished", finishedProcess.getProcessID());
        processes.removeFromFront();
        manyItems--;
    }
    public boolean hasProcess(){
        return (manyItems != 0);
    }
    public Process getFirstProcess(){
        return processes.getHead().getValue();
    }
    
}
