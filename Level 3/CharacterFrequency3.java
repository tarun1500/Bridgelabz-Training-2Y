import java.util.Scanner;

public class CharacterFrequency3 {

    public static String[] findFrequency(String text) {


        char[] chars = text.toCharArray();

        int[] frequency = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {


            if (chars[i] == '0') {
                continue;
            }


            frequency[i] = 1;

            for (int j = i + 1; j < chars.length; j++) {

                if (chars[i] == chars[j]) {

                    frequency[i]++;


                    chars[j] = '0';
                }
            }
        }


        int uniqueCount = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                uniqueCount++;
            }
        }


        String[] result = new String[uniqueCount];

        int index = 0;


        for (int i = 0; i < chars.length; i++) {

            if (chars[i] != '0') {

                result[index] = chars[i] + " : " + frequency[i];

                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter a string: ");
        String text = sc.nextLine();


        String[] result = findFrequency(text);


        System.out.println("\nCharacter Frequency");
        System.out.println("-------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        sc.close();
    }
}
