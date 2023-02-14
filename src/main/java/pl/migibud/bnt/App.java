package pl.migibud.bnt;

class App {
    public static void main(String[] args) {

        Tree<Integer> tree = new TreeImpl<>();

        tree.insert(1);
        tree.insert(6);
        tree.insert(10);
        tree.insert(4);
        tree.insert(-2);
        tree.insert(-4);

        tree.traverse();

    }
}
