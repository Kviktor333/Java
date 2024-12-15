package storage;

import orderprocessing.Product;
import java.util.ArrayList;
import java.util.List;

public class OrderStorage<T extends Product> {
    private final List<T> orders = new ArrayList<>();

    public synchronized void addOrder(T order) {
        orders.add(order);
    }

    public synchronized List<T> getOrders() {
        return new ArrayList<>(orders);
    }
}
