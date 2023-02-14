package pl.migibud.linkedlist3;

class App {
    public static void main(String[] args) {

        List<String> list = new LinkedList<>();

        list.insert("Piotr");
        list.insert("Anna");
        list.insert("Wojciech");
        list.insert("Marcin");

        list.traverse();
        list.reverse();
        System.out.println();
        list.traverse();
//        System.out.println();
//        list.remove("Anna");
//        list.remove("Piotr");
//        list.traverse();
//
//        System.out.println(list.isEmpty());
//        System.out.println(list.size());


    }
}
