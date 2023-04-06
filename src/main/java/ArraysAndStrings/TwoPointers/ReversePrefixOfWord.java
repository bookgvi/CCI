package ArraysAndStrings.TwoPointers;

public class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        StringBuilder reversePrefix = new StringBuilder(word);
        int len = word.length(), p1 = 0, p2 = 0;
        for (p2 = 0; p2 < len; p2 += 1) {
            char charAtPos = word.charAt(p2);
            if (charAtPos == ch) {
                break;
            }
            p1 += 1;
        }
        p2 = 0;
        while (p1 >= 0 && p1 < len && p1 > p2) {
            char leftCh = word.charAt(p1);
            char rightCh = word.charAt(p2);
            reversePrefix.setCharAt(p1--, rightCh);
            reversePrefix.setCharAt(p2++, leftCh);
        }
        return reversePrefix.toString();
    }
}
