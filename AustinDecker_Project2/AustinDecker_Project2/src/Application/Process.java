package Application;

public class Process{
    private int startTime;
    private int finishTime;
    private int priority;
    private String processID;

    public Process(String processID, int priority, int startTime, int finishTime){
        this.priority = priority;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public String getProcessID() {return processID;}
    public int getPriority() {return priority;}
    public int getStartTime() {return startTime;}
    public int getFinishTime() {return finishTime;}
    
    public static Process copy(Process target, Process copy){
        copy.priority = target.priority;
        copy.processID = target.processID;
        copy.startTime = target.startTime;
        copy.finishTime = target.finishTime;

        return copy;
    }
 
}
