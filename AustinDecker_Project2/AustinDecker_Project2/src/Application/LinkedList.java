package Application;

import java.util.NoSuchElementException;

public class LinkedList{
    class Node{
        private Process value;
        private Node next;

        public Node(Process value){
            this.value = value;
            next = null;
        }
        public Process getValue() {return value;}
        public Node getNext(){return next;}
    }
    private Node head;
    private Node tail;
    private int totalItems;

    public void addToBack( Process value){
        if (head == null){
            head = new Node(value);
            tail = head;
        }
        else{
            tail.next = new Node(value);
            tail = tail.next;
        }
        totalItems++;

    }
    public Process removeFromFront() throws NoSuchElementException{
        if(head == null)
           throw new NoSuchElementException();

        Process removedProcess = null;
        removedProcess = Process.copy(head.getValue(), removedProcess);
        
        head = head.next;
        totalItems--;

        return removedProcess;
    }
    public Node getHead() {return head;}
    public Node getTail() {return tail;}
    public int getTotalItems() {return totalItems;}
}
