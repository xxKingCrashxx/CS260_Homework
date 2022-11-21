package structures;

import java.io.Serializable;

public class AVLTree<T extends Comparable<T>> implements Serializable{
    Node<T> root;

    public AVLTree(){
        root = null;
    }

    
    /**
     * Returns the Node<T> object which represents the root of the AVLTree.
     * @return Node<T>
     */
    public Node<T> getRoot() {
        return root;
    }

    
    /** 
     * Sets the root of the AVLTree
     * @param root
     */
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    
    /**
     * Adds a new node to the AVLTree
     * @param data
     */
    //insert node
    public void addNode(Node<T> data){
       root = insert(root, data);
    }

    
    /**
     * Removes a node with the specified T data that it holds.
     * @param data
     */
    //delete node
    public void removeNodeWithData(T data){
        Node<T> delNode = findNodeWithData(data);
        root = delete(root, delNode);
    }

    
    /** 
     * Does a binary search for the node that has T data.
     * Returns the Node holding the data if found and null otherwise.
     * @param data
     * @return Node<T>
     */
    public Node<T> findNodeWithData(T data){
        return binarySearch(root, data);
    }

    
    /** 
     * returns true if the root Node is null.
     * @return boolean
     */
    public boolean isEmpty(){
        return root == null ? true:false;
    }

    public void printTreeDiagram(){
        printHelper(root, "", true);
    }

    
    /** 
     * Returns a string representation of the AVLTree in PreOrder form.
     * @return String
     */
    @Override
    public String toString(){
        return toStringPreOrderHelper(root, new StringBuilder(""));
    }

    
    /** 
     * @param root
     * @param target
     * @return Node<T>
     */
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

    
    /** 
     * @param root
     * @param string
     * @return String
     */
    private String inOrderTraversal(Node<T> root, StringBuilder string){
        if(root != null){
            inOrderTraversal(root.getLeftNode(), string);
            string.append(root.getData().toString() + " ");
            inOrderTraversal(root.getRightNode(), string);
        }
        return string.toString();
    }

    
    /** 
     * @param node
     * @return int
     */
    private int calculateBalanceFactor(Node<T> node){
        return node == null ? -1 : height(node.getLeftNode()) - height(node.getRightNode());
    }

    
    /** 
     * @param node
     * @return int
     */
    private int height(Node<T> node){
        return node == null ? -1: node.getHeight();
    }

    
    /** 
     * @param node
     */
    private void updateHeight(Node<T> node){
        if(node != null)
            node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
    }

    
    /** 
     * @param root
     * @return Node<T>
     */
    private Node<T> leftRotation(Node<T> root){
        Node<T> newRoot = root.getRightNode();
        root.setRightNode(newRoot.getLeftNode());
        newRoot.setLeftNode(root);

        updateHeight(root);
        updateHeight(newRoot);
        return newRoot;
    }

    
    /** 
     * @param root
     * @return Node<T>
     */
    private Node<T> rightRotation(Node<T> root){
        Node<T> newRoot = root.getLeftNode();
        root.setLeftNode(newRoot.getRightNode());
        newRoot.setRightNode(root);

        updateHeight(root);
        updateHeight(newRoot);
        return newRoot;
    }

    
    /** 
     * @param node
     * @return Node<T>
     */
    private Node<T> determineRotation(Node<T> node){
        if(calculateBalanceFactor(node) > 1){
            if(calculateBalanceFactor(node.getLeftNode()) < 0)
                node.setLeftNode(leftRotation(node.getLeftNode()));
            return rightRotation(node);
        }
        else if(calculateBalanceFactor(node) < -1){
            if(calculateBalanceFactor(node.getRightNode()) > 0)
                node.setRightNode(rightRotation(node.getRightNode()));
            return leftRotation(node);
        }
        else
            return node;
    }

    
    /** 
     * @param root
     * @param data
     * @return Node<T>
     */
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

    
    /** 
     * @param root
     * @param targetNode
     * @return Node<T>
     */
    private Node<T> delete(Node<T> root, Node<T> targetNode){
        if(root == null)
            return null;

        if(root.getData().compareTo(targetNode.getData()) > 0){
            root.setLeftNode(delete(root.getLeftNode(), targetNode));
        }
        else if(root.getData().compareTo(targetNode.getData()) < 0){
            root.setRightNode(delete(root.getRightNode(), targetNode));
        }
        else{
            Node<T> tempNode;
            if(root.getLeftNode() == null && root.getRightNode() == null){
                root = null;
            }
            else if(root.getLeftNode() == null){
                tempNode = root;
                root = root.getRightNode();
            }
            else if(root.getRightNode() == null){
                tempNode = root;
                root = root.getLeftNode();
            }
            else{
                tempNode = getMax(root.getLeftNode());
                root.setData(tempNode.getData());
                root.setLeftNode(delete(root.getLeftNode(), tempNode));

            }
        }
        updateHeight(root);
        return determineRotation(root);
    }

    
    /** 
     * @param root
     * @return Node<T>
     */
    private Node<T> getMax(Node<T> root) {
        Node<T> cursor = root;
        while(cursor.getRightNode() != null){
            cursor = cursor.getRightNode();
        }
        return cursor;
    }

    
    /** 
     * @param currentNode
     * @param string
     * @return String
     */
    private String toStringPreOrderHelper(Node<T> currentNode, StringBuilder string){

        if(currentNode != null){
            string.append(currentNode.getData().toString() + " ");
            if(currentNode.getLeftNode() != null)
                toStringPreOrderHelper(currentNode.getLeftNode(), string);
            if(currentNode.getRightNode() != null)
                toStringPreOrderHelper(currentNode.getRightNode(), string);
        }
        return string.toString();
    }

    
    /** 
     * @param root
     * @param indent
     * @param last
     */
    private void printHelper(Node<T> root, String indent, boolean last) {
		
	   	if (root != null) {
		   System.out.print(indent);
		   if (last) {
		      System.out.print("R----");
		      indent += "     ";
		   } else {
		      System.out.print("L----");
		      indent += "|    ";
		   }

		   System.out.println(root.getData().toString());

		   printHelper(root.getLeftNode(), indent, false);
		   printHelper(root.getRightNode(), indent, true);
		}
	}
}
