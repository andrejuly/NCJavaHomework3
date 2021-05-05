package com.ulyanovcompany;


import com.ulyanovcompany.mylinkedlist.MyLinkedList;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        //testMyLinkedList();
        //TestCollection.compareMyLinkedListAndStandardLinkedList();
        //TestCollection.testList();
        TestCollection.testSet();
    }

    public static void testMyLinkedList() {
        System.out.println("Test MyLinkedList:");
        MyLinkedList<Integer> list = new MyLinkedList<>();

        System.out.println();
        System.out.println("Size of list: " + list.size());

        list.add(0, 341);
        list.add( -4);
        list.add(132);
        list.add(13);
        list.add(0, -1323);
        list.add(1333);
        list.add(-321);
        list.add(56);
        list.add(3);
        list.add(3, -1);
        list.add(4, 1);
        list.add(777);
        list.add(666);
        list.add(555);
        //list.add(null);

        System.out.println();
        System.out.println(list.toString());
        System.out.println("Size = " + list.size());

        System.out.println("Pos element(777): " + list.indexOf(777));
        System.out.println("Pos element(1333): " + list.indexOf(1333));

        System.out.println();
        System.out.println("Remove element index = 7: " + list.remove(7));
        System.out.println();
        System.out.println(list.toString());
        System.out.println("Size = " + list.size());

        System.out.println("Remove element index = 3: " + list.remove(3));
//        System.out.println("Remove element index = 33: " + list.remove(33));
        System.out.println();
        System.out.println(list.toString());
        System.out.println("Size = " + list.size());

        System.out.println("Change element with index = 3. New element = 100");
        list.set(3, 100);
        System.out.println();
        for (Integer i: list) {
            System.out.println(i);
        }

        System.out.println();
        System.out.println("Size = " + list.size());

        System.out.println("Element with index = 4" + list.get(4));
        System.out.println("Element with index = 0" + list.get(0));
        System.out.println();

        Integer[] array = new Integer[list.size()];
        list.toArray(array);
        System.out.println("toArray: " + Arrays.toString(array));

        System.out.println("Clearing list");
        list.clear();
        System.out.println("Size = " + list.size());
        System.out.println("Print list");
        System.out.println(list.toString());
        System.out.println();
        System.out.println();
    }
}
