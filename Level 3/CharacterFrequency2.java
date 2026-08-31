import java.util.Scanner;

public class CharacterFrequency2 {


    public static char[] uniqueCharacters(String text) {

        int n = text.length();


        char[] temp = new char[n];

        int count = 0;


        for (int i = 0; i < n; i++) {

            boolean isUnique = true;


            for (int j = 0; j < i; j++) {

                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }


            if (isUnique) {
                temp[count] = text.charAt(i);
                count++;
            }
        }

        char[] unique = new char[count];

        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }

        return unique;
    }

    public static String[][] findFrequency(String text) {


        int[] frequency = new int[256];


        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }


        char[] unique = uniqueCharacters(text);


        String[][] result = new String[unique.length][2];


        for (int i = 0; i < unique.length; i++) {

            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(frequency[unique[i]]);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] result = findFrequency(text);

        System.out.println("\nCharacter Frequency");
        System.out.println("-------------------");

        for (int i = 0; i < result.length; i++) {

            System.out.println(
                    result[i][0] + " : " + result[i][1]
            );
        }

        sc.close();
    }
}
