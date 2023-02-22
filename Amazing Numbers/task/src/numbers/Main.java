package numbers;

import java.util.Scanner;

public class Main {

    static boolean isNatural(double d) {
        return ( d > 0 && (d % 1) == 0);
    }

    static boolean isEven(double num) {
        return num % 2 == 0;
    }

    static boolean isDivisibleBy7(double num) {
        if( num < 10) {
            return (num % 7) == 0;
        } else {
            int lastDigit = (int)num % 10;
            int reducedDigit = (int)(num - lastDigit) / 10;
            return isDivisibleBy7(reducedDigit - 2*lastDigit);
        }
    }

    static boolean endsWith7(double num) {
        return (num % 10) == 7;
    }

    static boolean isBuzzNumber(double num) {
        return isDivisibleBy7(num) || endsWith7(num);
    }

    static boolean isDuckNumber(double num ) {
        double temp = num;
        double lastDigit;
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

    public static void main(String[] args) {
//      write your code here
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        double input = in.nextInt();

        // natural number checking
        if(!isNatural(input)) {
            System.out.println("This number is not natural!");
            return;
        }
        System.out.println("Properties of " + input);

        //even nd odd parity checking
        if(isEven(input)) {
            System.out.println("even: true");
            System.out.println(" odd: false");
        } else {
            System.out.println("even: false");
            System.out.println(" odd: true");
        }

        // buzz number checking
        System.out.println("buzz: " + isBuzzNumber(input));

        //duck number checking
        System.out.println("duck: " + isDuckNumber(input));
    }
}
