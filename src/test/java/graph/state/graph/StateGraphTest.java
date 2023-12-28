package graph.state.graph;

import graph.state.NtfList;
import graph.state.graph.node.IStateNode;
import graph.state.graph.node.InfoStateNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StateGraphTest {

    private StateGraph stateGraph;
    private NtfList ntfList;

    @BeforeEach
    public void setup() {
        stateGraph = new StateGraph();
        ntfList = NtfList.getInstance();
    }

    @Test
    public void testAddTransitionWhenValidInputsThenTransitionAdded() {
        IStateNode source = new InfoStateNode("source", false, ntfList::addInfo);
        IStateNode dest = new InfoStateNode("dest", false, ntfList::addInfo);
        stateGraph.addState(source);
        stateGraph.addState(dest);

        stateGraph.addTransition(source, dest);

        Map<IStateNode, List<IStateNode>> graph = stateGraph.getGraph();
        assertTrue(graph.containsKey(source));
        assertTrue(graph.get(source).contains(dest));
    }

    @Test
    public void testAddTransitionWhenNullSourceThenIllegalStateException() {
        IStateNode dest = new InfoStateNode("dest", false, ntfList::addInfo);
        stateGraph.addState(dest);

        assertThrows(IllegalStateException.class, () -> stateGraph.addTransition(null, dest));
    }

    @Test
    public void testAddTransitionWhenNullDestinationThenIllegalStateException() {
        IStateNode source = new InfoStateNode("source", false, ntfList::addInfo);
        stateGraph.addState(source);

        assertThrows(IllegalStateException.class, () -> stateGraph.addTransition(source, null));
    }

    @Test
    public void testAddTransitionWhenSourceNotInGraphThenAddedToGraph() {
        IStateNode source = new InfoStateNode("source", false, ntfList::addInfo);
        IStateNode dest = new InfoStateNode("dest", false, ntfList::addInfo);
        stateGraph.addState(dest);

        stateGraph.addTransition(source, dest);

        Map<IStateNode, List<IStateNode>> graph = stateGraph.getGraph();
        assertTrue(graph.containsKey(source));
        assertTrue(graph.get(source).contains(dest));
    }

    @Test
    public void testAddTransitionWhenDestinationNotInGraphThenAddedToGraph() {
        IStateNode source = new InfoStateNode("source", false, ntfList::addInfo);
        IStateNode dest = new InfoStateNode("dest", false, ntfList::addInfo);
        stateGraph.addState(source);

        stateGraph.addTransition(source, dest);

        Map<IStateNode, List<IStateNode>> graph = stateGraph.getGraph();
        assertTrue(graph.containsKey(source));
        assertTrue(graph.get(source).contains(dest));

        graph.get(source).get(0).behavior("QQQ");
        assertTrue(ntfList.getInfoList().contains("QQQ"));
    }
}