package pl.migibud.twodimarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class App {
    public static void main(String[] args) {
        String[][] names = {{"Anna", "Piotr"}, {"Maria", "Michał"}, {"Krystyna", "Janusz"}};

        Arrays.stream(names)
                .forEach(arr -> System.out.println(Arrays.toString(arr)));

        List<int[]> indexes = new ArrayList<>();
        indexes.add(new int[]{1, 1});
        indexes.add(new int[]{2, 0});

        indexes
                .forEach(arr -> names[arr[0]][arr[1]] = "DUPA");

        Arrays.stream(names)
                .forEach(arr -> System.out.println(Arrays.toString(arr)));

    }
}
