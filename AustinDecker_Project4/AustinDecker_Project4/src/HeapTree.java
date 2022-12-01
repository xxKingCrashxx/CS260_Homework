import java.util.Arrays;

/**
 * Max Heap Structure
 * 
 */
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

    /**
     * builds the heap using the supplied array of numbers.
     * @param numbers
     */
    public void buildHeap(int[] numbers){
        if(numbers.length >= heap.length){
            ensureCapacity(numbers.length * (1+(1/3)));
        }

        for(int num : numbers){
            heap[currentIndex] = num;
            currentIndex++;
        }
        
        for (int i = ((currentIndex)/2) - 1; i >= 0; i--) {
            floidHeapify(i, heap.length);
        }
    }

    private void floidHeapify(int index, int heapSize) {
        int largestNode = index;
        

        if(getLeftIndex(index) < heapSize && getLeftNode(index) > heap[largestNode]){
            largestNode = getLeftIndex(index);
        }

        if(getRightIndex(index) < heapSize && getRightNode(index) > heap[largestNode]){
            largestNode = getRightIndex(index);
        }

        if(largestNode != index){
            swap(index, largestNode);
            floidHeapify(largestNode, heapSize);
        }
    }

    /**
     * inserts a single integer into the heap and reheapifies the structure.
     * @param obj
     */
    public void insert(int obj){
        if(currentIndex >= heap.length)
            ensureCapacity(heap.length * 2);
        heap[currentIndex] = obj;

        //reheaping the tree
        heapifyUp(currentIndex);
        currentIndex++;
    }

    /**
     * deletes the max node and reheapifies the structure
     * @return
     */
    public int delete(){
        if(currentIndex == 0){
            throw new IndexOutOfBoundsException("-1 is not a valid index");
        }

        if(currentIndex < heap.length * 2/3)
            trimCapacity();

        int ans = swap(0, currentIndex - 1);
        heap[currentIndex-1] = 0;

        //reheapification downwards
        heapifyDown(0);
        currentIndex--;
        return ans;
    }

    /**
     * returns a decending order array of values from the heap.
     * @return
     */
    public int[] heapSort(){
        int[] sortedHeap = new int[currentIndex];
        
        for(int j = 0, i = currentIndex; i > 0; i--, j++){
            sortedHeap[j] = delete();
        }
        return sortedHeap;
    }

    /**
     * prints the heap to screen in a single line.
     */
    public void print(){
        for (int i : heap) {
            if(i == 0)
                break;
            System.out.print(i + " ");  
        }
        System.out.println();
    }
    /**
     * returns the current index of the heap.
     * @return
     */
    public int getCurrentIndex() {
        return currentIndex -1;
    }

    private void heapifyUp(int index){
        int travIndex = index;

        while((travIndex > 0) && heap[travIndex] > getParentNode(travIndex)){
            swap(getParentIndex(travIndex), travIndex);
            travIndex = getParentIndex(travIndex);
        }
    }

    private void heapifyDown(int index){
        while(!isLeafNode(index)){
            int skip = 0;
            if((getLeftNode(index) > getRightNode(index)) && (heap[index] < getLeftNode(index))){
                swap(index, getLeftIndex(index));
                skip = 1;
            }
            else if((getLeftNode(index) < getRightNode(index)) && (heap[index] < getRightNode(index))){
                swap(index, getRightIndex(index));
                skip = 2;
            }
            else{
                break;
            }
            index = 2*index + skip;
        }
    }

    private int getParentNode(int index){
        return heap[(index - 1)/2];
    }

    private int getParentIndex(int index){
        return (index - 1) / 2;
    }

    private int getRightNode(int index){
        return heap[2*index + 2];
    }

    private int getRightIndex(int index){
        return 2*index + 2;
    }

    private int getLeftNode(int index){
        return heap[2*index + 1];
    }

    private int getLeftIndex(int index){
        return 2*index + 1;
    }

    private boolean isLeafNode(int index){
        if(index >= (currentIndex/2) && index <= heap.length)
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

    private int swap(int index1, int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;

        return temp;
    }
} 