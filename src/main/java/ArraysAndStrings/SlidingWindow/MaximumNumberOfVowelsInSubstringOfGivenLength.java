package ArraysAndStrings.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {
    private final Map<Character, Boolean> isVowelMap = new HashMap<>();
    {
        //'a', 'e', 'i', 'o', and 'u'
        isVowelMap.put('a', true);
        isVowelMap.put('e', true);
        isVowelMap.put('i', true);
        isVowelMap.put('o', true);
        isVowelMap.put('u', true);
    }

    public int maxVowels(String s, int k) {
        int len = s.length(), l, vowelsCounter = 0, ans = 0;
        for (int r = 0; r < k; r += 1) {
            if (isVowelMap.containsKey(s.charAt(r))) {
                vowelsCounter += 1;
            }
        }
        ans = Math.max(ans, vowelsCounter);
        for (int r = k; r < len; r += 1) {
            char chAtRightPos = s.charAt(r);
            char chAtLeftPos = s.charAt(r - k);
            if (isVowelMap.containsKey(chAtRightPos)) {
                vowelsCounter += 1;
            }
            if (isVowelMap.containsKey(chAtLeftPos)) {
                vowelsCounter -= 1;
            }
            ans = Math.max(ans, vowelsCounter);
        }
        return ans;
    }
}
