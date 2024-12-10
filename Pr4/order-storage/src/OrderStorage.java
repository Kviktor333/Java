import java.util.ArrayList;
import java.util.List;

public class OrderStorage {
    private final List<Product> orders = new ArrayList<>();

    public void addOrder(Product product) {
        orders.add(product);
    }

    public List<Product> getOrders() {
        return new ArrayList<>(orders);
    }
}