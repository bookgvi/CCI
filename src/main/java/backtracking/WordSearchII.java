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
public class WordSearchII {
    private StringBuilder buildWord = new StringBuilder();
    private List<Integer> sequence = new ArrayList<>();
    private Set<Integer> unique = new HashSet<>();
    private boolean isFinish = false;
    private int wordLen = 0;
    private int rowLen = 0;
    private int colLen = 0;

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
            for (int row = 0, rowLen = board.length; row < rowLen; row += 1) {
                for (int col = 1, colLen = board[0].length; col < colLen; col += 2) {
                    if (isWordPresent(board, word, word.toCharArray(), 0, row, col)) {
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

    private boolean isWordPresent(char[][] board, String wordString, char[] wordChars, int p1, int row, int col) {
        int divider = rowLen < 10 ? 10 : 100;
        if (p1 == wordLen && wordString.contentEquals(buildWord)) {
            isFinish = true;
        } else {
            if (!isFinish && p1 < wordLen) {
                if (isValid(board, wordChars, p1, row, col)) {
                    place(wordChars, p1, row, col, divider);
                    isWordPresent(board, wordString, wordChars, p1 + 1, row, col);
                    if (isFinish) {
                        return true;
                    }
                    removePrev();
                }
                if (!isFinish && row + 1 < rowLen) {
                    int tmpRow = !sequence.isEmpty() ? getRowCol() / divider + 1 : row + 1;
                    int tmpCol = !sequence.isEmpty() ? getRowCol() % divider : col;
                    if (isValid(board, wordChars, p1, tmpRow, tmpCol)) {
                        row = tmpRow;
                        col = tmpCol;
                        place(wordChars, p1, row, col, divider);
                        isWordPresent(board, wordString, wordChars, p1 + 1, row, col);
                        if (isFinish) {
                            return true;
                        }
                        removePrev();
                    }
                }
                if (!isFinish && row - 1 >= 0) {
                    int tmpRow = !sequence.isEmpty() ? getRowCol() / divider - 1 : row - 1;
                    int tmpCol = !sequence.isEmpty() ? getRowCol() % divider : col;
                    if (isValid(board, wordChars, p1, tmpRow, tmpCol)) {
                        row = tmpRow;
                        col = tmpCol;
                        place(wordChars, p1, row, col, divider);
                        isWordPresent(board, wordString, wordChars, p1 + 1, row, col);
                        if (isFinish) {
                            return true;
                        }
                        removePrev();
                    }
                }
                if (!isFinish && col + 1 < colLen) {
                    int tmpCol = !sequence.isEmpty() ? getRowCol() % divider + 1 : col + 1;
                    int tmpRow = !sequence.isEmpty() ? getRowCol() / divider : row;
                    if (isValid(board, wordChars, p1, tmpRow, tmpCol)) {
                        row = tmpRow;
                        col = tmpCol;
                        place(wordChars, p1, row, col, divider);
                        isWordPresent(board, wordString, wordChars, p1 + 1, row, col);
                        if (isFinish) {
                            return true;
                        }
                        removePrev();
                    }
                }
                if (!isFinish && col - 1 >= 0) {
                    int tmpCol = !sequence.isEmpty() ? getRowCol() % divider - 1 : col - 1;
                    int tmpRow = !sequence.isEmpty() ? getRowCol() / divider : row;
                    if (isValid(board, wordChars, p1, tmpRow, tmpCol)) {
                        row = tmpRow;
                        col = tmpCol;
                        place(wordChars, p1, row, col, divider);
                        isWordPresent(board, wordString, wordChars, p1 + 1, row, col);
                        if (isFinish) {
                            return true;
                        }
                        removePrev();
                    }
                }
            }
        }
        return isFinish;
    }

    private boolean isValid(char[][] board, char[] wordChars, int p1, int row, int col) {
        int divider = rowLen < 10 ? 10 : 100;
        boolean isPresent = unique.contains(row * divider + col);
        boolean isValidCol = col >= 0 && col < board[0].length;
        boolean isValidRow = row >= 0 && row < rowLen;
        boolean isCharEquals = isValidCol && isValidRow && wordChars[p1] == board[row][col];
        return !isFinish && !isPresent && isCharEquals;
    }

    private int getRowCol() {
        return sequence.get(sequence.size() - 1);
    }

    private void place(char[] wordChars, int p1, int row, int col, int divider) {
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
