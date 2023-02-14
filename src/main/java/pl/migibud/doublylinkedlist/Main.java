package pl.migibud.doublylinkedlist;

class Main {
    public static void main(String[] args) {

        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.insert("Piotr");
        doublyLinkedList.insert("Anna");
        doublyLinkedList.insert("Wojtek");

        doublyLinkedList.traverseForward();
        System.out.println();
        doublyLinkedList.traverseBackward();

    }
}
