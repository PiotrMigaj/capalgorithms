package pl.migibud.testanotherstring;

class App {
    public static void main(String[] args) {

        String input = "HelloH";

        for (int k = 1; k <= input.length(); k++) {
            for (int i = 0; i < input.length() - k + 1; i++) {
                System.out.println(input.substring(i, i + k));
            }
        }


    }
}
