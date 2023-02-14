package pl.migibud.extenstest;

import java.util.List;

class App {
    public static void main(String[] args) {

        BaseClass baseClass = new ChildClass();
        baseClass.add("Piotr");

        baseClass.addAll(List.of("Anna"));


    }
}
