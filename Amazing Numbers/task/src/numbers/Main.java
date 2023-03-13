package numbers;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//      write your code here
        Scanner in = new Scanner(System.in);
        BitSet inputStatus = new BitSet(4);
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

                for(int i=0;i<input.length;i++) {
                    inputStatus.set(i,true);
                }

                if (!(Validation.isNatural(input[0])))
                    throw new IllegalArgumentException("The first parameter should be a natural number or zero.");

                if (inputStatus.get(1))
                    if(!Validation.isNatural(input[1]))
                        throw new IllegalArgumentException("The second parameter should be a natural number.");


                switch(inputStatus.length()) {
                    case 1 :
                        OutputMethods.printNumberProperties(input);
                        break;
                    case 2 :
                        OutputMethods.printRangedProperties(input);
                        break;
                    case 3 :
                        if(Validation.isValid(input[2])) {
                            OutputMethods.printRangedPropertiesWithFilter(input);
                        }
                        break;
                    case 4 :
                        if(Validation.areValid(input[2],input[3],inputStatus)) {
                            OutputMethods.printRangedPropertiesWithFilters(input);
                        }
                        break;
                }
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            inputStatus.clear();
        }



        System.out.println("GoodBye!");
    }
}