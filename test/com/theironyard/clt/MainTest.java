package com.theironyard.clt;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Ben on 4/19/16.
 */
public class MainTest {
    @Test
    public void climbWorks() throws Exception {
        assertArrayEquals(new int[] { 5, 6, 8}, Main.climb(5, 3));
        assertArrayEquals(new int[] { 8, 9, 11, 14, 18, 23}, Main.climb(8, 6));
        assertArrayEquals(new int[] { 1, 2, 4, 7}, Main.climb(1, 4));
    }


    @Test
    public void reverseworks() throws Exception {
        assertEquals("stnap", Main.reverse("pants"));
    }

    @Test
    public void reverseWorseWorks() throws Exception {
        assertEquals("stnap", Main.reverseWorse("pants"));
    }

    @Test
    public void fibseq() throws Exception {
        ArrayList<Integer> expected = new ArrayList<>();

        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(5);
        expected.add(8);

        assertEquals(expected, Main.fibseq(6));
    }
}