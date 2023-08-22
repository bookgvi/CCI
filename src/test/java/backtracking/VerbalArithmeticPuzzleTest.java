package backtracking;

import org.junit.Test;

public class VerbalArithmeticPuzzleTest {
    @Test
    public void isSolvable_test1() {
        String[] words = {"SEND", "MORE"};
        String result = "MONEY";
        boolean ans = true;
        VerbalArithmeticPuzzle v = new VerbalArithmeticPuzzle();
        v.isSolvable(words, result);
    }
}