package graph.task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    private final int MAX = Integer.MAX_VALUE;
    private final String start = "00";


    public int minimumEffortPath(int[][] heights) {
        int rSize = heights.length, cSize = heights[0].length;
        int[][] pathArr = new int[rSize][cSize];
        for (int[] row : pathArr) {
            Arrays.fill(row, MAX);
        }
        pathArr[0][0] = 0;
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty()) {
            int[] curPos = q.poll();
            for (int[] move : moves) {
                int newY = curPos[0] + move[0];
                int newX = curPos[1] + move[1];
                if (newX < 0 || newX >= cSize || newY < 0 || newY >= rSize) {
                    continue;
                }
                int effort = Math.abs(heights[curPos[0]][curPos[1]] - heights[newY][newX]);
                int newEffort = Math.max(curPos[2], effort);
                int[] newPos = new int[]{newY, newX, newEffort};
                if (newEffort < pathArr[newY][newX]) {
                    q.offer(newPos);
                    pathArr[newY][newX] = newEffort;
                }
            }
        }
        return pathArr[rSize - 1][cSize - 1];
    }
}
