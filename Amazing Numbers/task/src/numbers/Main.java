package numbers;

import java.util.Scanner;

public class Main {

    static boolean isNatural(long d) {
        return ( d > 0 );
    }

    static boolean isEven(long num) {
        return num % 2 == 0;
    }

    static boolean isDivisibleBy7(long num) {
        if( num < 10) {
            return (num % 7) == 0;
        } else {
            long lastDigit = num % 10;
            long reducedDigit = (num - lastDigit) / 10;
            return isDivisibleBy7(reducedDigit - 2*lastDigit);
        }
    }

    static boolean endsWith7(long num){
        return (num % 10) == 7;
    }

    static boolean isBuzzNumber(long num) {
        return isDivisibleBy7(num) || endsWith7(num);
    }

    static boolean isDuckNumber(long num ) {
        long temp = num;
        long lastDigit;
        while(temp > 0) {
            lastDigit = temp % 10;
            if(lastDigit == 0) {
                return true;
            }
            temp -= lastDigit;
            temp = temp / 10;
        }
        return false;
    }

    static long reverseNumber(long num) {
        long temp = num;
        long result = 0;
        int lastDigit;
        while(temp > 0) {
            lastDigit = (int) temp % 10;
            temp -= lastDigit;
            temp /= 10;
            result = result*10 + lastDigit;
        }
        return result;
    }

    static boolean isPalindrome(long num) {
        return num == reverseNumber(num);
    }

    public static void main(String[] args) {
//      write your code here
        Scanner in = new Scanner(System.in);
        long input;

        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.\n");

        do{
            System.out.print("Enter a request: ");
            input = in.nextLong();

            // natural number checking
            if(!isNatural(input)) {
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
                continue;
            }
            System.out.println("\nProperties of " + input);

            //even nd odd parity checking
            if(isEven(input)) {
                System.out.println("       even: true");
                System.out.println("        odd: false");
            } else {
                System.out.println("       even: false");
                System.out.println("        odd: true");
            }

            // buzz number checking
            System.out.println("       buzz: " + isBuzzNumber(input));

            //duck number checking
            System.out.println("       duck: " + isDuckNumber(input));

            //palindrome number checking
            System.out.println("palindromic: " + isPalindrome(input));
            System.out.println();

        }while(input != 0);
    }
}