package structures;

import java.io.Serializable;

public class AVLTree<T extends Comparable<T>> implements Serializable{
    Node<T> root;

    public AVLTree(Node<T> root){
        //TODO
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void addNode(Node<T> data){
        //TODO
    }

    public Node<T> removeNodeWithData(T data){
        //TODO
        return null;
        
    }

    public Node<T> findNodeWithData(T data){
        //TODO
        return null;
    }

    public void printTreeDiagram(){
        //TODO
    }

    @Override
    public String toString(){
        //TODO
        return null;
    }

    public static Node<?> binarySearch(Node<?> root){
        //TODO
        return null;
    }

    public static String inOrderTraversal(Node<?> root){
        //TODO
        return null;
    }

    private int calculateBalanceFactor(Node<T> node){
        int balanceFactor = height(node.getLeftNode()) - height(node.getRightNode());
        return balanceFactor;
    }
    private int height(Node<T> node){
        if(node == null)
            return -1;
        else
            return node.getHeight();
    }

}
