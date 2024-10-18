package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        Cart cart = new Cart();
        OrderHistory orderHistory = new OrderHistory(); // Історія замовлень

        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Видалити товар з кошика");
            System.out.println("4 - Переглянути кошик");
            System.out.println("5 - Зробити замовлення");
            System.out.println("6 - Пошук товарів");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int addId = scanner.nextInt();
                    if (addId == 1) cart.addProduct(product1);
                    else if (addId == 2) cart.addProduct(product2);
                    else if (addId == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 3:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int removeId = scanner.nextInt();
                    Product removedProduct = cart.removeProductById(removeId);
                    if (removedProduct != null) {
                        System.out.println("Товар " + removedProduct.getName() + " видалено з кошика.");
                    } else {
                        System.out.println("Товар з таким ID не знайдено в кошику.");
                    }
                    break;
                case 4:
                    System.out.println(cart);
                    break;
                case 5:
                    Order order = new Order(cart);
                    System.out.println("Замовлення створено!");
                    System.out.println(order);
                    orderHistory.addOrder(order); // Додати замовлення до історії
                    cart = new Cart(); // Очищення кошика після замовлення
                    break;
                case 6:
                    System.out.println("Введіть назву або категорію для пошуку:");
                    String searchQuery = scanner.next();
                    searchProducts(searchQuery, product1, product2, product3);
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }

    private static void searchProducts(String query, Product... products) {
        boolean found = false;
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(query.toLowerCase()) ||
                    product.getCategory().getName().toLowerCase().contains(query.toLowerCase())) {
                System.out.println("Знайдено: " + product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Товари не знайдено.");
        }
    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Category {
    private int id;
    private String name;
}

@Getter
@Setter
@ToString
class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product removeProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return product;
            }
        }
        return null; // Якщо товар не знайдено
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}

@Getter
@ToString
class Order {
    private List<Product> products;
    private double totalPrice;
    private String status = "Нове";

    public Order(Cart cart) {
        this.products = new ArrayList<>(cart.getProducts());
        this.totalPrice = cart.getTotalPrice();
    }
}

class OrderHistory {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}

