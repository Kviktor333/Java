import lombok.Builder;

public class Clothing extends Product {
    @Builder
    public Clothing(String name, double price) {
        super(name, price);
    }
}