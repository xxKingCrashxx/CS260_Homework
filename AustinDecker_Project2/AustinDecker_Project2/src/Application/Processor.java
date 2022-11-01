package Application;

public class Processor {
    private LinkedList processes;
    private int manyItems;

    public Processor()
    {
        processes = new LinkedList();
        manyItems = 0;
    }
    public void addToProcessor(Process process){
        if(process == null)
            throw new NullPointerException();
        System.out.printf("%s started executing\n", process.getProcessID());
        processes.addToBack(process);
        manyItems++;
    }
    public void disposeProcess(){
        Process finishedProcess = processes.getHead().getValue();
        System.out.printf("%s finished\n", finishedProcess.getProcessID());
        processes.removeFromFront();
        manyItems--;
    }
    public boolean hasProcess(){
        return (manyItems > 0);
    }
    public Process getFirstProcess(){
        return processes.getHead().getValue();
    }
    
}
