package numbers;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//      write your code here
        Scanner in = new Scanner(System.in);
        String inputArguements;
        long input1,input2;
        String input3 = null;
        boolean hasSecondInput,hasThirdInput;
        System.out.println("Welcome to Amazing Numbers!\n");

        OutputMethods.printSupportedRequests();

        while(true){
            input2 = 0;
            hasSecondInput = false;
            hasThirdInput = false;
            System.out.print("\nEnter a request: ");
            inputArguements = in.nextLine();

            if(inputArguements.isBlank()) {
                OutputMethods.printSupportedRequests();
                continue;
            }

            StringTokenizer st = new StringTokenizer(inputArguements);
            input1 = Long.parseLong(st.nextToken());
            if(st.hasMoreTokens()) {
                input2 = Long.parseLong(st.nextToken());
                hasSecondInput = true;
            }
            if(st.hasMoreTokens()) {
                input3 = st.nextToken().toUpperCase();
                hasThirdInput = true;
            }

            if(input1 == 0) {
                System.out.println("Goodbye!");
                System.exit(0);
            }

            if(!Validation.isValidInput(input1,false)) { continue; }

            if(hasSecondInput && !Validation.isValidInput(input2,true)) { continue; }

            if(hasThirdInput && !(Validation.isValidInput(input3))) { continue; }

            if(!hasSecondInput || input2 == 0) {
                OutputMethods.printProperties(input1);
            } else {
                if(!hasThirdInput)
                    OutputMethods.printProperties(input1,input2);
                else {
                    OutputMethods.printProperties(input1,input2,input3);
                }
            }
        }
    }
}