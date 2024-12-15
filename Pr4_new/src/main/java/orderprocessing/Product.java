package orderprocessing;

import lombok.Getter;

@Getter
public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

}
