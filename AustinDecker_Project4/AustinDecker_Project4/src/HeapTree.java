import java.util.Arrays;

public class HeapTree {
    private final int INIT_SIZE;
    private int currentIndex = 0;
    private int[] heap;

    public HeapTree(){
        INIT_SIZE = 10;
        heap = new int[INIT_SIZE];
       
    }

    public HeapTree(int treeSize){
        INIT_SIZE = treeSize;
        heap = new int[treeSize];
    }

   public void buildHeap(int[] numbers){
        //TODO
   }

    public void insert(int obj){
        if(currentIndex >= INIT_SIZE)
            ensureCapacity(heap.length * 2);
        heap[currentIndex] = obj;

        //reheaping the tree
        heapifyUp(currentIndex);
        currentIndex++;
    }

    public int delete(){

        if(currentIndex == 0){
            throw new IndexOutOfBoundsException("-1 is not a valid index");
        }

        if(currentIndex < heap.length * 2/3)
            trimCapacity();

        int ans = heap[0];
        heap[0] = heap[currentIndex -1];
        heap[currentIndex-1] = 0;

        //reheapification downwards
        heapifyDown(0);
        currentIndex--;
        return ans;
    }

    public void heapSort(int[] numbers){
        //TODO
    }

    public void print(){
        for (int i : heap) {
            if(i == 0)
                break;
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    private void heapifyUp(int index){
        int travIndex = index;

        while((travIndex > 0) && heap[travIndex] > getParentNode(travIndex)){
            int temp = getParentNode(travIndex);
            heap[travIndex/2] = heap[travIndex];
            heap[travIndex] = temp;

            travIndex = travIndex/2;
        }
    }

    private void heapifyDown(int index){
        while(!isLeafNode(index)){
            int temp = heap[index];
            int skip = 0;
            if((getLeftNode(index) > getRightNode(index)) && (heap[index] < getLeftNode(index))){
                heap[index] = getLeftNode(index);
                heap[2*index + 1] = temp;
                skip = 1;
            }
            else if((getLeftNode(index) < getRightNode(index)) && (heap[index] < getRightNode(index))){
                heap[index] = getRightNode(index);
                heap[2*index + 2] = temp;
                skip = 2;
            }
            else{
                break;
            }
            index = 2*index + skip;
        }
    }

    private int getParentNode(int index){
        return heap[index/2];
    }

    private int getRightNode(int index){
        if(2*index + 2 >= INIT_SIZE)
            return 0;
        return heap[2*index + 2];
    }

    private int getLeftNode(int index){
        if(2*index + 1 >= INIT_SIZE)
            return 0;
        return heap[2*index + 1];
    }

    private boolean isLeafNode(int index){
        if(index >= (currentIndex/2) && index <= INIT_SIZE)
            return true;
        return false;
    }

    private void ensureCapacity(int size){
        int[] biggerArray = Arrays.copyOf(heap, size);
        this.heap = biggerArray;
    }

    private void trimCapacity(){
        int[] trimmedArray = Arrays.copyOf(heap, heap.length * 2/3);
        heap = trimmedArray;
    }
} 