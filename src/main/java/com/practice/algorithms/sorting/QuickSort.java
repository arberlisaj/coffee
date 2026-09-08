package com.practice.algorithms.sorting;

import java.util.Arrays;

/** Average O(n log n) in-place sort using Lomuto partitioning. */
public class QuickSort {

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) return;
        int pivotIndex = partition(array, lo, hi);
        sort(array, lo, pivotIndex - 1);
        sort(array, pivotIndex + 1, hi);
    }

    private static int partition(int[] array, int lo, int hi) {
        int pivot = array[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, hi);
        return i;
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        int[] data = {33, 10, 55, 71, 29, 3, 18};
        System.out.println("before: " + Arrays.toString(data));
        sort(data);
        System.out.println("after:  " + Arrays.toString(data));
    }
}
