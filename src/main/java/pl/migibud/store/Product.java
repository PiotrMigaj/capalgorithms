package pl.migibud.store;

import java.util.Objects;

abstract class Product {

    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    int getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
