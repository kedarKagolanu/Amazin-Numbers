package numbers;

import java.util.Optional;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static numbers.PropertiesMethods.*;
import static numbers.PropertiesMethods.isDuckNumber;

public class OutputMethods {
    static void printNumberProperties(String[] input) {
        // natural number checking
        System.out.println("\nProperties of " + input[0]);

        long temp = Long.parseLong(input[0]);

        // buzz number checking
        System.out.println("       buzz: " + isBuzzNumber(temp));

        //duck number checking
        System.out.println("       duck: " + isDuckNumber(temp));

        //palindrome number checking
        System.out.println("palindromic: " + isPalindrome(temp));
        System.out.println();

        //gapeful number checking
        System.out.println("     gapful: " + isGapfulNumber(temp));

        //spy number checking
        System.out.println("        spy: " + isSpyNumber(temp));

        System.out.println("     square: " + isSquareNumber(temp));
        System.out.println("      sunny: " + isSunnyNumber(temp));
        //even nd odd parity checking
        if(isEven(temp)) {
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
        String spy = isSpyNumber(temp) ? "spy, " : "";
        String square = isSquareNumber(temp) ? "square, " : "";
        String sunny = isSunnyNumber(temp) ? "sunny, " : "";
        String even = isEven(temp) ? "even" : "odd";

        System.out.printf("\t\t  %d is %s%s%s%s%s%s%s%s\n", temp, buzz, duck, palindromic, gapful, spy, square, sunny, even);
    }

    static void printRangedProperties(String[] input) {
        long temp1 = Long.parseLong(input[0]);
        long temp2 = Long.parseLong(input[1]);
        long buffer;
        for(int i=0;i<temp2;i++) {
            buffer = temp1 + i;
            printInLine(buffer);
        }
    }

    static void printRangedPropertiesWithFilter(String[] input) {
        long counter = Long.parseLong(input[1]);
        long start = Long.parseLong(input[0]);
        Optional<Properties> p = Properties.getProperty(input[2].toUpperCase());
        if(p.isPresent()) {
            Stream.iterate(start, n -> n + 1)
                    .filter(n -> p.get().getPredicate().test(n))
                    .limit(counter)
                    .forEach(OutputMethods::printInLine);

        }
    }

    static void printRangedPropertiesWithFilters(String[] input) {
        long counter = Long.parseLong(input[1]);
        long start = Long.parseLong(input[0]);

        Optional<Properties> property1 = Properties.getProperty(input[2].toUpperCase());
        Optional<Properties> property2 = Properties.getProperty(input[3].toUpperCase());
        if(property1.isPresent() && property2.isPresent()) {
            Stream.iterate(start, n -> n + 1)
                    .filter(n -> (property1.get().getPredicate().test(n)
                            && property2.get().getPredicate().test(n)))
                    .limit(counter)
                    .forEach(OutputMethods::printInLine);

        }
    }

    static void printSupportedRequests() {
        System.out.println("\nSupported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- two natural numbers and two properties to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.\n");
    }
}
