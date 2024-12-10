import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        System.out.println("Generating orders...");
        List<Product> orders = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            orders.add(Electronics.builder()
                    .name(faker.commerce().productName() + " (Electronics)")
                    .price(faker.number().randomDouble(2, 100, 1000))
                    .build());
        }

        for (int i = 0; i < 10; i++) {
            orders.add(Clothing.builder()
                    .name(faker.commerce().productName() + " (Clothing)")
                    .price(faker.number().randomDouble(2, 10, 200))
                    .build());
        }

        System.out.println("Orders list generated: " + orders.size() + " orders.");
        System.out.println();

        System.out.println("Example orders (first 10):");
        orders.stream()
                .limit(10)
                .forEach(order -> System.out.println(order.getClass().getSimpleName() + ": " + order.getName() + " - $" + order.getPrice()));
        System.out.println();

        System.out.println("Starting order processing...");
        OrderProcessor<Product> processor = new OrderProcessor<>();

        long startTime = System.currentTimeMillis();

        orders.forEach(order -> {
            processor.process(order);
            System.out.println("Order added for processing: " + order.getName() + " ($" + order.getPrice() + ")");
        });

        processor.shutdown();

        long endTime = System.currentTimeMillis();
        System.out.println("\nAll orders processed.");
        System.out.println("Total orders processed: " + orders.size());
        System.out.println("Processing time: " + (endTime - startTime) + " ms");
    }
}
