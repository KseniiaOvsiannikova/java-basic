package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Maps {

    static HashMap<Integer, String> addPassportsAndNames() {
        HashMap<Integer, String> passportsAndNames = new HashMap<>();

        passportsAndNames.put(212133, "Jackson Eric");
        passportsAndNames.put(162348, "Gagarin Jury");
        passportsAndNames.put(8082771, "Jackson Jack");
        //print map pairs in console after checking it is not empty
        if (!passportsAndNames.isEmpty()) {
            System.out.println(passportsAndNames);
        }

        return passportsAndNames;
    }

    static Set<Integer> printKeysAndValues(HashMap<Integer, String> passportsAndNames) {
        System.out.println("passportsAndNames.containsKey(11111): " + passportsAndNames.containsKey(11111));
        Set<Integer> keys = passportsAndNames.keySet();
        System.out.println("Keys of the Map: " + keys);

        return keys;
    }

    static ArrayList<String> printListOfValues(HashMap<Integer, String> passportsAndNames) {
        System.out.println("passportsAndNames.containsValue(\"Jackson Eric\"): " + passportsAndNames.containsValue("Jackson Eric"));
        ArrayList<String> values = new ArrayList<>(passportsAndNames.values());
        System.out.println("Values of the Map: " + values);

        return values;
    }

    static HashMap<Integer, String> mergeTwoHashMaps(HashMap<Integer, String> passportsAndNames) {
        HashMap<Integer, String> passportsAndNamesToMerge = new HashMap<>();
        passportsAndNamesToMerge.put(917352, "Gagarin Jane");
        passportsAndNamesToMerge.put(925648, "Smith Joe");

        passportsAndNames.putAll(passportsAndNamesToMerge);
        System.out.println("Map to merge contains:" + passportsAndNamesToMerge);
        System.out.println("Map after merge contains: " + passportsAndNames + "\n");

        return passportsAndNamesToMerge;
    }

    static HashMap<Integer, String> printEveryPairOfMapInCycle(HashMap<Integer, String> passportsAndNames) {
        for (Map.Entry entry : passportsAndNames.entrySet()) {
            System.out.println("Each element of the Map in cicle: " + entry);
        }
        return passportsAndNames;
    }
}


