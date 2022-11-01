package Application;

public class Process implements Comparable<Object>{
    private int startTime;
    private int finishTime;
    private int priority;
    private String processID;

    public Process(String processID, int priority, int startTime, int finishTime){
        this.priority = priority;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.processID = processID;
    }

    public Process(){
        startTime = 0;
        finishTime = 0;
        priority = 0;
        processID = null;
    }

    public String getProcessID() {return processID;}
    public int getPriority() {return priority;}
    public int getStartTime() {return startTime;}
    public int getFinishTime() {return finishTime;}

    public void setFinishTime(int addedTime){this.finishTime = this.finishTime + addedTime;}
    
    public static Process copy(Process target, Process copy){

        if(copy == null)
            copy = new Process();
        copy.priority = target.priority;
        copy.processID = target.processID;
        copy.startTime = target.startTime;
        copy.finishTime = target.finishTime;
        return copy;
    }

    /**
     * this method does not follow the rule (x.compareTo(y)==0) == (x.equals(y))
     */
    @Override
    public int compareTo(Object o) {
        Process process;
        if(o == null)
            throw new NullPointerException();

        if (!(o instanceof Process))
            throw new ClassCastException("the object is not a Process object");

        process = (Process)o;
        if(this.startTime == process.startTime)
            return 0;
        else if(this.startTime > process.startTime)
            return 1;
        else
            return -1;  
    }
}
