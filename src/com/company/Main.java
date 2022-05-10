package com.company;

public class Main {

    public static void main(String[] args) {
        MyHashTable<Integer, String> hst = new MyHashTable<>(10);
        hst.put(27, "Tom");
        hst.put(21, "Som");
        hst.put(31, "abbb");
        System.out.println(hst.getkey("abbb"));
        System.out.println(hst.get(31));
    }
}
