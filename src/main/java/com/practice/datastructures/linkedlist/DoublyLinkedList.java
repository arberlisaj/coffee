package com.practice.datastructures.linkedlist;

public class DoublyLinkedList<T> {

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int size() {
        return size;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (tail == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T removeLast() {
        if (tail == null) {
            throw new java.util.NoSuchElementException("list is empty");
        }
        T value = tail.value;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return value;
    }

    public String toStringForward() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(" <-> ");
            current = current.next;
        }
        return sb.append("]").toString();
    }

    public String toStringBackward() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = tail;
        while (current != null) {
            sb.append(current.value);
            if (current.prev != null) sb.append(" <-> ");
            current = current.prev;
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addLast("b");
        list.addLast("c");
        list.addFirst("a");
        System.out.println("forward:  " + list.toStringForward());
        System.out.println("backward: " + list.toStringBackward());

        System.out.println("removeLast: " + list.removeLast());
        System.out.println("forward after removeLast: " + list.toStringForward());
        System.out.println("size: " + list.size());
    }
}
