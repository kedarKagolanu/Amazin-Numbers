package numbers;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

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

    static boolean isGapfulNumber(long num) {
        String str = String.valueOf(num);
        long firstdigit = Character.digit(str.charAt(0),10);
        return (num > 99) && (num % (firstdigit*10 + num%10) == 0);
    }

    public static void main(String[] args) {
//      write your code here
        Scanner in = new Scanner(System.in);
        String inputArguements;
        long input1,input2;
        boolean hasSecondInput;
        System.out.println("Welcome to Amazing Numbers!\n");

        while(true) {
            System.out.println("Supported requests:");
            System.out.println("- enter a natural number to know its properties;");
            System.out.println("- enter two natural numbers to obtain the properties of the list:");
            System.out.println("  * the first parameter represents a starting number;");
            System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
            System.out.println("- separate the parameters with one space;");
            System.out.println("- enter 0 to exit.\n");

            do{
                input2 = 1;
                hasSecondInput = false;
                System.out.print("Enter a request: ");
                inputArguements = in.nextLine();

                if(inputArguements.isBlank()) {
                    break;
                }

                StringTokenizer st = new StringTokenizer(inputArguements);
                input1 = Long.parseLong(st.nextToken());
                if(st.hasMoreTokens()) {
                    input2 = Long.parseLong(st.nextToken());
                    hasSecondInput = true;
                }
                if(input1 == 0) {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                if(!isNatural(input1)) {
                    System.out.println("\nThe first parameter should be a natural number or zero.\n");
                    continue;
                }

                if(!isNatural(input2)) {
                    System.out.println("\nThe second parameter should be a natural number.\n");
                    continue;
                }

                if(!hasSecondInput) {
                    // natural number checking
                    System.out.println("\nProperties of " + input1);

                    // buzz number checking
                    System.out.println("       buzz: " + isBuzzNumber(input1));

                    //duck number checking
                    System.out.println("       duck: " + isDuckNumber(input1));

                    //palindrome number checking
                    System.out.println("palindromic: " + isPalindrome(input1));
                    System.out.println();

                    //gapeful number checking
                    System.out.println("     gapful: " + isGapfulNumber(input1));

                    //even nd odd parity checking
                    if(isEven(input1)) {
                        System.out.println("       even: true");
                        System.out.println("        odd: false");
                    } else {
                        System.out.println("       even: false");
                        System.out.println("        odd: true");
                    }
                } else {
                    long temp;
                    List<String> properties = new ArrayList<>(5);
                    for(int i=0;i<input2;i++) {
                        temp = input1 + i;
                        if(isBuzzNumber(temp)) properties.add("buzz");

                        if(isDuckNumber(temp)) properties.add("duck");

                        if(isPalindrome(temp)) properties.add("palindromic");

                        if(isGapfulNumber(temp)) properties.add("gapful");

                        if(isEven(temp))
                            properties.add("even");
                        else
                            properties.add("odd");

                        System.out.print("             " + temp + " is ");
                        for(int j=0;j<=properties.size()-2;j++) {
                            System.out.print(properties.get(j) + ", ");
                        }
                        System.out.print(properties.get(properties.size()-1));
                        System.out.println();

                        properties.clear();
                    }
                }

            }while(true);
        }
    }
}