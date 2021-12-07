package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Arrays {


    static String[] getArrayFromConsole(int length) throws IOException {

        String[] array = new String[length];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < length; i++) {
            array[i] = reader.readLine();
        }
        return array;
    }

    static String[] reverseArray(String[] array) {
        String[] reversedArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            int j = array.length - i - 1;
            reversedArray[j] = array[i];
        }
        return reversedArray;
    }

    static ArrayList<String> getArraylistFromConsole(int length) throws IOException {

        ArrayList<String> arrayList = new ArrayList<String>();
        Reader r = new InputStreamReader(System.in);
        System.out.println("Enter 10 Strings separating with Enter for Array:");
        BufferedReader reader = new BufferedReader(r);
        for (int i = 0; i < 10; i++) {
            arrayList.add(reader.readLine());
        }

        return arrayList;
    }

    static ArrayList<String> reverseArrayList(ArrayList<String> arrayList) {
        ArrayList<String> reversedArrayList = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            int j = arrayList.size() - i - 1;
            System.out.println(arrayList.get(j));
        }

        return reversedArrayList;
    }
}



