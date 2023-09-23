package graphUtils;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BorTest {
    @Test
    public void visualTest() {
        Bor b = Bor.getInstance();
        String[] words = {"dabc","abc", "bc"};
        String text = "dabc";
//        b.init(words);
//        b.dfs();
        Map<String, List<Integer>> res = b.findKeyWordsInText(text, words);
        System.out.println("\nText: \""
                +  text + "\", keywords: "
                + Arrays.toString(words)
                + "\n\t\tfound at positions: " + res + "\n"
        );
    }

    @Test
    public void testGetInstanceWhenCalledMultipleTimesThenReturnsSameInstance() {
        // Arrange
        Bor instance1 = Bor.getInstance();
        Bor instance2 = Bor.getInstance();

        // Assert
        assertSame("getInstance should always return the same instance", instance1, instance2);
    }
}