package graphUtils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GraphV2Test {
    @Test
    public void creatingGraph() {
        /*
         *                0
         *          1           2
         *              3   4
         */
        int[][] graph = {{3,4},{4,2},{1,3},{0,2},{0,1}}; // pentagramm
//        int[][] graph = {{1,2},{3,0},{0,4},{4,1},{2,3}}; // pentaedr
        GraphV2 g = GraphV2.INSTANCE;
        g.setG(graph, 5);
        g.dfs(1);
        g.displayCycle();
        g.displayTopoSort();
    }
}