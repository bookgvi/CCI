package graph.task;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int dublicate = -1;
        int i = 0;
        while (i < n) {
            if (!visited[nums[i] - 1]) {
                visited[nums[i] - 1] = true;
            } else {
                dublicate = nums[i];
            }
            ++i;
        }
        for (i = 0; i < n; ++i) {
            if (!visited[i]) {
                break;
            }
        }
        return new int[]{dublicate, i + 1};
    }
}
