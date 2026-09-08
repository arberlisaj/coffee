package com.practice.datastructures.queue;

import java.util.NoSuchElementException;

/** FIFO queue backed by a circular resizable array. */
public class ArrayQueue<T> {

    private Object[] elements = new Object[8];
    private int head;
    private int size;

    public void enqueue(T value) {
        if (size == elements.length) {
            resize();
        }
        int tail = (head + size) % elements.length;
        elements[tail] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("queue is empty");
        }
        T value = (T) elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("queue is empty");
        }
        return (T) elements[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] bigger = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            bigger[i] = elements[(head + i) % elements.length];
        }
        elements = bigger;
        head = 0;
    }

    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        System.out.println("peek: " + queue.peek());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("size: " + queue.size());
    }
}
