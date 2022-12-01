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
        int left = 2*index + 1;
        int right = 2*index + 2;

        if(left < heapSize && getLeftNode(index) > heap[largestNode]){
            largestNode = left;
        }

        if(right < heapSize && getRightNode(index) > heap[largestNode]){
            largestNode = right;
        }

        if(largestNode != index){
            int temp = heap[index];
            heap[index] = heap[largestNode];
            heap[largestNode] = temp;

            floidHeapify(largestNode, heapSize);
        }
    }

    public void insert(int obj){
        if(currentIndex >= heap.length)
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

    public void heapSort(){
        for(int i = currentIndex; i >= 0; i--){
            floidHeapify(i, i);
        }
    }

    public void print(){
        for (int i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int getCurrentIndex() {
        return currentIndex -1;
    }

    private void heapifyUp(int index){
        int travIndex = index;

        while((travIndex > 0) && heap[travIndex] > getParentNode(travIndex)){
            int temp = getParentNode(travIndex);
            heap[(travIndex -1)/2] = heap[travIndex];
            heap[travIndex] = temp;

            travIndex = (travIndex -1)/2;
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
        return heap[(index - 1)/2];
    }

    private int getRightNode(int index){
        return heap[2*index + 2];
    }

    private int getLeftNode(int index){
        return heap[2*index + 1];
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
} 