package ArraysAndStrings.TwoPointers;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string/description/">...</a>
 */
public class ReverseWordsString {
    public String reverseWords(String s) {
        s = trim(s);
        if (s.length() <= 1) {
            return s;
        }
        s = removeExtraSpaces(s);
        return trim(proceed(s));
    }

    private String trim(String s) {
        int p1 = 0, p2 = s.length() - 1;
        while (p1 < s.length() && s.charAt(p1) == ' ') {
            p1 += 1;
        }
        while (p2 >= 0 && s.charAt(p2) == ' ') {
            p2 -= 1;
        }
        int len = p2 - p1 + 1;
        if (len == 0) {
            return "";
        }
        return new String(s.toCharArray(), p1, len);
    }

    private String removeExtraSpaces(String s) {
        int p1 = 0, spaceCounter = 1, len = s.length();
        StringBuilder sb = new StringBuilder(s);
        char chAtPos = s.charAt(0);
        for (int i = 1; i < len; i += 1) {
            chAtPos = s.charAt(i);
            char chAtPrevPos = s.charAt(i - 1);
            if (chAtPos == ' ' && chAtPos == chAtPrevPos) {
                spaceCounter += 1;
            } else {
                spaceCounter = 1;
            }
            if (spaceCounter <= 1) {
                sb.setCharAt(p1++, chAtPrevPos);
//                sb.append(chAtPos);
            }
        }
        sb.setCharAt(p1, chAtPos);
        return sb.substring(0, p1 + 1);
    }

    private String proceed(String s) {
        int spaceCounter = getSpaceCounter(s);
        String[] words = new String[spaceCounter + 1];
        int p1 = 0;
        int i = spaceCounter, wordsCounter = 0;
        while(p1 < s.length()) {
            if (s.charAt(p1++) == ' ') {
                words[i--] = s.substring(wordsCounter, p1 - 1);
                wordsCounter = p1;
            }
        }
        words[i] = s.substring(wordsCounter);
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append(" ");
        }
        return sb.toString();
    }

    private int getSpaceCounter(String s) {
        int p1 = 0, spaceCounter = 0;
        while (p1 < s.length() - 1) {
            if (s.charAt(++p1) == ' ') {
                spaceCounter += 1;
            }
        }
        return spaceCounter;
    }


    /**
     * более быстрая реализация
     */
    private static class MoreQuickApproach {
        public String reverseWords(String s) {
            s = trim(s);
            int len = s.length(), p1 = 0, spaceCounter = 1;
            if (len <= 1) {
                return s;
            }
            StringBuilder sb = new StringBuilder(s.substring(0, 1));
            for (int i = 1; i < len; i += 1) {
                char chAtPos = s.charAt(i);
                char chAtPrevPos = s.charAt(i - 1);
                if (chAtPos == ' ' && chAtPos == chAtPrevPos) {
                    spaceCounter += 1;
                } else {
                    spaceCounter = 1;
                }
                if (spaceCounter <= 1) {
                    sb.append(chAtPos);
                }
            }
            spaceCounter = 0;
            while (p1 < sb.length() - 1) {
                if (sb.charAt(++p1) == ' ') {
                    spaceCounter += 1;
                }
            }
            return trim(reverseWords(spaceCounter, sb));
        }

        private String trim(String s) {
            int p1 = 0, p2 = s.length() - 1;
            while (p1 < s.length() && s.charAt(p1) == ' ') {
                p1 += 1;
            }
            while (p2 >= 0 && s.charAt(p2) == ' ') {
                p2 -= 1;
            }
            int len = p2 - p1 + 1;
            if (len == 0) {
                return "";
            }
            return new String(s.toCharArray(), p1, len);
        }

        private String reverseWords(int spaceCounter, StringBuilder sb) {
            String[] words = new String[spaceCounter + 1];
            int p1 = 0;
            int i = spaceCounter, wordsCounter = 0;
            while(p1 < sb.length()) {
                if (sb.charAt(p1++) == ' ') {
                    words[i--] = sb.substring(wordsCounter, p1 - 1);
                    wordsCounter = p1;
                }
            }
            words[i] = sb.substring(wordsCounter);
            sb = new StringBuilder();
            for (String word : words) {
                sb.append(word).append(" ");
            }
            return sb.toString();
        }
    }
}
