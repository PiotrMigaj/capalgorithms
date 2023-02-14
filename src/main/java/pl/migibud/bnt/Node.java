package pl.migibud.bnt;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> leftNode;
    private Node<T> rightNode;

    Node(T data) {
        this.data = data;
    }
}
