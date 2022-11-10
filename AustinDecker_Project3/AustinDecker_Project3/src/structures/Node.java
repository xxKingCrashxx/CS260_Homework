package structures;

import java.io.Serializable;

public class Node<T extends Comparable<T>> implements Serializable{
    Node<T> leftNode;
    Node<T> rightNode;
    T data;
    int height;

    public Node(T data, Node<T> leftNode, Node<T> rightNode){
        //TODO
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int calculateBalanceFactor(){
        //TODO
        return 0;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public int getHeight() {
        return height;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
