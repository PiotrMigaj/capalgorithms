package pl.migibud.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

class User {
    public String name;

    public User(String name) {
        this.name = name;
    }
}

class Main {
    public static void main(String[] args) {

        User user = new User("Piotr");
        Class<? extends User> aClass = user.getClass();
        Field[] fields = aClass.getFields();
        Arrays.stream(fields).forEach(System.out::println);

    }
}
