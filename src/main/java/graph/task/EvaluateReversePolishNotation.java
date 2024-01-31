package graph.task;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvaluateReversePolishNotation {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
    static {
        operations.put("+", Integer::sum);
        operations.put("-", (operand1, operand2) -> operand1 - operand2);
        operations.put("*", (operand1, operand2) -> operand1 * operand2);
        operations.put("/", (operand1, operand2) -> operand1 / operand2);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (operations.containsKey(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = operations.get(token).apply(operand1, operand2);
                stack.push(result);
            } else {
                int operand = Integer.parseInt(token);
                stack.push(operand);
            }
        }

        return stack.pop();
    }
}
