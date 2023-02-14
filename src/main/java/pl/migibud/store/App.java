package pl.migibud.store;

class App {
    public static void main(String[] args) {

        Product maslo1 = new DigitalProduct("Masło", 20, 2);
        Product maslo2 = new DigitalProduct("Masło2", 23, 2);

        Basket<Product> basket = new Basket<>();

        basket.addProduct(maslo1);
        basket.addProduct(maslo1);
        basket.addProduct(maslo1);
        basket.addProduct(maslo1);
        basket.addProduct(maslo2);

        String s = basket.toString();
        System.out.println(s);

        int totalSum = basket.getTotalSum();
        System.out.println("Total sum of basket: " + totalSum);

    }
}
