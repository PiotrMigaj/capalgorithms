package pl.migibud.testgravity;

import java.util.Arrays;

class App {
    public static void main(String[] args) {

        String[] input = {null, "P", null, null, "A", "C", null, "B", null, "Hello"};
        System.out.println(Arrays.toString(input));
        actOn(input);
        System.out.println(Arrays.toString(input));


    }

    public static void actOn(String[] input) {
        int i = 0;
        for (int j = 0; j < input.length; j++) {
            if (input[j] != null && i == j) {
                i++;
                continue;
            }
            if (input[j] == null && input[i] != null) {
                i++;
                continue;
            }
            if (input[j] == null && input[i] == null) {
                continue;
            }
            if (input[j] != null && input[i] == null) {
                swap(input, i, j);
                i++;
            }
        }

    }

    private static void swap(String[] input, int i, int j) {
        String temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
