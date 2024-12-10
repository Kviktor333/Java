import lombok.Builder;

public class Electronics extends Product {
    @Builder
    public Electronics(String name, double price) {
        super(name, price);
    }
}
