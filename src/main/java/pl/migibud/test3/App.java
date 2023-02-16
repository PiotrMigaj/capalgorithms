package pl.migibud.test3;

import java.util.EnumMap;
import java.util.Map;

class App {
    public static void main(String[] args) {

        Map<Fruit, Integer> map = new EnumMap<>(Fruit.class);

        map.put(Fruit.APPLE, 3);
        map.put(Fruit.ORANGE, 4);
        map.put(Fruit.ORANGE, 5);


        System.out.println(map);

    }
}
