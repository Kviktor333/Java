package orderprocessing;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class OrderProcessor<T extends Product> {

    public void processOrders(List<T> orders, Consumer<T> processor) {
        orders.forEach(processor);
    }

    public List<T> filterOrders(List<T> orders, Class<? extends T> type) {
        return orders.stream()
                .filter(type::isInstance)
                .collect(Collectors.toList());
    }
}
