package com.tiger.interview.ringcentral;

import com.tiger.offer.arrayAndString.Offer39;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RingCentralTest {

    private static MergeRange mergeRange;

    @BeforeClass
    public  static void starting() {
        mergeRange = new MergeRange();
    }

    @Test
    public void testspiralOrder() {
       int[][] test = new int[][]{{1,6},{2,7},{1,4},{5,9},{4,8}};
       int[][] expect = new int[][]{{1,9}};
       assertArrayEquals(mergeRange.merge(test),expect);
    }
}
