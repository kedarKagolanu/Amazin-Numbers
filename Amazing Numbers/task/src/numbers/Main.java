package numbers;

import java.util.Scanner;

public class Main {

    static boolean isNatural(double d) {
        return ( d > 0 && (d % 1) == 0);
    }

    static void printNumberParity(double num) {
        if(num%2 == 0) {
            System.out.println("This number is Even.");
        } else {
            System.out.println("This number is Odd.");
        }
    }

    static boolean isDivisible(double num) {
        System.out.println("--"+num);
        if( num < 10) {
            return (num % 7) == 0;
        } else {
            int lastDigit = (int)num % 10;
            int reducedDigit = (int)(num - lastDigit) / 10;
            return isDivisible(reducedDigit - 2*lastDigit);
        }
    }

    static boolean endsWith7(double num) {
        return (num % 10) == 7;
    }

    public static void main(String[] args) {
//      write your code here
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        double input = in.nextInt();

        if(!isNatural(input)) {
            System.out.println("This number is not natural!");
            return;
        } else {
            printNumberParity(input);
        }

        if(endsWith7(input) || isDivisible(input)) {
            System.out.println("It is a Buzz number.");
        } else {
            System.out.println("It is not a Buzz number.");
        }

        System.out.println("Explanation:");
        if(endsWith7(input) && isDivisible((int)input)) {
            System.out.println(input + " is divisible by 7 and ends with 7.");
        } else if(endsWith7((int)input)) {
            System.out.println(input + " ends with 7.");
        } else if(isDivisible(input)) {
            System.out.println(input + "is divisible by 7.");
        } else {
            System.out.println(input + " is neither divisible by 7 nor does it end with 7.");
        }

    }
}
