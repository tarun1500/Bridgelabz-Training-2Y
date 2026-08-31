import java.util.Scanner;

public class Question8_FactorsUsingDynamicArray {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Invalid number. Please enter a positive number.");
            input.close();
            return;
        }

        int maxFactor = 10;

        int[] factors = new int[maxFactor];

        int index = 0;

        for (int i = 1; i <= number; i++) {

            if (number % i == 0) {

                if (index == factors.length) {

                    maxFactor = factors.length * 2;

                    int[] temp = new int[maxFactor];

                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }

                    factors = temp;
                }

                factors[index] = i;

                index++;
            }
        }

        System.out.println("Factors of " + number + ":");

        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        System.out.println();

        input.close();
    }
}
