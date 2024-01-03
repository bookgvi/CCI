package graph.task;

import java.util.LinkedList;
import java.util.Queue;

public class NumberLaserBeamsBank {

    public int numberOfBeams(String[] bank) {
        int row = 0;
        Queue<Integer> q = new LinkedList<>();
        while(row < bank.length && q.isEmpty()) {
            String first = bank[row++];
            for (int i = 0, len = first.length(); i < len; i += 1) {
                if (first.charAt(i) == '1') {
                    q.offer(i);
                }
            }
        }
        int ans = 0;
        while (row != bank.length && !q.isEmpty()) {
            int res = 0;
            int count = q.size();
            Queue<Integer> newRowQ = new LinkedList<>();

            for (int i = 0, len = bank[row].length(); i < len; i += 1) {
                if (bank[row].charAt(i) == '1') {
                    newRowQ.offer(i);
                    res += 1;
                }
            }
            if (!newRowQ.isEmpty()) {
                q = newRowQ;
                res *= count;
            }
            ans += res;
            row += 1;
        }
        return ans;
    }
}
