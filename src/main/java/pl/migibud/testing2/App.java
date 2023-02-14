package pl.migibud.testing2;

import java.util.*;

class App {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put(null, null);

        List<String> strings = new ArrayList<>(map.values());
        Set<String> stringsSet = new HashSet<>(map.values());


        System.out.println(stringsSet);

    }
}
