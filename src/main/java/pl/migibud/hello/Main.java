package pl.migibud.hello;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

class Main {
    private static String stringRootPath;

    public static void main(String[] args) throws IOException {
        ourConsole();
    }

    public static void ourConsole() throws IOException {
        System.out.println("Witaj w losowaniu!");
        System.out.println("Czy chcesz rozpocząć losowanie filmu? Podaj tak lub nie");
        Scanner sc = new Scanner(System.in);
        String inputDecision = sc.nextLine();
        if ("tak".equalsIgnoreCase(inputDecision)) {
            do {
                System.out.println("Enter the directory path or press enter");
                stringRootPath = sc.nextLine();
                Path path = Path.of(stringRootPath);
                boolean exists = Files.exists(path) || stringRootPath.equals("");
                if (exists) {
                    System.out.println("The path was found...");
                    break;
                } else {
                    System.out.println("The path is incorrect... Try again or leave it empty...");
                }

            } while (true);
        }

    }
}
