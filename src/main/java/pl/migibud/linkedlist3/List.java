package pl.migibud.linkedlist3;

interface List<T> {
    void insert(T data);

    void remove(T data);

    void traverse();

    void reverse();

    int size();

    boolean isEmpty();
}
