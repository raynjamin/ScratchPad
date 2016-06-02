package com.theironyard.clt;

import java.lang.*;
import java.lang.Number;
import java.util.List;

public class Algorithm<T> {
//    public static <T extends Integer> T add(T a, T b) {
//        return (T)(Integer)((Integer)a + (Integer)b);
//    }

    T echo(T input) {
        return input;
    }

    public static Number testMethod(Number testNumber) {
        return testNumber;
    }
    public static <T extends Number> double sumOfList(List<T> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }
}
