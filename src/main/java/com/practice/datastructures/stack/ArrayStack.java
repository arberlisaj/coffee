package com.practice.datastructures.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/** LIFO stack backed by a resizable array. */
public class ArrayStack<T> {

    private Object[] elements = new Object[8];
    private int size;

    public void push(T value) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T value = (T) elements[--size];
        elements[size] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (T) elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("size: " + stack.size());
    }
}
