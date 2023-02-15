package pl.migibud.testmap;

import java.util.HashMap;
import java.util.Map;

class App {
    public static void main(String[] args) {

        Map<String, String> piotr = new HashMap<>(Map.of("Piotr", "Stefan", "Janusz", "Stefan"));

        piotr.remove("Piotr");

        System.out.println(piotr);

    }
}
