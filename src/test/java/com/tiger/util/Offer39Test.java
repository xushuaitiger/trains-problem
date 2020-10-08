package com.tiger.util;

import com.tiger.offer.arrayAndString.Offer29;
import com.tiger.offer.arrayAndString.Offer39;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Offer39Test {
    private static Offer39 offer39;

    @BeforeClass
    public  static void starting() {
        offer39 = new Offer39();
    }

    @Test
    public void testspiralOrder() {
        int[] test = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println("start offer 29 testing");
        assertEquals(offer39.majorityElement(test), 2);

    }
}
