package graph.task;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FindPlayersWithZeroOneLossesTest implements ListTests {

    private FindPlayersWithZeroOneLosses f;

    @Before
    public void setUp() throws Exception {
        f = new FindPlayersWithZeroOneLosses();
    }

    @Test
    public void findWinners() {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1,2,10), Arrays.asList(4,5,7,8));

        List<List<Integer>> res = f.findWinners(matches);
        for (int i = 0; i < 2; ++i) {
            assertListEquals(expected.get(i), res.get(i));
        }
    }
}