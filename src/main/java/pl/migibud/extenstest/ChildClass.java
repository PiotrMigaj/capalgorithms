package pl.migibud.extenstest;

import java.util.List;

class ChildClass extends BaseClass {

    @Override
    void add(String input) {
        System.out.println("Hello from add() childClass");
    }

    @Override
    void addAll(List<String> input) {
        super.addAll(input);
    }
}
