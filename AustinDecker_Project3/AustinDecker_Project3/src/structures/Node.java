package structures;

import java.io.Serializable;

public class Node<T extends Comparable<T>> implements Serializable{
    Node<T> leftNode;
    Node<T> rightNode;
    T data;
    int height = 0;

    public Node(T data, Node<T> leftNode, Node<T> rightNode){
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
        return this.height;
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

    public boolean isLeaf(){
        return (leftNode == null && rightNode == null);
    }

    public int calculateNewHeight() {
        //TODO
        int leftNodeHeight = 0;
        int rightNodeHeight = 0;

        if(this.isLeaf()){
            return 0;
        }
        else{
            if(this.leftNode != null){
                leftNodeHeight = 1 + this.leftNode.getHeight();
            }

            if(this.rightNode != null){
                rightNodeHeight = 1 + this.rightNode.getHeight();
            }
            int updatedHeight = Math.max(leftNodeHeight, rightNodeHeight);
            this.height = updatedHeight;
            return updatedHeight;
        }
    }

}
