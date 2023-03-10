package numbers;

import java.util.EnumMap;
import java.util.function.LongPredicate;

public enum Properties{
    BUZZ(PropertiesMethods::isBuzzNumber),
    DUCK(PropertiesMethods::isDuckNumber),
    PALINDROMIC(PropertiesMethods::isPalindrome),
    GAPFUL(PropertiesMethods::isGapfulNumber),
    SPY(PropertiesMethods::isSpyNumber),
    EVEN(PropertiesMethods::isEven),
    ODD(PropertiesMethods::isOdd),
    SQUARE(PropertiesMethods::isSquareNumber),
    SUNNY(PropertiesMethods::isSunnyNumber);

    final private LongPredicate validate;

    Properties(LongPredicate lp) {
        this.validate = lp;
    }

    public LongPredicate getLongPredicate() {
        return validate;
    }

    public static boolean has(String input3) {
        for(Properties p: Properties.values()) {
            if(p.name().equals(input3)) return true;
        }
        return false;
    }
}