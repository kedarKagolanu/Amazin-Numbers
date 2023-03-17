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
    SUNNY(PropertiesMethods::isSunnyNumber),
    JUMPING(PropertiesMethods::isJumpingNumber);

    final private LongPredicate validate;

    Properties(LongPredicate lp) {
        this.validate = lp;
    }

    public LongPredicate getPredicate() { return validate; }

    public static List<LongPredicate> getPredicates(String[] input) {

        return Arrays.stream(input)
                .map(String::toUpperCase)
                .map(Properties::getProperty)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Properties::getPredicate)
                .collect(Collectors.toList());

    }

    public static Optional<Properties> getProperty(String input3) {
        return Arrays.stream(Properties.values())
                .filter(p -> p.toString().equals(input3))
                .findAny();
    }

    static boolean isProperty(String input3) {
        try {
            Properties.valueOf(input3);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

}