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
        Node<T> delNode = findNodeWithData(data);

        if(delNode == null)
            System.out.println("the data to be deleted does not exist.");
        else{
            root = delete(root, delNode);
            return root;
        }
        return null;
    }

    public Node<T> findNodeWithData(T data){
        return binarySearch(root, data);
    }

    public void printTreeDiagram(){
        //TODO
    }

    @Override
    public String toString(){
        return toStringPreOrderHelper(root, "");
    }

    private Node<T> binarySearch(Node<T> root, T target){
        if(root == null){
            return null;
        }

        if(root.getData().equals(target)){
            return root;
        }
        else if(root.getData().compareTo(target) > 0){
            return binarySearch(root.getLeftNode(), target);
        }
        else{
            return binarySearch(root.getRightNode(), target);
        } 
    }

    private String inOrderTraversal(Node<T> root){
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

    private Node<T> determineRotation(Node<T> node){
        //left-left
        if(calculateBalanceFactor(node) > 1){
            //left-right
            if(calculateBalanceFactor(node.getLeftNode()) < 0)
                node.setLeftNode(leftRotation(node.getLeftNode()));
            return rightRotation(node);
        }
        //right-right
        else if(calculateBalanceFactor(node) < -1){
            //right-left
            if(calculateBalanceFactor(node.getRightNode()) > 0)
                node.setRightNode(rightRotation(node.getRightNode()));
            return leftRotation(node);
        }
        else
            return node;
    }

    private Node<T> insert(Node<T> root, Node<T> data){
        if(root == null){
            return data;
        }
        else if(data.getData().compareTo(root.getData()) < 0){
            root.setLeftNode(insert(root.getLeftNode(), data));
        }
        else if(data.getData().compareTo(root.getData()) > 0){
            root.setRightNode(insert(root.getRightNode(), data));
        }
        updateHeight(root);
        return determineRotation(root);
    }

    private Node<T> delete(Node<T> root, Node<T> targetNode){
        //TODO
        if(root == null)
            return null;

        if(root.getData().compareTo(targetNode.getData()) > 0){
            root.setLeftNode(delete(root.getLeftNode(), targetNode));
        }
        else if(root.getData().compareTo(targetNode.getData()) < 0){
            root.setRightNode(delete(root.getRightNode(), targetNode));
        }
        else{
            if(root.getLeftNode() == null)
                return root.getRightNode();
            else if(root.getRightNode() == null)
                return root.getLeftNode();
            //LOOK HERE -------- THIS IS WRONG AND INCOMPLETE, COME BACK TO FIX LATER
            root = getMax(root.getLeftNode());
            root.setLeftNode(delete(root.getLeftNode(), root));
        }
        updateHeight(root);
        determineRotation(root);
        return null;
    }

    private Node<T> getMax(Node<T> root) {
        Node<T> cursor = root;
        while(cursor.getRightNode() != null){
            cursor = cursor.getRightNode();
        }
        return cursor;
    }

    private Node<T> getMin(Node<T> root){
        Node<T> cursor = root;
        while(cursor.getLeftNode() != null){
            cursor = cursor.getLeftNode();
        }
        return cursor;
    }

    private String toStringPreOrderHelper(Node<T> root, String contents){
        String avlString = contents;

        avlString = avlString + " " + root.getData().toString();
        if(root.getLeftNode() != null)
            avlString = toStringPreOrderHelper(root.getLeftNode(), avlString);
        if(root.getRightNode() != null)
            avlString = toStringPreOrderHelper(root.getRightNode(), avlString);
        return avlString;
    }
}
