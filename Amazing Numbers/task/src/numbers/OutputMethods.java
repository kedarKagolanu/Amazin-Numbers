package numbers;

import java.util.List;
import java.util.Optional;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
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

        System.out.println("    jumping: " + isJumpingNumber(temp));
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
        String jumping = isJumpingNumber(temp) ? "jumping, " : "";
        String even = isEven(temp) ? "even" : "odd";

        System.out.printf("\t\t  %d is %s%s%s%s%s%s%s%s%s\n", temp, buzz, duck, palindromic, gapful, spy, square, jumping, sunny, even);
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

    static void printRangedPropertiesWithFilters(String[] input) {
        long counter = Long.parseLong(input[1]);
        long start = Long.parseLong(input[0]);

        var predicates = Properties.getPredicates(input);

        Stream.iterate(start, n -> n + 1)
                .filter(n -> processingInput(n,predicates))
                .limit(counter)
                .forEach(OutputMethods::printInLine);

    }

    static boolean processingInput(long input, List<LongPredicate> predicates) {
        //https://stackoverflow.com/questions/60121926/how-to-iterate-a-list-of-predicates

        return predicates.stream().allMatch(predicate -> predicate.test(input));
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
