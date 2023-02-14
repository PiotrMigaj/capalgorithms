package pl.migibud.scanner;

import java.util.Scanner;

class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter line:");

        String s = scanner.nextLine();
        System.out.println(s);

    }
}
