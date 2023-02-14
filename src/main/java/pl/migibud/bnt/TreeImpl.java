package pl.migibud.bnt;


class TreeImpl<T extends Comparable<T>> implements Tree<T> {

    private Node<T> head;

    @Override
    public void insert(T data) {
        if (head == null) {
            head = new Node<>(data);
            return;
        }
        insert(data, head);
    }

    private void insert(T data, Node<T> node) {
        if (node.getData().compareTo(data) > 0) {
            if (node.getLeftNode() == null) {
                node.setLeftNode(new Node<>(data));
            } else {
                insert(data, node.getLeftNode());
            }
        }
        if (node.getData().compareTo(data) < 0) {
            if (node.getRightNode() == null) {
                node.setRightNode(new Node<>(data));
            } else {
                insert(data, node.getRightNode());
            }
        }
    }

    @Override
    public void traverse() {
        if (head == null) {
            return;
        }
        traverse(head);


    }

    private void traverse(Node<T> node) {
        if (node.getLeftNode() != null) {
            traverse(node.getLeftNode());
        }
        System.out.println(node.getData());
        if (node.getRightNode() != null) {
            traverse(node.getRightNode());
        }
    }
}
