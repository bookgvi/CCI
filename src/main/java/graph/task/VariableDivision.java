package graph.task;

import java.util.*;

/**
 * You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
 * <p>
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 * <p>
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * <p>
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero
 * and that there is no contradiction.
 * <p>
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 * <p>
 * <p>
 * In this example, we create a VariableGraph class to represent the graph and its nodes.
 * The calcEquation method builds the graph and performs the DFS to find the answer for each query.
 * The buildGraph method creates the variable-to-index mapping and the adjacency list based on theGiven the problem description,
 * we can solve it by creating a graph and performing a Depth-First Search (DFS) to find the answer for each query. Here's a step-by-step approach:
 * 1) Create a class called VariableDivision to solve the problem.
 * 2) Inside the VariableDivision class, define a method called calcEquation that takes the equations, values,
 *          and queries as parameters and returns an array of doubles representing the answers to the queries.
 * 3) Create a map called variableToIndex to store the variable-to-index mapping. This map will help us assign a unique index to each variable.
 * 4) Create a list called adjacencyList to represent the graph.
 *          Each variable will be a node in the graph, and the edges will represent the division operation between variables.
 * 5) Iterate through the equations and values arrays. For each equation, add the variables and their corresponding values to the variableToIndex map.
 * 6) Iterate through the equations and values arrays again. For each equation, add two directed edges to the graph:
 *          one from Ai to Bi with weight values[i], and another from Bi to Ai with weight 1 / values[i].
 * 7) Create a method called dfs that performs a Depth-First Search to find the answer for each query.
 * 8) Inside the dfs method, check if the source and destination variables exist in the graph. If not, return -1.0.
 * 9) If the source and destination variables are the same, return 1.0.
 * 10) Mark the source variable as visited and iterate through its neighbors. For each neighbor,
 *          recursively call the dfs method with the neighbor as the new source variable.
 * 11) Multiply the result of the recursive call by the weight of the edge between the source and neighbor variables.
 *          If the result is not -1.0, return it.
 * 12) If no valid result is found, return -1.0.
 */
class VariableDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> variableToIndex = new HashMap<>();
        List<List<Edge>> adjacencyList = new ArrayList<>();

        int index = 0;
        for (int i = 0; i < equations.size(); i++) {
            String variable1 = equations.get(i).get(0);
            String variable2 = equations.get(i).get(1);

            if (!variableToIndex.containsKey(variable1)) {
                variableToIndex.put(variable1, index++);
                adjacencyList.add(new ArrayList<>());
            }
            if (!variableToIndex.containsKey(variable2)) {
                variableToIndex.put(variable2, index++);
                adjacencyList.add(new ArrayList<>());
            }

            int index1 = variableToIndex.get(variable1);
            int index2 = variableToIndex.get(variable2);

            adjacencyList.get(index1).add(new Edge(index2, values[i]));
            adjacencyList.get(index2).add(new Edge(index1, 1.0 / values[i]));
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String source = queries.get(i).get(0);
            String destination = queries.get(i).get(1);
            results[i] = dfs(source, destination, variableToIndex, adjacencyList, new HashSet<>());
        }

        return results;
    }

    private double dfs(
            String source,
            String destination,
            Map<String, Integer> variableToIndex,
            List<List<Edge>> adjacencyList,
            Set<Integer> visited
    ) {
        if (!variableToIndex.containsKey(source) || !variableToIndex.containsKey(destination)) {
            return -1.0;
        }

        int sourceIndex = variableToIndex.get(source);
        int destinationIndex = variableToIndex.get(destination);

        if (source.equals(destination)) {
            return 1.0;
        }

        visited.add(sourceIndex);

//        for (int j = 0; j < adjacencyList.get(sourceIndex).size(); j++) {
//            Edge edge = adjacencyList.get(sourceIndex).get(j);
        for (Edge edge : adjacencyList.get(sourceIndex)) {
            if (!visited.contains(edge.destination)) {
                double result = dfs(getKeyByValue(variableToIndex, edge.destination), destination, variableToIndex, adjacencyList, visited);
                if (result != -1.0) {
                    return edge.weight * result;
                }
            }
        }

        return -1.0;
    }

    private String getKeyByValue(Map<String, Integer> map, int value) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return null;
    }

    static class Edge {
        int destination;
        double weight;

        public Edge(int destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}