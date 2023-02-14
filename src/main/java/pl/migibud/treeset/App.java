package pl.migibud.treeset;

import java.util.TreeSet;

class App {
    public static void main(String[] args) {

        TreeSet<User> users = new TreeSet<>();


        users.add(new User("Piotr"));
        users.add(new User("Stefan"));
        users.add(new User("Anna"));

        System.out.println(users);


    }
}
