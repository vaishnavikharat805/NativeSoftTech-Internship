import java.util.Scanner;

public class SimpleCalculator {

		public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int continueChoice;
	        System.out.println(" =====Welcome to the Simple Calculator===== ");
	       
	        do {
	            Double a, b;
	            
	            System.out.println("Enter the First Number:");
	            a = sc.nextDouble();

	            System.out.println("Enter the Second Number:");
	            b = sc.nextDouble();

	            System.out.println("\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Exit");
	            System.out.println("Enter your choice:");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("Result: " + (a + b));
	                    break;
	                case 2:
	                    System.out.println("Result: " + (a - b));
	                    break;
	                case 3:
	                    System.out.println("Result: " + (a * b));
	                    break;
	                case 4:
	                    if (b != 0) {
	                        System.out.println("Result: " + (a / b));
	                    } else {
	                        System.out.println("Error: Division by zero is not allowed.");
	                    }
	                    break;
	                case 5:
	                    System.out.println("Exiting the program. Goodbye!");
	                    sc.close();
	                    return;  // Exit the program completely
	                default:
	                    System.out.println("Error: Invalid choice. Please select a valid option (1-5).");
	            }

	            System.out.println("\nDo you want to continue? Press 1 to continue or 0 to exit.");
	            continueChoice = sc.nextInt();

	        } while (continueChoice == 1);

	        System.out.println("Thank you for using the calculator. Goodbye!");
	        sc.close();
	    }
	}
