package pl.migibud.linkedlist;

class LinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    @Override
    public void add(T t) {
        Node<T> newNode = new Node<>(t);
//        if (head == null) {
//            head = newNode;
//            size++;
//            return;
//        }
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public void traverse() {
        if (head == null) {
            return;
        }
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
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
