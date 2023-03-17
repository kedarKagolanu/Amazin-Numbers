package numbers;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//      write your code here
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!\n");

        OutputMethods.printSupportedRequests();

        while(true){
            try {
                System.out.print("\nEnter a request: ");
                String[] input = in.nextLine().split(" ");

                if(input.length == 0) {
                    OutputMethods.printSupportedRequests();
                    continue;
                }

                if(input[0].equals("0")) {
                    break;
                }

                if (!(Validation.isNatural(input[0])))
                    throw new IllegalArgumentException("The first parameter should be a natural number or zero.");

                if (input.length > 1)
                    if(!Validation.isNatural(input[1]))
                        throw new IllegalArgumentException("The second parameter should be a natural number.");

                Validation.PropertiesAreValid(input);

                switch(input.length) {
                    case 1 :
                        OutputMethods.printNumberProperties(input);
                        break;
                    case 2 :
                        OutputMethods.printRangedProperties(input);
                        break;
                    default : OutputMethods.printRangedPropertiesWithFilters(input);
                        break;
                }
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }



        System.out.println("GoodBye!");
    }
}