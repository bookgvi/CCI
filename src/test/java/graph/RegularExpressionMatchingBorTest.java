package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RegularExpressionMatchingBorTest {
    private RegularExpressionMatchingBor.Bor bor;

    @Before
    public void setUp() {
        bor = new RegularExpressionMatchingBor.Bor();
    }

    @Test
    public void customTest() {
        String text = "tttt";
        List<String> words = Arrays.asList("t", "tt", "tttt");
        Map<String, List<Integer>> res = bor.analyzeText(text, words);
        System.out.println("\nText: \""
                +  text + "\", keywords: "
                + words
                + "\n\t\tfound at positions: " + res + "\n"
        );

    }

    @Test
    public void testInitWhenWordIsGivenThenBorIsCorrectlyInitialized() {
        String word = "test";
        bor.init(word);

        RegularExpressionMatchingBor.Bor.Node currentNode = bor.root;
        StringBuilder prefixBuilder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            String letter = String.valueOf(ch);
            prefixBuilder.append(ch);
            String prefix = prefixBuilder.toString();

            assertTrue(currentNode.children.containsKey(letter));
            RegularExpressionMatchingBor.Bor.Node nextNode = currentNode.children.get(letter);
            assertEquals(letter, nextNode.val);
            assertEquals(prefix, nextNode.prefix);
            assertEquals(currentNode, nextNode.parent);
            currentNode = nextNode;
        }
        assertTrue(currentNode.isTerminal);
    }

    @Test
    public void testInitWhenEmptyStringIsGivenThenOnlyRootNodeExists() {
        bor.init("");

        assertEquals("root", bor.root.val);
        assertEquals("", bor.root.prefix);
        assertTrue(bor.root.children.isEmpty());
    }

    @Test
    public void testInitWhenNullIsGivenThenOnlyRootNodeExists() {
        bor.init(null);

        assertEquals("root", bor.root.val);
        assertEquals("", bor.root.prefix);
        assertTrue(bor.root.children.isEmpty());
    }

    @Test
    public void testSetUnvisitedWhenNodesAreVisitedThenAllNodesAreUnvisited() {
        bor.init("test");
        bor.root.isVisited = true;
        bor.root.children.get("t").isVisited = true;
        bor.root.children.get("t").children.get("e").isVisited = true;
        bor.root.children.get("t").children.get("e").children.get("s").isVisited = true;
        bor.root.children.get("t").children.get("e").children.get("s").children.get("t").isVisited = true;

        bor.setUnvisited(bor.root);

        assertFalse(bor.root.isVisited);
        assertFalse(bor.root.children.get("t").isVisited);
        assertFalse(bor.root.children.get("t").children.get("e").isVisited);
        assertFalse(bor.root.children.get("t").children.get("e").children.get("s").isVisited);
        assertFalse(bor.root.children.get("t").children.get("e").children.get("s").children.get("t").isVisited);
    }

    @Test
    public void testSetUnvisitedWhenTreeIsEmptyThenNoExceptionIsThrown() {


        try {
            bor.setUnvisited(bor.root);
        } catch (Exception e) {
            fail("Exception should not be thrown when tree is empty.");
        }
    }

    @Test
    public void testSetUnvisitedWhenAllNodesAreUnvisitedThenNoChangeInState() {
        bor.init("test");

        bor.setUnvisited(bor.root);

        assertFalse(bor.root.isVisited);
        assertFalse(bor.root.children.get("t").isVisited);
        assertFalse(bor.root.children.get("t").children.get("e").isVisited);
        assertFalse(bor.root.children.get("t").children.get("e").children.get("s").isVisited);
        assertFalse(bor.root.children.get("t").children.get("e").children.get("s").children.get("t").isVisited);
    }

    @Test
    public void testSetSuffixLinkWhenParentSuffixLinkHasChild() {

        bor.init("abc");
        bor.createAutomata();

        RegularExpressionMatchingBor.Bor.Node cur = bor.root.children.get("a").children.get("b");
        RegularExpressionMatchingBor.Bor.Node parent = cur.parent;

        bor.setSuffixLink(cur, parent);

        RegularExpressionMatchingBor.Bor.Node expectedSuffixLink = parent.suffixLink.children.get(cur.val);
        if (expectedSuffixLink == null) {
            expectedSuffixLink = bor.root;
        }

        assertEquals(expectedSuffixLink, cur.suffixLink);
    }

    @Test
    public void testSetSuffixLinkWhenParentSuffixLinkHasNoChild() {

        bor.init("abc");
        bor.createAutomata();

        RegularExpressionMatchingBor.Bor.Node cur = bor.root.children.get("a").children.get("b").children.get("c");
        RegularExpressionMatchingBor.Bor.Node parent = cur.parent;

        bor.setSuffixLink(cur, parent);

        RegularExpressionMatchingBor.Bor.Node expectedSuffixLink = parent.suffixLink.children.get(cur.val);
        if (expectedSuffixLink == null) {
            expectedSuffixLink = bor.root;
        }

        assertEquals(expectedSuffixLink, cur.suffixLink);
    }


    @Test
    public void testPrepareBorWhenWordIsProvidedThenBorIsPreparedCorrectly() {


        bor.init("word");
        bor.createAutomata();

        assertNotNull(bor.root);
        assertTrue(bor.root.isVisited);
        assertEquals(bor.root, bor.root.suffixLink);

        RegularExpressionMatchingBor.Bor.Node childNode = bor.root.children.get("w");
        assertNotNull(childNode);
        assertTrue(childNode.isVisited);
        assertEquals(bor.root, childNode.suffixLink);

        childNode = childNode.children.get("o");
        assertNotNull(childNode);
        assertTrue(childNode.isVisited);
        assertEquals(bor.root, childNode.suffixLink);

        childNode = childNode.children.get("r");
        assertNotNull(childNode);
        assertTrue(childNode.isVisited);
        assertEquals(bor.root, childNode.suffixLink);

        childNode = childNode.children.get("d");
        assertNotNull(childNode);
        assertTrue(childNode.isVisited);
        assertEquals(bor.root, childNode.suffixLink);
    }

    @Test
    public void testPrepareBorWhenNoWordIsProvidedThenBorIsHandledCorrectly() {

        bor.init(null);
        bor.createAutomata();

        assertNotNull(bor.root);
        assertTrue(bor.root.isVisited);
        assertEquals(bor.root, bor.root.suffixLink);
        assertTrue(bor.root.children.isEmpty());
    }

    @Test
    public void testPrepareBorWhenSingleCharacterWordIsProvidedThenBorIsPreparedCorrectly() {

        bor.init("a");
        bor.createAutomata();

        assertNotNull(bor.root);
        assertTrue(bor.root.isVisited);
        assertEquals(bor.root, bor.root.suffixLink);

        RegularExpressionMatchingBor.Bor.Node childNode = bor.root.children.get("a");
        assertNotNull(childNode);
        assertTrue(childNode.isVisited);
        assertEquals(bor.root, childNode.suffixLink);
    }


    @Test
    public void testSetGoBySuffixWhenRootHasNoChildrenThenGoBySuffixMapIsEmpty() {
        bor.init("");
        bor.createAutomata();

        assertTrue(bor.root.goBySuffixLink.isEmpty());
    }

    @Test
    public void testAnalizeTextWhenTextAndWordsAreNullThenReturnEmptyMap() {
        Map<String, List<Integer>> result = bor.analyzeText(null, null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testAnalizeTextWhenTextIsNotNullAndWordsAreNullThenReturnEmptyMap() {
        Map<String, List<Integer>> result = bor.analyzeText("some text", null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testAnalizeTextWhenTextIsNullAndWordsAreNotNullThenReturnEmptyMap() {
        List<String> words = new ArrayList<>();
        words.add("word1");
        words.add("word2");
        Map<String, List<Integer>> result = bor.analyzeText(null, words);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testAnalizeTextWhenTextAndWordsAreNotNullThenReturnCorrectMap() {
        List<String> words = new ArrayList<>();
        words.add("word1");
        words.add("word2");
        Map<String, List<Integer>> result = bor.analyzeText("word1 word2 word1", words);
        assertFalse(result.isEmpty());
        assertTrue(result.containsKey("word1"));
        assertTrue(result.containsKey("word2"));
        assertEquals(Arrays.asList(0, 12), result.get("word1"));
        assertEquals(Arrays.asList(6), result.get("word2"));
    }
}