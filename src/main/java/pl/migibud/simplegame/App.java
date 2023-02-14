package pl.migibud.simplegame;

import java.util.*;

class App {

    public static final char[] baseChars = {'#', '%', '&', '*', '&'};
    public static int SCORE = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        char[] baseChars = {'#', '%', '&','*', '&'};
        List<Character> input = Arrays.asList('#', '%', '&', '&', '&', '*', '&');

        while (true) {
            System.out.println(input);
            System.out.println("Pick number from 0 to " + (input.size() - 1));
            int inputNumber = scanner.nextInt();
            List<Integer> neighbours = findNeighbours(input, inputNumber);
            SCORE += neighbours.size();
            replaceWithRandomChar(input, neighbours);
            System.out.println("Your score: " + SCORE);
        }


    }

    public static List<Integer> findNeighbours(List<Character> input, int index) {
        if (index < 0 || index >= input.size()) {
            throw new IndexOutOfBoundsException();
        }
        char baseChar = input.get(index);
        List<Integer> indexes = new ArrayList<>();
        for (int i = index; i >= 0; i--) {
            if (input.get(i).equals(baseChar)) {
                indexes.add(i);
            } else {
                break;
            }
        }
        for (int i = index + 1; i < input.size(); i++) {
            if (input.get(i).equals(baseChar)) {
                indexes.add(i);
            } else {
                break;
            }
        }
        return indexes;
    }

    public static void replaceWithRandomChar(List<Character> input, List<Integer> indexesToReplace) {

        indexesToReplace.forEach(index -> {
            int randomIndex = new Random().nextInt(baseChars.length);
            input.set(index, baseChars[randomIndex]);
        });

    }
}
