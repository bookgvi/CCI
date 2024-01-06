package graph.task;

import java.util.Arrays;

public class MaximumProfitJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int count = profit.length;
        // max value ended at index
        int[] dp = new int[count];
        dp[0] = profit[0];
        for (int i = 1; i < count; ++i) {
            int indexForValidEndTime = binSearch(startTime, endTime, i);
            int curMaxProfit = profit[i];
            if (indexForValidEndTime >= 0) {
                curMaxProfit += dp[indexForValidEndTime];
            }
            dp[i] = Math.max(dp[i - 1], curMaxProfit);
        }
        return dp[count - 1];
    }

    private int binSearch(int[] startTime, int[] endTime, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            if (endTime[mid] <= startTime[index]) {
                if (endTime[mid + 1] <= startTime[index]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }


    static class MaximumProfitJobs {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int n = startTime.length;

            // Create a Job class to store the start time, end time, and profit
            Job[] jobs = new Job[n];
            for (int i = 0; i < n; i++) {
                jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
            }

            // Sort the jobs array based on the end time in ascending order
            Arrays.sort(jobs, (a, b) -> a.end - b.end);

            // Create a dp array to store the maximum profit at each index
            int[] dp = new int[n];
            dp[0] = jobs[0].profit;

            for (int i = 1; i < n; i++) {
                // Find the latest non-overlapping job
                int latestNonOverlappingJob = binarySearch(jobs, i);

                // Calculate the maximum profit at the current index
                int profitIncludingCurrentJob = jobs[i].profit;
                if (latestNonOverlappingJob != -1) {
                    profitIncludingCurrentJob += dp[latestNonOverlappingJob];
                }

                dp[i] = Math.max(profitIncludingCurrentJob, dp[i - 1]);
            }

            return dp[n - 1];
        }

        // Binary search to find the latest non-overlapping job
        private int binarySearch(Job[] jobs, int index) {
            int low = 0;
            int high = index - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (jobs[mid].end <= jobs[index].start) {
                    if (jobs[mid + 1].end <= jobs[index].start) {
                        low = mid + 1;
                    } else {
                        return mid;
                    }
                } else {
                    high = mid - 1;
                }
            }

            return -1;
        }

        // Job class to store the start time, end time, and profit
        private static class Job {
            int start;
            int end;
            int profit;

            public Job(int start, int end, int profit) {
                this.start = start;
                this.end = end;
                this.profit = profit;
            }
        }
    }
}
