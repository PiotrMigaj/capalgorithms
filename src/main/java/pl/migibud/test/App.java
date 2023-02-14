package pl.migibud.test;

import java.util.ArrayList;
import java.util.List;

class App {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Piotr");
        list.add(null);
        list.add("Arianna");

        List<String> result = list.stream()
//                .filter(Objects::nonNull)
                .filter(s -> s.startsWith("P"))
                .toList();

        System.out.println(result);

    }
}
