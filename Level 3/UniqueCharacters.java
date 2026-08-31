import java.util.Scanner;

public class UniqueCharacters {

    public static int findLength(String text) {

        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {

        }

        return count;
    }


    public static char[] findUniqueCharacters(String text) {

        int n = findLength(text);


        char[] unique = new char[n];

        int uniqueCount = 0;


        for (int i = 0; i < n; i++) {

            boolean isUnique = true;


            for (int j = 0; j < i; j++) {

                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }


            if (isUnique) {
                unique[uniqueCount] = text.charAt(i);
                uniqueCount++;
            }
        }


        char[] result = new char[uniqueCount];

        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter a string: ");
        String text = sc.nextLine();


        char[] result = findUniqueCharacters(text);


        System.out.print("Unique characters: ");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}
