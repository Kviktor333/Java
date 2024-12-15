import com.github.javafaker.Faker;
import orderprocessing.*;
import storage.OrderStorage;
import threadmanagement.ThreadManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        OrderStorage<Product> storage = new OrderStorage<>();
        OrderProcessor<Product> processor = new OrderProcessor<>();
        ThreadManager threadManager = new ThreadManager();

        // Generate fake orders
        Electronics electronics = Electronics.builder()
                .name(faker.commerce().productName())
                .brand(faker.company().name())
                .price(faker.number().randomDouble(2, 100, 2000))
                .build();

        Clothing clothing = Clothing.builder()
                .name(faker.commerce().productName())
                .size("L")
                .color("Blue")
                .build();

        storage.addOrder(electronics);
        storage.addOrder(clothing);

        // Process orders
        threadManager.executeInThread(() -> {
            List<Product> orders = storage.getOrders();
            processor.processOrders(orders, order ->
                    System.out.println("Processing order: " + order.getName()));
        });
    }
}
