package org.example;

public class Double<E> {
    class Node<U> {
        public U data;
        public Node<U> prev;
        public Node<U> next;

        public Node(U data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public Node<E> head;
    public Node<E> tail;
    public int size = 0;

    public Double() {
        this.head = new Node<E>(null);
        this.head.prev = null;
        this.head.next = null;

        this.tail = new Node<E>(null);
        this.tail.prev = this.head;
        this.tail.next = null;

        this.head.next = this.tail;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E getFirst() {
        return isEmpty() ? null : this.head.next.data;
    }

    public E getLast() {
        return isEmpty() ? null : this.tail.prev.data;
    }

    public void addBetween(E data, Node<E> prevNode, Node<E> nextNode) {
        Node<E> node = new Node<E>(data);
        node.prev = prevNode;
        node.next = nextNode;

        prevNode.next = node;
        nextNode.prev = node;
        this.size++;
    }

    public void addFirst(E data) {
        addBetween(data, this.head, this.head.next);    // head is last node and header.next is the first node
    }

    public void addLast(E data) {
        addBetween(data, this.tail.prev, this.tail);    // adding a new node between previous node of tail and tail node
    }

    public E remove(Node<E> node) {
        Node<E> prevNode = node.prev;       // 2
        Node<E> nextNode = node.next;       // 4

        prevNode.next = nextNode;       // 2.next = 4
        nextNode.prev = prevNode;       // 4.prev = 2
        this.size--;

        return node.data;
    }

    // head.next is the first node and tail.prev is the last node
    public E removeFirst() {
        if (isEmpty())
            return null;

        return remove(this.head.next);      // head.next is the first node
    }

    public E removeLast() {
        if (isEmpty())
            return null;

        return remove(this.tail.prev);      // tail.prev is the last node
    }

    public void printLinkedList() {
        if (this.size == 0)
            return;

        else {
            Node<E> current = this.head.next;

            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current.next != null);

            System.out.print("\n");
        }
    }

    private class DIterator<T> implements Iterator<T> {
        private Node<T> current;

        public DIterator(Node<T> head) {
            current = head.next;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
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

    public Iterator<E> iterator()
    {
        return new DIterator<E>(this.head);
    }
}
