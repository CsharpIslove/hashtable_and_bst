package com.company;

public class MyHashTable <K, V>{
    private class HashNode<K, V>{
        private K key;
        private V value;
        HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] buckets;
    private int M;
    private int size;

    public MyHashTable(){
        this(11);
    }

    public MyHashTable(int M){
        this.M = M;
        this.buckets = new HashNode[M];
        this.size = 0;
    }

    private int hash(K key){
        return (int) key % buckets.length;
    }

    public void put(K key, V value){
        int index = hash(key);
        HashNode head = buckets[index];
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[index];
        HashNode node = new HashNode(key, value);
        node.next = head;
        buckets[index] = node;
    }

    public V get(K key){
        int index = hash(key);
        HashNode head = buckets[index];
        while(head != null){
            if(head.key.equals(key)){
                return (V) head.value;
            }
            head = head.next;
        }

        return null;
    }

    public V remove(K key){
        int index = hash(key);
        HashNode head = buckets[index];
        HashNode prev = null;

        while(head != null){
            if(head.key.equals(key)){
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head == null) {
            return null;
        }
        size--;
        if(prev != null){
            prev.next = head.next;
        } else{
            buckets[index] = head.next;
        }
        return (V) head.value;
    }

    public boolean contains(V value){
        for(int i = 0; i < buckets.length-1; i++){
            HashNode head = buckets[i];
            while(head != null){
                if(head.value.equals(value)){
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    public K getkey(V value){
        for(int i = 0; i < buckets.length-1; i++){
            HashNode head = buckets[i];
            while(head != null){
                if(head.value.equals(value)){
                    return (K) head.key;
                }
                head = head.next;
            }
        }
        return null;
    }

}
