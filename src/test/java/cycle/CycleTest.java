package cycle;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class CycleTest {

    @Test
    public void testCycle() {
        int size = 10;
        int[] arr = generateArr(size);
        System.out.println(Arrays.toString(arr));
        int i = 0;
        int p1 = arr[0], p2 = arr[arr[0]];
        while (p1 != p2 && p2 < arr.length - 1) {
            p1 = arr[p1];
            p2 = arr[arr[p2]];
        }
        if (!Objects.equals(p1, p2)) {
            System.out.println("There is no cycle in arr");
            return;
        }
        p1 = 0;
        i = 1;
        while (p1 != p2) {
            p1 = arr[p1];
            p2 = arr[p2];
            i += 1;
        }
        System.out.println("cycle start at " + p2 + " index and length = " + i);
    }

    private int[] generateArr(int size) {
        int[] res = new int[size];
        for (int i = 0; i < size; i += 1) {
            res[i] = ThreadLocalRandom.current().nextInt(size - 1);
        }
        return res;
    }
}
