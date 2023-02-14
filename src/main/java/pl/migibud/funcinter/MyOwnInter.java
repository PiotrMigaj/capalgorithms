package pl.migibud.funcinter;

@FunctionalInterface
public interface MyOwnInter {

    int calculate(int a, int b);

    default void hello() {
        System.out.println("Hello from inter");
    }

}
