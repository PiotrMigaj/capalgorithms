package pl.migibud.queue;

class QueueImpl<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            tail = newNode;
            head = tail;
            size++;
            return;
        }
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    @Override
    public T poll() {
        if (head == null) {
            return null;
        }
        if (head != tail) {
            Node<T> temp = head;
            head = head.getNext();
            temp.setNext(null);
            size--;
            return temp.getData();
        }
        Node<T> temp = head;
        head = null;
        tail = null;
        return temp.getData();
    }

    @Override
    public T peek() {
        return head != null ? head.getData() : null;
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
}
