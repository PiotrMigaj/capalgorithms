package pl.migibud.store;

import java.util.HashMap;
import java.util.Map;

class Basket<T extends Product> {
    private Map<T, Integer> basket = new HashMap<>();

    void addProduct(T t) {
        if (!basket.containsKey(t)) {
            basket.put(t, 1);
            return;
        }
        basket.computeIfPresent(t, (t1, integer) -> integer + 1);
    }

    int getTotalSum() {
        return basket.entrySet().stream()
                .map(v -> v.getKey().getPrice() * v.getValue())
                .reduce(0, Integer::sum);
    }


    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + basket +
                '}';
    }
}
