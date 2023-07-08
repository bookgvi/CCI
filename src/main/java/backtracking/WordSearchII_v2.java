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
public class WordSearchII_v2 {
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
            divider = rowLen < 10 ? 10 : 100;
            if (isWordPresent(board, word.toCharArray(), 0, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isWordPresent(char[][] board, char[] wordChars, int p1, int row, int col) {
        if (isFinish || p1 == wordLen) {
            isFinish = true;
            return true;
        }
        if (
                isValid(board, wordChars, p1, row, col)
                || isValid(board, wordChars, p1, row + 1, col)
                || isValid(board, wordChars, p1, row - 1, col)
                || isValid(board, wordChars, p1, row, col + 1)
                || isValid(board, wordChars, p1, row, col - 1)
        ) {
            place(wordChars, p1, row, col);
            isWordPresent(board,  wordChars, p1 + 1, row, col + 1);
            isWordPresent(board,  wordChars, p1 + 1, row, col - 1);
            isWordPresent(board,  wordChars, p1 + 1, row + 1, col);
            isWordPresent(board,  wordChars, p1 + 1, row - 1, col);
            if (isFinish) {
                return true;
            }
            removePrev();
        }
        if (!isFinish && sequence.isEmpty() && col + 1 < rowLen) {
            isWordPresent(board,  wordChars, p1, row,  col + 1);
        }
        if (!isFinish && sequence.isEmpty() && row + 1 < rowLen) {
            isWordPresent(board,  wordChars, p1, row + 1,  0);
        }
        return isFinish;
    }

    private boolean isValid(char[][] board, char[] wordChars, int p1, int row, int col) {
        int curElt = row * divider + col;
        int prevElt = !sequence.isEmpty() ? getRowCol() : -1;
        boolean isPresent = unique.contains(row * divider + col);
        boolean isValidCol = col >= 0 && col < colLen;
        boolean isValidRow = row >= 0 && row < rowLen;
        boolean isNotDiagonal = prevElt == -1 || (curElt + 10 == prevElt) || (curElt - 10 == prevElt) || (curElt + 1 == prevElt) || (curElt - 1 == prevElt);
        return !isFinish && isNotDiagonal && !isPresent && isValidCol && isValidRow && wordChars[p1] == board[row][col];
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
