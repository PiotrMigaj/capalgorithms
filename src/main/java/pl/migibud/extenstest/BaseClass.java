package pl.migibud.extenstest;

import java.util.ArrayList;
import java.util.List;

class BaseClass {

    List<String> list = new ArrayList<>();

    void add(String input) {
        System.out.println("Hello from add() baseClass");
        list.add(input);
    }

    void addAll(List<String> input) {
        System.out.println("Hello from addAll() baseClass");
        input.forEach(this::add);
    }

}
