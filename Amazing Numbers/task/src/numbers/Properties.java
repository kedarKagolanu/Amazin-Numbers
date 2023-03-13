package numbers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;

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

    public static List<Properties> getProperties(long num) {
        return Arrays.stream(Properties.values())
                .filter(p -> p.validate.test(num))
                .collect(Collectors.toList());
    }

    public LongPredicate getPredicate() { return validate; }

    public static Optional<Properties> getProperty(String input3) {
        return Arrays.stream(Properties.values())
                .filter(p -> p.toString().equals(input3))
                .findAny();
    }

    static boolean isProperty(String input3) {
        return getProperty(input3.toUpperCase()).isPresent();
    }
}