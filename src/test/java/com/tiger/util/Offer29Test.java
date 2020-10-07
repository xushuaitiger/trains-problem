package com.tiger.util;

import com.tiger.offer.arrayAndString.Offer29;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Offer29Test {
    private static Offer29 offer29;

    @BeforeClass
    public  static void starting() {
        offer29 = new Offer29();
    }

    @Test
    public void testspiralOrder() {
        int[][] test = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println("start offer 29 testing");
        assertArrayEquals(offer29.spiralOrder(test),
                new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7});
        System.out.println("test of offer 29 successfully passed!");
    }
}
