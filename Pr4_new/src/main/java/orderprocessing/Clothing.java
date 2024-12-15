package orderprocessing;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Clothing extends Product {
    private final String size;
    private final String color;

    @Builder
    public Clothing(String name, String size, String color) {
        super(name);
        this.size = size;
        this.color = color;
    }

}
