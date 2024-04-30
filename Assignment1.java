import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to Simple Calculator App!");
        
        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Perform arithmetic operation");
            System.out.println("2. View previous calculations");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    performOperation(scanner);
                    break;
                case 2:
                    viewPreviousCalculations();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you for using the calculator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 3.");
            }
        }
        
        scanner.close();
    }
    
    public static void performOperation(Scanner scanner) {
        System.out.println("Enter two numbers:");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        
        System.out.println("Enter the operation (+, -, *, /):");
        char operator = scanner.next().charAt(0);
        
        double result = calculate(num1, num2, operator);
        System.out.println("Result: " + result);
        
        // Save the calculation
        saveCalculation(num1, num2, operator, result);
    }
    
    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                    System.exit(0);
                }
                return num1 / num2;
            default:
                System.out.println("Error: Invalid operation.");
                System.exit(0);
                return 0;
        }
    }
    
    public static void saveCalculation(double num1, double num2, char operator, double result) {
        System.out.println("Saving calculation: " + num1 + " " + operator + " " + num2 + " = " + result);
    }
    
    public static void viewPreviousCalculations() {
        System.out.println("No previous calculations available.");
    }
}
