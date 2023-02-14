package pl.migibud.store;

import java.util.Objects;

class DigitalProduct extends Product {
    private int weight;

    public DigitalProduct(String name, int price, int weight) {
        super(name, price);
        this.weight = weight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DigitalProduct that = (DigitalProduct) o;
        return weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }

    @Override
    public String toString() {
        return "DigitalProduct{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
