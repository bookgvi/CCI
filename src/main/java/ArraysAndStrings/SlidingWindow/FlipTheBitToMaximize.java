package ArraysAndStrings.SlidingWindow;

public class FlipTheBitToMaximize {
    public int proceed(String s) {
        int l = 0, curFlips = 0, numToFlip = 1, res = 0;
        for (int r = 0, len = s.length(); r < len; r += 1) {
            if (s.charAt(r) == '0') {
                curFlips += 1;
            }
            while(curFlips > numToFlip) {
                if (s.charAt(l++) == '0') {
                    curFlips -= 1;
                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
