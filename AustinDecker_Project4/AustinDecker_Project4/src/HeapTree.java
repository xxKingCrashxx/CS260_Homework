public class HeapTree<T extends Comparable<T>> {
    private final int INIT_SIZE;
    private int currentIndex = 0;
    private T[] objects;

    public HeapTree(){
        INIT_SIZE = 10;
        objects = (T[])new Object[INIT_SIZE];
    }
    
    public HeapTree(int treeSize){
        INIT_SIZE = treeSize;
        objects = (T[])new Object[treeSize];
    }
} 