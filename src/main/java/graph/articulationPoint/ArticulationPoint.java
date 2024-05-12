package graph.articulationPoint;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {

    /**
     * Adds an edge to the given adjacency list representation of a graph.
     *
     * @param  adj  the adjacency list representation of the graph
     * @param  u    the starting vertex of the edge
     * @param  v    the ending vertex of the edge
     */
    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    /**
     * Recursive helper function for finding articulation points in a graph.
     *
     * @param  graph  the adjacency list representation of the graph
     * @param  u      the current vertex being visited
     * @param  parent the parent vertex of the current vertex
     * @param  low    an array to store the low value of each vertex
     * @param  disc   an array to store the discovery time of each vertex
     * @param  time   the current time
     * @param  used   an array to track if a vertex has been visited
     * @param  isAp   an array to store whether a vertex is an articulation point
     */
    private static void apUtil(List<List<Integer>> graph, int u, int parent, int[] low, int[] disc, int time, int[] used, boolean[] isAp) {
        int count = 0;
        used[u] = 1;
        low[u] = disc[u] = ++time;

        for (int v : graph.get(u)) {
            if (used[v] == 0) {
                count += 1;
                apUtil(graph, v, u, low, disc, time, used, isAp);

                low[u] = Math.min(low[u], low[v]);

                if (parent != -1 && disc[u] <= low[v]) {
                    isAp[u] = true;
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (parent == -1 && count > 1) {
            isAp[u] = true;
        }
    }

    /**
     * Finds the articulation points in a graph represented by an adjacency list.
     *
     * @param  adj    the adjacency list representation of the graph
     * @param  V      the number of vertices in the graph
     */
    private static void AP(List<List<Integer> > adj, int V) {
        int[] used = new int[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];
        int time = 0;

        // Adding this loop so that the
        // code works even if we are given
        // disconnected graph
        for (int u = 0; u < V; u++)
            if (used[u] == 0)
                apUtil(adj, u, -1, low, disc, time, used, isAP);

        for (int u = 0; u < V; u++)
            if (isAP[u])
                System.out.print(u + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating first example graph
        int V = 5;
        List<List<Integer> > adj1 = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj1.add(new ArrayList<>());
        }
        addEdge(adj1, 1, 0);
        addEdge(adj1, 0, 2);
        addEdge(adj1, 2, 1);
        addEdge(adj1, 0, 3);
        addEdge(adj1, 3, 4);
        System.out.println("Articulation points in first graph");
        AP(adj1, V);

        // Creating second example graph
        V = 4;
        List<List<Integer> > adj2 = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj2.add(new ArrayList<>());
        }

        addEdge(adj2, 0, 1);
        addEdge(adj2, 1, 2);
        addEdge(adj2, 2, 3);

        System.out.println("Articulation points in second graph");
        AP(adj2, V);

        // Creating third example graph
        V = 7;
        List<List<Integer> > adj3 = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj3.add(new ArrayList<>());
        }

        addEdge(adj3, 0, 1);
        addEdge(adj3, 1, 2);
        addEdge(adj3, 2, 0);
        addEdge(adj3, 1, 3);
        addEdge(adj3, 1, 4);
        addEdge(adj3, 1, 6);
        addEdge(adj3, 3, 5);
        addEdge(adj3, 4, 5);

        System.out.println("Articulation points in third graph");

        AP(adj3, V);
    }
}
