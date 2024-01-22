package graph.task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindPathExistsGraphDJSTest {

    private FindPathExistsGraph_DJS f;

    @Before
    public void setUp() throws Exception {
        f = new FindPathExistsGraph_DJS();
    }

    @Test
    public void validPath() {
        int n = 3, edges[][] = {{0,1},{1,2},{2,0}}, source = 0, destination = 2;
        boolean isPath = f.validPath(n, edges, source, destination);
        assertTrue(isPath);
    }
}