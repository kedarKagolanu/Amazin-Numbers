package numbers;

public class PropertiesMethods {

    static boolean isEven(long num) {
        return num % 2 == 0;
    }

    static boolean isOdd(long num) { return !isEven(num);}

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

    static long getDigitsSum(long num) {
        long sum = 0;
        while(num > 0) {
            sum += num%10;
            num/=10;
        }
        return sum;
    }

    static long getDigitsProduct(long num) {
        long product = 1;
        while(num > 0) {
            product *= num%10;
            num/=10;
        }
        return product;
    }
    static boolean isSpyNumber(long num) {
        return getDigitsSum(num) == getDigitsProduct(num);
    }

    static boolean isSunnyNumber(long num) {
        return isSquareNumber(num+1);
    }

    static boolean isSquareNumber(long num) {
        double temp = Math.sqrt(num);
        return num != Math.floor(temp);
    }
}
