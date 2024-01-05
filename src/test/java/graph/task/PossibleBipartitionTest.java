package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PossibleBipartitionTest {
    
    private PossibleBipartition p = new PossibleBipartition();
    
    @Before
    public void init() {
        p = new PossibleBipartition();
    }

    @Test
    public void testPossibleBipartition2() {
        // Testing for a small graph with dislikes
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 1}};
        assertFalse(p.possibleBipartition(3, dislikes));
    }

    @Test
    public void testPossibleBipartition4() {
        // Testing for a disconnected graph with dislikes
        int[][] dislikes = {{1, 2}, {3, 4}};
        assertTrue(p.possibleBipartition(4, dislikes));
    }

    @Test
    public void testPossibleBipartition5() {
        // Testing for a large graph with dislikes
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 10}, {10, 1}};
        assertTrue(p.possibleBipartition(10, dislikes));
    }

    @Test
    public void testPossibleBipartition6() {
        // Testing for a disconnected graph with dislikes
        int[][] dislikes = {{1, 2}, {1, 3}, {2,3}};
        assertFalse(p.possibleBipartition(3, dislikes));
    }
    @Test
    public void testPossibleBipartition7() {
        // Testing for a disconnected graph with dislikes
        int[][] dislikes = {{1,2},{3,4},{4,5},{3,5}};
        assertFalse(p.possibleBipartition(5, dislikes));
    }
    @Test
    public void testPossibleBipartition8() {
        // Testing for a disconnected graph with dislikes
        int[][] dislikes = {{24,30},{39,46},{20,25},{15,20},{30,41},{17,20},{2,22},{8,50},{13,30},{2,5},{18,30},{16,50},{3,24},{3,45},{4,46},{11,22},{8,26},{5,47},{28,46},{5,7},{35,36},{18,20},{15,49},{25,49},{3,23},{30,31},{5,24},{4,16},{4,35},{8,38},{32,35},{22,42},{5,34},{20,36},{7,35},{10,22},{8,12},{1,49},{16,43},{5,14},{20,42},{35,41},{8,18},{5,27},{5,26},{30,45},{11,16},{22,23},{5,37},{22,26},{11,35},{26,49},{21,49},{20,47},{3,17},{14,22},{21,46},{29,49},{8,45},{22,45},{5,43},{20,21},{8,32},{13,16},{16,32},{11,46},{15,46},{2,49},{8,25},{3,44},{5,17},{20,31},{21,30},{17,22},{35,39},{16,48},{12,46},{46,50},{20,33},{3,6},{32,49},{22,36},{20,28},{12,49},{1,30},{6,46},{3,15},{18,22},{16,42},{30,50},{5,13},{20,43},{3,21},{3,25},{46,47},{22,33},{1,20},{16,17},{40,46},{5,36},{12,20},{35,44},{16,36},{22,27},{3,10},{2,30},{31,49},{5,6},{35,50},{8,29},{20,40},{25,46},{25,35},{5,29},{20,27},{5,42},{30,44},{8,33},{9,22},{5,39},{35,43},{9,49},{17,49},{3,47},{26,46},{6,8},{20,24},{3,32},{22,47},{30,40},{7,30},{16,19},{12,30},{35,38},{16,44},{5,9},{11,49},{43,46},{14,30},{13,46},{20,34},{26,35},{22,37},{21,35},{45,49},{10,46},{5,32},{12,16},{30,47},{3,13},{7,46},{10,49},{6,20},{18,49},{17,35},{13,49},{3,41},{22,38},{2,46},{8,37},{16,18},{30,38},{35,47},{33,35},{41,46},{20,26},{8,11},{16,40},{23,30},{5,15},{20,41},{3,19},{5,28},{4,20},{3,36},{5,41},{8,34},{16,31},{5,38},{35,42},{9,35},{1,8},{42,46},{3,29},{8,27},{4,30}};
        assertTrue(p.possibleBipartition(50, dislikes));
    }
}