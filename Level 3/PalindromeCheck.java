import java.util.Scanner;

public class PalindromeCheck {


    public static boolean palindromeUsingLoop(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }



    public static boolean palindromeUsingRecursion(
            String text, int start, int end) {


        if (start >= end) {
            return true;
        }


        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }


        return palindromeUsingRecursion(text, start + 1, end - 1);
    }



    public static char[] reverseString(String text) {

        int n = text.length();

        char[] reverse = new char[n];

        int index = 0;

        for (int i = n - 1; i >= 0; i--) {

            reverse[index] = text.charAt(i);
            index++;
        }

        return reverse;
    }



    public static boolean palindromeUsingArrays(String text) {


        char[] original = text.toCharArray();


        char[] reverse = reverseString(text);


        for (int i = 0; i < original.length; i++) {

            if (original[i] != reverse[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        boolean result1 = palindromeUsingLoop(text);

        boolean result2 = palindromeUsingRecursion(
                text, 0, text.length() - 1);

        boolean result3 = palindromeUsingArrays(text);


        System.out.println("\nPalindrome Check Results");
        System.out.println("------------------------");

        System.out.println("Using Loop      : " +
                (result1 ? "Palindrome" : "Not Palindrome"));

        System.out.println("Using Recursion : " +
                (result2 ? "Palindrome" : "Not Palindrome"));

        System.out.println("Using Arrays    : " +
                (result3 ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}
