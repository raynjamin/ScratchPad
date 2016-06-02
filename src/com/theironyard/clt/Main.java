package com.theironyard.clt;

import static javax.measure.unit.SI.*;
import static javax.measure.unit.NonSI.*;
import static org.jscience.economics.money.Currency.*;

import com.sun.deploy.util.StringUtils;
import com.sun.tools.javac.util.ArrayUtils;
import junit.extensions.TestSetup;
import org.jscience.economics.money.*;
import org.jscience.economics.money.Currency;
import org.jscience.physics.amount.Amount;
import sun.misc.Regexp;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        MountainBike bike = new MountainBike(4, 4, 4, 21);
        List<Double> test = new ArrayList<>();

        test.add(1.0);
        test.add(2.0);
        test.add(3.0);

        System.out.println(Algorithm.sumOfList(test));

        Algorithm.testMethod(5);

        Amount<Money> start = Amount.valueOf(19.99, USD);

        start = start.times(1.15);

        System.out.println(start.toText());
    }

    public static int countYZ(String input) {
        Matcher m = Pattern.compile("(\\w+)").matcher(input);
        int wordCount = 0;

        while (m.find()) {
            if (m.group(0).matches("\\w+[zZyY]{1}"))
                wordCount++;
        }

        return wordCount;
    }

    public static Map<String, Integer> wordLen(String[] strings) {
        return Arrays.asList(strings)
                .stream()
                .distinct()
                .collect(Collectors.toMap(k -> k, v -> v.length()));
    }

    public static int sumNumbers(String input) {
        Matcher matcher = Pattern.compile("(\\d+)").matcher(input);
        int sum = 0;

        while (matcher.find()) {
            for(int i = 1;i <= matcher.groupCount();i++) {
                sum += Integer.parseInt(matcher.group(i));
            }
        }

        return sum;
    }

    /**
     * Given an array of integers, returns the number of integer clumps in the array.
     * @param input The array of integers to review
     * @return The number of clumps present in the array.
     */
    public static int clumps(int[] input) {
        int clumps = 0;

        for (int i = 0;i < input.length - 1;i++) {

            if (input[i + 1] == input[i]) {
                clumps++;
            }

            while (i < input.length - 1 && input[i + 1] == input[i]) {
                i++;
            }
        }

        return clumps;
    }

    public static boolean equalIsNot(String input) {
        // by default, split trims any empty array elements at the end of
        // the array. Passing in a negative number stops that from happening.
        return input.split("is", -1).length == input.split("not", -1).length;
    }

    public static Map<String, Boolean> wordMultiple(String[] input) {
        List<String> listInput = Arrays.asList(input);

        return Arrays.stream(input)
                .distinct()
                .collect(
                    Collectors.toMap(
                        s -> s,
                        s -> listInput.indexOf(s) != listInput.lastIndexOf(s))
                );
    }

//    public static Object[] primeFactors(long max) {
//        max = (long)Math.sqrt((double)max);
//
//        Stream<Long> longStream = LongStream.range(0, max).mapToObj(Long::new).parallel();
//
//        for (long i = 2;i < max;i++) {
//
//            Object[] currArr = longStream.toArray();
//
//            for (long j = 0; j < currArr.length;j++) {
//                if (currArr[j]
//            }
//
//            longStream = longStream.filter(l -> j % l != 0);
//        }
//
//        return longStream.toArray();
//    }


    static String phoneNumRedux(String input) {
        input = input.replaceAll("[^\\d]", "");

        if (input.length() == 10) {
            return String.format("(%s) %s-%s",
                    input.substring(0, 3),
                    input.substring(3, 6),
                    input.substring(6));
        } else {
            return String.format("%s-%s",
                    input.substring(0, 3),
                    input.substring(3));
        }
    }

    static boolean isNarcissistic(Integer input) {
        char[] numbers = input.toString().toCharArray();

        int sum = 0;

        for(char i : numbers) {
            sum += Math.pow(Character.getNumericValue(i), numbers.length);
        }

        return sum == input;
    }

    static void printSumOfEvenFibs(int maxFib) {
        int sum = 0;
        ArrayList<Integer> fibs = new ArrayList<>();

        fibs.add(1);
        fibs.add(2);

        int nextFib = 2;

        do {
            if (nextFib % 2 == 0) {
                sum += nextFib;
            }

            nextFib = fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2);
            fibs.add(nextFib);
        } while (nextFib < maxFib);

        System.out.println(sum);
    }

    static void printSumOfFactors(int top) {
        int sum = 0;

        for (int i = 0;i < top;i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }

    static void puttingThisHereSoItsNotInMain() {
        ArrayList<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(Transaction.TransactionType.BILLS, 1, 400));
        transactions.add(new Transaction(Transaction.TransactionType.GROCERY, 2, 250));
        transactions.add(new Transaction(Transaction.TransactionType.ONLINE_SHOPPING, 3, 10));
        transactions.add(new Transaction(Transaction.TransactionType.BILLS, 4, 1200));
        transactions.add(new Transaction(Transaction.TransactionType.GAS, 5, 150));
        transactions.add(new Transaction(Transaction.TransactionType.GROCERY, 6, 234));
        transactions.add(new Transaction(Transaction.TransactionType.UTILITIES, 7, 250));
        transactions.add(new Transaction(Transaction.TransactionType.GROCERY, 8, 100));
        transactions.add(new Transaction(Transaction.TransactionType.ONLINE_SHOPPING, 9, 8));
        transactions.add(new Transaction(Transaction.TransactionType.ONLINE_SHOPPING, 10, 15));
        transactions.add(new Transaction(Transaction.TransactionType.BILLS, 11, 360));
        transactions.add(new Transaction(Transaction.TransactionType.GROCERY, 12, 110));
        transactions.add(new Transaction(Transaction.TransactionType.GAS, 13, 80));
        transactions.add(new Transaction(Transaction.TransactionType.BILLS, 14, 630));
        transactions.add(new Transaction(Transaction.TransactionType.BILLS, 15, 75));

        System.out.println(transactions.stream()
                .filter( t -> t.getType() == Transaction.TransactionType.BILLS)
                .collect(Collectors.summingInt(Transaction::getValue)));

        Map<Transaction.TransactionType, List<Transaction>> transactionMap =
                transactions.stream()
                        .collect(Collectors.groupingBy(Transaction::getType));


        transactionMap.forEach( (k, v) -> {
            System.out.printf("Type: %s, Number of transactions: %d\n", k.toString(), v.size());
        });
    }

    static int maxSpan(Integer[] integers) {
        List<Integer> list = Arrays.asList(integers);

        int max = 1;

        for (Integer i : list) {
            // if there is only one digit of this kind in the array,
            // the difference will return 0. We need to add 1 to any
            // array index difference to get the inclusive max.
            int diff = list.lastIndexOf(i) - list.indexOf(i) + 1;

            if (diff > max) {
                max = diff;
            }
        }

        return max;
    }

    static double monteCarloPi(long iterations) {

        int inside = 0;

        for(long i = 0;i < iterations;i++) {
            Point randomPoint = Point.generateRandom();
            double distance = Math.sqrt(Math.pow(randomPoint.getX(), 2.0) + Math.pow(randomPoint.getY(), 2.0));

            if (distance <= 1) {
                inside++;
            }
        }

        return 4 * (double)inside/iterations;
    }

    static int mather(Mather input, int a, int b) {
        return input.action(a, b);
    }

    static int boost(Integer input) {
        char[] arr = input.toString().toCharArray();

        for (int i = 0;i < arr.length;i++)  {
            Character c = arr[i];

            Integer digit = Integer.valueOf(c.toString());

            digit = digit < 9 ? ++digit : 0;

            arr[i] = digit.toString().toCharArray()[0];
        }


        return Integer.valueOf(String.valueOf(arr));
    }

    static void findLotteryWinner() {

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

    static int[] changeMe(int dollarAmount) {
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

    static boolean balanced(String word, String test) {
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

    static boolean uncharted(Integer[] a, Integer[] b) {
        HashSet<Integer> setA = new HashSet<>(Arrays.asList(a));
        HashSet<Integer> setB = new HashSet<>(Arrays.asList(b));

        return setA.equals(setB);
    }

    static void fizzBuzz(int maxNumber) {
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

    static void fizzBuzz2(int maxNumber) {
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

    static void fizzBuzz3(int maxNumber) {
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

    static double bonus(double dollaAmount) {
        double baseTip = dollaAmount * .2;
        double amountWithTip = dollaAmount  + baseTip;
        double additionalTip = Math.ceil(amountWithTip) - amountWithTip;

        return baseTip + additionalTip;
    }

    static int desirables(String input) {
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

    static Color colorBlender2(Color[] colors) {
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

    static Color colorBlender(Color[] colors) {
        int averageRed = Arrays.stream(colors).mapToInt(c -> c.getRed()).reduce(0, (n, m) -> n + m) / colors.length;
        int averageGreen = Arrays.stream(colors).mapToInt(c -> c.getGreen()).reduce(0, (n, m) -> n + m) / colors.length;
        int averageBlue = Arrays.stream(colors).mapToInt(c -> c.getBlue()).reduce(0, (n, m) -> n + m) / colors.length;

        return new Color(averageRed, averageGreen, averageBlue);
    }

    static double pursuit(Mover a, Mover b) {
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

    static int gimme(int[] input) {
        int max = (int)(Math.random()*input.length);

        return input[max];
    }

    static int cherokeeHair(int start, double rate, int weeks) {
        return (int)(start* Math.pow(1 + rate, weeks));
    }

    static Integer[] divisiblesSimpler(int[] base, int[] divisors) {
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

    static int[] divisibles(int[] base, int[] divisors){
        int divisor =
                Arrays.stream(divisors)
                    .reduce(1, (a, b) -> a * b);

        return Arrays.stream(base)
                .filter(i -> i % divisor == 0).toArray();
    }

    static String phoneNum(String crappyPhoneNum) {
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

    static int[] climb(int start, int length) {
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

    static String reverseWorse(String input) {
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = input.length() - 1;i >= 0;i--) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }

    static String reverse(String input) {
        char[] chars = input.toCharArray();


        for (int i = 0;i < input.length()/2;i++) {
            int mirrorIndex = (input.length() - 1) - i;
            char temp = chars[i];

            chars[i] = chars[mirrorIndex];
            chars[mirrorIndex] = temp;
        }

        return String.valueOf(chars);
    }

    static ArrayList<Integer> fibseq(int x) {
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