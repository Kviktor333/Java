import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        try {
            System.out.println("Введіть перше число:");
            double num1 = scanner.nextDouble();

            System.out.println("Введіть друге число:");
            double num2 = scanner.nextDouble();

            System.out.println("Оберіть операцію (+, -, *, /):");
            String operation = scanner.next();

            double result;

            switch (operation) {
                case "+":
                    result = calculator.add(num1, num2);
                    System.out.println("Результат додавання: " + result);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    System.out.println("Результат віднімання: " + result);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    System.out.println("Результат множення: " + result);
                    break;
                case "/":
                    result = calculator.divide(num1, num2);
                    System.out.println("Результат ділення: " + result);
                    break;
                default:
                    System.out.println("Невідома операція!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Невідома помилка!");
        } finally {
            System.out.println("Обробка запиту завершена.");
        }

        scanner.close();
    }
}
