package com.practice.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    @Test
    void sortsRandomOrderArray() {
        int[] input = {5, 3, 8, 1, 9, 2};
        MergeSort.sort(input);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9}, input);
    }

    @Test
    void handlesEmptyAndSingleElementArrays() {
        int[] empty = {};
        MergeSort.sort(empty);
        assertArrayEquals(new int[]{}, empty);

        int[] single = {42};
        MergeSort.sort(single);
        assertArrayEquals(new int[]{42}, single);
    }
}
