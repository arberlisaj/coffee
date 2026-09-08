package com.practice;

/**
 * Entry point. Each data structure / algorithm package also has its own
 * class with a main() method, so you can run them individually:
 *
 *   mvn compile exec:java -Dexec.mainClass="com.practice.algorithms.sorting.MergeSort"
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("DSA practice project");
        System.out.println("Run an individual structure/algorithm with:");
        System.out.println("  mvn compile exec:java -Dexec.mainClass=\"com.practice.<package>.<ClassName>\"");
        System.out.println();
        System.out.println("Available classes:");
        System.out.println("  com.practice.datastructures.linkedlist.SinglyLinkedList");
        System.out.println("  com.practice.datastructures.linkedlist.DoublyLinkedList");
        System.out.println("  com.practice.datastructures.stack.ArrayStack");
        System.out.println("  com.practice.datastructures.queue.ArrayQueue");
        System.out.println("  com.practice.datastructures.tree.BinarySearchTree");
        System.out.println("  com.practice.algorithms.sorting.BubbleSort");
        System.out.println("  com.practice.algorithms.sorting.MergeSort");
        System.out.println("  com.practice.algorithms.sorting.QuickSort");
        System.out.println("  com.practice.algorithms.searching.BinarySearch");
    }
}
