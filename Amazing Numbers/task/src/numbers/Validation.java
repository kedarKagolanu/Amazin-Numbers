package numbers;

import java.util.*;
import java.util.stream.Collectors;

public class Validation {

    public static boolean isNatural(String num) {
        long x;
        try {
            x = Long.parseLong(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return x > 0;
    }


    public static void PropertiesAreValid(String[] input) {
        // finding if there are any inputs that are not valid or a property.
         var tmp = Arrays.stream(input)
                 .skip(2)
                 .map(OutputMethods::clean)
                 .map(String::toUpperCase)
                 .collect(Collectors.partitioningBy(Properties::isProperty));


         //geting inputs that are partitioned to map associated with false key for the "isProperty" method.
        List<String> invalidInputs = tmp.get(false);
        //checking if there are any invalid inputs. If there exists atleast one,
        // will throw an Exception with a message depending on the number of invalid inputs.
        if(!invalidInputs.isEmpty()) {
            if(invalidInputs.size() == 1) {
                throw new IllegalArgumentException("The property " + invalidInputs + " is wrong.\nAvailable properties: " + Arrays.toString(Properties.values()));
            } else {
                throw new IllegalArgumentException("The properties " + invalidInputs + " are wrong.\nAvailable properties: " + Arrays.toString(Properties.values()));
            }
        }

        //validation for mutually exclusive pairs if they exist.

        String[] mutuallyExclusiveProperties = {"EVEN","ODD","DUCK","SPY","SUNNY","SQUARE"};
        List<String> mutuallayExclusivePairs = new ArrayList<>();
        var set = Arrays.stream(mutuallyExclusiveProperties)
                .collect(Collectors.toSet());

        var tempList = Arrays.stream(input)
                    .skip(2)
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

        //getting all the mutually exclusive pairs where both properties are same but in clean and unclean state in the tempList to mutualluExcusivePairs List.
        String str;
        for(int i=0;i<tempList.size();i++) {
            str = tempList.get(i);
            if(tempList.contains("-"+str)) {
                mutuallayExclusivePairs.add(str+", "+"-"+str);
            }
        }


        var temp2 = Arrays.stream(input)
                        .skip(2)
                        .map(String::toUpperCase)
                        .collect(Collectors.partitioningBy(OutputMethods::isClean));

        //getting all the mutually exclusive pairs in the cleanList to mutualluExcusivePairs List.
        var cleanInputs = temp2.get(true);
        for(int i=0;i<cleanInputs.size();i++) {
            String s = cleanInputs.get(i);
            if(set.contains(s)) {
                if(cleanInputs.contains(getPair(s))){
                    mutuallayExclusivePairs.add(s+", "+getPair(s));
                    cleanInputs.remove(getPair(s));
                }
            }
        }

        var unCleanInputs = temp2.get(false)
                                .stream()
                                .map(OutputMethods::clean)
                                .collect(Collectors.toList());

        //getting all the mutually exclusive pairs in the UnCleanList to mutualluExcusivePairs List.
        for(int i=0;i<unCleanInputs.size();i++) {
            String s = unCleanInputs.get(i);
            if(set.contains(s)) {
                if(unCleanInputs.contains(getPair(s))){
                    mutuallayExclusivePairs.add("-"+s+", "+"-"+getPair(s));
                    unCleanInputs.remove(getPair(s));
                }
            }
        }
        //if mutually pair exist, adding them to message and throwing an exception.
        if(!mutuallayExclusivePairs.isEmpty()){
            StringBuilder message = new StringBuilder("The request contains mutually exclusive properties: ");
            for(String s : mutuallayExclusivePairs) {
                message.append("[").append(s).append("]");
            }
            message.append("\nThere are no numbers with these properties.");

            throw new IllegalArgumentException(message.toString());
        }
    }

    static String getPair(String s) {
        String tmp;
        switch(s) {
            case "EVEN" : tmp = "ODD"; break;
            case "ODD" : tmp = "EVEN"; break;
            case "DUCK" : tmp = "SPY"; break;
            case "SPY" : tmp = "DUCK"; break;
            case "SUNNY" : tmp = "SQUARE"; break;
            case "SQUARE" : tmp = "SUNNY"; break;

            default:
                tmp = null;
        }

        return tmp;
    }
}
