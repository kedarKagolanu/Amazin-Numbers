package numbers;

import java.util.Arrays;
import java.util.EnumSet;

public class Validation {

    private static boolean isNatural(long d) {
        return ( d > 0 );
    }

    static boolean isValidInput(long num,boolean isSecondInput) {
        if(isNatural(num)) {
            return true;
        } else {
            if(isSecondInput) {
                System.out.println("\nThe second parameter should be a natural number.\n");
            } else {
                System.out.println("\nThe first parameter should be a natural number or zero.\n");
            }
            return false;
        }
    }

    static boolean isValidInput(String input3) {
        if(input3 == null) return false;

        if(!Properties.has(input3)) {
            System.out.println("\nThe property [" + input3 + "] is wrong.");
            System.out.println("Available properties: " + Arrays.toString(Properties.values()));
            return false;
        }
        return true;
    }
}
