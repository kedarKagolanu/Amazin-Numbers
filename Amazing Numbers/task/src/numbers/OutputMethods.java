package numbers;

import java.util.function.LongPredicate;
import java.util.function.Predicate;

import static numbers.PropertiesMethods.*;
import static numbers.PropertiesMethods.isDuckNumber;

public class OutputMethods {
    static void printProperties(long input1) {
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

        //spy number checking
        System.out.println("        spy: " + isSpyNumber(input1));

        //even nd odd parity checking
        if(isEven(input1)) {
            System.out.println("       even: true");
            System.out.println("        odd: false");
        } else {
            System.out.println("       even: false");
            System.out.println("        odd: true");
        }
    }

    static void printInLine(long temp) {
        String buzz = isBuzzNumber(temp) ? "buzz, " : "";
        String duck = isDuckNumber(temp) ? "duck, " : "";
        String palindromic = isPalindrome(temp) ? "palindromic, " : "";
        String gapful = isGapfulNumber(temp) ? "gapful, " : "";
        String spy = isSpyNumber(temp) ? "spy," : "";
        String even = isEven(temp) ? "even" : "odd";

        System.out.printf("\n%d is %s%s%s%s%s%s\n", temp, buzz, duck, palindromic, gapful, spy, even);
    }

    static void printProperties(long input1,long input2) {
        long temp;
        for(int i=0;i<input2;i++) {
            temp = input1 + i;
            printInLine(temp);
        }
    }

    static void printProperties(long input1,long input2,String input3) {
        long counter = input2;
        long i = input1;
        Properties temp = Properties.valueOf(input3);
        LongPredicate lp = temp.getLongPredicate();
        while(counter > 0) {
            if(lp.test(i)) {
                printInLine(i);
                counter--;
            }
            i++;
        }
    }

    static void printSupportedRequests() {
        System.out.println("\nSupported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.\n");
    }
}
