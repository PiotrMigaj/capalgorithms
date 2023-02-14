package pl.migibud.queue;

public interface Queue<T> {

    int size();

    boolean isEmpty();

    void add(T data);

    T poll();

    T peek();

    void traverse();
}
