package org.example;

class Node <U> {
    public U data;
    public Node<U> next;

    public Node(U data) {
        this.data = data;
        this.next = null;
    }
}

public class Linkedlist<U> {
    public Node<U> head;
    public Node<U> tail;
    public int size;

    public Linkedlist() {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(U data) {
        Node<U> node = new Node<U>(data);
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    public void addLast(U data) {
        Node<U> node = new Node<U>(data);
        node.next = null;

        if (this.head == null) {
            this.head = node;
            this.size++;
        }

        else {
            Node<U> current = this.head;

            while (current.next != null)
                current = current.next;

            current.next = node;
            this.size++;
        }
    }

    public void deleteFirst() {
        if (this.head != null) {
            this.head = this.head.next;
            this.size--;
        }

        else
            System.out.println("LinkedList is empty");
    }

    public void deleteLast() {
        if (this.head == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        else if (this.head.next == null) {
            this.head = null;
            this.size--;
        }

        else {
            Node<U> current = this.head;

            while (current.next.next != null)
                current = current.next;

            current.next = null;
            this.size--;
        }
    }

    public void deleteNode(U value) {
        if (this.head == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        else if (this.head.data == value) {
            this.head = this.head.next;
            this.size--;
        }

        else {
            Node<U> current = this.head;

            while (current.next != null) {
                if (current.next.data == value) {
                    current.next = current.next.next;
                    this.size--;
                    break;
                }

                else
                    current = current.next;
            }
        }
    }

    public int size() {
        return this.size;
    }

    public void printLinkedList() {
        Node<U> current = this.head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.print("\n");
    }

    private class LinkedListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public LinkedListIterator(Node<T> head) {

            current = head;
        }

        @Override
        public boolean hasNext() {

            return current != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T data = current.data;
                current = current.next;
                return data;
            }

            return null;
        }
    }

    public Iterator<U> iterator() {
        return new LinkedListIterator<U>(this.head);
    }
}
