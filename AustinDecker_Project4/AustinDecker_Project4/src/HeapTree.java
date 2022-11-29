public class HeapTree<T extends Comparable<T>> {
    private T[] objects;

    public HeapTree(int treeSize){
        objects = (T[])new Object[treeSize];
    }
} 