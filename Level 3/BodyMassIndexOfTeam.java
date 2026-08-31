import java.util.Scanner;
public class BodyMassIndexOfTeam {

    public static String[] calculateBMI(double weight, double heightCm) {


        double heightMeter = heightCm / 100;


        double bmi = weight / (heightMeter * heightMeter);


        String status;

        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }


        return new String[] {
                String.format("%.2f", heightCm),
                String.format("%.2f", weight),
                String.format("%.2f", bmi),
                status
        };
    }

    public static String[][] calculateAllBMI(double[][] data) {

        String[][] result = new String[10][4];

        for (int i = 0; i < 10; i++) {

            double weight = data[i][0];
            double height = data[i][1];


            String[] bmiData = calculateBMI(weight, height);

            for (int j = 0; j < 4; j++) {
                result[i][j] = bmiData[j];
            }
        }

        return result;
    }

     public static void displayResult(String[][] result) {

        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s %-12s %-12s %-15s%n",
                "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < result.length; i++) {

            System.out.printf("%-10s %-12s %-12s %-15s%n",
                    result[i][0],
                    result[i][1],
                    result[i][2],
                    result[i][3]);
        }

        System.out.println("---------------------------------------------------------------");
     }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][2];


        for (int i = 0; i < 10; i++) {

            System.out.println("Enter details for Person " + (i + 1));

            System.out.print("Enter weight (kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm): ");
            data[i][1] = sc.nextDouble();
            System.out.println();
        }


        String[][] result = calculateAllBMI(data);


        displayResult(result);

        sc.close();
    }

}
