package com.ulyanovcompany;

import com.ulyanovcompany.mylinkedlist.MyLinkedList;
import com.ulyanovcompany.mylinkedlist.MyPoint;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class TestCollection {

    public static void compareMyLinkedListAndStandardLinkedList() {
        System.out.println("Compare MyLinkedList and StandardLinkedList:");
        System.out.println();
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        long startAddToMyList = System.nanoTime();
        for (int i = 0; i <= 100000; i++) {
            myLinkedList.add(i);
        }
        long addToMyListTime = System.nanoTime() - startAddToMyList;


        LinkedList<MyPoint> standardLinkedList = new LinkedList<>();
        long startAddToStandardList = System.nanoTime();
        for (int i = 0; i <= 100000; i++) {
            standardLinkedList.add(new MyPoint(new Random().nextInt(10), new Random().nextInt(10)));
        }

        long addToStandardListTime = System.nanoTime() - startAddToStandardList;
        System.out.println("Time of adding element to myLinkedList: " + addToMyListTime);
        System.out.println("Time of adding element to standard list: " + addToStandardListTime);


        long startFindToMyList = System.nanoTime();
        myLinkedList.indexOf(new MyPoint(new Random().nextInt(10), new Random().nextInt(10)));
        long findToMyListTime = System.nanoTime() - startFindToMyList;

        long startFindInStandardList = System.nanoTime();
        standardLinkedList.indexOf(new MyPoint(new Random().nextInt(10), new Random().nextInt(10)));
        long findStandardListTime = System.nanoTime() - startFindInStandardList;

        System.out.println("Time of finding element in myLinkedList: " + findToMyListTime);
        System.out.println("Time of finding element in standardLinkedList: " + findStandardListTime);


        long startDeleteElementInMyList = System.nanoTime();
        myLinkedList.remove(myLinkedList.size() / 4);
        long deleteInMyListTime = System.nanoTime() - startDeleteElementInMyList;

        long startDeleteElementInStandardList = System.nanoTime();
        standardLinkedList.remove(myLinkedList.size() / 4);
        long deleteInStandardListTime = System.nanoTime() - startDeleteElementInStandardList;

        System.out.println("Time of deleting element in myLinkedList: " + deleteInMyListTime);
        System.out.println("Time of deleting element in standardLinkedList: " + deleteInStandardListTime);
        System.out.println();
        System.out.println();
    }

    public static void testList() {
        final int toMiele = 10000;
        System.out.println("Test ArrayList and LinkedList:");
        System.out.println();
        ArrayList<Integer> arrayList = new ArrayList<>();
        long startAddToArrayList = System.nanoTime();
        int i1 = 1000000;
        for (int i = 0; i <= i1; i++) {
            arrayList.add(new Random().nextInt(i1));
        }
        long addTimeToArrayList = System.nanoTime() - startAddToArrayList;
        System.out.println("Add to arrayList time: " + (double) addTimeToArrayList / toMiele);

        LinkedList<Integer> linkedList = new LinkedList<>();
        long startAddToLinkedList = System.nanoTime();
        for (int i = 0; i <= i1; i++) {
            linkedList.add(new Random().nextInt(i1));
        }
        long addTimeToLinkedList = System.nanoTime() - startAddToLinkedList;
        System.out.println("Add to linkedList time: " + (double) addTimeToLinkedList / toMiele);

        int indexSearchElem = new Random().nextInt(i1);
        long startSearchArrayList = System.nanoTime();
        arrayList.indexOf(indexSearchElem);
        long searchTimeArrayList = System.nanoTime() - startSearchArrayList;
        System.out.println("Search in arrayList time: " + (double) searchTimeArrayList / toMiele);

        long startSearchLinkedList = System.nanoTime();
        linkedList.indexOf(indexSearchElem);
        long searchTimeLinkedList = System.nanoTime() - startSearchLinkedList;
        System.out.println("Search in linkedList time: " + (double) searchTimeLinkedList / toMiele);

        int indexDeleteElem = new Random().nextInt(i1);
        long startDeleteArrayList = System.nanoTime();
        arrayList.remove(indexDeleteElem);
        long deleteTimeArrayList = System.nanoTime() - startDeleteArrayList;
        System.out.println("Delete element in arrayList time: " + (double) deleteTimeArrayList / toMiele);

        long startDeleteLinkedList = System.nanoTime();
        linkedList.remove(indexDeleteElem);
        long deleteTimeLinkedList = System.nanoTime() - startDeleteLinkedList;
        System.out.println("Delete element in linkedList time: " + (double) deleteTimeLinkedList / toMiele);
    }

    public static void testSet() {
        final int toMiele = 10000;
        System.out.println("Test ArrayList and LinkedList:");
        System.out.println();
        Set<Integer> set = new HashSet<>();
        HashSet<Integer> lset = new LinkedHashSet<>();
        TreeSet<Integer> tset = new TreeSet<>();

        long startAddToHashSet = System.nanoTime();
        int i1 = 100000;
        for (int i = 0; i <= i1; i++) {
            set.add(new Random().nextInt(i1));
        }
        long addTimeToArrayList = System.nanoTime() - startAddToHashSet;
        System.out.println("Add to HashSet time: " + (double) addTimeToArrayList / toMiele);

        long startAddToLinkedHashSet = System.nanoTime();
        for (int i = 0; i <= i1; i++) {
            lset.add(new Random().nextInt(i1));
        }
        long addTimeToLinkedHashSet = System.nanoTime() - startAddToLinkedHashSet;
        System.out.println("Add to LinkedHashSet time: " + (double) addTimeToLinkedHashSet / toMiele);

        long startAddToTS = System.nanoTime();
        for (int i = 0; i <= i1; i++) {
            tset.add(new Random().nextInt(i1));
        }
        long addTimeToTS = System.nanoTime() - startAddToTS;
        System.out.println("Add to TreeSet time: " + (double) addTimeToTS / toMiele);

        int indexDeleteElem = new Random().nextInt(i1);
        long start = System.nanoTime();
        for (int i = 0; i <= i1; i++) {
            set.remove(indexDeleteElem);
        }
        long end = System.nanoTime();
        System.out.println("Delete element in HashSet time: " + (double)((end - start) / toMiele));

        start = System.nanoTime();
        for (int i = 0; i <= i1; i++) {
            lset.remove(indexDeleteElem);
        }
        end = System.nanoTime();
        System.out.println("Delete element in LinkedHashSet time: " + (double)((end - start) / toMiele));

        start = System.nanoTime();
        for (int i = 0; i <= i1; i++) {
            tset.remove(indexDeleteElem);
        }
        end = System.nanoTime();
        System.out.println("Delete element in TreeSet time: " + (double)((end - start) / toMiele));

        int indexFindElem = new Random().nextInt(i1);
        start = System.nanoTime();
        for (int i = 0; i <= i1; i++) {
            set.contains(indexFindElem);
        }
        end = System.nanoTime();
        System.out.println("Find element in HashSet time: " + (double)((end - start) / toMiele));

        start = System.nanoTime();
        for (int i = 0; i <= i1; i++) {
            lset.contains(indexFindElem);
        }
        end = System.nanoTime();
        System.out.println("Find element in LinkedHashSet time: " + (double)((end - start) / toMiele));

        start = System.nanoTime();
        for (int i = 0; i <= i1; i++) {
            tset.contains(indexFindElem);
        }
        end = System.nanoTime();
        System.out.println("Find element in TreeSet time: " + (double)((end - start) / toMiele));

    }

    public static void testMap() {

    }


}
