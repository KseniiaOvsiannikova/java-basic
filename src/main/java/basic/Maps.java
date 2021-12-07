package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Maps {

    public static void main(String[] args) {

        HashMap<Integer, String> passportsAndNames = new HashMap<>();

        passportsAndNames.put(212133, "Лидия Аркадьевна Бубликова");
        passportsAndNames.put(162348, "Иван Михайлович Серебряков");
        passportsAndNames.put(8082771, "Дональд Джон Трамп");

        //contains key and value
        System.out.println(passportsAndNames.containsKey(11111));
        System.out.println(passportsAndNames.containsValue("Дональд Джон Трамп"));

        //print in console keySet and arraylist values
        Set<Integer> keys = passportsAndNames.keySet();
        System.out.println("Ключи: " + keys);

        ArrayList<String> values = new ArrayList<>(passportsAndNames.values());
        System.out.println("Значения: " + values);

        //print map pairs in console after checking it is not empty
        if (!passportsAndNames.isEmpty()) {

            System.out.println(passportsAndNames);

        }

        //merge 2 maps
        HashMap<Integer, String> passportsAndNames2 = new HashMap<>();

        passportsAndNames2.put(917352, "Алексей Андреевич Ермаков");
        passportsAndNames2.put(925648, "Максим Олегович Архаров");


        passportsAndNames.putAll(passportsAndNames2);
        System.out.println(passportsAndNames);
        System.out.println("\n" + passportsAndNames2 + "\n");

        //print every pair in cycle
        for (Map.Entry entry: passportsAndNames.entrySet()) {

            System.out.println(entry);

        }
    }
}

