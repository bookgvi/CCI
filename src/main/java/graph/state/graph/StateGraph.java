package graph.state.graph;

import graph.state.graph.node.IStateNode;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class StateGraph {

    private final Map<IStateNode, List<IStateNode>> graph;

    public StateGraph() {
        graph = new HashMap<>();
    }

    public Map<IStateNode, List<IStateNode>> getGraph() {
        return new HashMap<>(graph);
    }

    public boolean addState(IStateNode state) {
        graph.put(state, new ArrayList<>());
        return true;
    }

    public boolean addTransition(IStateNode source, IStateNode dest) {
        if (source == null || dest == null) {
            throw new IllegalStateException("states could not be null");
        }
        List<IStateNode> neighbours = graph.getOrDefault(source, new ArrayList<>());
        neighbours.add(dest);
        graph.putIfAbsent(source, neighbours);
        return true;
    }
}
