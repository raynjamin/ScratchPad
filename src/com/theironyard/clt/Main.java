package com.theironyard.clt;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(mather(new Adder(), 5, 6)); // 11
        System.out.println(mather(new Subtractor(), 5, 6)); // -1

        System.out.println(mather((a, b) -> a * b, 5, 6)); // 30
    }

    public static int mather(Mather input, int a, int b) {
        return input.action(a, b);
    }

    public static int boost(Integer input) {
        char[] arr = input.toString().toCharArray();

        for (int i = 0;i < arr.length;i++)  {
            Character c = arr[i];

            Integer digit = Integer.valueOf(c.toString());

            digit = digit < 9 ? ++digit : 0;

            arr[i] = digit.toString().toCharArray()[0];
        }


        return Integer.valueOf(String.valueOf(arr));
    }

    public static void findLotteryWinner() {

        Lottery lottery = new Lottery();

        lottery.guess("Jenna", 17);
        lottery.guess("Seth",  77);
        lottery.guess("Prince", 42);


        for(int i = 0;i < 100;i++) {
            lottery.pick();
        }

        HashMap<String, Integer> winners = lottery.getWinners();

        if (winners.size() == 0) {
            System.out.println("No winners this time.");
        } else {
            winners.forEach((key, value) -> {
                System.out.printf("%s wins bacon!\n", key);
            });
        }
    }



     public static int[] changeMe(int dollarAmount) {
        int twenties = 0, tens = 0, fives = 0, ones = 0;

        twenties = dollarAmount / 20;

        if (twenties > 0) {
            dollarAmount -= twenties * 20;
        }

        tens = dollarAmount / 10;

        if (tens > 0) {
            dollarAmount -= tens * 10;
        }

        fives = dollarAmount / 5;

        if (fives > 0) {
            dollarAmount -= fives * 5;
        }

        ones = dollarAmount;

        return new int[] { ones, fives, tens, twenties };

    }

    public static boolean balanced(String word, String test) {
        int sameCount = 0, differentCount = 0;

        for (Character s : word.toCharArray()) {
            if (s.toString().equals(test)) {
                sameCount++;
            } else {
                differentCount++;
            }
        }

        return sameCount == differentCount;
    }

    public static boolean uncharted(Integer[] a, Integer[] b) {
        HashSet<Integer> setA = new HashSet<>(Arrays.asList(a));
        HashSet<Integer> setB = new HashSet<>(Arrays.asList(b));

        return setA.equals(setB);
    }

    public static void fizzBuzz(int maxNumber) {
        for (int i =  1;i <= maxNumber;i++) {
            System.out.println(
                    i % 15 == 0 ?
                            "FizzBuzz" :
                            i % 3 == 0 ?
                                    "Fizz" :
                                    i % 5 == 0 ?
                                            "Buzz" : i);
        }
    }

    public static void fizzBuzz2(int maxNumber) {
        for(int i = 1; i <= maxNumber;i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void fizzBuzz3(int maxNumber) {
        if (maxNumber > 1) {
            fizzBuzz3(maxNumber - 1);
        }

        if (maxNumber % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if (maxNumber % 3 == 0) {
            System.out.println("Fizz");
        } else if (maxNumber % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(maxNumber);
        }
    }

    private static Character swallowedArrayAccess(Character[] input, int index) {
        Character results = 'C';

        try {
            results = input[index];

        } catch (ArrayIndexOutOfBoundsException ex) {

        }

        return results;
    }

    public static double bonus(double dollaAmount) {
        double baseTip = dollaAmount * .2;
        double amountWithTip = dollaAmount  + baseTip;
        double additionalTip = Math.ceil(amountWithTip) - amountWithTip;

        return baseTip + additionalTip;
    }

    public static int desirables(String input) {
        int results = 0;

        for(int i = 0;i < input.length();i++) {
            if (input.charAt(i) == 'H') {
                String substring = input.substring(
                        i - 2 < 0 ? 0 : i - 2,
                        i + 3 >= input.length() ? input.length() : i + 3);

                if (substring.contains("R")) {
                    results++;
                }
            }
        }

        return results;
    }

    public static Color colorBlender2(Color[] colors) {
        // take the average color for red, green, and blue
        int redSum = 0, greenSum = 0, blueSum = 0;

        // add them all together
        for (Color color : colors) {
            redSum += color.getRed();
            greenSum += color.getGreen();
            blueSum += color.getBlue();
        }

        // make a new color from this average and return it.
        return new Color(
                redSum / colors.length,
                greenSum / colors.length,
                blueSum / colors.length);

    }

    public static Color colorBlender(Color[] colors) {
        int averageRed = Arrays.stream(colors).mapToInt(c -> c.getRed()).reduce(0, (n, m) -> n + m) / colors.length;
        int averageGreen = Arrays.stream(colors).mapToInt(c -> c.getGreen()).reduce(0, (n, m) -> n + m) / colors.length;
        int averageBlue = Arrays.stream(colors).mapToInt(c -> c.getBlue()).reduce(0, (n, m) -> n + m) / colors.length;

        return new Color(averageRed, averageGreen, averageBlue);
    }

    public static double pursuit(Mover a, Mover b) {
        Mover first = a.position < b.position ? a : b;
        Mover second = a.position < b.position ? b : a;

        if (first.speed < second.speed) {
            return Double.POSITIVE_INFINITY;
        }

        double distance = second.position - first.position;
        double speed = first.speed - second.speed;
        double time = distance / speed;

        return (first.speed * time) + first.position;
    }

    public static int gimme(int[] input) {
        int max = (int)(Math.random()*input.length);

        return input[max];
    }

    public static int cherokeeHair(int start, double rate, int weeks) {
        return (int)(start* Math.pow(1 + rate, weeks));
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

        int time = 5;

        Thread a = new Thread(() -> {
            try {
                Thread.sleep(time * 1000);
            } catch (InterruptedException ex) {

            }


        });

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