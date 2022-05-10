package com.company;

public class BST <K extends Comparable<K>, V>{
    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val){
        Node node = new Node(key, val);
        if(root == null){
            root = node;
        }else{
            Node currentNode = root;
            while(true){
                if((Integer) key < (Integer) currentNode.key){
                    currentNode = currentNode.left;
                    if(currentNode == null){
                        currentNode = node;
                        return;
                    }
                }
                else{
                    currentNode = currentNode.right;
                    if(currentNode == null){
                        currentNode = node;
                        return;
                    }
                }
            }
        }
    }
    public V get(K key){return null;}
    public void delete(K key){}
    public Iterable<K> iterator(){return null;}
}
