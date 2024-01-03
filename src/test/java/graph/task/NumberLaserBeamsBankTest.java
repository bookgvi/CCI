package graph.task;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class NumberLaserBeamsBankTest {

    private NumberLaserBeamsBank n = new NumberLaserBeamsBank();

    @Before
    public void init() {
        n = new NumberLaserBeamsBank();
    }

    @Test
    public void testNumberOfBeams() {
        // Test case 1: Single row with no beams
        String[] bank1 = {"00000"};
        int result1 = n.numberOfBeams(bank1);
        Assertions.assertEquals(0, result1);
    }

    // Test case 2: Single row with one beam
    @Test
    public void testNumberOfBeams1() {
        String[] bank2 = {"01000"};
        int result2 = n.numberOfBeams(bank2);
        Assertions.assertEquals(0, result2);
    }

    // Test case 3: Multiple rows with multiple beams
    @Test
    public void testNumberOfBeams2() {
        String[] bank3 = {"01000", "00100", "00010"};
        int result3 = n.numberOfBeams(bank3);
        Assertions.assertEquals(2, result3);
    }

    // Test case 4: Multiple rows with no beams
    @Test
    public void testNumberOfBeams3() {
        String[] bank4 = {"00000", "00000", "00000"};
        int result4 = n.numberOfBeams(bank4);
        Assertions.assertEquals(0, result4);
    }

    @Test
    public void testNumberOfBeams4() {
        String[] bank4 = {"011001","000000","010100","001000"};
        int result4 = n.numberOfBeams(bank4);
        Assertions.assertEquals(8, result4);
    }
    @Test
    public void testNumberOfBeams5() {
        String[] bank4 = {"00000","00101","10100","11110","11100","01001","00100","11010"};
        int result4 = n.numberOfBeams(bank4);
        Assertions.assertEquals(35, result4);
    }

}