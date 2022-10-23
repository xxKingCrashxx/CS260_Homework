package Application;

import java.util.NoSuchElementException;

public class LinkedList{
    class Node{
        Process value;
        Node next;

        public Node(Process value){
            this.value = value;
            next = null;
        }

        public Process getValue() {
            return value;
        }
    }
    Node head;
    Node tail;
    int totalItems;

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
    public void removeFromFront(){
        if(head == null)
           throw new NoSuchElementException();
        head = head.next;
        totalItems--;
    }
    public Node getHead() {return head;}
    public Node getTail() {return tail;}
    public int getTotalItems() {return totalItems;}
}
