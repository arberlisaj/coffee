package com.practice.algorithms.sorting;

import java.util.Arrays;

/** O(n^2) comparison sort. Good baseline before tackling merge/quick sort. */
public class BubbleSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 2, 9, 1, 5, 6};
        System.out.println("before: " + Arrays.toString(data));
        sort(data);
        System.out.println("after:  " + Arrays.toString(data));
    }
}
