package com.practice.datastructures.linkedlist;

public class SinglyLinkedList<T> {

    private static class Node<T> {
        T value;
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

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            throw new java.util.NoSuchElementException("list is empty");
        }
        T value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (java.util.Objects.equals(current.value, value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        tail = head;
        while (current != null) {
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        System.out.println("list: " + list);
        System.out.println("contains 2: " + list.contains(2));

        list.reverse();
        System.out.println("reversed: " + list);

        System.out.println("removeFirst: " + list.removeFirst());
        System.out.println("after removeFirst: " + list);
        System.out.println("size: " + list.size());
    }
}
