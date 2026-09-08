package com.practice.algorithms.searching;

/** O(log n) search over a sorted array. */
public class BinarySearch {

    /** Returns the index of target, or -1 if not found. */
    public static int search(int[] sortedArray, int target) {
        int lo = 0;
        int hi = sortedArray.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (sortedArray[mid] == target) {
                return mid;
            } else if (sortedArray[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sorted = {1, 3, 4, 9, 10, 18, 29, 33, 55, 71};
        System.out.println("index of 29: " + search(sorted, 29));
        System.out.println("index of 2:  " + search(sorted, 2));
    }
}
