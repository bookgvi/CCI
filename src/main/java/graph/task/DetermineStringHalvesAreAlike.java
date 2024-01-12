package graph.task;

public class DetermineStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        int half = s.length() >>> 1;
        int[] lowChars = new int[27];
        int[] lowChars2 = new int[27];
        for (int p1 = 0; p1 < half; ++p1) {
            int chL11 = s.charAt(p1) - 'a';
            int chL21 = s.charAt(p1 + half) - 'a';
            int chU11 = s.charAt(p1) - 'A';
            int chU21 = s.charAt(p1 + half) - 'A';
            if ((chL11 >= 0 && chL11 <= 26) || (chU11 >= 0 && chU11 <= 26)) {
                int chVal = chL11 >= 0 && chL11 <= 26 ? chL11 : chU11;
                lowChars[chVal] += 1;
            }
            if ((chL21 >= 0 && chL21 <= 26) || (chU21 >= 0 && chU21 <= 26)){
                int chVal = chL21 >= 0 && chL21 <= 26 ? chL21 : chU21;
                lowChars2[chVal] += 1;
            }
        }
        int[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int count1 = 0;
        int count2 = 0;
        for (int chVal : vowels) {
            if (lowChars[chVal - 'a'] != 0) {
                count1 += lowChars[chVal - 'a'];
            }
            if (lowChars2[chVal - 'a'] != 0) {
                count2 += lowChars2[chVal - 'a'];
            }
        }
        return count1 == count2 ;
    }

}
