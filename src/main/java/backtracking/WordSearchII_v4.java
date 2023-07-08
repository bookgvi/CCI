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
public class WordSearchII_v4 {
    private final int[] steps = new int[]{-1, 1};
    private StringBuilder buildWord = new StringBuilder();
    private List<Integer> sequence = new ArrayList<>();
    private Set<Integer> unique = new HashSet<>();
    private boolean isFinish = false;
    private int wordLen = 0;
    private int divider = 10;

    private int rowLen = 0;
    private int colLen = 0;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        rowLen = board.length;
        colLen = board[0].length;
        Map<Character, List<Integer>> charToPositionsMap = getCharToPositionsMap(board);
        for (String word : words) {
            init(board, word);
            List<Integer> firstLetterPositions = charToPositionsMap.get(word.charAt(0));
            if (firstLetterPositions != null) {
                for (int pos : firstLetterPositions) {
                    if (isWordPresent(board, word.toCharArray(), 0, pos)) {
                        res.add(word);
                        break;
                    }
                }
            }
        }
        return res;
    }

    private boolean isWordPresent(char[][] board, char[] wordChars, int p1, int pos) {
        if (isFinish || p1 == wordLen) {
            isFinish = true;
            return true;
        }
        divider = pos >= 100 ? 100 : 10;
        int row = pos / divider;
        int col = pos % divider;
        int rowCol = isValid(board, wordChars, p1, row, col);
        if (rowCol == -1) {
            rowCol = isValid(board, wordChars, p1, row + 1, col);
        }
        if (rowCol == -1) {
            rowCol = isValid(board, wordChars, p1, row, col + 1);
        }
        if (rowCol == -1) {
            rowCol = isValid(board, wordChars, p1, row - 1, col);
        }
        if (rowCol == -1) {
            rowCol = isValid(board, wordChars, p1, row, col - 1);
        }

        if (!isFinish && rowCol != -1) {
            row = rowCol / divider;
            col = rowCol % divider;
            place(wordChars, p1, rowCol);
            int newColPos = row * divider + col + 1;
            if (isPosValid(newColPos)) {
                isWordPresent(board, wordChars, p1 + 1, newColPos);
            }
            if (isFinish) {
                return true;
            }
            int newRowPos = (row + 1) * divider + col;
            if (isPosValid(newRowPos)) {
                isWordPresent(board, wordChars, p1 + 1, newRowPos);
            }
            if (isFinish) {
                return true;
            }
            newColPos = row * divider + col - 1;
            if (isPosValid(newColPos)) {
                isWordPresent(board, wordChars, p1 + 1, newColPos);
            }
            if (isFinish) {
                return true;
            }
            newRowPos = (row - 1) * divider + col;
            if (isPosValid(newRowPos)) {
                isWordPresent(board, wordChars, p1 + 1, newRowPos);
            }
            if (isFinish) {
                return true;
            }
            removePrev();
        }
        return isFinish;
    }

    private boolean isPosValid(int pos) {
        int row = pos / divider;
        int col = pos % divider;
        boolean isValidCol = col >= 0 && col < colLen;
        boolean isValidRow = row >= 0 && row < rowLen;
        return isValidCol && isValidRow;
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

    /**
     * Получение последнего элемента в коллекции sequence
     *
     * @return row+col
     * @throws IndexOutOfBoundsException - если коллекция sequence пустая
     */
    private int getRowCol() throws IndexOutOfBoundsException {
        return sequence.get(sequence.size() - 1);
    }

    private void place(char[] wordChars, int p1, int pos) {
        buildWord.append(wordChars[p1]);
        sequence.add(pos);
        unique.add(pos);
    }

    private void removePrev() {
        buildWord.deleteCharAt(buildWord.length() - 1);
        int val = sequence.remove(sequence.size() - 1);
        unique.remove(val);
    }

    private void init(char[][] board, String word) {
        buildWord = new StringBuilder();
        sequence = new Stack<>();
        unique = new HashSet<>();
        isFinish = false;
        wordLen = word.length();
    }

    private Map<Character, List<Integer>> getCharToPositionsMap(char[][] board) {
        Map<Character, List<Integer>> charsToPositionsMap = new HashMap<>();
        for (int row = 0; row < rowLen; row += 1) {
            int divider = row < 10 ? 10 : 100;
            for (int col = 0; col < colLen; col += 1) {
                List<Integer> positions = charsToPositionsMap.get(board[row][col]);
                positions = positions == null ? new ArrayList<>() : positions;
                positions.add(row * divider + col);
                charsToPositionsMap.putIfAbsent(board[row][col], positions);
            }
        }
        return charsToPositionsMap;
    }
}
