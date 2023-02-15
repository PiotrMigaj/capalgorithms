package pl.migibud.island;

import java.util.Arrays;

class App {
    public static void main(String[] args) {
//        int[][] nums = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 1, 0}};
        int[][] nums = {{1, 1}, {0, 0}};

//        Arrays.stream(nums).forEach(arr -> System.out.println(Arrays.toString(arr)));

        CountNeighbours countNeighbours = new CountNeighbours();
        countNeighbours.countIsland(nums, 0, 0);
        CountNeighbours.listOfIndexes.forEach(arr -> System.out.println(Arrays.toString(arr)));

    }
}
