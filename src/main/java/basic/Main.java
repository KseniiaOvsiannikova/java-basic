package basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Enter 10 Strings separating with Enter for Array:");
        String[] array = Arrays.getArrayFromConsole(10);
        String[] reversedArray = Arrays.reverseArray(array);

        java.util.Arrays.stream(reversedArray).forEach(System.out::println);

        System.out.println("Enter 10 Strings separating with Enter for ArrayList:");
        ArrayList<String> arrayList = Arrays.getArraylistFromConsole(10);
        ArrayList<String> reversedArrayList = Arrays.reverseArrayList(arrayList);

        System.out.println(reversedArrayList);

        //maps
        HashMap<Integer, String> passportsAndNamesMap = Maps.addPassportsAndNames();
        Set<Integer> printKeysFromMap = Maps.printKeysAndValues(passportsAndNamesMap);
        ArrayList<String> printListOfValuesFromMap = Maps.printListOfValues(passportsAndNamesMap);
        HashMap<Integer, String> mergedTwoHashMaps = Maps.mergeTwoHashMaps(passportsAndNamesMap);
        HashMap<Integer, String> printEveryPairOfMapInCycle = Maps.printEveryPairOfMapInCycle(passportsAndNamesMap);

        //Strings

    }
}
