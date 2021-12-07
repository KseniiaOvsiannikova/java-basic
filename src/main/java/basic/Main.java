package basic;

import java.io.IOException;
import java.util.ArrayList;

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

        }
    }
