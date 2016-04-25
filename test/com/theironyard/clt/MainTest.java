package com.theironyard.clt;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Ben on 4/19/16.
 */
public class MainTest {

    @Test
    public void divisiblesWork() {
        assertArrayEquals(new Integer[] { 18 }, Main.divisiblesSimpler(new int[] { 10, 4, 18, 11, 91}, new int[] { 2, 9 }));
        assertArrayEquals(new Integer[] { 10, 4, 18 }, Main.divisiblesSimpler(new int[] { 10, 4, 18, 11, 91}, new int[] { 2 }));
        assertArrayEquals(new Integer[] { 18 }, Main.divisiblesSimpler(new int[] { 10, 4, 18, 11, 91}, new int[] { 3 }));
    }

    @Test
    public void phoneNumsGetNormalized() throws Exception {
        assertEquals("(812) 671-3221", Main.phoneNum("8126713221"));
        assertEquals("(910) 875-6789", Main.phoneNum("(910)8756789"));
        assertEquals("(565) 987-6880", Main.phoneNum("565 987 6880"));
        assertEquals("727-9331", Main.phoneNum("7  2 7--933-1"));
    }

    @Test
    public void climbWorks() throws Exception {
        assertArrayEquals(new int[] { 5, 6, 8 }, Main.climb(5, 3));
        assertArrayEquals(new int[] { 8, 9, 11, 14, 18, 23 }, Main.climb(8, 6));
        assertArrayEquals(new int[] { 1, 2, 4, 7 }, Main.climb(1, 4));
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