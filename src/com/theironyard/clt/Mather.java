package com.theironyard.clt;

/**
 * Any class that implements Mather must be able to
 * perform an action that takes in two integers,
 * and returns one.
 */

@FunctionalInterface
public interface Mather {

    int action(int a, int b);

}
