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

    public void addToBack( Process value){
        if (head == null){
            head = new Node(value);
            tail = head;
        }
        else{
            Node cursor = head;
            while(cursor.next != null)
                cursor = cursor.next;
            cursor.next = new Node(value);
            tail = tail.next;
        }

    }
    public void removeFromFront(){
        if(head == null)
           throw new NoSuchElementException();
        head = head.next;
    }
    public Node getHead() {
        return head;
    }
    public Node getTail() {
        return tail;
    }
}
