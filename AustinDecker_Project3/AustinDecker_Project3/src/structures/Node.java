package structures;

import java.io.Serializable;
/***
 * Node class used for AVLTree to hold generic objects.
 */
public class Node<T extends Comparable<T>> implements Serializable{
    private Node<T> leftNode;
    private Node<T> rightNode;
    private T data;
    private int height = 0;

    public Node(T data, Node<T> leftNode, Node<T> rightNode){
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
    /**
     * gets the data the node object holds
     * @return T obj
     */
    public T getData() {return data;}

    /***
     * gets the left Node<T> object
     * @return Node<T> 
     */
    public Node<T> getLeftNode() {return leftNode;}

    /***
     * gets the right Node<T> object
     * @return Node<T> 
     */
    public Node<T> getRightNode() {return rightNode;}

    /***
     * returns the height of the node
     * @return int
     */
    public int getHeight() {return this.height;}

    /**
     * sets the data the Node<T> holds
     * @param data
     */
    public void setData(T data) {this.data = data;}

    /**
     * sets the left Node<T> of Node<T>
     * @param leftNode
     */
    public void setLeftNode(Node<T> leftNode) {this.leftNode = leftNode;}

    /**
     * sets the right node of Node<T>
     * @param rightNode
     */
    public void setRightNode(Node<T> rightNode) {this.rightNode = rightNode;}

    /**
     * sets the height of the node
     * @param height
     */
    public void setHeight(int height) {this.height = height;}

    /**
     * returns true if the node is a leaf node and false otherwise.
     * @return boolean
     */
    public boolean isLeaf(){return (leftNode == null && rightNode == null);}

}
