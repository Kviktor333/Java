package shop.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Кошик містить:\n");
        if (products.isEmpty()) {
            sb.append("Кошик порожній.");
        } else {
            for (Product product : products) {
                sb.append(product.toString()).append("\n");
            }
            sb.append("Загальна вартість: ").append(getTotalPrice());
        }
        return sb.toString();
    }
}
