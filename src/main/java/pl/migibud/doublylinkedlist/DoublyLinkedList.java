package pl.migibud.doublylinkedlist;

class DoublyLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;
    private int size;


    void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            tail = newNode;
            head = newNode;
            size++;
            return;
        }
        newNode.setPrevious(tail);
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    void traverseForward() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    void traverseBackward() {
        Node<T> current = tail;
        while (current != null) {
            System.out.println(current);
            current = current.getPrevious();
        }
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

}
