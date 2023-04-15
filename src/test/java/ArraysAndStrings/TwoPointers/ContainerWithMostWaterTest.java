package ArraysAndStrings.TwoPointers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {

    @Test
    public void maxArea_test1() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int ans = 49;
        ContainerWithMostWater c = new ContainerWithMostWater();
        Assert.assertEquals(ans, c.maxArea(height));
    }

    @Test
    public void maxArea_test2() {
        int[] height = new int[]{1,1};
        int ans = 1;
        ContainerWithMostWater c = new ContainerWithMostWater();
        Assert.assertEquals(ans, c.maxArea(height));
    }
}