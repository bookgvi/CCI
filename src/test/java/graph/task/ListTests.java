package graph.task;

import java.util.List;

import static org.junit.Assert.assertEquals;

public interface ListTests {
    default <T> void assertListEquals(List<T> l1, List<T> l2) {
        assertEquals(l1.size(), l2.size());
        for (int i = 0, n = l1.size(); i < n; ++i) {
            assertEquals(l1.get(i), l2.get(i));
        }
    }
}
