package backtracking;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/word-search-ii/">...</a>
 * <p>
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once in a word.
 */
public class WordSearchII_v3 {
    private final int[] steps = new int[]{-1, 1};
    private StringBuilder buildWord = new StringBuilder();
    private List<Integer> sequence = new ArrayList<>();
    private Set<Integer> unique = new HashSet<>();
    private boolean isFinish = false;
    private int wordLen = 0;
    private int rowLen = 0;
    private int colLen = 0;
    private int divider = 10;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            buildWord = new StringBuilder();
            sequence = new Stack<>();
            unique = new HashSet<>();
            isFinish = false;
            wordLen = word.length();
            rowLen = board.length;
            colLen = board[0].length;
            for (int row = 0; row < rowLen; row += 1) {
                for (int col = -1; col < colLen; col += Math.min(colLen -1, 3)) {
                    if (isWordPresent(board, word.toCharArray(), 0, row, col)) {
                        res.add(word);
                        break;
                    }
                }
                if (isFinish) {
                    break;
                }
            }
        }
        return res;
    }

    private boolean isWordPresent(char[][] board, char[] wordChars, int p1, int row, int col) {
        if (isFinish || p1 == wordLen) {
            isFinish = true;
            return true;
        }
        divider = row < 10 ? 10 : 100;
        int rowCol = isValid(board, wordChars, p1, row, col);
        for (int val : steps) {
            if (rowCol == -1) {
                rowCol = isValid(board, wordChars, p1, row + val, col);
            }
            if (rowCol == -1) {
                rowCol = isValid(board, wordChars, p1, row, col + val);
            }
        }

        if (rowCol != -1) {
            row = rowCol / divider;
            col = rowCol % divider;
            place(wordChars, p1, row, col);
            for (int val : steps) {
                isWordPresent(board, wordChars, p1 + 1, row, col + val);
                isWordPresent(board, wordChars, p1 + 1, row + val, col);
            }
            if (isFinish) {
                return true;
            }
            removePrev();
        }
        return isFinish;
    }

    private int isValid(char[][] board, char[] wordChars, int p1, int row, int col) {
        int curElt = row * divider + col;
        int prevElt = !sequence.isEmpty() ? getRowCol() : -1;
        boolean isPresent = unique.contains(row * divider + col);
        boolean isValidCol = col >= 0 && col < colLen;
        boolean isValidRow = row >= 0 && row < rowLen;
        boolean isNotDiagonal = prevElt == -1 || (curElt + 10 == prevElt) || (curElt - 10 == prevElt) || (curElt + 1 == prevElt) || (curElt - 1 == prevElt);
        if (!isFinish && isNotDiagonal && !isPresent && isValidCol && isValidRow && wordChars[p1] == board[row][col]) {
            return curElt;
        }
        return -1;
    }

    private int getRowCol() {
        return sequence.get(sequence.size() - 1);
    }

    private void place(char[] wordChars, int p1, int row, int col) {
        buildWord.append(wordChars[p1]);
        sequence.add(row * divider + col);
        unique.add(row * divider + col);
    }

    private void removePrev() {
        buildWord.deleteCharAt(buildWord.length() - 1);
        int val = sequence.remove(sequence.size() - 1);
        unique.remove(val);
    }
}
