package org.example;

import java.util.*;
public class Main {
    public static void main(String[] args) {

        Myset set = new Myset();
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);
        System.out.println(set);
        System.out.println(set.contains(11));
        System.out.println(set.contains(5));
        System.out.println(set.get(5));
        System.out.println(set.getArrayList());
        System.out.println(set.headSet(7));
        System.out.println(set.tailSet(7));
        System.out.println(set.subSet(7,9));
    }

}

class Myset {
    private HashMap<Integer, Object> values = new HashMap<>();
    private static final Object X = new Object();

    void add(int data) {
        values.put(data, X);
    }

    public String toString() {
        return values.keySet().toString();
    }

    Boolean contains(int data) {
        return values.containsKey(data);
    }

    void clear() {
        values.clear();
    }

    void remove(int data) {
        values.remove(data);
    }

    int size() {
        return values.size();
    }

    int get(int ind) {
        return (int) values.keySet().toArray()[ind];
    }

    ArrayList getArrayList() {
        ArrayList<Integer> res = new ArrayList<>();
        values.forEach((k, v) -> res.add(k));
        return res;
    }

    Myset headSet(int data){
        Myset res = new Myset();
        for (int el: values.keySet()) {
            res.add(el);
            if (data == el)
                break;
        }
        return res;
    }

    Myset tailSet(int data){
        boolean ad = false;
        Myset res = new Myset();
        for (int el: values.keySet()) {
            if (data == el)
                ad = true;
            if (ad) {
                res.add(el);}
        }
        return res;
    }

    Myset subSet (int key1, int key2){
        Myset res = new Myset();
        boolean ad = false;
        for (int el: values.keySet()) {
            if ((el == key1 || el == key2) && !ad){
                ad = true;
                res.add(el);
                continue;
            }
            if ((el == key1 || el == key2) && ad){
                res.add(el);
                break;}
            else if (ad) res.add(el);
        }
        return res;
    }

}