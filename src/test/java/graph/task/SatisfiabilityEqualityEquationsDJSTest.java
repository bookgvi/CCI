package graph.task;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SatisfiabilityEqualityEquationsDJSTest {
    @Test
    public void testEquationsPossible_case1() {
        SatisfiabilityEqualityEquations_DJS unionFind = new SatisfiabilityEqualityEquations_DJS();
        String[] equations = {"a==b", "b!=a"};
        boolean result = unionFind.equationsPossible(equations);
        assertFalse(result);
    }

    @Test
    public void testEquationsPossible_case2() {
        SatisfiabilityEqualityEquations_DJS unionFind = new SatisfiabilityEqualityEquations_DJS();
        String[] equations = {"b==a", "a==b"};
        boolean result = unionFind.equationsPossible(equations);
        assertTrue(result);
    }

    @Test
    public void testEquationsPossible_case3() {
        SatisfiabilityEqualityEquations_DJS unionFind = new SatisfiabilityEqualityEquations_DJS();
        String[] equations = {"a==b", "b==c", "a==c"};
        boolean result = unionFind.equationsPossible(equations);
        assertTrue(result);
    }

    @Test
    public void testEquationsPossible_case4() {
        SatisfiabilityEqualityEquations_DJS unionFind = new SatisfiabilityEqualityEquations_DJS();
        String[] equations = {"a==b", "b==c", "c!=a"};
        boolean result = unionFind.equationsPossible(equations);
        assertFalse(result);
    }
}