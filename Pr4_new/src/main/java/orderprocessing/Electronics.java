package orderprocessing;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Electronics extends Product {
    private final String brand;
    private final double price;

    @Builder
    public Electronics(String name, String brand, double price) {
        super(name);
        this.brand = brand;
        this.price = price;
    }

}
