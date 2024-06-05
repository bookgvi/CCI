package TMP.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int wordsCount = words.length;
        int[][] allChars = new int[wordsCount][26];
        for (int j = 0; j < wordsCount; ++j) {
            int[] chars = new int[26];
            allChars[j] = chars;
        }
        for (int j = 0; j < wordsCount; ++j) {
            int[] chars = allChars[j];
            for (char ch : words[j].toCharArray()) {
                chars[ch - 'a'] += 1;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            int chCounter = 0;
            int j = 0;
            while (allChars[j][i] > 0) {
                chCounter += 1;
                allChars[j][i] -= 1;
                ++j;
                j %= wordsCount;
            }
            if (chCounter >= wordsCount) {
                String letter = String.valueOf((char) ('a' + i));
                for (int k = 0; k < chCounter / wordsCount; ++k) {
                    res.add(letter);
                }
            }
        }
        return res;
    }
}
