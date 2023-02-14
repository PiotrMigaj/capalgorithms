package pl.migibud.linkedlist3;

class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int size;

    @Override
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
            size++;
            return;
        }
        insertBeginning(data);
    }

    private void insertBeginning(T data) {
        size++;
        Node<T> newNode = new Node<>(data);
        newNode.setNext(root);
        root = newNode;
    }

    private void insertEnd(T data, Node<T> node) {
        if (node.getNext() != null) {
            insertEnd(data, node.getNext());
        }
        Node<T> newNode = new Node<>(data);
        node.setNext(newNode);
    }

    @Override
    public void remove(T data) {
        if (root == null) {
            return;
        }
        if (root.getData().compareTo(data) == 0) {
            root = root.getNext();
            size--;
            return;
        }
        remove(data, root, root.getNext());
    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode) {
        while (actualNode != null) {
            if (actualNode.getData().compareTo(data) == 0) {
                size--;
                previousNode.setNext(actualNode.getNext());
                actualNode = null;
                return;
            }
            previousNode = actualNode;
            actualNode = actualNode.getNext();
        }
    }

    @Override
    public void traverse() {
        if (root == null) {
            return;
        }
        Node<T> current = root;
        while (current != null) {
            System.out.print(current);
            current = current.getNext();
        }
        System.out.print("null");
    }

    @Override
    public void reverse() {
        if (root == null || root.getNext() == null) {
            return;
        }
        Node<T> previous = null;
        Node<T> current = root;
        Node<T> next = root;
        while (current != null) {
            next = next.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        root = previous;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
