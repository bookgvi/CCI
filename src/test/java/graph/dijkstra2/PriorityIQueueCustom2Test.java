package graph.dijkstra2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueCustom2Test {

    private PriorityQueueCustom2<Integer> priorityQueue;

    @BeforeEach
    public void setup() {
        priorityQueue = new PriorityQueueCustom2<>(5);
    }

    @Test
    public void testOfferWhenEmptyThenSizeOne() {
        // Arrange
        int element = 1;

        // Act
        priorityQueue.offer(element);

        // Assert
        assertEquals(1, priorityQueue.getSize());
    }

    @Test
    public void testOfferWhenFullThenSizeOne() {
        // Arrange
        PriorityQueueCustom2<Integer> fullQueue = new PriorityQueueCustom2<>(1);
        int element = 1;

        // Act
        fullQueue.offer(element);

        // Assert
        assertEquals(1, fullQueue.getSize());
    }

    @Test
    public void testOfferWhenNotFullThenSizeThree() {
        // Arrange
        int element1 = 1;
        int element2 = 2;
        int element3 = 3;

        // Act
        priorityQueue.offer(element1);
        priorityQueue.offer(element2);
        priorityQueue.offer(element3);

        // Assert
        assertEquals(3, priorityQueue.getSize());
    }

    @Test
    public void testPollWhenEmptyThenNull() {
        // Act
        Integer result = priorityQueue.poll();

        // Assert
        assertNull(result);
    }

    @Test
    public void testPollWhenNotEmptyThenReturnsAndRemovesFirstElement() {
        // Arrange
        int element1 = 1;
        int element2 = 2;
        priorityQueue.offer(element1);
        priorityQueue.offer(element2);

        // Act
        Integer result = priorityQueue.poll();

        // Assert
        assertEquals(element1, result);
        assertEquals(1, priorityQueue.getSize());
    }

    @Test
    public void testPollWhenOneElementThenReturnsAndRemovesThatElement() {
        // Arrange
        int element = 1;
        priorityQueue.offer(element);

        // Act
        Integer result = priorityQueue.poll();

        // Assert
        assertEquals(element, result);
        assertEquals(0, priorityQueue.getSize());
    }

    @Test
    public void testOfferForObjects() {
        PriorityQueueCustom2<Node> priorityQueue = new PriorityQueueCustom2<>(Comparator.comparing(Node::getTitle));
        Node n1 = new Node("K");
        Node n2 = new Node("A");
        Node n3 = new Node("J");
        Node n4 = new Node("C");

        priorityQueue.offer(n1);
        priorityQueue.offer(n2);
        priorityQueue.offer(n3);
        priorityQueue.offer(n4);
        assertEquals(4, priorityQueue.getSize());
        Node top = priorityQueue.poll();
        assertEquals("A", top.getTitle(), "On queue top is Node with letter 'A'");
    }
}