package com.theironyard.clt;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here

    }

    public static Integer[] divisiblesSimpler(int[] base, int[] divisors) {
        int divisor = 1;
        ArrayList<Integer> validElements = new ArrayList<>();

        for(int i = 0;i < divisors.length;i++) {
            divisor *= divisors[i];
        }

        for(int i = 0;i < base.length;i++) {
            if (base[i] % divisor == 0) {
                validElements.add(base[i]);
            }
        }

        return validElements.toArray(new Integer[0]);
    }

    public static int[] divisibles(int[] base, int[] divisors){
        int divisor =
                Arrays.stream(divisors)
                    .reduce(1, (a, b) -> a * b);

        return Arrays.stream(base)
                .filter(i -> i % divisor == 0).toArray();
    }

    public static String phoneNum(String crappyPhoneNum) {
        String results = crappyPhoneNum;

        results = results.replaceAll("[^\\d]", "");

        if (results.length() == 7) {
            results = String.format("%s-%s",
                    results.substring(0, 3),
                    results.substring(3));

        } else if (results.length() == 10) {
            results = String.format("(%s) %s-%s",
                    results.substring(0, 3),
                    results.substring(3, 6),
                    results.substring(6, 10));
        } else {
            throw new IllegalArgumentException("This isn't a valid phone number.");
        }

        return results;
    }

    public static int[] climb(int start, int length) {
        int[] results = new int[length];

        for (int i = 0;i < length;i++) {
            if (i == 0) {
                results[i] = start;
            } else {
                results[i] = results[i-1] + i;
            }
        }

        return results;
    }

    public static String reverseWorse(String input) {
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = input.length() - 1;i >= 0;i--) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }

    public static String reverse(String input) {
        char[] chars = input.toCharArray();


        for (int i = 0;i < input.length()/2;i++) {
            int mirrorIndex = (input.length() - 1) - i;
            char temp = chars[i];

            chars[i] = chars[mirrorIndex];
            chars[mirrorIndex] = temp;
        }

        return String.valueOf(chars);
    }

    public static ArrayList<Integer> fibseq(int x) {
        ArrayList<Integer> base = new ArrayList<>();

        base.add(1);

        if (x == 1) {
            return base;
        }
        if (x == 2) {
            base.add(1);
            return base;
        } else {
            ArrayList<Integer> prev = fibseq(x - 1);

            prev.add(prev.get(prev.size() - 1) + prev.get(prev.size() - 2));

            return prev;

        }
    }
}