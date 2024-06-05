package TMP.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backTrack(0, s, new ArrayList<>(), ans);
        return ans;
    }

    private void backTrack(int start, String s, List<String> palindrome, List<List<String>> ans) {
        for (int end = start; end < s.length(); end += 1) {
            String ss = s.substring(start, end + 1);
            if (isPalindrome(ss)) {
                palindrome.add(ss);
                if (end + 1 == s.length())
                    ans.add(new ArrayList<>(palindrome));
                else
                    backTrack(end + 1, s, palindrome, ans);
                palindrome.remove(palindrome.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        int size = s.length();
        for (int i = 0, half = size >> 1; i < half; ++i) {
            if (s.charAt(i) != s.charAt(size - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
