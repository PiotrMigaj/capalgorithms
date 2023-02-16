package pl.migibud.swapmatrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class App {
    public static void main(String[] args) {

        String[][] table = new String[][]{{"P", "A", "B", "C", "D"}, {"P", "A", "B", "C", "D"}, {"P", "A", null, "C", "D"}, {"P", null, null, null, "D"}, {"P", "A", "B", "C", "D"}};

        Arrays.stream(table)
                .forEach(arr -> System.out.println(Arrays.toString(arr)));

        gravity(table);

        System.out.println();

        Arrays.stream(table)
                .forEach(arr -> System.out.println(Arrays.toString(arr)));

    }

    public static void gravity(Object[][] array) {

        int size = array.length;
        for (int j = 0; j < size; j++) {
            Deque<Object> stack = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                if (array[i][j] != null) {
                    stack.addFirst(array[i][j]);
                }
            }
            for (int i = size - 1; i >= 0; i--) {
                if (!stack.isEmpty()) {
                    array[i][j] = stack.remove();
                } else {
                    array[i][j] = null;
                }
            }
        }
    }
}
