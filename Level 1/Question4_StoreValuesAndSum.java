import java.util.Scanner;

public class Question4_StoreValuesAndSum {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] numbers = new double[10];

        int index = 0;
        double total = 0.0;

        while (true) {

            if (index == numbers.length) {
                break;
            }

            System.out.print("Enter a positive number (0 or negative to stop): ");
            double number = input.nextDouble();

            if (number <= 0) {
                break;
            }

            numbers[index] = number;

            index++;
        }

        System.out.println("\nNumbers entered:");

        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println("Sum of all numbers: " + total);

        input.close();
    }
}
