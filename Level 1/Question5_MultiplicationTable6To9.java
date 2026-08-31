import java.util.Scanner;

public class Question5_MultiplicationTable6To9 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] multiplicationResult = new int[4];

        for (int i = 0; i < multiplicationResult.length; i++) {
            int multiplier = i + 6;
            multiplicationResult[i] = number * multiplier;
        }

        for (int i = 0; i < multiplicationResult.length; i++) {
            int multiplier = i + 6;

            System.out.println(number + " * " + multiplier
                    + " = " + multiplicationResult[i]);
        }

        input.close();
    }
}
