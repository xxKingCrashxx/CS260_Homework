package structures;

import java.io.Serializable;

public class AVLTree<T extends Comparable<T>> implements Serializable{
    Node<T> root;

    public AVLTree(){
        root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    //insert node
    public void addNode(Node<T> data){
       root = insert(root, data);
    }

    //delete node
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

    private void updateHeight(Node<T> node){
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
    }

    private Node<T> leftRotation(Node<T> root){
        Node<T> newRoot = root.getRightNode();
        root.setRightNode(newRoot.getLeftNode());
        newRoot.setLeftNode(root);

        //update height
        updateHeight(root);
        updateHeight(newRoot);
        return newRoot;
    }

    private Node<T> rightRotation(Node<T> root){
        Node<T> newRoot = root.getLeftNode();
        root.setLeftNode(newRoot.getRightNode());
        newRoot.setRightNode(root);

        //update height
        updateHeight(root);
        updateHeight(newRoot);
        return newRoot;
    }

    private Node<T> insert(Node<T> root, Node<T> data){
        //TODO
        if(root == null){
            return data;
        }
        else if(data.getData().compareTo(root.getData()) < 0){
            root.setLeftNode(insert(root.getLeftNode(), data));
            if(calculateBalanceFactor(root) == 2){

            }
        }
        else if(data.getData().compareTo(root.getData()) > 0){
            root.setRightNode(insert(root.getRightNode(), data));
        }
        else;
        updateHeight(root);
        return root;
    }


}
