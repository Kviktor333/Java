package shop;

import shop.model.Cart;
import shop.model.Category;
import shop.model.Order;
import shop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Order> orderHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        Cart cart = new Cart();

        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Видалити товар з кошика");
            System.out.println("4 - Переглянути кошик");
            System.out.println("5 - Зробити замовлення");
            System.out.println("6 - Переглянути історію замовлень");
            System.out.println("7 - Пошук товарів");
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
                    int idToAdd = scanner.nextInt();
                    if (idToAdd == 1) cart.addProduct(product1);
                    else if (idToAdd == 2) cart.addProduct(product2);
                    else if (idToAdd == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 3:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int idToRemove = scanner.nextInt();
                    if (idToRemove == 1) cart.removeProduct(product1);
                    else if (idToRemove == 2) cart.removeProduct(product2);
                    else if (idToRemove == 3) cart.removeProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 4:
                    System.out.println(cart);
                    break;
                case 5:
                    Order order = new Order(cart);
                    orderHistory.add(order); // Додаємо замовлення до історії
                    System.out.println("Замовлення створено!");
                    System.out.println(order);
                    cart = new Cart();
                    break;
                case 6:
                    System.out.println("Історія замовлень:");
                    for (Order o : orderHistory) {
                        System.out.println(o);
                    }
                    break;
                case 7:
                    System.out.println("Введіть назву або категорію для пошуку:");
                    String searchTerm = scanner.next();
                    searchProducts(searchTerm, product1, product2, product3);
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }

    private static void searchProducts(String searchTerm, Product... products) {
        boolean found = false;
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    product.getCategory().getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Товари не знайдено.");
        }
    }
}
