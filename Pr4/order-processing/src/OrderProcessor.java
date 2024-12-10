import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderProcessor<T extends Product> {
    private final ExecutorService executor;

    public OrderProcessor() {
        this.executor = Executors.newFixedThreadPool(4);
    }

    public void process(T order) {
        executor.submit(() -> {
            System.out.println("Processing order: " + order);
            try {
                Thread.sleep(1000);
                System.out.println("Order processed: " + order);
            } catch (InterruptedException e) {
                System.err.println("Error processing order: " + e.getMessage());
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}