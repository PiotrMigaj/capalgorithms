package pl.migibud.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class App {
    public static void main(String[] args) {
        List<String> strings = List.of("Piotr", "Piotr", "Basia");
        Map<String, Integer> map = strings.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (k, v) -> v + v));
        System.out.println(map);

        strings.stream()
                .map(StringBuilder::new)
                .map(sb -> sb.deleteCharAt(0))
                .forEach(System.out::println);

    }


}
