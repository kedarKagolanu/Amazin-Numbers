package numbers;

import java.util.Arrays;
import java.util.BitSet;

public class Validation {

    public static boolean isNatural(String num) {
        long x = -1;
        try {
            x = Long.parseLong(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return x > 0;
    }

    public static boolean isValid(String p) {
        if(!Properties.isProperty(p.toUpperCase()))
            throw new IllegalArgumentException("The property [" + p.toUpperCase() + "] is wrong.\nAvailable properties: " + Arrays.toString(Properties.values()));

        return true;
    }

    public static boolean areValid(String p1,String p2,BitSet is) {
        boolean firstPropertyIsValid = Properties.isProperty(p1.toUpperCase());
        boolean secondPropertyIsValid = Properties.isProperty(p2.toUpperCase());

        if(!firstPropertyIsValid && !secondPropertyIsValid)
            throw new IllegalArgumentException("The properties [" + p1.toUpperCase() +", "+ p2.toUpperCase()+ "] are wrong.\n" +
                    "Available properties:" + Arrays.toString(Properties.values()));
        else if(!firstPropertyIsValid)
            throw new IllegalArgumentException("The property [" + p1.toUpperCase() + "] is wrong.\nAvailable properties: " + Arrays.toString(Properties.values()));
        else if(!secondPropertyIsValid)
            throw new IllegalArgumentException("The property [" + p2.toUpperCase() + "] is wrong.\nAvailable properties: " + Arrays.toString(Properties.values()));


        if(Validation.mutuallyExclusive(p1.toUpperCase(),p2.toUpperCase())) {
            System.out.println("The request contains mutually exclusive properties: ["+ p1.toUpperCase() + ", " + p2.toUpperCase() +"]\nThere are no numbers with these properties.");
            return false;
        }

        return true;
    }

    public static boolean mutuallyExclusive(String input1,String input2) {
        if((input1.equals("EVEN") && input2.equals("ODD")) || (input1.equals("ODD") && input2.equals("EVEN")))
            return true;

        if((input1.equals("DUCK") && input2.equals("SPY")) || (input1.equals("SPY") && input2.equals("DUCK")))
            return true;

        return (input1.equals("SUNNY") && input2.equals("SQUARE")) || (input1.equals("SQUARE") && input2.equals("SUNNY"));
    }
}
