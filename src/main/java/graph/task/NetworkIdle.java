package graph.task;
import java.util.PriorityQueue;

public class NetworkIdle {
    public int earliestMoment(int[][] edges, int[] patience) {
            int n = patience.length;
            int[] lastSent = new int[n]; // To keep track of the last sent time for each server

            // Create a priority queue to store the messages
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

            // Initialize the priority queue with the initial messages from all data servers
            for (int i = 1; i < n; i++) {
                pq.offer(new int[]{patience[i], i});
                lastSent[i] = patience[i];
            }

            int currentTime = 0;

            while (!pq.isEmpty()) {
                int[] message = pq.poll();
                int time = message[0];
                int server = message[1];

                if (time > currentTime) {
                    currentTime = time;
                }

                if (server == 0) {
                    continue;
                }

                if (currentTime - lastSent[server] >= patience[server]) {
                    continue;
                }

                time = currentTime + patience[server];
                pq.offer(new int[]{time, server});
                lastSent[server] = currentTime;

                // Check if there are any outgoing connections from the current server
                for (int[] edge : edges) {
                    if (edge[0] == server) {
                        int nextServer = edge[1];
                        if (currentTime - lastSent[nextServer] >= patience[nextServer]) {
                            time = currentTime + patience[nextServer];
                            pq.offer(new int[]{time, nextServer});
                            lastSent[nextServer] = currentTime;
                        }
                    }
                }
            }

            return currentTime;
    }
}