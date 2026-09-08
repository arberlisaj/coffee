package com.practice.algorithms.sorting;

import java.util.Arrays;

/** O(n log n) divide-and-conquer sort. */
public class MergeSort {

    public static void sort(int[] array) {
        if (array.length < 2) return;
        int[] buffer = new int[array.length];
        sort(array, buffer, 0, array.length - 1);
    }

    private static void sort(int[] array, int[] buffer, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(array, buffer, lo, mid);
        sort(array, buffer, mid + 1, hi);
        merge(array, buffer, lo, mid, hi);
    }

    private static void merge(int[] array, int[] buffer, int lo, int mid, int hi) {
        System.arraycopy(array, lo, buffer, lo, hi - lo + 1);

        int left = lo;
        int right = mid + 1;
        int i = lo;

        while (left <= mid && right <= hi) {
            array[i++] = buffer[left] <= buffer[right] ? buffer[left++] : buffer[right++];
        }
        while (left <= mid) {
            array[i++] = buffer[left++];
        }
        while (right <= hi) {
            array[i++] = buffer[right++];
        }
    }

    public static void main(String[] args) {
        int[] data = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("before: " + Arrays.toString(data));
        sort(data);
        System.out.println("after:  " + Arrays.toString(data));
    }
}
