package TMP;

import org.junit.Assert;
import org.junit.Test;

public class RadixSortAnalyzeTest {

    @Test
    public void test1() {
        int b = 8, dw = 4;
        int[] arr = new int[]{4444,3444,24444,Integer.MIN_VALUE, Integer.MAX_VALUE,0,-1,-5};
        int[] ans = new int[]{Integer.MIN_VALUE, -5, -1, 0, 3444, 4444, 24444, Integer.MAX_VALUE};
        int[] tmp = new int[arr.length];
        String[][] binNums = new String[arr.length][dw];
        int[][] decNums = new int[arr.length][dw];
        int grp = (1 << b) - 1;
        for (int p = 0; p < dw; p += 1) {
            int[] count = new int[1 << b];
            for (int i = 0; i < arr.length; i += 1) {
                int n = arr[i];
                String r1 = Integer.toBinaryString(Integer.MIN_VALUE);
                String r2 = Integer.toBinaryString(n);
                int decNum = n ^ Integer.MIN_VALUE;
                String r3 = Integer.toBinaryString(n ^ Integer.MIN_VALUE);
                decNum = (n ^ Integer.MIN_VALUE) >>> (p * b);
                String r4 = Integer.toBinaryString(decNum);
                decNum = (n ^ Integer.MIN_VALUE) >>> (p * b) & grp;
                String r5 = Integer.toBinaryString(decNum);
                decNums[i][p] = decNum;
                binNums[i][p] = r5;
                count[decNum] += 1;
            }
            for (int i = 1; i < 1 << b; i += 1) {
                count[i] += count[i - 1];
            }
            for (int i = arr.length - 1; i >= 0; i -= 1) {
                tmp[--count[((arr[i] ^ Integer.MIN_VALUE) >>> (p * b)) & ((1 << b) - 1)]] = arr[i];
            }
            System.arraycopy(tmp, 0, arr, 0, arr.length);
        }
        Assert.assertArrayEquals(ans, arr);
    }
}