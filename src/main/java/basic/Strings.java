package basic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.stream.Stream;

public class Strings {

    public static void main(String[] args) throws IOException {

        final Logger logger = LogManager.getRootLogger();

        String over = "What is Overloading and Overriding? When two or more methods in the same class have the same name but different parameters, it's called Overloading." +
                " When the method signature (name and parameters) are the same in the superclass and the child class, it's called Overriding.";
        String overloading = "When two or more methods in the same class have the same name but different parameters.";
        String containedSymbol = "a";
        String containedWord = "what";
        String symbolToFindIndex = ",";

        logger.info(String.format("Symbol with index 3 is %s", over.charAt(3)));

        logger.info("String length is equal to comparable text length - result is " + (overloading.compareTo("When two or more methods in the same class have the same name but different parameters.")));
        logger.info("String length is less then comparable text length - result is " + (overloading.compareTo("When two or more methods in the same class have the same name but different parameters....")));
        logger.info("String length is more then comparable text length - result is " + (overloading.compareTo("When two or more methods in the same class have the same name but different parameters")));

        System.out.println(over.compareTo(overloading)); // -4 - wtf? :) - overloading>over by 4 symbols

        logger.info("String contains symbol - " + containedSymbol + ". Result is " + over.contains(containedSymbol));
        logger.info("String contains word - " + containedWord + ". Result is " + over.toLowerCase(Locale.ROOT).contains(containedWord));

        logger.info("\nIndex of first symbol " + symbolToFindIndex + " in String\n" + over + "\nis " + over.indexOf(symbolToFindIndex));
        logger.info("\nIndex of last symbol " + symbolToFindIndex + " in String\n" + over + "\nis " + over.lastIndexOf(symbolToFindIndex));

        logger.info("".isEmpty());
        logger.info(" ".isEmpty());

        logger.info("Length of String\n" + over + "\nis " + over.length() + "\n");


        logger.info("Regex methods are covered further. Details os https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html");
        String[] overWords = over.toLowerCase(Locale.ROOT).split(" ");
        logger.info("String\n" + over + "\ncontains " + overWords.length + " words.");

        int cutFromIndex = 4;
        int cutToIndex = 8;
        String middlePartOfStringOver = over.substring(cutFromIndex, cutToIndex);
        String firstPartOfStringOver = over.substring(0, cutFromIndex);
        String lastPartOfStringOver = over.substring(cutToIndex, over.length());
        logger.info("String between " + cutFromIndex + " and " + cutToIndex + " symbol index:  " + middlePartOfStringOver);
        logger.info("First part of trimmed string to " + cutFromIndex + " symbol index:  " + firstPartOfStringOver);
        logger.info("Last part of trimmed string after " + cutToIndex + " symbol index:  " + lastPartOfStringOver + "\n");

        char[] array = middlePartOfStringOver.toCharArray();
        logger.info("Length of middlePartOfStringOver: " + array.length + "\n");


        //Reverse words direction
        List<String> list = new ArrayList<>();
        char[] overChars = over.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int charLength = overChars.length;
        for (int i = 0; i < overChars.length; i++) {
            if (overChars[i] == ' ') {
                list.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                continue;
            }
            stringBuilder.append(overChars[i]);
            if (i == charLength - 1) {
                list.add(stringBuilder.toString());
            }
        }
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }

        StringBuilder reversedWordsDirection = new StringBuilder();
        while (listIterator.hasPrevious()) {
            reversedWordsDirection.append(listIterator.previous()).append(" ");
        }
        System.out.println("String with reversed words direction: " + reversedWordsDirection.substring(0, reversedWordsDirection.length() - 1));

        //String after reverse option 1
        String reverse = new StringBuffer(over).reverse().toString();
        System.out.println("String before reverse: " + over);
        System.out.println("String after reverse option 1: " + reverse);

        //String after reverse option 2
        StringBuilder reversed = new StringBuilder();
        for (String word : overWords) {
            reversed.append(new StringBuilder(word).reverse())
                    .append(" ");
        }
        System.out.println("String after reverse option 2: " + reversed);

        //String after reverse option 3
        StringBuilder reversedWords = new StringBuilder();
        Stream.of(over.split(" "))
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .forEach(word -> reversedWords.append(word).append(" "));
        System.out.println("String after reverse option 3: " + reversedWords);

        //String after reverse option 4
        String reversedString = "";
        for (int i = 0; i < overWords.length; i++) {
            String word = overWords[i];
            String reverseWord = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord = reverseWord + word.charAt(j);
            }
            reversedString = reversedString + reverseWord + " ";
        }
        System.out.println("String after reverse option 4: " + reversedString);


        //Count concrete symbols in string
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] charsFromStringOver = over.toCharArray();

        for (int i = 0; i < charsFromStringOver.length; i++) {
            if (!map.containsKey(charsFromStringOver[i])) {
                map.put(charsFromStringOver[i], 1);
            }
            map.put(charsFromStringOver[i], map.get(charsFromStringOver[i]) + 1);
        }

        System.out.println("String with counted symbols: " + map.toString());


        //Words in alphabetic order
        Arrays.sort(overWords);
        for (String word : overWords) {
            System.out.println(word);
        }

        //Cut trailing whitespaces
        System.out.println("".strip());
        System.out.println("  both  ".strip());
        System.out.println("  leading".strip());
        System.out.println("trailing  ".strip());
    }
}


