package pl.migibud.simplegame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        char[][] chars = provideMatrix();
        for (int i = 0; i < 3; i++) {
            System.out.println(chars[i]);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick an element: ");
        int inputNumber = scanner.nextInt();
        System.out.println(inputNumber);
        int[] ints = parseNumberToArrayIndex(inputNumber);
        System.out.println(Arrays.toString(ints));

    }

    public static char[][] provideMatrix() {

        char[] baseTable = {'#', '*', '$'};
        char[][] table = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int randomInt = new Random().nextInt(baseTable.length);
                table[i][j] = baseTable[randomInt];
            }
        }
        return table;
    }

    public static int[] parseNumberToArrayIndex(int input) {

        switch (input) {
            case 7 -> {
                return new int[]{0, 0};
            }
            case 8 -> {
                return new int[]{0, 1};
            }
            case 9 -> {
                return new int[]{0, 2};
            }
            case 4 -> {
                return new int[]{1, 0};
            }
            case 5 -> {
                return new int[]{1, 1};
            }
            case 6 -> {
                return new int[]{1, 2};
            }
            case 1 -> {
                return new int[]{2, 0};
            }
            case 2 -> {
                return new int[]{2, 1};
            }
            case 3 -> {
                return new int[]{2, 2};
            }
            default -> {
                return new int[]{};
            }
        }


    }
}
