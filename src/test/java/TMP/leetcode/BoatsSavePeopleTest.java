package TMP.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoatsSavePeopleTest {

    @Test
    public void numRescueBoats1() {
        BoatsSavePeople b = new BoatsSavePeople();
        int[] people = new int[]{1,2};
        int limit = 3;
        int ans = 1;
        int res = b.numRescueBoats(people, limit);
        assertEquals(ans, res);
    }

    @Test
    public void numRescueBoats2() {
        BoatsSavePeople b = new BoatsSavePeople();
        int[] people = new int[]{2,2};
        int limit = 6;
        int ans = 1;
        int res = b.numRescueBoats(people, limit);
        assertEquals(ans, res);
    }

    @Test
    public void numRescueBoats3() {
        BoatsSavePeople b = new BoatsSavePeople();
        int[] people = new int[]{3,1,7};
        int limit = 7;
        int ans = 2;
        int res = b.numRescueBoats(people, limit);
        assertEquals(ans, res);
    }
}