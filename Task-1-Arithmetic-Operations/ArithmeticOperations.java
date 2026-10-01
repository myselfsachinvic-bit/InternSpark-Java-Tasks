import java.util.Scanner;

public class ArithmeticOperations {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("===== Basic Arithmetic Operations =====");
            
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            double addition = num1 + num2;
            double subtraction = num1 - num2;
            double multiplication = num1 * num2;
            
            System.out.println("\n----- Results -----");
            System.out.println("Addition       : " + addition);
            System.out.println("Subtraction    : " + subtraction);
            System.out.println("Multiplication : " + multiplication);
            
            if (num2 != 0) {
                double division = num1 / num2;
                System.out.println("Division       : " + division);
            } else {
                System.out.println("Division       : Cannot divide by zero.");
            }
        }
    }
}