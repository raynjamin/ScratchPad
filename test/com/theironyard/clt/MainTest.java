package com.theironyard.clt;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Ben on 4/19/16.
 */
public class MainTest {

    @Test
    public void wordsAreBalanced() {
        assertTrue(Main.balanced("abbt", "b"));  // returns true
        assertFalse(Main.balanced("creek", "e")); // returns false
        assertTrue(Main.balanced("prrt", "r"));  // returns true
        assertTrue(Main.balanced("wowx", "w"));  // returns true
    }

    @Test
    public void unchartedWorks() {
        assertTrue(Main.uncharted(new Integer[] {1, 2, 3}, new Integer[] {3, 2, 1}));             // returns true
        assertTrue(Main.uncharted(new Integer[] {1, 8, 9}, new Integer[] {8, 9, 1}));             // returns true
        assertTrue(Main.uncharted(new Integer[] {5, 4, 3, 2, 1}, new Integer[] {4, 1, 3, 5, 2})); // returns true
        assertFalse(Main.uncharted(new Integer[] {1, 2, 3}, new Integer[] {4, 5, 6}));             // returns false
        assertFalse(Main.uncharted(new Integer[] {1, 4, 6}, new Integer[] {1, 6, 5}));             // returns false
    }


    @Test
    public void properTip() {
        assertEquals(4.00, Main.bonus(20.00), .01);
        assertEquals(5.63, Main.bonus(23.37), .01);
    }

    @Test
    public void desirableHouses() {
        assertEquals(2, Main.desirables("RHHH"));
        assertEquals(3, Main.desirables("RHHHR"));
    }

    @Test
    public void colorsBlend() {
        Color[] colors = new Color[2];

        colors[0] = new Color(255, 0, 0);
        colors[1] = new Color(0, 0, 255);

        assertEquals(new Color(127, 0, 127), Main.colorBlender(colors));
    }

    @Test
    public void cherokeeHairWorks() {
        assertEquals(241, Main.cherokeeHair(150, .1, 5));
        assertEquals(3405, Main.cherokeeHair(550, .2, 10));
        assertEquals(1113, Main.cherokeeHair(220, .5, 4));

    }

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