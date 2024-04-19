package TMP.leetcode;

import java.util.Stack;

public class Parenthesis {
    public boolean isValidString(String s) {
        if (s.isEmpty()) return true;
        Stack<Integer> openBracketStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();
        int index = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openBracketStack.push(index);
            } else if (ch == ')') {
                if (!openBracketStack.isEmpty()) {
                    openBracketStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            } else if (ch == '*') {
                asteriskStack.push(index);
            }
            ++index;
        }
        // process remaining open brackets
        while (!openBracketStack.isEmpty() && !asteriskStack.isEmpty()) {
            if (openBracketStack.pop() > asteriskStack.pop()) {
                return false;
            }
        }
        return openBracketStack.isEmpty();
    }
}
