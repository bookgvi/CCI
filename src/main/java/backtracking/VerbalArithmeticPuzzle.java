package backtracking;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/verbal-arithmetic-puzzle/">...</a>
 * <p>
 * Given an equation, represented by words on the left side and the result on the right side.
 * <p>
 * You need to check if the equation is solvable under the following rules:
 * <p>
 * Each character is decoded as one digit (0 - 9).
 * No two characters can map to the same digit.
 * Each words[i] and result are decoded as one number without leading zeros.
 * Sum of numbers on the left side (words) will equal to the number on the right side (result).
 * Return true if the equation is solvable, otherwise return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["SEND","MORE"], result = "MONEY"
 * Output: true
 * Explanation: Map 'S'-> 9, 'E'->5, 'N'->6, 'D'->7, 'M'->1, 'O'->0, 'R'->8, 'Y'->'2'
 * Such that: "SEND" + "MORE" = "MONEY" ,  9567 + 1085 = 10652
 */
public class VerbalArithmeticPuzzle {

    private final char[] abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final Map<Character, Integer> charToIntMap = new HashMap<>();
    private final Map<Integer, Character> intToCharMap = new HashMap<>();
    private final List<Integer> usedInTurn = new ArrayList<>();
    private final List<Integer> numsOrder = new ArrayList<>();
    private final Set<Integer> uniqueNums = new HashSet<>();
    private final Set<Character> storedResultChar = new HashSet<>();
    private boolean isFinish = false;
    private boolean isRowFinish = false;
    private int wordsCount = 0;
    private int wordMaxLen = 0;
    private int extraDigit = 0;
    private int prevExtraDigit = 0;
    private int uniqueCharsCount = 0;

    public boolean isSolvable(String[] words, String result) {
        boolean res = false;
        List<List<Character>> wordsMatrix = this.buildCharMatrixAndInitSizes(words);
        char[] resultMatrix = getReverseCharsArr(result);
        this.uniqueCharsCount = this.storedResultChar.size();
        this.storedResultChar.clear();
        backTrack(wordsMatrix, resultMatrix, 0, 0);
        return res;
    }

    private void backTrack(List<List<Character>> wordsMatrix, char[] resultMatrix, int row, int col) {
        if (this.uniqueCharsCount == this.charToIntMap.size()) {
            this.isFinish = true;
        }

        if (row < this.wordsCount) {
            for (int i = 0; i < 10; i += 1) {
                if (isValidNum(i)) {
                    this.usedInTurn.add(persist(wordsMatrix, row, col, i));
                    backTrack(wordsMatrix, resultMatrix, row + 1, col);
                    if (!this.isFinish) {
                        removePrev();
                    }
                }
            }
        } else {
            int sum = getSumAndUpdateExtraDigit();
            if (isValid(resultMatrix, col, sum)) {
                Character ch = resultMatrix[col];
                Integer n = sum % 10;
                persistNum(ch, n);
                this.usedInTurn.clear();
                backTrack(wordsMatrix, resultMatrix, 0, col + 1);
                if (!this.isFinish) {
                    removePrevNum(n);
                }

            }
        }
    }


    private boolean isValidNum(int i) {
        return this.uniqueNums.add(i);
    }

    private int getSumAndUpdateExtraDigit() {
        int sum = this.extraDigit;
        this.prevExtraDigit = this.extraDigit;
        for (Integer integer : this.usedInTurn) {
            sum += integer;
        }
        this.extraDigit = sum / 10;
        return sum;
    }

    private int persist(List<List<Character>> wordsMatrix, int row, int col, int newNum) {
        Character ch = wordsMatrix.get(row).get(col);
        Integer num = this.charToIntMap.get(ch);
        if (num == null) {
            persistNum(ch, newNum);
            num = newNum;
        }
        return num;
    }


    private void removePrev() {
        Integer num = this.numsOrder.remove(this.numsOrder.size() - 1);

        if (num != null) {
            removePrevNum(num);
        }
        if (this.usedInTurn.size() > 0) {
            this.usedInTurn.remove(this.usedInTurn.size() - 1);
        }
    }

    private void removePrevNum(Integer num) {
        this.uniqueNums.remove(num);
        Character ch = this.intToCharMap.remove(num);
        this.charToIntMap.remove(ch);
        this.extraDigit = this.prevExtraDigit;
    }

    private boolean isValid(char[] resultMatrix, int col, Integer sum) {
        Character ch = resultMatrix[col];
        Integer storedNum = this.charToIntMap.get(ch);
        if (storedNum == null) {
            Character storedChar = this.intToCharMap.get(sum);
            if (storedChar == null) {
//                persistNum(ch, n);
                storedNum = sum;
            }
        }
        return ((Integer)(sum % 10)).equals(storedNum);
    }

    private void persistNum(Character ch, Integer num) {
        this.charToIntMap.put(ch, num);
        this.intToCharMap.put(num, ch);
        this.uniqueNums.add(num);
        this.numsOrder.add(num);
    }

    private boolean hasFinish(int col) {
        return col >= this.wordMaxLen;
    }

    /**
     * Reversed!!!!!!!!!!!!
     *
     * @param words array of words
     * @return matrix of characters in reverse mode
     */
    private List<List<Character>> buildCharMatrixAndInitSizes(String[] words) {
        this.wordsCount = words.length;
        List<List<Character>> matrix = new ArrayList<>(this.wordsCount);
        for (String word : words) {
            int len = word.length();
            this.wordMaxLen = Math.max(this.wordMaxLen, len);
            List<Character> chArr = new ArrayList<>();
            for (int i = len - 1; i >= 0; i -= 1) {
                Character ch = word.charAt(i);
                chArr.add(ch);
                this.storedResultChar.add(ch);
            }
            matrix.add(chArr);
        }
        return matrix;
    }

    private char[] getReverseCharsArr(String result) {
        int len = result.length();
        char[] res = new char[len];
        int j = 0;
        for (int i = len - 1; i >= 0; i -= 1) {
            Character ch = result.charAt(i);
            res[j++] = ch;
            this.storedResultChar.add(ch);

        }
        return res;
    }

    private int getSumMod(int a, int b, int extraDigit) {
        return (a + b + extraDigit) % 10;
    }

    private int getExtraDigit(int a, int b) {
        return (a + b) / 10;
    }


}
