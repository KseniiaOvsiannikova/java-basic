package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

public class Arrays {
    public static void main(String[] args) throws IOException {

        //ввести 10 строк с клавиатуры и вывести их на экран в обратном порядке

        //Array
        Reader r = new InputStreamReader(System.in);
        System.out.println("Enter 10 Strings separating with Enter for Array:");
        BufferedReader reader = new BufferedReader(r);
        // ввод строк с клавиатуры
        String[] array = new String[10];
        for (int i = 0; i < array.length; i++) {
            String s = reader.readLine();
            array[i] = s;
        }
        System.out.println("Enter 10 Strings");
        // вывод содержимого массива на экран в обратном порядке
        for (int i = 0; i < array.length; i++) {
            int j = array.length - i - 1;
            System.out.println(array[j]);
        }

        //ArrayList
        System.out.println("Enter 10 Strings separating with Enter for ArrayList:");
        // ввод строк с клавиатуры
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            arrayList.add(s);
        }
        // вывод содержимого коллекции на экран в обратном порядке
        for (int i = 0; i < arrayList.size(); i++) {
            int j = arrayList.size() - i - 1;
            System.out.println(arrayList.get(j));
        }
    }
}
